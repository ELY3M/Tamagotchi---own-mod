package org.acra.collector;

import android.content.Context;
import android.os.DropBoxManager;
import android.os.DropBoxManager.Entry;
import android.support.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.acra.config.ACRAConfiguration;

final class DropBoxCollector {
    private static final String NO_RESULT = "N/A";
    private static final String[] SYSTEM_TAGS = new String[]{"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());

    DropBoxCollector() {
    }

    @NonNull
    public String read(@NonNull Context context, @NonNull ACRAConfiguration config) {
        try {
            DropBoxManager dropbox = (DropBoxManager) context.getSystemService("dropbox");
            Calendar calendar = Calendar.getInstance();
            calendar.roll(12, -config.dropboxCollectionMinutes());
            long time = calendar.getTimeInMillis();
            this.dateFormat.format(calendar.getTime());
            List<String> tags = new ArrayList();
            if (config.includeDropBoxSystemTags()) {
                tags.addAll(Arrays.asList(SYSTEM_TAGS));
            }
            String[] additionalTags = config.additionalDropBoxTags();
            if (additionalTags.length > 0) {
                tags.addAll(Arrays.asList(additionalTags));
            }
            if (tags.isEmpty()) {
                return "No tag configured for collection.";
            }
            StringBuilder dropboxContent = new StringBuilder();
            for (String tag : tags) {
                dropboxContent.append("Tag: ").append(tag).append('\n');
                Entry entry = dropbox.getNextEntry(tag, time);
                if (entry == null) {
                    dropboxContent.append("Nothing.").append('\n');
                } else {
                    while (entry != null) {
                        long msec = entry.getTimeMillis();
                        calendar.setTimeInMillis(msec);
                        dropboxContent.append("@").append(this.dateFormat.format(calendar.getTime())).append('\n');
                        String text = entry.getText(500);
                        if (text != null) {
                            dropboxContent.append("Text: ").append(text).append('\n');
                        } else {
                            dropboxContent.append("Not Text!").append('\n');
                        }
                        entry.close();
                        entry = dropbox.getNextEntry(tag, msec);
                    }
                    continue;
                }
            }
            return dropboxContent.toString();
        } catch (Exception e) {
            return NO_RESULT;
        }
    }
}
