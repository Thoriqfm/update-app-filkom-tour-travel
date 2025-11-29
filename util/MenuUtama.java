package util;

/*
* Util MenuUtama digunakan untuk membantu menampilkan menu-menu untuk user
* Terdapat juga beberapa tambahan untuk menunjang platform (ada beberapa terpakai dan tidak)
 */

public class MenuUtama {

    public static void tampilkanMenu() {
        System.out.println("\n===== SISTEM MANAJEMEN KARYAWAN & MOBIL =====");
        System.out.println("1. Manejemen Karyawan");
        System.out.println("2. Manejemen Mobil");
        System.out.println("3. Pesan Travel & Sewa Mobil");
        System.out.println("4. Exit Program");
        System.out.print("Pilih menu: ");
    }

    // Menu Karyawan
    public static void tampilkanMenuKaryawan() {
        System.out.println("\n===== MANAJEMEN KARYAWAN =====");
        System.out.println("1. Input Data Karyawan");
        System.out.println("2. Tampilan Data Karyawan");
        System.out.println("3. Ubah Data Karyawan");
        System.out.println("4. Hapus Data Karyawan");
        System.out.println("5. Kembali ke Menu Utama");
        System.out.print("Pilih menu: ");
    }

    // Menu Mobil
    public static void tampilkanMenuMobil() {
        System.out.println("\n===== MANAJEMEN MOBIL =====");
        System.out.println("1. Input Data Mobil");
        System.out.println("2. Tampilan Data Mobil");
        System.out.println("3. Ubah Data Mobil");
        System.out.println("4. Hapus Data Mobil");
        System.out.println("5. Kembali ke Menu Utama");
        System.out.print("Pilih menu: ");
    }

    // Menu Transaksi
    public static void tampilkanMenuTransaksi() {
        System.out.println("\n===== MENU PEMESANAN =====");
        System.out.println("1. Masukkan Pesanan Sewa");
        System.out.println("2. Masukkan Pesanan Travel");
        System.out.println("3. Hapus Transaksi");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.print("Pilih menu: ");
    }

    // Behavior : Tampilkan pesan sukses
    public static void pesanSukses(String pesan) {
        System.out.println("\nV " + pesan);
    }

    // Behavior : Tampilan pesan error
    public static void pesanError(String pesan) {
        System.out.println("\nX " + pesan);
    }

    // Behavior : Tampilkan garis pemisah
    public static void garisPemisah() {
        System.out.println("════════════════════════════════════════════════");
    }

    // Clear screen (simulasi)
    public static void clearScreen() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}
