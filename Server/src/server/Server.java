/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 019959
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Server(12345).executa();
    }

    private int porta;
    private List<PrintStream> clientes;
    public List<Partida> partidas = new ArrayList();

    public Server (int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa () throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta o Servidor esta Online!");

        while (true) {
            try{
                // aceita um cliente
                Socket cliente = servidor.accept();
                if(cliente != null){
                    System.out.println("Nova conexão com o cliente " +     
                        cliente.getInetAddress().getHostAddress()
                    );

                    // adiciona saida do cliente à lista
                    PrintStream ps = new PrintStream(cliente.getOutputStream());
                    System.out.println("Aviso do servidor:\nNumero de salas: " + this.partidas.size());
                    ps.println("Aviso do servidor:\nNumero de salas: " + this.partidas.size());
                    
                    //if(clientes.size() < 2){
                        this.clientes.add(ps);
                        TrataJogador trata = new TrataJogador(cliente, cliente.getInputStream(), this);
                        Thread threadTrata = new Thread(trata);
                        threadTrata.start();
                    //}
                    /*
                    else {
                        Server sv = new Server(12345);
                        sv.clientes.add(ps);
                        TrataJogador trata = new TrataJogador(cliente, cliente.getInputStream(), sv);
                        Thread threadTrata = new Thread(trata);
                        threadTrata.start();
                    }
                    */

                    // cria tratador de cliente numa nova thread

                }
            }
            catch(IOException e){
                System.out.println("o cliente se desconectou!");
            }
        }
    }

    public void distribuiMensagem(String msg) {
        // envia msg para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
}