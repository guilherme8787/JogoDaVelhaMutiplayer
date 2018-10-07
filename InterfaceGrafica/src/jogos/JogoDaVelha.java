/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Orion
 */
public class JogoDaVelha extends javax.swing.JFrame {
    
    int VitoriaDoJogador1 = 0;
    int VitoriaDoJogador2 = 0;
    int PartidasEmpatadas = 0; 
    public String p;
    public int fl = 0;
    public boolean joga1 = true;
    public boolean joga2 = false;
    
    public void start(){
            initComponents();
    }
    public void setP(String msg){
        this.p = msg;
    }
    
    public void setBotao(String msg){
        
        //if(this.fl == 0){
            setP(msg.substring(0,2));
            //fl = 1;
        //}
        
        if(msg.equals("P1B1")){
            if(B1.getText().equals("") && !B1.getText().equals("0") && joga1 == true){
                B1.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B1")){
            if(B1.getText().equals("") && !B1.getText().equals("X") && joga1 == false){
                B1.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B2")){
            if(B2.getText().equals("") && !B2.getText().equals("0") && joga1 == true){
                B2.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B2")){
            if(B2.getText().equals("") && !B2.getText().equals("X") && joga1 == false){
                B2.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B3")){
            if(B3.getText().equals("") && !B3.getText().equals("0") && joga1 == true){
                B3.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B3")){
            if(B3.getText().equals("") && !B3.getText().equals("X") && joga1 == false){
                B3.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B4")){
            if(B4.getText().equals("") && !B4.getText().equals("0") && joga1 == true){
                B4.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B4")){
            if(B4.getText().equals("") && !B4.getText().equals("X") && joga1 == false){    
                B4.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B5")){
            if(B5.getText().equals("") && !B5.getText().equals("0") && joga1 == true){
                B5.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B5")){
            if(B5.getText().equals("") && !B5.getText().equals("X") && joga1 == false){
                B5.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B6")){
            if(B6.getText().equals("") && !B6.getText().equals("0") && joga1 == true){
                B6.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B6")){
            if(B6.getText().equals("") && !B6.getText().equals("X") && joga1 == false){
                B6.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B7")){
            if(B7.getText().equals("") && !B7.getText().equals("0") && joga1 == true){
                B7.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B7")){
            if(B7.getText().equals("") && !B7.getText().equals("X") && joga1 == false){
                B7.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B8")){
            if(B8.getText().equals("") && !B8.getText().equals("0") && joga1 == true){
                B8.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B8")){
            if(B8.getText().equals("") && !B8.getText().equals("X") && joga1 == false){
                B8.setText("0");
                JogadorAtivo();
            }
        }
        
        if(msg.equals("P1B9")){
            if(B9.getText().equals("") && !B9.getText().equals("0") && joga1 == true){
                B9.setText("X");
                JogadorAtivo();
            }
        }
        if(msg.equals("P2B9")){
            if(B9.getText().equals("") && !B9.getText().equals("X") && joga1 == false){
                B9.setText("0");
                JogadorAtivo();
            }
        }
        
        /*
        String playervez = msg.substring(0,2);
        if(playervez.equals("P1")){
            if(msg.substring(3,4).equals("B1")){
                B1.setText("X");
            }
        }
        if(playervez.equals("P2")){
            if(msg.substring(3,4).equals("B1")){
                B1.setText("0");
            }
        }
        */
    }
    
    private Cliente cliente;
    
    public JogoDaVelha() throws IOException {
        this.cliente = new Cliente("127.0.0.1", 12345, this);
        if(this.cliente.executa() == true){
            //String nickname = JOptionPane.showInputDialog(null, "Digite o seu nickname!");
            //this.cliente.enviaMsg(nickname);
            this.start();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar ao servidor!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void JogadorAtivo(){
        if(this.p.equals("P2")){
            this.joga1 = true;
            this.joga2 = false;
        } else if(this.p.equals("P1")){
            this.joga1 = false;
            this.joga2 = true;
        }
        
        JogadorVencedor ("X");
        JogadorVencedor("0");
        
    }
    
    public void JogadorVencedor(String Jogador) {
        
        
        /****************Verificando a linha **/
        if (B1.getText().equals(Jogador)&&
                B2.getText().equals(Jogador) &&
                B3.getText().equals(Jogador)) {
        
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
        
        if (B4.getText().equals(Jogador)&&
                B5.getText().equals(Jogador) &&
                B6.getText().equals(Jogador)) {
        
        
        if (B4.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
        
         if (B7.getText().equals(Jogador)&&
                B8.getText().equals(Jogador) &&
                B9.getText().equals(Jogador)) {
        
        
        if (B7.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
         
      
        
      if (B1.getText().equals(Jogador)&&
                B4.getText().equals(Jogador) &&
                B7.getText().equals(Jogador)) {
           /** Verificando Colunas **/
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
      if (B2.getText().equals(Jogador)&&
                B5.getText().equals(Jogador) &&
                B8.getText().equals(Jogador)) {
        
        
        if (B2.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
      if (B3.getText().equals(Jogador)&&
                B6.getText().equals(Jogador) &&
                B9.getText().equals(Jogador)) {
        
        
        if (B3.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
        
      if (B1.getText().equals(Jogador)&&
                B4.getText().equals(Jogador) &&
                B7.getText().equals(Jogador)) {
        
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
      if (B2.getText().equals(Jogador)&&
                B5.getText().equals(Jogador) &&
                B8.getText().equals(Jogador)) {
        
        
        if (B2.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
         /** Verificando Diagonais **/
      
      if (B1.getText().equals(Jogador)&&
                B5.getText().equals(Jogador) &&
                B9.getText().equals(Jogador)) {
        
        
        if (B1.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
      if (B3.getText().equals(Jogador)&&
                B5.getText().equals(Jogador) &&
                B7.getText().equals(Jogador)) {
         
        if (B4.getText().equals("X"))
            Vencedor("Jogador 1");
        else
            Vencedor("Jogador 2");
    }
      
      /** Verificando Empates **/
      
      if  ( !B1.getText().equals("") &&
              !B2.getText().equals("") &&
              !B3.getText().equals("") &&
              !B4.getText().equals("") &&
              !B5.getText().equals("") &&
              !B6.getText().equals("") &&
              !B7.getText().equals("") &&
              !B8.getText().equals("") &&
              !B9.getText().equals("") ) {
          
          Vencedor("Empate");
          
      }
              
    }
    
    public void Vencedor(String JogadorVencedor) {
        if (JogadorVencedor.equals("Jogador 1")) {
            JOptionPane.showMessageDialog(JogoDaVelha.this, "Parabens Jogador 1 Você venceu o jogo! ");
            VitoriaDoJogador1 ++;
            VitoriasDoJogador1.setText("Numero de vitorias: " + VitoriaDoJogador1);
            LimparCampos();
        }
        if (JogadorVencedor.equals("Jogador 2")){
           JOptionPane.showMessageDialog(JogoDaVelha.this, "Parabens Jogador 2 Você venceu o jogo! ");
            VitoriaDoJogador2 ++;
            VitoriasDoJogador2.setText("Numero de vitorias: " + VitoriaDoJogador2);
            LimparCampos();
        }
        
        if (JogadorVencedor.equals("Empate")) {
            JOptionPane.showMessageDialog(JogoDaVelha.this, "jogo empatado! Joguem novamente! ");
            PartidasEmpatadas++;
            NumeroDeEmpates.setText("Número de empates: " + PartidasEmpatadas);
            LimparCampos();
        }
    }
    
    public void LimparCampos() {
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        VitoriasDoJogador1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        VitoriasDoJogador2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        NumeroDeEmpates = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        NovoJogo = new javax.swing.JButton();
        SairDoJogo = new javax.swing.JButton();
        buscarjogo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nickname = new javax.swing.JTextField();
        suavez = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo Da Velha");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        B1.setBackground(new java.awt.Color(37, 240, 240));
        B1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B2.setBackground(new java.awt.Color(37, 240, 240));
        B2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B3.setBackground(new java.awt.Color(37, 240, 240));
        B3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B4.setBackground(new java.awt.Color(37, 240, 240));
        B4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B5.setBackground(new java.awt.Color(37, 240, 240));
        B5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B6.setBackground(new java.awt.Color(37, 240, 240));
        B6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B7.setBackground(new java.awt.Color(37, 240, 240));
        B7.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.setBackground(new java.awt.Color(37, 240, 240));
        B8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.setBackground(new java.awt.Color(37, 240, 240));
        B9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(B4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B8, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(B9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do jogo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setText("Jogador 1");

        VitoriasDoJogador1.setText("Números de Vitórias: 0");

        jLabel3.setText("Jogador 2     ");

        VitoriasDoJogador2.setText("Números de Vitórias: 0");

        NumeroDeEmpates.setText("Números de empates: 0");

        jLabel4.setText(" Símbolo: 0");

        jLabel5.setText("Símbolo: X");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(VitoriasDoJogador1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(VitoriasDoJogador2)
                    .addComponent(NumeroDeEmpates))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VitoriasDoJogador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VitoriasDoJogador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroDeEmpates)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle do jogo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        NovoJogo.setText("Novo Jogo");
        NovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoJogoActionPerformed(evt);
            }
        });

        SairDoJogo.setText("Sair do Jogo");
        SairDoJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SairDoJogoMouseClicked(evt);
            }
        });
        SairDoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairDoJogoActionPerformed(evt);
            }
        });

        buscarjogo.setText("Buscar jogo");
        buscarjogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarjogoMouseClicked(evt);
            }
        });
        buscarjogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarjogo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SairDoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NovoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(NovoJogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(SairDoJogo)
                .addContainerGap())
        );

        jLabel2.setText("Digite o seu nick:");

        nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameActionPerformed(evt);
            }
        });

        suavez.setText("Aguardando Jogador!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(suavez)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nickname))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suavez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairDoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairDoJogoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairDoJogoActionPerformed

    private void NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoJogoActionPerformed
       if(!nickname.getText().equals("")){
            this.cliente.enviaMsg(nickname.getText());
            this.cliente.enviaMsg("2");
       }
       else {
            JOptionPane.showMessageDialog(null, "entre com o nickname!", "Erro!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_NovoJogoActionPerformed

    private void buscarjogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjogoActionPerformed
        if(!nickname.getText().equals("")){
            this.cliente.enviaMsg(nickname.getText());
            this.cliente.enviaMsg("1");
       }
       else {
            JOptionPane.showMessageDialog(null, "entre com o nickname!", "Erro!", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_buscarjogoActionPerformed

    private void buscarjogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarjogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarjogoMouseClicked

    private void SairDoJogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SairDoJogoMouseClicked
        try {
            this.cliente.tchau();
        } catch (IOException ex) {
            Logger.getLogger(JogoDaVelha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SairDoJogoMouseClicked

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        //9                                
        this.cliente.enviaMsg("B9");
    }//GEN-LAST:event_B9ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        //8                                
        this.cliente.enviaMsg("B8");
    }//GEN-LAST:event_B8ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        //7                                
        this.cliente.enviaMsg("B7");
    }//GEN-LAST:event_B7ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        //6                                
        this.cliente.enviaMsg("B6");
    }//GEN-LAST:event_B6ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        //5                                
        this.cliente.enviaMsg("B5");
    }//GEN-LAST:event_B5ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        //4                                
        this.cliente.enviaMsg("B4");
    }//GEN-LAST:event_B4ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        //3                                
        this.cliente.enviaMsg("B3");
    }//GEN-LAST:event_B3ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        //2
        this.cliente.enviaMsg("B2");
    }//GEN-LAST:event_B2ActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        //1                                
        this.cliente.enviaMsg("B1");
    }//GEN-LAST:event_B1ActionPerformed

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
        this.cliente.enviaMsg("B1");
    }//GEN-LAST:event_B1MouseClicked

    private void nicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicknameActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JogoDaVelha().setVisible(true);
                } catch (IOException ex) {
                    System.out.println("Não foi possivel construir a interface");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton NovoJogo;
    private javax.swing.JLabel NumeroDeEmpates;
    private javax.swing.JButton SairDoJogo;
    private javax.swing.JLabel VitoriasDoJogador1;
    private javax.swing.JLabel VitoriasDoJogador2;
    private javax.swing.JButton buscarjogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nickname;
    private javax.swing.JLabel suavez;
    // End of variables declaration//GEN-END:variables
}