/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 019959
 */
public class Recebedor implements Runnable{
    private Socket socket;
    private String nickname;
    private Server server;
    private String msg;
    private InputStream cliente;

    public Recebedor(Socket socket, String nickname, Server server, InputStream cliente) {
        this.socket = socket;
        this.nickname = nickname;
        this.server = server;
        this.cliente = cliente;
    }
    
    public void run(){
        try { 
            Scanner in = new Scanner(socket.getInputStream());
            while(true){
                if(in.hasNext()){
                    msg = "Mensagem de " + nickname + " : " + in.nextLine();
                    server.distribuiMensagem(msg);
                }
            }
        } catch (IOException ex) {
            System.out.println("erro na thread de receber msgs do servidor");
        }
    }
}