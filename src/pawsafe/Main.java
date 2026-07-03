package pawsafe;

import pawsafe.model.*;
import pawsafe.manager.DataManager;
import pawsafe.gui.login;

/**
 * Main Class untuk menjalankan aplikasi PawSafe.
 * @author Lunna
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
        
        System.out.println("=== SISTEM PAWSAFE: BACKEND & GUI READY ===");
    }
}