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

/**
 *
 * @author 019959
 */
public class RecebeIn  implements Runnable{
    private String nickname;
    private String msg;
    private Scanner in;
    private Partida partida;
    private String p;

    public RecebeIn(String nickname, Scanner in, Partida partida, String p) {
        this.nickname = nickname;
        this.in = in;
        this.partida = partida;
        this.p = p;
    }
    
    public void run(){
        try { 
            while(true){
                if(in.hasNext()){
                        msg = in.nextLine();
                    partida.distribuiMensagem(p+msg);
                }
            }
        } catch (Exception ex) {
            System.out.println("erro na thread de receber msgs da partida");
        }
    }
}