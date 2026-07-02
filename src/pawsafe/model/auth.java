/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pawsafe.model;

/**
 *
 * @author asus
 */
public interface auth {
    boolean login(String username, String password);
    String getUsername();
    String getPassword();
}
