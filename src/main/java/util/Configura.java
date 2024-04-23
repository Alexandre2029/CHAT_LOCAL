/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.*;

/**
 *
 * @author Felipe
 */
public class Configura {
    
        public static void lookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
                if ("Windows".equals(info.getName())) { 
                    UIManager.setLookAndFeel(info.getClassName()); 
                    break; 
                } 
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Erro: " + e.getMessage()); 
            e.printStackTrace();

        }
         
    }
    
}
