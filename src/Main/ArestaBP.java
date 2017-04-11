/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author leotr
 */
public class ArestaBP {
    double peso;
    VerticeBuscaProfundidade verticeDestino;
    VerticeBuscaProfundidade verticeOrigem;

    public ArestaBP(double peso, VerticeBuscaProfundidade verticeDestino, VerticeBuscaProfundidade verticeOrigem) {
        this.peso = peso;
        this.verticeDestino = verticeDestino;
        this.verticeOrigem = verticeOrigem;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public VerticeBuscaProfundidade getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(VerticeBuscaProfundidade verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public VerticeBuscaProfundidade getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(VerticeBuscaProfundidade verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }
    
    
}
