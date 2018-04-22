package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf.zza;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlh extends zzlg {
    public static final List<String> zzYf = Collections.singletonList("email");
    private Class<?> zzYg;
    private Class<?> zzYh;
    private Object zzYi;
    private Object zzYj;

    public zzlh(Activity activity, List<String> list) {
        super(activity, zzYf, list);
    }

    public static void zzag(Context context) throws IllegalStateException {
        Class cls;
        Throwable e;
        zzx.zzz(context);
        try {
            try {
                Class.forName("com.facebook.FacebookSdk").getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{context.getApplicationContext(), Integer.valueOf(64206)});
                cls = Class.forName("com.facebook.login.LoginManager");
                cls.getDeclaredMethod("logOut", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
                return;
            } catch (NoSuchMethodException e2) {
                e = e2;
            } catch (IllegalAccessException e3) {
                e = e3;
            } catch (InvocationTargetException e4) {
                e = e4;
            }
            Log.e("AuthSignInClient", "Facebook logout error.", e);
            throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
        } catch (ClassNotFoundException e5) {
            try {
                cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    cls.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(invoke, new Object[0]);
                }
            } catch (ClassNotFoundException e6) {
                e = e6;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (NoSuchMethodException e7) {
                e = e7;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (IllegalAccessException e8) {
                e = e8;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (InvocationTargetException e9) {
                e = e9;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void zznv() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.zzYj != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.zzYj, new Object[]{this.mActivity, new ArrayList(zzns())});
            return;
        }
        Class cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.mActivity});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(zzns())});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(64206)});
        Class cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")}).invoke(newInstance, new Object[]{zznw()});
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mActivity});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke(null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object zznw() throws ClassNotFoundException {
        final Class cls = Class.forName("com.facebook.Session");
        return Proxy.newProxyInstance(Class.forName("com.facebook.Session$StatusCallback").getClassLoader(), new Class[]{r1}, new InvocationHandler(this) {
            final /* synthetic */ zzlh zzYl;

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class cls = Class.forName("com.facebook.SessionState");
                Class[] parameterTypes = method.getParameterTypes();
                if (method.getName().equals("call") && parameterTypes.length == 3 && parameterTypes[0] == cls && parameterTypes[1] == cls && parameterTypes[2] == Exception.class) {
                    if (((Boolean) cls.getDeclaredMethod("isOpened", new Class[0]).invoke(args[0], new Object[0])).booleanValue()) {
                        this.zzYl.zznt().zzk(this.zzYl.zza(IdpTokenType.zzXA, (String) cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(args[0], new Object[0]), this.zzYl.zznu()));
                    }
                    return null;
                }
                throw new ExceptionInInitializerError("Method not supported!");
            }
        });
    }

    public void zza(zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb(null, null, (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb((String) zzx.zzz(str), null, (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, String str2, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb((String) zzx.zzz(str), (String) zzx.zzz(str2), (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public boolean zza(int i, int i2, Intent intent, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb(com_google_android_gms_internal_zzlf_zza);
        if (i != 64206 && this.zzYg == null) {
            return false;
        }
        if (this.zzYg == null || this.zzYh == null || this.zzYi == null) {
            try {
                Class cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        }
        try {
            if (!((Boolean) this.zzYg.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                return false;
            }
            return ((Boolean) this.zzYh.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.zzYi, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }

    public zzd zzmU() {
        return zzd.FACEBOOK;
    }
}
