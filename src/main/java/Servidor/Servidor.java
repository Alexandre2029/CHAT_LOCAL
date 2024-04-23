
package Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor {
    
        public static void main(String args[]){        
            
          ArrayList <PrintStream> clientes = new ArrayList<>();
          
          
            try {
                
                ServerSocket server = new ServerSocket(5050);
                Socket socket;
                
                
                
                while(true){
                    socket = server.accept();
                    
                    //Guarda o Endereço do Cliente
                    clientes.add(new PrintStream(socket.getOutputStream()));
                    
                    Mensagem mensagem = new Mensagem(socket,clientes);
                    


                    
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
   
}