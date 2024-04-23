/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 *
 * @author Felipe
 */
public class Formata {
    
    /*Formatacao do CPF usando a classe DefaultMaskFormatter */
    public static DefaultFormatterFactory cpf(){
        
        MaskFormatter Mask = null;
        
        try{
        
            Mask = new MaskFormatter("###-###-###-##");
            Mask.setPlaceholderCharacter('_');
        
        }catch(ParseException e){
            System.out.println("Erro na Formatação do CPF !!!");
        }
        
        return(new DefaultFormatterFactory(Mask,Mask));
    }    
}
