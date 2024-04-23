/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.Configura;
import view.Login;

/**
 *
 * @author gabriel
 */
public class Main {
    public static void main(String[] args) {
        
        Configura.lookAndFeel("cd/motif");
        
        Login login = new Login();
        login.setVisible(true);
        
        String sobrenome = "Santos da Silva";
        
        String nome = "Felipe";
        
        String nomeF = nome + " " + sobrenome;
        
        System.out.println(sobrenome.length() < 5);
    }
}
