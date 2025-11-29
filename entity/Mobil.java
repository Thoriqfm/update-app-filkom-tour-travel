package entity;

public class Mobil {

    private String noPlat;
    private String merkMobil;
    private String warnaMobil;
    private String tahunKeluaran;
    private String status;

    // Constructor
    public Mobil(String noPlat, String merkMobil, String warnaMobil, String tahunKeluaran) {
        this.noPlat = noPlat;
        this.merkMobil = merkMobil;
        this.warnaMobil = warnaMobil;
        this.tahunKeluaran = tahunKeluaran;
        this.status = "Tersedia";
    }

    // Getter and Setter
    public String getNoPlat() {
        return noPlat;
    }

    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public void setMerkMobil(String merkMobil) {
        this.merkMobil = merkMobil;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public void setWarnaMobil(String warnaMobil) {
        this.warnaMobil = warnaMobil;
    }

    public String getTahunKeluaran() {
        return tahunKeluaran;
    }

    public void setTahunKeluaran(String tahunKeluaran) {
        this.tahunKeluaran = tahunKeluaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // function untuk status
    public boolean isTersedia() {
        return status.equals("Tersedia");
    }

    public void setDigunakanUntukTransaksi() {
        this.status = "Sedang Digunakan";
    }

    public void setKembaliTersedia() {
        this.status = "Tersedia";
    }

    // display for Info (Mobil)
    public void displayInfoMobil() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║           INFORMASI MOBIL              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ No. Plat       : " + String.format("%-21s", noPlat) + "║");
        System.out.println("║ Merk Mobil     : " + String.format("%-21s", merkMobil) + "║");
        System.out.println("║ Warna          : " + String.format("%-21s", warnaMobil) + "║");
        System.out.println("║ Tahun Keluaran : " + String.format("%-21s", tahunKeluaran) + "║");
        System.out.println("║ Status         : " + String.format("%-21s", status) + "║");
        System.out.println("╚════════════════════════════════════════╝");
    }

}
