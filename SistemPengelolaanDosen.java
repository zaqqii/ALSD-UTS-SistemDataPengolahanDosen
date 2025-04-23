import java.util.Scanner;

public class SistemPengelolaanDosen {
    static Dosen[] daftarDosen = new Dosen[3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarDosen[0] = new Dosen("1234567890", "Budi Santoso", "budi221@gmail.com", 2015, "Teknik Informatika");
        daftarDosen[1] = new Dosen("0987654321", "Ani Rahayu", "ani112@gmail.com", 2018, "Akuntansi");
        daftarDosen[2] = new Dosen("1122334455", "Candra Wijaya", "candra331@gmail.com", 2010, "Manajemen");

        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1: tampilkanDataDosen(); break;
                case 2: urutkanBerdasarkanNIDN(); break;
                case 3: cariBerdasarkanNama(); break;
                case 4: urutkanBerdasarkanMasaKerja(); break;
                case 0: System.out.println("Terima kasih!"); return;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilkanMenu() {
        System.out.println("\n=== Sistem Pengelolaan Data Dosen Polinema ===");
        System.out.println("1. Tampilkan Data Dosen");
        System.out.println("2. Urutkan Berdasarkan NIDN");
        System.out.println("3. Cari Dosen Berdasarkan Nama");
        System.out.println("4. Urutkan Berdasarkan Masa Kerja");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void tampilkanDataDosen() {
        System.out.println("\nDaftar Dosen:");
        for (Dosen d : daftarDosen) {
            System.out.println(d);
        }
    }

    static void urutkanBerdasarkanNIDN() {
        for (int i = 0; i < daftarDosen.length - 1; i++) {
            for (int j = i + 1; j < daftarDosen.length; j++) {
                if (daftarDosen[i].nidn.compareTo(daftarDosen[j].nidn) > 0) {
                    Dosen temp = daftarDosen[i];
                    daftarDosen[i] = daftarDosen[j];
                    daftarDosen[j] = temp;
                }
            }
        }
        System.out.println("\nData dosen telah diurutkan berdasarkan NIDN (ascending):");
        tampilkanDataDosen();
    }

    static void cariBerdasarkanNama() {
        System.out.print("\nMasukkan nama dosen yang dicari: ");
        String namaCari = scanner.nextLine().toLowerCase();
        boolean ditemukan = false;

        for (Dosen d : daftarDosen) {
            if (d.nama.toLowerCase().contains(namaCari)) {
                System.out.println(d);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Dosen dengan nama tersebut tidak ditemukan.");
        }
    }

    static void urutkanBerdasarkanMasaKerja() {
        for (int i = 0; i < daftarDosen.length - 1; i++) {
            for (int j = i + 1; j < daftarDosen.length; j++) {
                if (daftarDosen[i].hitungMasaKerja() < daftarDosen[j].hitungMasaKerja()) {
                    Dosen temp = daftarDosen[i];
                    daftarDosen[i] = daftarDosen[j];
                    daftarDosen[j] = temp;
                }
            }
        }
        System.out.println("\nData dosen telah diurutkan berdasarkan masa kerja (descending):");
        tampilkanDataDosen();
    }
}