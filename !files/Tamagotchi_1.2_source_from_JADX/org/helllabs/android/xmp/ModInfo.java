package org.helllabs.android.xmp;

class ModInfo {
    int bpm;
    int chn;
    String filename;
    int ins;
    int len;
    String name;
    int pat;
    int smp;
    int time;
    int tpo;
    int trk;
    String type;

    public ModInfo(String _name, String _type, String _filename, int _chn, int _pat, int _ins, int _trk, int _smp, int _len, int _bpm, int _tpo, int _time) {
        this.name = _name;
        this.type = _type;
        this.filename = _filename;
        this.chn = _chn;
        this.pat = _pat;
        this.ins = _ins;
        this.trk = _trk;
        this.smp = _smp;
        this.len = _len;
        this.bpm = _bpm;
        this.tpo = _tpo;
        this.time = _time;
    }
}
