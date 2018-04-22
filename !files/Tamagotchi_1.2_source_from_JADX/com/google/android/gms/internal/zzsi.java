package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzsi {

    public static class zza {
        public final zzsj zzbty;
        public final List<Asset> zzbtz;

        public zza(zzsj com_google_android_gms_internal_zzsj, List<Asset> list) {
            this.zzbty = com_google_android_gms_internal_zzsj;
            this.zzbtz = list;
        }
    }

    private static int zza(String str, com.google.android.gms.internal.zzsj.zza.zza[] com_google_android_gms_internal_zzsj_zza_zzaArr) {
        int i = 14;
        for (com.google.android.gms.internal.zzsj.zza.zza com_google_android_gms_internal_zzsj_zza_zza : com_google_android_gms_internal_zzsj_zza_zzaArr) {
            if (i == 14) {
                if (com_google_android_gms_internal_zzsj_zza_zza.type == 9 || com_google_android_gms_internal_zzsj_zza_zza.type == 2 || com_google_android_gms_internal_zzsj_zza_zza.type == 6) {
                    i = com_google_android_gms_internal_zzsj_zza_zza.type;
                } else if (com_google_android_gms_internal_zzsj_zza_zza.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + com_google_android_gms_internal_zzsj_zza_zza.type + " for key " + str);
                }
            } else if (com_google_android_gms_internal_zzsj_zza_zza.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + com_google_android_gms_internal_zzsj_zza_zza.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzsj com_google_android_gms_internal_zzsj = new zzsj();
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzsj.zzbtA = zza(dataMap, arrayList);
        return new zza(com_google_android_gms_internal_zzsj, arrayList);
    }

    private static com.google.android.gms.internal.zzsj.zza.zza zza(List<Asset> list, Object obj) {
        com.google.android.gms.internal.zzsj.zza.zza com_google_android_gms_internal_zzsj_zza_zza = new com.google.android.gms.internal.zzsj.zza.zza();
        if (obj == null) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 14;
            return com_google_android_gms_internal_zzsj_zza_zza;
        }
        com_google_android_gms_internal_zzsj_zza_zza.zzbtE = new com.google.android.gms.internal.zzsj.zza.zza.zza();
        if (obj instanceof String) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 2;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtG = (String) obj;
        } else if (obj instanceof Integer) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 6;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtK = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 5;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtJ = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 3;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtH = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 4;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtI = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 8;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtM = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 7;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtL = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 1;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtF = (byte[]) obj;
        } else if (obj instanceof String[]) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 11;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtP = (String[]) obj;
        } else if (obj instanceof long[]) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 12;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtQ = (long[]) obj;
        } else if (obj instanceof float[]) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 15;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtR = (float[]) obj;
        } else if (obj instanceof Asset) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 13;
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtS = (long) zza((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.keySet());
            com.google.android.gms.internal.zzsj.zza[] com_google_android_gms_internal_zzsj_zzaArr = new com.google.android.gms.internal.zzsj.zza[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                com_google_android_gms_internal_zzsj_zzaArr[r1] = new com.google.android.gms.internal.zzsj.zza();
                com_google_android_gms_internal_zzsj_zzaArr[r1].name = str;
                com_google_android_gms_internal_zzsj_zzaArr[r1].zzbtC = zza((List) list, dataMap.get(str));
                r1++;
            }
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtN = com_google_android_gms_internal_zzsj_zzaArr;
        } else if (obj instanceof ArrayList) {
            com_google_android_gms_internal_zzsj_zza_zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.zzsj.zza.zza[] com_google_android_gms_internal_zzsj_zza_zzaArr = new com.google.android.gms.internal.zzsj.zza.zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.internal.zzsj.zza.zza zza = zza((List) list, obj3);
                if (zza.type == 14 || zza.type == 2 || zza.type == 6 || zza.type == 9) {
                    if (i2 == 14 && zza.type != 14) {
                        r1 = zza.type;
                    } else if (zza.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    com_google_android_gms_internal_zzsj_zza_zzaArr[i] = zza;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtO = com_google_android_gms_internal_zzsj_zza_zzaArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return com_google_android_gms_internal_zzsj_zza_zza;
    }

    public static DataMap zza(zza com_google_android_gms_internal_zzsi_zza) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.zzsj.zza com_google_android_gms_internal_zzsj_zza : com_google_android_gms_internal_zzsi_zza.zzbty.zzbtA) {
            zza(com_google_android_gms_internal_zzsi_zza.zzbtz, dataMap, com_google_android_gms_internal_zzsj_zza.name, com_google_android_gms_internal_zzsj_zza.zzbtC);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, com.google.android.gms.internal.zzsj.zza.zza.zza com_google_android_gms_internal_zzsj_zza_zza_zza, int i) {
        ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtO.length);
        for (com.google.android.gms.internal.zzsj.zza.zza com_google_android_gms_internal_zzsj_zza_zza : com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtO) {
            if (com_google_android_gms_internal_zzsj_zza_zza.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.zzsj.zza com_google_android_gms_internal_zzsj_zza : com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtN) {
                    zza(list, dataMap, com_google_android_gms_internal_zzsj_zza.name, com_google_android_gms_internal_zzsj_zza.zzbtC);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtG);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzsj_zza_zza.zzbtE.zzbtK));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.zzsj.zza.zza com_google_android_gms_internal_zzsj_zza_zza) {
        int i = com_google_android_gms_internal_zzsj_zza_zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        com.google.android.gms.internal.zzsj.zza.zza.zza com_google_android_gms_internal_zzsj_zza_zza_zza = com_google_android_gms_internal_zzsj_zza_zza.zzbtE;
        if (i == 1) {
            dataMap.putByteArray(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtF);
        } else if (i == 11) {
            dataMap.putStringArray(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtP);
        } else if (i == 12) {
            dataMap.putLongArray(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtQ);
        } else if (i == 15) {
            dataMap.putFloatArray(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtR);
        } else if (i == 2) {
            dataMap.putString(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtG);
        } else if (i == 3) {
            dataMap.putDouble(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtH);
        } else if (i == 4) {
            dataMap.putFloat(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtI);
        } else if (i == 5) {
            dataMap.putLong(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtJ);
        } else if (i == 6) {
            dataMap.putInt(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtK);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtL);
        } else if (i == 8) {
            dataMap.putBoolean(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtM);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtS));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.zzsj.zza com_google_android_gms_internal_zzsj_zza : com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtN) {
                zza(list, dataMap2, com_google_android_gms_internal_zzsj_zza.name, com_google_android_gms_internal_zzsj_zza.zzbtC);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = zza(str, com_google_android_gms_internal_zzsj_zza_zza_zza.zzbtO);
            ArrayList zza = zza(list, com_google_android_gms_internal_zzsj_zza_zza_zza, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, zza);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, zza);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, zza);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, zza);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.zzsj.zza[] zza(DataMap dataMap, List<Asset> list) {
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        com.google.android.gms.internal.zzsj.zza[] com_google_android_gms_internal_zzsj_zzaArr = new com.google.android.gms.internal.zzsj.zza[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            com_google_android_gms_internal_zzsj_zzaArr[i] = new com.google.android.gms.internal.zzsj.zza();
            com_google_android_gms_internal_zzsj_zzaArr[i].name = str;
            com_google_android_gms_internal_zzsj_zzaArr[i].zzbtC = zza((List) list, obj);
            i++;
        }
        return com_google_android_gms_internal_zzsj_zzaArr;
    }
}
