package entity;

public class TransaksiSewa extends Transaksi {

    private Mobil mobilDisewa;
    private double hargaSewaPerHari;

    // Constructor
    public TransaksiSewa(String idTransaksi, String tanggalTransaksi, String namaPelanggan, String kontakPelanggan,
            int durasiHari, Mobil mobilDisewa, double hargaSewaPerHari) {
        super(idTransaksi, tanggalTransaksi, namaPelanggan, kontakPelanggan, durasiHari);
        this.mobilDisewa = mobilDisewa;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.totalHarga = hitungTotalHarga();

        // set untuk digunakan
        this.mobilDisewa.setDigunakanUntukTransaksi();
    }

    // Getter method
    public Mobil getMobil() {
        return mobilDisewa;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    // Setter method
    public void setMobilDisewa(Mobil mobilDisewa) {
        this.mobilDisewa = mobilDisewa;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.totalHarga = hitungTotalHarga();
    }

    @Override
    public double hitungTotalHarga() {
        return this.hargaSewaPerHari * this.durasiHari;
    }

    @Override
    public String getJenisTransaksi() {
        return "SEWA MOBIL";
    }

    @Override
    public void displayInfoTransaksi() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          TRANSAKSI SEWA MOBIL                  ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ ID Transaksi    : " + String.format("%-28s", idTransaksi) + "║");
        System.out.println("║ Tanggal         : " + String.format("%-28s", tanggalTransaksi) + "║");
        System.out.println("║ Nama Pelanggan  : " + String.format("%-28s", namaPelanggan) + "║");
        System.out.println("║ Kontak          : " + String.format("%-28s", kontakPelanggan) + "║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ DETAIL SEWA                                    ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ Mobil           : " + String.format("%-28s", mobilDisewa.getMerkMobil()) + "║");
        System.out.println("║ No. Plat        : " + String.format("%-28s", mobilDisewa.getNoPlat()) + "║");
        System.out.println("║ Warna           : " + String.format("%-28s", mobilDisewa.getWarnaMobil()) + "║");
        System.out.println("║ Durasi Sewa     : " + String.format("%-25s", durasiHari + " hari") + "║");
        System.out.println("║ Harga/Hari      : Rp " + String.format("%-24s", String.format("%,.0f", hargaSewaPerHari)) + "║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ TOTAL BAYAR     : Rp " + String.format("%-24s", String.format("%,.0f", totalHarga)) + "║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    @Override
    public String toString() {
        return "TransaksiSewa{"
                + "idTransaksi='" + idTransaksi + '\''
                + ", namaPelanggan='" + namaPelanggan + '\''
                + ", mobilDisewa=" + mobilDisewa.getMerkMobil()
                + ", totalHarga=" + totalHarga
                + '}';
    }
}
