package model;

public class BaiHoc {
    private int maBaiHoc;
    private int maModule;
    private String tieuDe;
    private String loaiBaiHoc;
    private String doKho;
    private String linkBaiHoc;

    public BaiHoc(int maModule, String tieuDe, String loaiBaiHoc, String doKho, String linkBaiHoc) {
        this.maModule = maModule;
        this.tieuDe = tieuDe;
        this.loaiBaiHoc = loaiBaiHoc;
        this.doKho = doKho;
        this.linkBaiHoc = linkBaiHoc;
    }

    public BaiHoc(int maBaiHoc, int maModule, String tieuDe, String loaiBaiHoc, String doKho, String linkBaiHoc) {
        this.maBaiHoc = maBaiHoc;
        this.maModule = maModule;
        this.tieuDe = tieuDe;
        this.loaiBaiHoc = loaiBaiHoc;
        this.doKho = doKho;
        this.linkBaiHoc = linkBaiHoc;
    }

    public int getMaBaiHoc() {
        return maBaiHoc;
    }

    public void setMaBaiHoc(int maBaiHoc) {
        this.maBaiHoc = maBaiHoc;
    }

    public int getMaModule() {
        return maModule;
    }

    public void setMaModule(int maModule) {
        this.maModule = maModule;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getLoaiBaiHoc() {
        return loaiBaiHoc;
    }

    public void setLoaiBaiHoc(String loaiBaiHoc) {
        this.loaiBaiHoc = loaiBaiHoc;
    }

    public String getDoKho() {
        return doKho;
    }

    public void setDoKho(String doKho) {
        this.doKho = doKho;
    }

    public String getLinkBaiHoc() {
        return linkBaiHoc;
    }

    public void setLinkBaiHoc(String linkBaiHoc) {
        this.linkBaiHoc = linkBaiHoc;
    }
}
