package pawsafe.model;

public abstract class Pengguna {
    private String idPengguna;
    private String nama;
    private String noTelp;

    // Constructor
    public Pengguna(String idPengguna, String nama, String noTelp) {
        this.idPengguna = idPengguna;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    // Abstract Method untuk Polymorphism Aktor
    public abstract void tampilkanInfo();

    // Getter dan Setter
    public String getIdPengguna() { return idPengguna; }
    public void setIdPengguna(String idPengguna) { this.idPengguna = idPengguna; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
}