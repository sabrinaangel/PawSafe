package pawsafe.model;

public class Relawan extends Pengguna {
    private String keahlian;
    private boolean statusAktif;

    public Relawan(String idPengguna, String nama, String noTelp, String keahlian, boolean statusAktif) {
        super(idPengguna, nama, noTelp);
        this.keahlian = keahlian;
        this.statusAktif = statusAktif;
    }

    // Implementasi aksi evakuasi
    public void evakuasi(Hewan h) {
        if (statusAktif) {
            System.out.println("Relawan " + getNama() + " sedang mengevakuasi hewan dengan ID: " + h.getIdHewan());
        } else {
            System.out.println("Relawan " + getNama() + " sedang tidak aktif.");
        }
    }

    // Override info khusus relawan (Polymorphism)
    @Override
    public void tampilkanInfo() {
        System.out.println("[Relawan] ID: " + getIdPengguna() + " | Nama: " + getNama() + 
                           " | Keahlian: " + keahlian + " | Aktif: " + (statusAktif ? "Ya" : "Tidak"));
    }

    // Getter dan Setter
    public String getKeahlian() { return keahlian; }
    public void setKeahlian(String keahlian) { this.keahlian = keahlian; }

    public boolean isStatusAktif() { return statusAktif; }
    public void setStatusAktif(boolean statusAktif) { this.statusAktif = statusAktif; }
}