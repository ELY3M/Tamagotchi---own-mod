package org.acra.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.security.KeyStoreFactory;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;

public final class HttpRequest {
    private static final int HTTP_CLIENT_ERROR = 400;
    private static final int HTTP_CONFLICT = 409;
    private static final int HTTP_FORBIDDEN = 403;
    private static final int HTTP_REDIRECT = 300;
    private static final int HTTP_SUCCESS = 200;
    private static final int MAX_HTTP_CODE = 600;
    private static final String UTF8 = "UTF-8";
    private final ACRAConfiguration config;
    private int connectionTimeOut = 3000;
    private Map<String, String> headers;
    private String login;
    private String password;
    private int socketTimeOut = 3000;

    public HttpRequest(@NonNull ACRAConfiguration config) {
        this.config = config;
    }

    public void setLogin(@Nullable String login) {
        this.login = login;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public void setConnectionTimeOut(int connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }

    public void setSocketTimeOut(int socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
    }

    public void setHeaders(@Nullable Map<String, String> headers) {
        this.headers = headers;
    }

    public void send(@NonNull Context context, @NonNull URL url, @NonNull Method method, @NonNull String content, @NonNull Type type) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if (urlConnection instanceof HttpsURLConnection) {
            try {
                HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) urlConnection;
                TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                KeyStoreFactory keyStoreFactory = this.config.keyStoreFactory();
                tmf.init(keyStoreFactory == null ? null : keyStoreFactory.create(context));
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, tmf.getTrustManagers(), null);
                httpsUrlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
            } catch (GeneralSecurityException e) {
                ACRA.log.mo4044e(ACRA.LOG_TAG, "Could not configure SSL for ACRA request to " + url, e);
            }
        }
        if (!(this.login == null || this.password == null)) {
            urlConnection.setRequestProperty("Authorization", "Basic " + new String(Base64.encode((this.login + ":" + this.password).getBytes(UTF8), 2), UTF8));
        }
        urlConnection.setConnectTimeout(this.connectionTimeOut);
        urlConnection.setReadTimeout(this.socketTimeOut);
        urlConnection.setRequestProperty("User-Agent", "Android");
        urlConnection.setRequestProperty("Accept", "text/html,application/xml,application/json,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        urlConnection.setRequestProperty("Content-Type", type.getContentType());
        if (this.headers != null) {
            for (Entry<String, String> header : this.headers.entrySet()) {
                urlConnection.setRequestProperty((String) header.getKey(), (String) header.getValue());
            }
        }
        byte[] contentAsBytes = content.getBytes(UTF8);
        urlConnection.setRequestMethod(method.name());
        urlConnection.setDoOutput(true);
        urlConnection.setFixedLengthStreamingMode(contentAsBytes.length);
        System.setProperty("http.keepAlive", "false");
        urlConnection.connect();
        OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
        outputStream.write(contentAsBytes);
        outputStream.flush();
        outputStream.close();
        int responseCode = urlConnection.getResponseCode();
        if (responseCode >= HTTP_SUCCESS && responseCode < 300) {
            ACRA.log.mo4046i(ACRA.LOG_TAG, "Request received by server");
        } else if (responseCode == HTTP_FORBIDDEN) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Data validation error on server - request will be discarded");
        } else if (responseCode == 409) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Server has already received this post - request will be discarded");
        } else if (responseCode < HTTP_CLIENT_ERROR || responseCode >= MAX_HTTP_CODE) {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Could not send ACRA Post - request will be discarded responseCode=" + responseCode + " message=" + urlConnection.getResponseMessage());
        } else {
            ACRA.log.mo4050w(ACRA.LOG_TAG, "Could not send ACRA Post responseCode=" + responseCode + " message=" + urlConnection.getResponseMessage());
            throw new IOException("Host returned error code " + responseCode);
        }
        urlConnection.disconnect();
    }

    @NonNull
    public static String getParamsAsFormString(@NonNull Map<?, ?> parameters) throws UnsupportedEncodingException {
        StringBuilder dataBfr = new StringBuilder();
        for (Entry<?, ?> entry : parameters.entrySet()) {
            Object value;
            if (dataBfr.length() != 0) {
                dataBfr.append('&');
            }
            Object preliminaryValue = entry.getValue();
            if (preliminaryValue == null) {
                value = "";
            } else {
                value = preliminaryValue;
            }
            dataBfr.append(URLEncoder.encode(entry.getKey().toString(), UTF8));
            dataBfr.append('=');
            dataBfr.append(URLEncoder.encode(value.toString(), UTF8));
        }
        return dataBfr.toString();
    }
}
