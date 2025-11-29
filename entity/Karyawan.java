package entity;

public class Karyawan {

    private String nama;
    private String alamat;
    private String noTelp;
    private String jenisKelamin;
    private String jabatan;
    private String status;

    // Constructor
    public Karyawan(String nama, String alamat, String noTelp, String jenisKelamin, String jabatan) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.jabatan = jabatan;
        this.status = "Tersedia";
    }

    // Getter and Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Function untuk status
    public boolean isTersedia() {
        return status.equals("Tersedia");
    }

    public void setBertugasUntukTransaksi() {
        this.status = "Sedang Bertugas";
    }

    public void setKembaliTersedia() {
        this.status = "Tersedia";
    }

    // display for Info (Karyawan)
    public void displayInfoKaryawan() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║         INFORMASI KARYAWAN             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Nama           : " + String.format("%-21s", nama) + "║");
        System.out.println("║ Alamat         : " + String.format("%-21s", alamat) + "║");
        System.out.println("║ No. Telepon    : " + String.format("%-21s", noTelp) + "║");
        System.out.println("║ Jenis Kelamin  : " + String.format("%-21s", jenisKelamin) + "║");
        System.out.println("║ Jabatan       : " + String.format("%-21s", jabatan) + "║");
        System.out.println("║ Status         : " + String.format("%-21s", status) + "║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}
