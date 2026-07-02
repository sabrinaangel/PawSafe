/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pawsafe;

import pawsafe.manager.DataManager;
import pawsafe.model.Laporan;
import pawsafe.model.Shelter;
/**
 *
 * @author asus
 */
public class DataGlobal {
    // Ini yang akan diakses oleh Dashboard.java
    public static DataManager<Laporan> laporanManager = new DataManager<>();
    public static DataManager<Shelter> shelterManager = new DataManager<>();
}
