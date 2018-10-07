/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 019959
 */
public class TrataJogador implements Runnable{
    
    Socket socket;
    String nickname;
    Server server;
    InputStream cliente;
    Partida partidaatual;

    public TrataJogador(Socket socket, InputStream cliente, Server server) {
        this.socket = socket;
        this.cliente = cliente;
        this.server = server;
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    public void run(){
        try {
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("Bem vindo, digite o seu nick: ");
            Scanner in = new Scanner(cliente);
            setNickname(in.nextLine());
            System.out.println(this.nickname);
            int choise = 0;
            out.println("Escolha a opção!");
            boolean saidoloop = true;
            while(saidoloop){
                choise = Integer.parseInt(in.nextLine());
                switch (choise){
                    case 1:
                        System.out.println("Buscando partida");
                        out.println("Buscando partida");
                        out.println("Numero de salas: " + server.partidas.size());
                        int i = 0, bandeira = server.partidas.size();
                        if(bandeira == 0){
                            break;
                        }
                        else{
                            if(bandeira < 1){
                                bandeira = 3;
                            }
                            while(i < bandeira){
                                if(server.partidas.get(i).clientes.size() < 2){
                                out.println("entrou1");
                                partidaatual = server.partidas.get(i);
                                out.println("entrou2");
                                i = server.partidas.get(i).clientes.size();
                                out.println("Partida encontrada!");
                                partidaatual.setNewPlayer(cliente, nickname, in, out);
                                //setNewPlayer(InputStream cliente, String nickname, Scanner in, PrintStream out)
                                }
                                i++;
                            }
                            saidoloop = false;
                            break;
                        }
                    case 2:
                        System.out.println("Criar partida");
                        out.println("Criar partida");
                        try{
                            Partida pt = new Partida(out, this.nickname, cliente);
                            Thread partidaRolando = new Thread(pt);
                            partidaRolando.start();
                            out.println("Partida criada!");
                            server.partidas.add(pt);
                        }
                        catch(Exception e){
                            out.println("erro ao tentar criar a partida! \n Descricao: " + e);
                        }
                        //Partida(Socket playersocket, Server server, PrintStream out, InputStream in) {
                        saidoloop = false;
                        break;
                    default:
                        System.out.println("Tchau!");
                        cliente.close();
                        break;
                }
            }
            //Recebedor tr = new Recebedor(socket, nickname, server, cliente);
            //Thread threadRecebe = new Thread(tr);
            //threadRecebe.start();
        } catch (IOException ex) {
            System.out.println("Falha no thread Trata jogador");
        }
    }
}