package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzhq {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzhv<T> zzhv, zzff zzff) throws IOException;

    <T> void zza(List<T> list, zzhv<T> zzhv, zzff zzff) throws IOException;

    <K, V> void zza(Map<K, V> map, zzgu<K, V> zzgu, zzff zzff) throws IOException;

    @Deprecated
    <T> T zzb(zzhv<T> zzhv, zzff zzff) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzhv<T> zzhv, zzff zzff) throws IOException;

    void zzd(List<Double> list) throws IOException;

    void zze(List<Float> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    long zzfi() throws IOException;

    long zzfj() throws IOException;

    int zzfk() throws IOException;

    long zzfl() throws IOException;

    int zzfm() throws IOException;

    boolean zzfn() throws IOException;

    String zzfo() throws IOException;

    zzeh zzfp() throws IOException;

    int zzfq() throws IOException;

    int zzfr() throws IOException;

    int zzfs() throws IOException;

    long zzft() throws IOException;

    int zzfu() throws IOException;

    long zzfv() throws IOException;

    void zzg(List<Long> list) throws IOException;

    int zzgf() throws IOException;

    boolean zzgg() throws IOException;

    void zzh(List<Integer> list) throws IOException;

    void zzi(List<Long> list) throws IOException;

    void zzj(List<Integer> list) throws IOException;

    void zzk(List<Boolean> list) throws IOException;

    void zzl(List<String> list) throws IOException;

    void zzm(List<zzeh> list) throws IOException;

    void zzn(List<Integer> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Integer> list) throws IOException;

    void zzq(List<Long> list) throws IOException;

    void zzr(List<Integer> list) throws IOException;

    void zzs(List<Long> list) throws IOException;
}
