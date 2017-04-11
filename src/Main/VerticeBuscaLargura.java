/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;

/**
 *
 * @author leotr
 */
public class VerticeBuscaLargura extends Vertice{
    Color cor;
    Double d;
    VerticeBuscaLargura pi;
    
    public VerticeBuscaLargura(String id) {
        super(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public VerticeBuscaLargura getPi() {
        return pi;
    }

    public void setPi(VerticeBuscaLargura pi) {
        this.pi = pi;
    }
    
    public String getCorNome(){
        if(cor == WHITE)
            return "Branco";
        if(cor == BLACK)
            return "Preto";
        if(cor == GRAY)
            return "Cinza";
        return "";
    }
}
