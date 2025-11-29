package entity;

public class TransaksiTravel extends Transaksi {

    private Mobil mobilTravel;
    private Karyawan driver;
    private String ruteAsal;
    private String ruteTujuan;
    private int kapasitasPenumpang;
    private double hargaTravelPerOrang;

    // Constructor
    public TransaksiTravel(String idTransaksi, String tanggalTransaksi, String namaPelanggan, String kontakPelanggan,
            int durasiHari, Mobil mobilTravel, Karyawan driver, String ruteAsal, String ruteTujuan, int kapasitasPenumpang, double hargaTravelPerOrang) {
        super(idTransaksi, tanggalTransaksi, namaPelanggan, kontakPelanggan, durasiHari);
        this.mobilTravel = mobilTravel;
        this.driver = driver;
        this.ruteAsal = ruteAsal;
        this.ruteTujuan = ruteTujuan;
        this.kapasitasPenumpang = kapasitasPenumpang;
        this.hargaTravelPerOrang = hargaTravelPerOrang;
        this.totalHarga = hitungTotalHarga();

        // set digunakan 
        this.mobilTravel.setDigunakanUntukTransaksi();
        this.driver.setBertugasUntukTransaksi();
    }

    // Getter method
    public Mobil getMobilTravel() {
        return mobilTravel;
    }

    public Karyawan getDriver() {
        return driver;
    }

    public String getRuteAsal() {
        return ruteAsal;
    }

    public String getRuteTujuan() {
        return ruteTujuan;
    }

    public int getKapasitasPenumpang() {
        return kapasitasPenumpang;
    }

    public double getHargaTravelPerOrang() {
        return hargaTravelPerOrang;
    }

    // Setter method
    public void setMobilTravel(Mobil mobilTravel) {
        this.mobilTravel = mobilTravel;
    }

    public void setDriver(Karyawan driver) {
        this.driver = driver;
    }

    public void setRuteAsal(String ruteAsal) {
        this.ruteAsal = ruteAsal;
    }

    public void setRuteTujuan(String ruteTujuan) {
        this.ruteTujuan = ruteTujuan;
    }

    public void setKapasitasPenumpang(int kapasitasPenumpang) {
        this.kapasitasPenumpang = kapasitasPenumpang;
        this.totalHarga = hitungTotalHarga();
    }

    public void setHargaTravelPerOrang(double hargaTravelPerOrang) {
        this.hargaTravelPerOrang = hargaTravelPerOrang;
        this.totalHarga = hitungTotalHarga();
    }

    @Override
    public double hitungTotalHarga() {
        return hargaTravelPerOrang * kapasitasPenumpang;
    }

    @Override
    public String getJenisTransaksi() {
        return "TRAVEL";
    }

    @Override
    public void displayInfoTransaksi() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          TRANSAKSI TRAVEL                      ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ ID Transaksi    : " + String.format("%-28s", idTransaksi) + "║");
        System.out.println("║ Tanggal         : " + String.format("%-28s", tanggalTransaksi) + "║");
        System.out.println("║ Nama Pelanggan  : " + String.format("%-28s", namaPelanggan) + "║");
        System.out.println("║ Kontak          : " + String.format("%-28s", kontakPelanggan) + "║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ DETAIL TRAVEL                                  ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ Rute            : " + String.format("%-28s", ruteAsal + " → " + ruteTujuan) + "║");
        System.out.println("║ Mobil           : " + String.format("%-28s", mobilTravel.getMerkMobil()) + "║");
        System.out.println("║ Driver          : " + String.format("%-28s", driver.getNama()) + "║");
        System.out.println("║ Kontak Driver   : " + String.format("%-28s", driver.getNoTelp()) + "║");
        System.out.println("║ Jumlah Penumpang: " + String.format("%-25s", kapasitasPenumpang + " orang") + "║");
        System.out.println("║ Harga/Orang     : Rp " + String.format("%-24s", String.format("%,.0f", hargaTravelPerOrang)) + "║");
        System.out.println("║ Durasi          : " + String.format("%-25s", durasiHari + " hari") + "║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ TOTAL BAYAR     : Rp " + String.format("%-24s", String.format("%,.0f", totalHarga)) + "║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "TransaksiTravel{"
                + "idTransaksi='" + idTransaksi + '\''
                + ", namaPelanggan='" + namaPelanggan + '\''
                + ", rute='" + ruteAsal + " → " + ruteTujuan + '\''
                + ", driver=" + driver.getNama()
                + ", totalHarga=" + totalHarga
                + '}';
    }
}
