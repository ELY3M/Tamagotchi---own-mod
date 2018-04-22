package org.acra.collector;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class MediaCodecListCollector {
    private static final String[] AAC_TYPES = new String[]{"aac", "AAC"};
    private static final String[] AVC_TYPES = new String[]{"avc", "h264", "AVC", "H264"};
    private static final String COLOR_FORMAT_PREFIX = "COLOR_";
    private static final String[] H263_TYPES = new String[]{"h263", "H263"};
    private static final String[] MPEG4_TYPES = new String[]{"mp4", "mpeg4", "MP4", "MPEG4"};
    private static final SparseArray<String> mAACProfileValues = new SparseArray();
    private static final SparseArray<String> mAVCLevelValues = new SparseArray();
    private static final SparseArray<String> mAVCProfileValues = new SparseArray();
    private static final SparseArray<String> mColorFormatValues = new SparseArray();
    private static final SparseArray<String> mH263LevelValues = new SparseArray();
    private static final SparseArray<String> mH263ProfileValues = new SparseArray();
    private static final SparseArray<String> mMPEG4LevelValues = new SparseArray();
    private static final SparseArray<String> mMPEG4ProfileValues = new SparseArray();

    private enum CodecType {
        AVC,
        H263,
        MPEG4,
        AAC
    }

    private MediaCodecListCollector() {
    }

    static {
        try {
            for (Field f : Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Modifier.isFinal(f.getModifiers()) && f.getName().startsWith(COLOR_FORMAT_PREFIX)) {
                    mColorFormatValues.put(f.getInt(null), f.getName());
                }
            }
            for (Field f2 : Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getFields()) {
                if (Modifier.isStatic(f2.getModifiers()) && Modifier.isFinal(f2.getModifiers())) {
                    if (f2.getName().startsWith("AVCLevel")) {
                        mAVCLevelValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("AVCProfile")) {
                        mAVCProfileValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("H263Level")) {
                        mH263LevelValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("H263Profile")) {
                        mH263ProfileValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("MPEG4Level")) {
                        mMPEG4LevelValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("MPEG4Profile")) {
                        mMPEG4ProfileValues.put(f2.getInt(null), f2.getName());
                    } else if (f2.getName().startsWith("AAC")) {
                        mAACProfileValues.put(f2.getInt(null), f2.getName());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
        } catch (SecurityException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        }
    }

    @NonNull
    public static String collectMediaCodecList() {
        if (VERSION.SDK_INT < 16) {
            return "";
        }
        MediaCodecInfo[] infos;
        if (VERSION.SDK_INT < 21) {
            int codecCount = MediaCodecList.getCodecCount();
            infos = new MediaCodecInfo[codecCount];
            for (int codecIdx = 0; codecIdx < codecCount; codecIdx++) {
                infos[codecIdx] = MediaCodecList.getCodecInfoAt(codecIdx);
            }
        } else {
            infos = new MediaCodecList(1).getCodecInfos();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < infos.length; i++) {
            MediaCodecInfo codecInfo = infos[i];
            result.append('\n').append(i).append(": ").append(codecInfo.getName()).append('\n').append("isEncoder: ").append(codecInfo.isEncoder()).append('\n');
            String[] supportedTypes = codecInfo.getSupportedTypes();
            result.append("Supported types: ").append(Arrays.toString(supportedTypes)).append('\n');
            for (String type : supportedTypes) {
                result.append(collectCapabilitiesForType(codecInfo, type));
            }
            result.append('\n');
        }
        return result.toString();
    }

    @TargetApi(16)
    @NonNull
    private static String collectCapabilitiesForType(@NonNull MediaCodecInfo codecInfo, @NonNull String type) {
        int i;
        StringBuilder result = new StringBuilder();
        CodecCapabilities codecCapabilities = codecInfo.getCapabilitiesForType(type);
        int[] colorFormats = codecCapabilities.colorFormats;
        if (colorFormats.length > 0) {
            result.append(type).append(" color formats:");
            for (i = 0; i < colorFormats.length; i++) {
                result.append((String) mColorFormatValues.get(colorFormats[i]));
                if (i < colorFormats.length - 1) {
                    result.append(',');
                }
            }
            result.append("\n");
        }
        CodecType codecType = identifyCodecType(codecInfo);
        CodecProfileLevel[] codecProfileLevels = codecCapabilities.profileLevels;
        if (codecProfileLevels.length > 0) {
            result.append(type).append(" profile levels:");
            i = 0;
            while (i < codecProfileLevels.length) {
                int profileValue = codecProfileLevels[i].profile;
                int levelValue = codecProfileLevels[i].level;
                if (codecType == null) {
                    result.append(profileValue).append('-').append(levelValue);
                    result.append('\n');
                } else {
                    switch (codecType) {
                        case AVC:
                            result.append(profileValue).append((String) mAVCProfileValues.get(profileValue)).append('-').append((String) mAVCLevelValues.get(levelValue));
                            break;
                        case H263:
                            result.append((String) mH263ProfileValues.get(profileValue)).append('-').append((String) mH263LevelValues.get(levelValue));
                            break;
                        case MPEG4:
                            result.append((String) mMPEG4ProfileValues.get(profileValue)).append('-').append((String) mMPEG4LevelValues.get(levelValue));
                            break;
                        case AAC:
                            result.append((String) mAACProfileValues.get(profileValue));
                            break;
                    }
                    if (i < codecProfileLevels.length - 1) {
                        result.append(',');
                    }
                    i++;
                }
            }
            result.append('\n');
        }
        return result.append('\n').toString();
    }

    @Nullable
    @TargetApi(16)
    private static CodecType identifyCodecType(@NonNull MediaCodecInfo codecInfo) {
        String name = codecInfo.getName();
        for (String token : AVC_TYPES) {
            if (name.contains(token)) {
                return CodecType.AVC;
            }
        }
        for (String token2 : H263_TYPES) {
            if (name.contains(token2)) {
                return CodecType.H263;
            }
        }
        for (String token22 : MPEG4_TYPES) {
            if (name.contains(token22)) {
                return CodecType.MPEG4;
            }
        }
        for (String token222 : AAC_TYPES) {
            if (name.contains(token222)) {
                return CodecType.AAC;
            }
        }
        return null;
    }
}
