/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 019959
 */
public class Partida implements Runnable{
    public List<PrintStream> clientes = new ArrayList();
    public List<String> nickname = new ArrayList();
    public List<InputStream> cliente = new ArrayList();
    public List<Scanner> in = new ArrayList();

    public Partida(PrintStream out, String nickname, InputStream cliente) {
        if(clientes.size() < 2){
            clientes.add(out);
            this.nickname.add(nickname);
            Scanner tuts = new Scanner(cliente);
            this.in.add(tuts);
            out.println("Entrou na sala!");
            out.println("P1");
            RecebeIn tr = new RecebeIn(nickname, tuts, this, "P1");
            Thread threadRecebe = new Thread(tr);
            threadRecebe.start();
        }
        else{
            out.println("Sala cheia!");
            //out.println("Sala cheia!");
        }
    }

    public void setNewPlayer(InputStream cliente, String nickname, Scanner in, PrintStream out) {
        if(clientes.size() < 2){
            this.clientes.add(out);
            this.cliente.add(cliente);
            this.nickname.add(nickname);
            this.in.add(in);
            out.println("Entrou na sala!");
            String msg = nickname + " se conectou!";
            distribuiMensagem(msg);
            out.println(this.nickname.get(0) + " esta conectado!");
            out.println("P2");
            RecebeIn tr = new RecebeIn(nickname, in, this, "P2");
            Thread threadRecebe = new Thread(tr);
            threadRecebe.start();
        }
        else{
            out.println("Sala cheia!");
        }
    }
    
    public void distribuiMensagem(String msg) {
        // envia msg para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
    
    public void run(){
        try {
            System.out.println("Sala 1 em execução!");
        } catch (Exception e) {
            System.out.println("erro na thread de receber msgs do servidor");
        }
    }
}