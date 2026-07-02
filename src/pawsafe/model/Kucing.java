package pawsafe.model;

public class Kucing extends Hewan {
    private String ukuran; // Atribut spesifik Kucing (Kecil, Sedang, Besar)

    public Kucing(String idHewan, String ras, String kondisiKesehatan, String ukuran) {
        // Memanggil constructor dari abstract class Hewan
        super(idHewan, ras, kondisiKesehatan);
        this.ukuran = ukuran;
    }

    // Polimorfisme: Override method getDeskripsi() secara spesifik
    @Override
    public String getDeskripsi() {
        return "Kucing Ras: " + getRas() + " | Kondisi: " + getKondisiKesehatan() + " | Ukuran Body: " + ukuran;
    }

    // Implementasi kontrak dari Interface DapatDievakuasi
    @Override
    public String hitungPrioritas() {
        if (getKondisiKesehatan().equalsIgnoreCase("Tenggelam") || getKondisiKesehatan().equalsIgnoreCase("Kritis")) {
            return "TINGGI (Sangat Mendesak)";
        }
        return "SEDANG";
    }

    @Override
    public int estimasiWaktuEvakuasi() {
        // Kucing kecil lebih gampang dimasukkan kandang evakuasi
        return ukuran.equalsIgnoreCase("Kecil") ? 10 : 20;
    }

    // Getter dan Setter
    public String getUkuran() { return ukuran; }
    public void setUkuran(String ukuran) { this.ukuran = ukuran; }
}