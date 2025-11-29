package service;

import entity.Karyawan;
import java.util.ArrayList;
import java.util.Scanner;
import util.MenuUtama;

public class ManajemenKaryawan {

    private final ArrayList<Karyawan> daftarKaryawan;
    private int jumlahKaryawan;
    private final Scanner scanner;

    // Constructor
    public ManajemenKaryawan() {
        this.daftarKaryawan = new ArrayList<>();
        this.jumlahKaryawan = 0;
        this.scanner = new Scanner(System.in);
    }

    public void inputDataKaryawan() {
        MenuUtama.clearScreen();
        System.out.println("=== INPUT DATA KARYAWAN ===");
        System.out.print("Nama karyawan : ");
        String nama = scanner.nextLine();
        System.out.print("Alamat : ");
        String alamat = scanner.nextLine();
        System.out.print("No. Telpon (+62): ");
        String noTelp = scanner.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Jabatan (Driver/Staff/Manager) : ");
        String jabatan = scanner.nextLine();

        Karyawan karyawanBaru = new Karyawan(nama, alamat, noTelp, jenisKelamin, jabatan);
        daftarKaryawan.add(karyawanBaru);
        jumlahKaryawan++;

        MenuUtama.pesanSukses("Data Karyawan Berhasil Ditambahkan!");
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Method untuk menampilkan data karyawan
    public void menampilkanDataKaryawan() {
        MenuUtama.clearScreen();
        System.out.println("=== DAFTAR DATA KARYAWAN ===");

        if (daftarKaryawan.isEmpty()) {
            MenuUtama.pesanError("Data masih kosong!");
        } else {
            for (int i = 0; i < daftarKaryawan.size(); i++) {
                System.out.println("Index : " + (i + 1));
                daftarKaryawan.get(i).displayInfoKaryawan();
                System.out.println();
            }
            System.out.println("Total karyawan : " + jumlahKaryawan);
        }

        System.out.print("\nTekan enter untuk melanjutkan...");
        scanner.nextLine();
    }

    // Method untuk mengubah data karyawan
    public void mengubahDataKaryawan() {
        MenuUtama.clearScreen();
        System.out.println("=== UBAH DATA KARYAWAN ===");

        if (daftarKaryawan.isEmpty()) {
            MenuUtama.pesanError("Belum ada data karyawan!");
            System.out.print("\nTekan enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Tampilkan daftar karyawan
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            System.out.println("Index " + (i + 1) + " - " + daftarKaryawan.get(i).getNama());
        }

        System.out.print("\nMasukkan index karyawan yang ingin diubah: ");
        int index = Integer.parseInt(scanner.nextLine());

        int newIndex = index - 1;

        if (newIndex < 0 || newIndex >= daftarKaryawan.size()) {
            MenuUtama.pesanError("Index tidak valid!");
            System.out.print("\nTekan enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        Karyawan karyawan = daftarKaryawan.get(newIndex);
        System.out.println("\nData saat ini:");
        karyawan.displayInfoKaryawan();

        // Input Data baru
        System.out.println("\nMasukkan data baru (tekan Enter untuk tidak mengubah):");
        System.out.print("Nama [" + karyawan.getNama() + "]: ");
        String nama = scanner.nextLine();
        if (!nama.trim().isEmpty()) {
            karyawan.setNama(nama);
        }

        System.out.print("Alamat [" + karyawan.getAlamat() + "]: ");
        String alamat = scanner.nextLine();
        if (!alamat.trim().isEmpty()) {
            karyawan.setAlamat(alamat);
        }

        System.out.print("No. Telepon [" + karyawan.getNoTelp() + "]: ");
        String noTelp = scanner.nextLine();
        if (!noTelp.trim().isEmpty()) {
            karyawan.setNoTelp(noTelp);
        }

        System.out.print("Jenis Kelamin [" + karyawan.getJenisKelamin() + "] (L/P): ");
        String jenisKelamin = scanner.nextLine();
        if (!jenisKelamin.trim().isEmpty()) {
            karyawan.setJenisKelamin(jenisKelamin);
        }

        System.out.print("Jabatan [" + karyawan.getJabatan() + "]: ");
        String jabatan = scanner.nextLine();
        if (!jabatan.trim().isEmpty()) {
            karyawan.setJabatan(jabatan);
        }

        MenuUtama.pesanSukses("Data karyawan berhasil diubah!");
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();

    }

    // Method untuk menghapus data karyawan
    public void menghapusDataKaryawan() {
        MenuUtama.clearScreen();
        System.out.println("=== HAPUS DATA KARYAWAN ===");

        if (daftarKaryawan.isEmpty()) {
            MenuUtama.pesanError("Belum ada data karyawan!");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        // Tampilkan daftar karyawan
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            System.out.println("Index: " + (i + 1) + " - " + daftarKaryawan.get(i).getNama());
        }

        System.out.print("\nMasukkan index karyawan yang ingin dihapus: ");
        int index = Integer.parseInt(scanner.nextLine());

        int newIndex = index - 1;

        if (newIndex < 0 || newIndex >= daftarKaryawan.size()) {
            MenuUtama.pesanError("Index tidak valid!");
            System.out.print("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
            return;
        }

        System.out.print("Apakah Anda yakin ingin menghapus data ini? (y/n): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            String namaKaryawan = daftarKaryawan.get(newIndex).getNama();
            daftarKaryawan.remove(newIndex);
            jumlahKaryawan--;
            MenuUtama.pesanSukses("Data karyawan " + namaKaryawan + " berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan!");
        }

        System.out.print("\nTekan enter untuk melanjutkan...");
        scanner.nextLine();

    }

    // Getter method
    public Karyawan getKaryawan(int index) {
        if (index >= 0 && index < daftarKaryawan.size()) {
            return daftarKaryawan.get(index);
        }
        return null;
    }

    public int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public void kembaliKeMain() {
        // Kembali ke main
    }

    public Karyawan pilihDriverUntukTravel() {
        System.out.println("\n=== PILIH KARYAWAN ===");

        if (daftarKaryawan.isEmpty()) {
            MenuUtama.pesanError("Belum ada data karyawan!");
            return null;
        }
        // Menampilkan driver yang kategori driver dan MASIH TERSEDIA
        ArrayList<Karyawan> daftarDriverTersedia = new ArrayList<>();

        for (Karyawan k : daftarKaryawan) {
            if (k.getJabatan().equalsIgnoreCase("Driver") && k.isTersedia()) {
                daftarDriverTersedia.add(k);
            }
        }

        if (daftarDriverTersedia.isEmpty()) {
            MenuUtama.pesanError("Tidak ada Driver yang tersedia. Semua driver sedang bekerja!");
            return null;
        }

        // Menampilkan driver yang TERSEDIA
        System.out.println("Daftar Driver Tersedia:");
        for (int i = 0; i < daftarDriverTersedia.size(); i++) {
            System.out.println("No. " + (i + 1) + " - " + daftarDriverTersedia.get(i).getNama()
                    + " | " + daftarDriverTersedia.get(i).getNoTelp()
                    + " - [" + daftarDriverTersedia.get(i).getStatus() + "]");
        }

        System.out.print("\nPilih nomor karyawan (1-" + daftarDriverTersedia.size() + "): ");
        int nomorInput = scanner.nextInt();

        // konversi ke index
        int index = nomorInput - 1;

        if (index < 0 || index >= daftarDriverTersedia.size()) {
            MenuUtama.pesanError("Nomor tidak valid!");
            return null;
        }
        return daftarDriverTersedia.get(index);
    }
}
