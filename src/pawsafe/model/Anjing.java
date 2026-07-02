package pawsafe.model;

public class Anjing extends Hewan {
    private boolean kolar; // Atribut spesifik Anjing (Punya kalung pemilik atau tidak)

    public Anjing(String idHewan, String ras, String kondisiKesehatan, boolean kolar) {
        // Memanggil constructor dari abstract class Hewan
        super(idHewan, ras, kondisiKesehatan);
        this.kolar = kolar;
    }

    // Polimorfisme: Override method getDeskripsi() secara spesifik
    @Override
    public String getDeskripsi() {
        return "Anjing Ras: " + getRas() + " | Kondisi: " + getKondisiKesehatan() + 
               " | Memakai Kolar: " + (kolar ? "Ya" : "Tidak");
    }

    // Implementasi kontrak dari Interface DapatDievakuasi
    @Override
    public String hitungPrioritas() {
        // Jika kondisi kritis atau luka parah, prioritasnya tinggi
        if (getKondisiKesehatan().equalsIgnoreCase("Luka Parah") || getKondisiKesehatan().equalsIgnoreCase("Kritis")) {
            return "TINGGI (Butuh Penanganan Medis)";
        }
        return "SEDANG";
    }

    @Override
    public int estimasiWaktuEvakuasi() {
        // Anjing berkolar biasanya lebih jinak, jadi evakuasi lebih cepat
        return kolar ? 15 : 25; 
    }

    // Getter dan Setter
    public boolean isKolar() { return kolar; }
    public void setKolar(boolean kolar) { this.kolar = kolar; }
}