/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogos;

/**
 *
 * @author Orion
 */
public class Gerenciador {
    private String Vez;
    private String MensagemDoServer;
    private String MensagemToServer;

    public String getVez() {
        return Vez;
    }

    public void setVez(String Vez) {
        this.Vez = Vez;
    }

    public String getMensagemDoServer() {
        return MensagemDoServer;
    }

    public void setMensagemDoServer(String MensagemDoServer) {
        this.MensagemDoServer = MensagemDoServer;
    }

    public String getMensagemToServer() {
        return MensagemToServer;
    }

    public void setMensagemToServer(String MensagemToServer) {
        this.MensagemToServer = MensagemToServer;
    }
}