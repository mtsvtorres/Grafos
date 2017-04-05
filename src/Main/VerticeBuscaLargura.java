/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;

/**
 *
 * @author leotr
 */
public class VerticeBuscaLargura extends Vertice{
    String id;
    Color cor;
    Double d;
    VerticeBuscaLargura pi;
    
    public VerticeBuscaLargura(String id) {
        super(id);
        this.id = id;
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
    
}
