
import java.util.Scanner;
import service.*;
import util.MenuUtama;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static ManajemenKaryawan karyawanData = new ManajemenKaryawan();
    private final static ManajemenMobil mobilData = new ManajemenMobil();
    private final static ManajemenTransaksi transaksiData = new ManajemenTransaksi();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("========= SELAMAT DATANG ========");
        System.out.println("SISTEM MANAJEMEN KARYAWAN & MOBIL");
        System.out.print("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();

        while (running) {
            MenuUtama.tampilkanMenu();
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> {
                    manajemenKaryawan();
                }
                case 2 -> {
                    manajemenMobil();
                }
                case 3 -> {
                    manajemenTransaksi();
                }
                case 4 -> {
                    running = false;
                    exit();
                }
                default -> {
                    MenuUtama.pesanError("Pilihan tidak valid!");
                    System.out.println("\nTekan enter untuk melanjutkan...");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void manajemenKaryawan() {
        boolean jalan = true;

        while (jalan) {
            MenuUtama.tampilkanMenuKaryawan();
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1: {
                    karyawanData.inputDataKaryawan();
                    break;
                }
                case 2: {
                    karyawanData.menampilkanDataKaryawan();
                    break;
                }
                case 3: {
                    karyawanData.mengubahDataKaryawan();
                    break;
                }
                case 4: {
                    karyawanData.menghapusDataKaryawan();
                }
                case 5: {
                    jalan = false;
                    break;
                }
                default: {
                    MenuUtama.pesanError("Pilihan tidak valid!");
                    System.out.println("\nTekan enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;
                }
            }
        }
    }

    public static void manajemenMobil() {
        boolean jalan = true;

        while (jalan) {
            MenuUtama.tampilkanMenuMobil();
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1: {
                    mobilData.inputDataMobil();
                    break;
                }
                case 2: {
                    mobilData.menampilkanDataMobil();
                    break;
                }
                case 3: {
                    mobilData.mengubahDataMobil();
                    break;
                }
                case 4: {
                    mobilData.menghapusDataMobil();
                }
                case 5: {
                    jalan = false;
                    break;
                }
                default: {
                    MenuUtama.pesanError("Pilihan tidak valid!");
                    System.out.println("\nTekan enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;
                }
            }
        }
    }

    public static void manajemenTransaksi() {
        boolean jalan = true;

        while (jalan) {
            MenuUtama.tampilkanMenuTransaksi();
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> {
                    transaksiData.inputTransaksiSewa(mobilData);
                }
                case 2 -> {
                    transaksiData.inputTransaksiTravel(mobilData, karyawanData);
                }
                case 3 -> {
                    transaksiData.hapusTransaksi();
                }
                case 4 -> {
                    jalan = false;
                }
                default -> {
                    MenuUtama.pesanError("Pilihan tidak valid!");
                    System.out.println("\nTekan enter untuk melanjutkan");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void exit() {
        MenuUtama.clearScreen();
        System.out.println("===== TERIMA KASIH =====");
        System.out.println("Telah menggunakan program!");
        System.out.println("\nTotal Data:");
        System.out.println("- Karyawan: " + karyawanData.getJumlahKaryawan());
        System.out.println("- Mobil: " + mobilData.getJumlahMobil());
        System.out.println("\nProgram Selesai...");
        scanner.close();

    }
}
