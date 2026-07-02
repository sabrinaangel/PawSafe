package pawsafe.model;

public class Admin extends Pengguna {
    private String username;
    private String password; // Tipe data dirubah dari varchar ke String agar valid di Java

    public Admin(String idPengguna, String nama, String noTelp, String username, String password) {
        super(idPengguna, nama, noTelp);
        this.username = username;
        this.password = password;
    }

    // Method operasional admin
    public void kelolaData() {
        System.out.println("Admin " + getNama() + " memasuki mode manajemen data sistem.");
    }

    // Override info khusus admin (Polymorphism)
    @Override
    public void tampilkanInfo() {
        System.out.println("[Admin] ID: " + getIdPengguna() + " | Nama: " + getNama() + " | Username: " + username);
    }

    // Getter dan Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}