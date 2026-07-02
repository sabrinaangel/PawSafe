package pawsafe.model;

import pawsafe.interfaces.DapatDievakuasi;

public abstract class Hewan implements DapatDievakuasi {
    // Encapsulation: Atribut di-set private sesuai revisi proposal
    private String idHewan;
    private String ras;
    private String kondisiKesehatan;

    // Constructor untuk inisialisasi objek hewan
    public Hewan(String idHewan, String ras, String kondisiKesehatan) {
        this.idHewan = idHewan;
        this.ras = ras;
        this.kondisiKesehatan = kondisiKesehatan;
    }

    // Abstract Method untuk di-override oleh Anjing & Kucing (Polymorphism)
    public abstract String getDeskripsi();

    // Getter dan Setter untuk akses data secara aman
    public String getIdHewan() { return idHewan; }
    public void setIdHewan(String idHewan) { this.idHewan = idHewan; }

    public String getRas() { return ras; }
    public void setRas(String ras) { this.ras = ras; }

    public String getKondisiKesehatan() { return kondisiKesehatan; }
    public void setKondisiKesehatan(String kondisiKesehatan) { this.kondisiKesehatan = kondisiKesehatan; }
}