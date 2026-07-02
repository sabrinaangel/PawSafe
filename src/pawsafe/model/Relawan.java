package pawsafe.model;

public class Relawan extends Pengguna implements auth {
    private String username;
    private String password;
    private String keahlian;
    private boolean statusAktif;

    public Relawan(String id, String nama, String telp, String username, String password) {
        super(id, nama, telp);
        this.username = username;
        this.password = password;
        this.keahlian = "Umum"; // Default
        this.statusAktif = true;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[Relawan] ID: " + getIdPengguna() + " | Nama: " + getNama() + " | Keahlian: " + getKeahlian());
    }

    public void evakuasi(Hewan h) {
        System.out.println("Relawan " + getNama() + " sedang mengevakuasi hewan.");
    }

    @Override
    public boolean login(String inputUser, String inputPass) {
        return this.username.equals(inputUser) && this.password.equals(inputPass);
    }

    // WAJIB ADA: Getter keahlian
    public String getKeahlian() { 
        return keahlian; 
    }

    @Override
    public String getUsername() { return username; }
    
    @Override
    public String getPassword() { return password; }
}