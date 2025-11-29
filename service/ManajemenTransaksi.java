package service;

import entity.Karyawan;
import entity.Mobil;
import entity.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import util.MenuUtama;

public class ManajemenTransaksi {

    private final ArrayList<Transaksi> dafTransaksi;
    private int jumlahTransaksi;
    private final Scanner scanner;

    // Constructor
    public ManajemenTransaksi() {
        this.dafTransaksi = new ArrayList<>();
        this.jumlahTransaksi = 0;
        this.scanner = new Scanner(System.in);
    }

    // Generate otomatis id transaksi
    public String generateIDTransaksi() {
        jumlahTransaksi++;
        /*
         * Secara otomatis akan menambah dari setiap jumlahTransaksi nya,
         * akan dipanggil setiap selesai input data,
         * nantinya akan menambah jumlah transaksi, dan dikembalikkan dalam bentuk
         * format seperti di bawah
         */
        return String.format("ID%03d", jumlahTransaksi);
    }

    public void inputTransaksiSewa(ManajemenMobil mobilData) {
        MenuUtama.clearScreen();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          BUAT TRANSAKSI SEWA MOBIL             ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // Cek terlebih dahulu apakah ada mobil
        if (mobilData.getJumlahMobil() == 0) {
            MenuUtama.pesanError("Belum ada data mobil! Tambahkan mobil terlebih dahulu...");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Input data pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan kontak pelanggan (+62): ");
        String kontakPelanggan = scanner.nextLine();

        // Pilih mobil
        /*
         * Pada kondisi ini, akan memanggil layer service ManajemenMobil dan memanggil
         * method pilihMobilUntukTransaksi()
         * Lalu akan dilakukan pengecekan apakah mobil pilihan null atau tidak, jika
         * null, akan kembali
         */
        Mobil mobilPilihan = mobilData.pilihMobilUntukTransaksi();
        if (mobilPilihan == null) {
            return;
        }

        // lanjut input
        System.out.print("Durasi Sewa (hari) : ");
        int durasiHari = Integer.parseInt(scanner.nextLine());

        System.out.print("Harga Sewa per Hari (Rp) : ");
        double hargaSewaPerHari = Double.parseDouble(scanner.nextLine());

        // Generate ID
        String idTransaksi = generateIDTransaksi();
        String tanggalTransaksi = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Buat Objek Transaksi Sewa
        TransaksiSewa transaksiSewa = new TransaksiSewa(idTransaksi, tanggalTransaksi, namaPelanggan, kontakPelanggan,
                durasiHari, mobilPilihan, hargaSewaPerHari);

        // tambahkan ke list
        dafTransaksi.add(transaksiSewa);

        // Tampilan konfirmasi
        MenuUtama.clearScreen();
        System.out.println("\nTRANSAKSI BERHASIL DIBUAT");
        transaksiSewa.displayInfoTransaksi();

        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();

    }

    public void inputTransaksiTravel(ManajemenMobil mobilData, ManajemenKaryawan karyawanData) {
        MenuUtama.clearScreen();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          BUAT TRANSAKSI TRAVEL MOBIL             ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // cek apakah ada mobil
        if (mobilData.getJumlahMobil() == 0) {
            MenuUtama.pesanError("Belum ada data mobil! Tambahkan mobil terlebih dahulu...");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // cek apakah ada driver a.k.a karyawan
        if (karyawanData.getJumlahKaryawan() == 0) {
            MenuUtama.pesanError("Belum ada data karyawan! Tambahkan karyawan terlebih dahulu...");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Input
        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Kontak Pelanggan (+62) : ");
        String kontakPelanggan = scanner.nextLine();

        System.out.print("Rute Asal (Kota) : ");
        String ruteAsal = scanner.nextLine();

        System.out.print("Rute Tujuan (Kota) : ");
        String ruteTujuan = scanner.nextLine();

        // Pilih mobil
        /*
         * Pada kondisi ini, akan memanggil layer service ManajemenMobil dan memanggil
         * method pilihMobilUntukTransaksi()
         * Lalu akan dilakukan pengecekan apakah mobil pilihan null atau tidak, jika
         * null, akan kembali
         */
        Mobil mobilPilihan = mobilData.pilihMobilUntukTransaksi();
        if (mobilPilihan == null) {
            return;
        }

        // Pilih driver
        /*
         * Pada kondisi ini, akan memanggil layer service ManajemenKaryawan dan
         * memanggil method pilihDriverUntukTravel()
         * Lalu akan dilakukan pengecekan apakah driver pilihan null atau tidak, jika
         * null, akan kembali
         */
        Karyawan driverPilihan = karyawanData.pilihDriverUntukTravel();
        if (driverPilihan == null) {
            return;
        }

        System.out.print("Jumlah Penumpang: ");
        int kapasitasPenumpang = Integer.parseInt(scanner.nextLine());

        System.out.print("Harga Travel per Orang (Rp): ");
        double hargaTravelPerOrang = Double.parseDouble(scanner.nextLine());

        System.out.print("Durasi Perjalanan (hari): ");
        int durasiHari = Integer.parseInt(scanner.nextLine());

        String idTransaksi = generateIDTransaksi();
        String tanggalTransaksi = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Buat objek TransaksiTravel
        TransaksiTravel transaksiTravel = new TransaksiTravel(idTransaksi, tanggalTransaksi, namaPelanggan,
                kontakPelanggan, durasiHari, mobilPilihan, driverPilihan, ruteAsal, ruteTujuan, kapasitasPenumpang,
                hargaTravelPerOrang);

        // tambahkan ke list
        dafTransaksi.add(transaksiTravel);

        // Tampilkan konfirmasi
        MenuUtama.clearScreen();
        System.out.println("\nTRANSAKSI BERHASIL DIBUAT!\n");
        transaksiTravel.displayInfoTransaksi();

        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    public void menampilkanSemuaTransaksi() {
        MenuUtama.clearScreen();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          DAFTAR SEMUA TRANSAKSI                ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        if (dafTransaksi.isEmpty()) {
            MenuUtama.pesanError("Belum ada transaksi!");
        } else {
            for (int i = 0; i < dafTransaksi.size(); i++) {
                System.out.println("No : " + (i + 1));
                dafTransaksi.get(i).displayInfoTransaksi();
                System.out.println();
            }
            System.out.println("Total transaksi : " + dafTransaksi.size());
        }

        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    public void menampilkanTransaksiSewa() {
        MenuUtama.clearScreen();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          DAFTAR TRANSAKSI SEWA MOBIL           ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        int count = 0;
        for (int i = 0; i < dafTransaksi.size(); i++) {
            if (dafTransaksi.get(i) instanceof TransaksiSewa) {
                count++;
                System.out.println("No : " + count);
                dafTransaksi.get(i).displayInfoTransaksi();
                System.out.println();
            }
        }

        if (count == 0) {
            MenuUtama.pesanError("Belum ada transaksi sewa!");
        } else {
            System.out.println("Total Transaksi sewa " + count);
        }

        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    public void menampilkanTransaksiTravel() {
        MenuUtama.clearScreen();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          DAFTAR TRANSAKSI TRAVEL               ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        int count = 0;
        for (int i = 0; i < dafTransaksi.size(); i++) {
            if (dafTransaksi.get(i) instanceof TransaksiTravel) {
                count++;
                System.out.println("No : " + count);
                dafTransaksi.get(i).displayInfoTransaksi();
                System.out.println();
            }
        }

        if (count == 0) {
            MenuUtama.pesanError("Belum ada transaksi Travel!");
        } else {
            System.out.println("Total transaksi sewa " + count);
        }

        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    public void hapusTransaksi() {
        MenuUtama.clearScreen();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          HAPUS TRANSAKSI                       ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        if (dafTransaksi.isEmpty()) {
            MenuUtama.pesanError("Belum ada transaksi!");
            System.out.print("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        for (int i = 0; i < dafTransaksi.size(); i++) {
            Transaksi trx = dafTransaksi.get(i);
            System.out.println("No. " + (i + 1) + " - " + trx.getIdTransaksi()
                    + " | " + trx.getJenisTransaksi()
                    + " | " + trx.getNamaPelanggan());
        }

        System.out.print("\nMasukkan nomor transaksi yang ingin dihapus (1-" + dafTransaksi.size() + "): ");
        int nomorInput = Integer.parseInt(scanner.nextLine());
        int index = nomorInput - 1;

        if (index < 0 || index >= dafTransaksi.size()) {
            MenuUtama.pesanError("Nomor tidak valid!");
            System.out.print("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        System.out.print("Apakah Anda yakin ingin menghapus transaksi ini? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            Transaksi transaksiDihapus = dafTransaksi.get(index);
            String idTranksaksi = transaksiDihapus.getIdTransaksi();

            // Kembalikan status mobil ke tersedia
            if (transaksiDihapus instanceof TransaksiSewa) {
                TransaksiSewa ts = (TransaksiSewa) transaksiDihapus;
                ts.getMobil().setKembaliTersedia();
                System.out.println("Mobil " + ts.getMobil().getNoPlat() + " kembali tersedia.");
            } else if (transaksiDihapus instanceof TransaksiTravel) {
                TransaksiTravel tt = (TransaksiTravel) transaksiDihapus;
                tt.getMobilTravel().setKembaliTersedia();
                tt.getDriver().setKembaliTersedia();
                System.out.println("Mobil " + tt.getMobilTravel().getNoPlat() + " kembali tersedia.");
                System.out.println("Driver " + tt.getDriver().getNama() + " kembali tersedia.");
            }

            dafTransaksi.remove(index);
            MenuUtama.pesanSukses("Transaksi " + idTranksaksi + " berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan...");
        }

        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Getter method untuk get
    public Transaksi getTransaksi(int index) {
        if (index >= 0 && index < dafTransaksi.size()) {
            return dafTransaksi.get(index);
        }
        return null;
    }

    public int getJumlahTransaksi() {
        return dafTransaksi.size();
    }
}
