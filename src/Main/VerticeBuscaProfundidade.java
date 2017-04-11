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
public class VerticeBuscaProfundidade extends VerticeBuscaLargura {
     Double f;
     VerticeBuscaProfundidade pi;
     
    public VerticeBuscaProfundidade(String id) {
        super(id);
    }

    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
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

    public VerticeBuscaProfundidade getPi() {
        return pi;
    }

    public void setPi(VerticeBuscaProfundidade pi) {
        this.pi = pi;
    }
     
}
