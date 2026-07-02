package pawsafe.interfaces;

public interface DapatDievakuasi {
    // Kontrak perilaku/aksi untuk menentukan tingkat urgensi & estimasi evakuasi
    String hitungPrioritas();
    int estimasiWaktuEvakuasi(); // Mengembalikan estimasi waktu dalam satuan menit
}