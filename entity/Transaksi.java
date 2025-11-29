package entity.transc;

public abstract class Transaksi {

    protected String idTransaksi;
    protected String tanggalTransaksi;
    protected String namaPelanggan;
    protected String kontakPelanggan;
    protected int durasiHari;
    protected double totalHarga = 0;

    public Transaksi(String idTransaksi, String tanggalTransaksi, String namaPelanggan,
            String kontakPelanggan, int durasiHari) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.kontakPelanggan = kontakPelanggan;
        this.durasiHari = durasiHari;
        this.totalHarga = 0.0;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getKontakPelanggan() {
        return kontakPelanggan;
    }

    public void setKontakPelanggan(String kontakPelanggan) {
        this.kontakPelanggan = kontakPelanggan;
    }

    public int getDurasiHari() {
        return durasiHari;
    }

    public void setDurasiHari(int durasiHari) {
        this.durasiHari = durasiHari;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    // Abstract methods
    public abstract double hitungTotalHarga();

    public abstract void displayInfoTransaksi();

    public abstract String getJenisTransaksi();
}
