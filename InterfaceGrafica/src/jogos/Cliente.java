/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogos;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Orion
 */
public class Cliente extends Gerenciador{
    
    private String host;
    private int porta;
    private PrintStream saida;
    private Socket cliente;
    private JogoDaVelha jogo;
    public boolean ndeu = false;

    public Cliente (String host, int porta, JogoDaVelha jogo) {
        this.jogo = jogo;
        this.host = host;
        this.porta = porta;
    }
    
    public void enviaMsg(String msg){
        saida.println(msg);
        saida.flush();
    }
    
    public void tchau() throws IOException{
        this.cliente.close();
    }

    public boolean executa() throws UnknownHostException, IOException {
        try{
            this.cliente = new Socket(this.host, this.porta);
            System.out.println("O cliente se conectou ao servidor!");
            // thread para receber mensagens do servidor
            Recebedor r = new Recebedor(cliente.getInputStream(), jogo);
            new Thread(r).start();
            this.saida = new PrintStream(cliente.getOutputStream());
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
}