
package Servidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mensagem {

        private Socket s;
        private ArrayList<PrintStream> clientes;
        
        public Mensagem(Socket s, ArrayList<PrintStream> clientes){
            this.s = s;
            this.clientes = clientes;
            
            Thread();
        }
        
    public void setS(Socket s) {
        this.s = s;
    }
    
    public void setClientes(ArrayList<PrintStream> clientes) {
        this.clientes = clientes;
    }
    
    private void Thread(){
        
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                
                String mensagem = "";

                try {

                    InputStreamReader isr = new InputStreamReader(s.getInputStream());
                    BufferedReader br = new BufferedReader(isr);

                    while((mensagem = br.readLine()) != null ){
                        enviarMensagem(mensagem);
                    }

                } catch (IOException ex) {
                   ex.printStackTrace();
                }              
            }           
        });    
        
        t.start();
    }
    
    /**Este metodo server para enviar a mensagem para todos os usuario que estiverem
     conectadso no servidor o ArrayList da classe "Servidor" ira passar no construtor 
     da classe "Mensagem" o numero de usuarios conectados, fazendo assim o array local
     ter o numero total e tendo uma varivael de controle para que ele envie ate atingir
     todos os usuarios.**/
    private void enviarMensagem(String mensagem){
        
        for(int i = 0; i < clientes.size(); i++){
            
            clientes.get(i).println(mensagem);
            clientes.get(i).flush();
        }
    
    }
    

        
        
    
}
