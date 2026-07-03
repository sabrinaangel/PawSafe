package pawsafe.manager;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import pawsafe.interfaces.CSVSerializable;

public class DataManager<T> {
    private ArrayList<T> listData;

    public DataManager() {
        this.listData = new ArrayList<>();
    }

    public void tambahData(T data) {
        listData.add(data);
    }

    public ArrayList<T> getAllData() {
        return listData;
    }

    public void updateData(int index, T dataBaru) {
        if (index >= 0 && index < listData.size()) {
            listData.set(index, dataBaru);
        } else {
            throw new IndexOutOfBoundsException("Gagal Update: Indeks tidak valid.");
        }
    }

    public void hapusData(int index) {
        if (index >= 0 && index < listData.size()) {
            listData.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Gagal Hapus: Indeks tidak valid.");
        }
    }

    public void simpanCSV(String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile, false))) {
        for (T item : listData) {
            if (item instanceof CSVSerializable) {
                writer.write(((CSVSerializable) item).toCSV());
                writer.newLine();
            }
        }
        System.out.println("Data berhasil disimpan ke: " + namaFile);
    } catch (IOException e) {
        System.out.println("Gagal menyimpan file: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(null,
            "Gagal menyimpan data!\n" + e.getMessage(),
            "Error File I/O", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    public void bacaCSV(String namaFile, CSVLoader<T> loader) {
        listData.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                if (!baris.trim().isEmpty()) {
                    T item = loader.fromCSV(baris);
                    if (item != null) {
                        listData.add(item);
                    }
                }
            }
            System.out.println("Data berhasil dimuat dari: " + namaFile);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File " + namaFile + " belum ada, mulai dengan data kosong.");
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,
                "Gagal memuat data!\n" + e.getMessage(),
                "Error File I/O", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public interface CSVLoader<T> {
        T fromCSV(String baris);
    }
}