
package view;
import dao.UsuarioDao;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class TelaChat extends javax.swing.JFrame {
    
    private String nome;
    private Socket s;
    private BufferedReader br;
    private InputStreamReader isr;
    private List<String> lista = new ArrayList<String>();
    private boolean rodar = true;
    

    public TelaChat(String nome) {
        
        initComponents();
        
        this.nome = nome;
        carregaArray();
        setLabelNome(nome.toUpperCase());
        MensagemEnviada.requestFocus();
        
        
     try{
            s = new Socket("192.168.3.7", 5050);
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Falha ao Conectar no Servidor !!!");
           System.exit(0);
        }    
        
        Thread();       
    }
    
    private void Thread(){
        
       
    
        Thread t = new Thread(new Runnable() {
            
            String mensagem;
            
            @Override
            public void run() {
                
                try {
                    
                    isr = new InputStreamReader(s.getInputStream());
                    br = new BufferedReader(isr);
                    
                    while((mensagem = br.readLine()) != null){
                        
                        MensagemRecebida.setText(MensagemRecebida.getText() + mensagem + "\n");
                    }                    
                }catch (IOException ex) {
                    ex.printStackTrace();
                }              
            }
        });
        
        t.start();
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        MensagemRecebida = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        MensagemEnviada = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 0));

        MensagemRecebida.setEditable(false);
        MensagemRecebida.setColumns(20);
        MensagemRecebida.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        MensagemRecebida.setRows(5);
        MensagemRecebida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(MensagemRecebida);

        MensagemEnviada.setColumns(20);
        MensagemEnviada.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        MensagemEnviada.setRows(5);
        MensagemEnviada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MensagemEnviada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MensagemEnviadaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(MensagemEnviada);

        btnEnviar.setText("Enviar");
        btnEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Seja Bem Vindo");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(183, 230, 230));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 108, 138), 2));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 40)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Área de Chat");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
       
        
        String mensagem = "\n" + nome  + " disse : \n";
        
        try {
            
            PrintStream ps = new PrintStream(s.getOutputStream());
            mensagem += MensagemEnviada.getText();
            for (int i = 0; i < lista.size(); i++) {
                if (mensagem.toLowerCase().contains(lista.get(i))) {
                    ps.println("Essa mensagem possui palavras de cunho ofensivo!");
                    return;
                }
            }
            
           ps.println(mensagem);
           ps.flush();
           
           MensagemEnviada.setText("");
           MensagemEnviada.requestFocus();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao enviar a mensagem !!","",ERROR);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void MensagemEnviadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MensagemEnviadaKeyPressed
        

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
            String mensagem = "\n" + nome  + " disse : \n";
        
        try {
            
            PrintStream ps = new PrintStream(s.getOutputStream());
            mensagem += MensagemEnviada.getText();
            for (int i = 0; i < lista.size(); i++) {
                if (mensagem.toLowerCase().contains(lista.get(i))) {
                    ps.println("Essa mensagem possui palavras de cunho ofensivo!");
                    MensagemEnviada.requestFocus();
                    return;
                }
            }
           ps.println(mensagem);
           ps.flush();
           
           MensagemEnviada.setText("");
           MensagemEnviada.requestFocus();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao enviar a mensagem !!","",ERROR);
        }
        
        
        }   
    }//GEN-LAST:event_MensagemEnviadaKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        try {
                
                s.close();
                System.exit(0);
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnSairActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea MensagemEnviada;
    private javax.swing.JTextArea MensagemRecebida;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables

    public void carregaArray(){      
        for(String p:UsuarioDao.block()){
            this.lista.add(p);
        }
    }
    
    public void setLabelNome(String nome){
        lblNome.setText(nome);
    }
}
