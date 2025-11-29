package service;

import entity.Mobil;
import java.util.ArrayList;
import java.util.Scanner;
import util.MenuUtama;

public class ManajemenMobil {

    private ArrayList<Mobil> daftarMobil;
    private int jumlahMobil;
    private Scanner scanner;

    // Constructor
    public ManajemenMobil() {
        this.daftarMobil = new ArrayList<>();
        this.jumlahMobil = 0;
        this.scanner = new Scanner(System.in);
    }

    public void inputDataMobil() {
        MenuUtama.clearScreen();
        System.out.println("=== INPUT DATA MOBIL ===");
        System.out.print("No. Plat : ");
        String noPlat = scanner.nextLine();
        System.out.print("Merek Mobil : ");
        String merkMobil = scanner.nextLine();
        System.out.print("Warna Mobil : ");
        String warna = scanner.nextLine();
        System.out.print("Tahun Keluaran (YYYY): ");
        String tahunKeluaran = scanner.nextLine();

        Mobil mobilBaru = new Mobil(noPlat, merkMobil, warna, tahunKeluaran);
        daftarMobil.add(mobilBaru);
        jumlahMobil++;

        MenuUtama.pesanSukses("Data Mobil Berhasil Ditambahkan!");
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Method untuk menampilkan data mobil
    public void menampilkanDataMobil() {
        MenuUtama.clearScreen();
        System.out.println("=== DAFTAR DATA MOBIL ===");

        if (daftarMobil.isEmpty()) {
            MenuUtama.pesanError("Data masih kosong!");
        } else {
            for (int i = 0; i < daftarMobil.size(); i++) {
                System.out.println("Index : " + (i + 1));
                daftarMobil.get(i).displayInfoMobil();
                System.out.println();
            }
            System.out.println("Total karyawan : " + jumlahMobil);
        }

        System.out.print("\nTekan enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Method untuk mengubah data mobil
    public void mengubahDataMobil() {
        MenuUtama.clearScreen();
        System.out.println("=== UBAH DATA MOBIL ===");

        if (daftarMobil.isEmpty()) {
            MenuUtama.pesanError("Belum ada data mobil!");
            System.out.print("\nTekan enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Tampilkan daftar karyawan
        for (int i = 0; i < daftarMobil.size(); i++) {
            System.out.println("Index " + (i + 1) + " - " + daftarMobil.get(i).getNoPlat());
        }

        System.out.print("\nMasukkan index mobil yang ingin diubah: ");
        int index = Integer.parseInt(scanner.nextLine());
        int newIndex = index - 1;

        if (newIndex < 0 || newIndex >= daftarMobil.size()) {
            MenuUtama.pesanError("Index tidak valid!");
            System.out.print("\nTekan enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        Mobil mobil = daftarMobil.get(newIndex);
        System.out.println("\nData saat ini:");
        mobil.displayInfoMobil();

        // Input Data baru
        System.out.println("\nMasukkan data baru (tekan Enter untuk tidak mengubah): ");
        System.out.print("No. Plat [" + mobil.getNoPlat() + "]: ");
        String noPlat = scanner.nextLine();
        if (!noPlat.trim().isEmpty()) {
            mobil.setNoPlat(noPlat);
        }

        System.out.print("Merek Mobil [" + mobil.getMerkMobil() + "]: ");
        String merkMobil = scanner.nextLine();
        if (!merkMobil.trim().isEmpty()) {
            mobil.setMerkMobil(merkMobil);
        }

        System.out.print("Warna Mobil [" + mobil.getWarnaMobil() + "]: ");
        String warna = scanner.nextLine();
        if (!warna.trim().isBlank()) {
            mobil.setWarnaMobil(warna);
        }

        System.out.print("Tahun Keluaran [" + mobil.getTahunKeluaran() + "]: ");
        String tahunKeluaran = scanner.nextLine();
        if (!tahunKeluaran.trim().isBlank()) {
            mobil.setTahunKeluaran(tahunKeluaran);
        }

        MenuUtama.pesanSukses("Data mobil berhasil diubah!");
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Method untuk menghapus data mobil
    public void menghapusDataMobil() {
        MenuUtama.clearScreen();
        System.out.println("=== HAPUS DATA MOBIL ===");

        if (daftarMobil.isEmpty()) {
            MenuUtama.pesanError("Belum ada data Mobil!");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Tampilkan daftar mobil
        for (int i = 0; i < daftarMobil.size(); i++) {
            System.out.println("Index: " + (i + 1) + " - " + daftarMobil.get(i).getNoPlat());
        }

        System.out.print("\nMasukkan index mobil yang ingin dihapus: ");
        int index = Integer.parseInt(scanner.nextLine());
        int newIndex = index - 1;

        if (newIndex < 0 || newIndex >= daftarMobil.size()) {
            MenuUtama.pesanError("Index tidak valid!");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        System.out.print("Apakah Anda yakin ingin menghapus data ini? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            String noPlatMobil = daftarMobil.get(newIndex).getNoPlat();
            daftarMobil.remove(newIndex);
            jumlahMobil--;
            MenuUtama.pesanSukses("Data mobil " + noPlatMobil + " berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan!");
        }

        System.out.print("\nTekan enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Getter method
    public Mobil getMobil(int index) {
        if (index >= 0 && index < daftarMobil.size()) {
            return daftarMobil.get(index);
        }
        return null;
    }

    public int getJumlahMobil() {
        return jumlahMobil;
    }

    public void kembaliKeMain() {
        // Kembali ke main
    }

    public Mobil pilihMobilUntukTransaksi() {
        System.out.println("\n=== PILIH MOBIL ===");

        if (daftarMobil.isEmpty()) {
            MenuUtama.pesanError("Belum ada data mobil!");
            return null;
        }

        boolean adaTersedia = false;
        for (Mobil m : daftarMobil) {
            if (m.isTersedia()) {
                adaTersedia = true;
                break;
            }
        }

        if (!adaTersedia) {
            MenuUtama.pesanError("Semua mobil sedang digunakan! Tidak ada mobil tersedia");
            return null;
        }

        // Menampilkan mobil yang tersedia saja
        System.out.println("Daftar Mobil Tersedia:");
        int nomor = 1; // <- digunakan untuk penomoran di for, karena menggunakan for each

        ArrayList<Mobil> mobilTersedia = new ArrayList<>();

        for (Mobil m : daftarMobil) {
            if (m.isTersedia()) {
                System.out.println("No. " + nomor + " - " + m.getMerkMobil()
                        + " | " + m.getNoPlat()
                        + " (" + m.getWarnaMobil() + ") - [" + m.getStatus() + "]");
                mobilTersedia.add(m);
                nomor++;
            }
        }

        System.out.print("\nPilih nomor mobil (1-" + mobilTersedia.size() + "): ");
        int nomorInput = scanner.nextInt();

        // konversi ke index
        int index = nomorInput - 1;

        if (index < 0 || index >= mobilTersedia.size()) {
            MenuUtama.pesanError("Nomor tidak valid!");
            return null;
        }

        return mobilTersedia.get(index);

    }
}
