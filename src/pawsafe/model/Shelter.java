package pawsafe.model;

import pawsafe.interfaces.CSVSerializable;

public class Shelter implements CSVSerializable {
    // Encapsulation: Atribut diset private
    private String idShelter;
    private String namaShelter;
    private String lokasi;
    private int kapasitas;
    private int terisi;

    // Constructor
    public Shelter(String idShelter, String namaShelter, String lokasi, int kapasitas, int terisi) {
        this.idShelter = idShelter;
        this.namaShelter = namaShelter;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
        this.terisi = terisi;
    }
    
    public boolean tambahPenghuni() {
        // Kita gunakan atribut yang sudah kamu deklarasikan di atas (terisi dan kapasitas)
        if (terisi < kapasitas) { 
            terisi++;
            return true; // Berhasil masuk
        }
        return false; // Penuh!
    }

    @Override
    public String toCSV() {
        // Format: idShelter,namaShelter,lokasi,kapasitas,terisi
        return idShelter + "," + namaShelter + "," + lokasi + "," + kapasitas + "," + terisi;
    }

    // Method statis untuk baca dari CSV (dipakai di DataManager)
    public static Shelter fromCSV(String baris) {
        try {
            String[] parts = baris.split(",", 5); // max 5 bagian
            String id = parts[0];
            String nama = parts[1];
            String lok = parts[2];
            int kap = Integer.parseInt(parts[3]);
            int ter = Integer.parseInt(parts[4]);
            return new Shelter(id, nama, lok, kap, ter);
        } catch (Exception e) {
            System.out.println("Gagal parse baris Shelter: " + baris);
            return null;
        }
    }

    // Operasional Method
    public void cekKapasitas() {
        System.out.println("Shelter " + namaShelter + " | Sisa Slot: " + (kapasitas - terisi));
    }

    // Metode tambahan untuk fungsionalitas evakuasi hewan ke shelter
    public boolean tambahHewan() {
        if (terisi < kapasitas) { 
            terisi++; 
            return true; 
        }
        return false;
    }

    // Getter & Setter
    public String getIdShelter() { return idShelter; }
    public void setIdShelter(String idShelter) { this.idShelter = idShelter; }
    
    public String getNamaShelter() { return namaShelter; }
    public void setNamaShelter(String namaShelter) { this.namaShelter = namaShelter; }
    
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    
    public int getKapasitas() { return kapasitas; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }
    
    public int getTerisi() { return terisi; }
    public void setTerisi(int terisi) { this.terisi = terisi; }
}