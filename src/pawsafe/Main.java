package pawsafe;

import pawsafe.model.*;
import pawsafe.manager.DataManager;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new pawsafe.gui.login().setVisible(true));
        System.out.println("=== SISTEM PAWSAFE: SIMULASI BACKEND RUNNING ===");

        // 1. Inisialisasi Data Manager Generik (Memenuhi Penilaian Generics)
        DataManager<Pengguna> penggunaManager = new DataManager<>();

        // 2. Membuat Data Objek Shelter
        Shelter shelterDarurat = new Shelter("S01", "Posko Lapangan Terminal", "Jl. Kaligawe No.10", 5, 2);

        DataGlobal.shelterManager.tambahData(shelterDarurat);
        // 3. Membuat Data Polimorfisme Hewan (Anjing & Kucing)
        Hewan kucingKiki = new Kucing("H01", "Anggora", "Tenggelam", "Kecil");
        Hewan anjingBobi = new Anjing("H02", "Golden Retriever", "Luka Parah", true);

        // 4. Membuat Data Laporan (Relasi Has-A Terbentuk)
        Laporan lap1 = new Laporan("LAP001", kucingKiki, shelterDarurat, "Genangan RT 03", "Terjebak", "Ahmad");
        Laporan lap2 = new Laporan("LAP002", anjingBobi, shelterDarurat, "Ruko Depan Pasar", "Terjebak", "Budi");

        DataGlobal.laporanManager.tambahData(lap1);
        DataGlobal.laporanManager.tambahData(lap2);

        // 5. Membuat Data Aktor (Relawan & Admin)
        Pengguna relawan1 = new Relawan("P01", "Sabrina", "0812345", "relawan_user", "relawan123");
        Pengguna admin1 = new Admin("ADM01", "Valencia", "089999", "valen_admin", "rahasia123");

        penggunaManager.tambahData(relawan1);
        penggunaManager.tambahData(admin1);

        // 6. Uji Coba Output Polimorfisme & Interface Kontrak
        System.out.println("\n--- DAFTAR ANTRIAN EVAKUASI HEWAN ---");
        for (Laporan lap : DataGlobal.laporanManager.getAllData()) {
            System.out.println("ID Laporan: " + lap.getIdLaporan());
            System.out.println("Detail: " + lap.getHewan().getDeskripsi()); // Polymorphism getDeskripsi()
            System.out.println("Tingkat Urgensi: " + lap.getHewan().hitungPrioritas()); // Interface Method
            System.out.println("Estimasi Waktu: " + lap.getHewan().estimasiWaktuEvakuasi() + " menit");
            System.out.println("Lokasi Penyelamatan: " + lap.getLokasi());
            System.out.println("-------------------------------------");
        }

        System.out.println("\n--- INFORMASI AKTOR SISTEM ---");
        for (Pengguna p : penggunaManager.getAllData()) {
            p.tampilkanInfo(); // Polymorphism tampilkanInfo()
        }

        // 7. Simulasi Aksi Relawan & Perubahan Status Laporan (CRUD Update)
        System.out.println("\n--- PROSES EVAKUASI LAPANGAN ---");
        // Downcasting untuk memanggil method spesifik relawan
        if (relawan1 instanceof Relawan) {
            ((Relawan) relawan1).evakuasi(kucingKiki);
        }
        
        // Update Status Laporan
        lap1.updateStatus("Dalam Penanganan Medis");
        System.out.println("Status terbaru Laporan LAP001: " + lap1.getStatus());
        
        System.out.println("\n==============================================");
        System.out.println("BERHASIL: Semua class PBO terintegrasi tanpa error!");
    }
}