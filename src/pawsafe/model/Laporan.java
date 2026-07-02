package pawsafe.model;

import pawsafe.interfaces.CSVSerializable;

public class Laporan implements CSVSerializable {
    private String namaPelapor;
    private String idLaporan;
    private Hewan hewan; // Hubungan Asosiasi (Has-A)
    private Shelter shelter; // Hubungan Asosiasi (Has-A)
    private String lokasi;
    private String status; // "Terjebak", "Dalam Penanganan Medis", "Terselamatkan"

    // Constructor
    public Laporan(String idLaporan, Hewan hewan, Shelter shelter, String lokasi, String status, String namaPelapor) {
        this.namaPelapor = namaPelapor;
        this.idLaporan = idLaporan;
        this.hewan = hewan;
        this.shelter = shelter;
        this.lokasi = lokasi;
        this.status = status;
    }

    @Override
    public String toCSV() {
        // Format: idLaporan,namaPelapor,jenisHewan,idShelter,lokasi,status
        String jenisHewan = hewan.getClass().getSimpleName(); // "Anjing" atau "Kucing"
        String idShelter = (shelter != null) ? shelter.getIdShelter() : "S-Default";
        return idLaporan + "," + namaPelapor + "," + jenisHewan + "," + idShelter + "," + lokasi + "," + status;
    }

    public static Laporan fromCSV(String baris) {
        try {
            String[] parts = baris.split(",", 6);
            String id = parts[0];
            String pelapor = parts[1];
            String jenisHewan = parts[2];
            // idShelter parts[3] - buat shelter placeholder
            String lok = parts[4];
            String stat = parts[5];

            // Buat hewan berdasarkan jenis yang tersimpan
            Hewan h = jenisHewan.equals("Anjing")
                ? new Anjing("H-Load", "Unknown", stat, false)
                : new Kucing("H-Load", "Unknown", stat, "Sedang");

            Shelter s = new Shelter(parts[3], "Shelter Tersimpan", "-", 10, 0);
            return new Laporan(id, h, s, lok, stat, pelapor);
        } catch (Exception e) {
            System.out.println("Gagal parse baris Laporan: " + baris);
            return null;
        }
    }

    // Method untuk Update Status (Bagian dari fungsi CRUD)
    public void updateStatus(String statusBaru) { 
        this.status = statusBaru; 
    }

    // Getter & Setter
    public String getNamaPelapor() { return namaPelapor; }
    
    public String getIdLaporan() { return idLaporan; }
    public void setIdLaporan(String idLaporan) { this.idLaporan = idLaporan; }
    
    public Hewan getHewan() { return hewan; }
    public void setHewan(Hewan hewan) { this.hewan = hewan; }
    
    public Shelter getShelter() { return shelter; }
    public void setShelter(Shelter shelter) { this.shelter = shelter; }
    
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}