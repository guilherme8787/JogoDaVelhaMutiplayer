/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogos;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Orion
 */
public class Recebedor implements Runnable {
    private JogoDaVelha jogo;
    private InputStream servidor;

    public Recebedor(InputStream servidor, JogoDaVelha jogo) {
        this.servidor = servidor;
        this.jogo = jogo;
    }

    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        int opt = 0;
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
            //jogo.setJogador(s.nextLine().substring(0,2));
            /*
            opt = Integer.parseInt(s.nextLine().substring(0,1));
            switch(opt){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("sou problematico");
                    break;
            }
            */
            jogo.setBotao(s.nextLine());
        }
    }
}