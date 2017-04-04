/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Mateus Torres
 */
public class ArestaBL {
    double peso;
    VerticeBuscaLargura verticeDestino;
    VerticeBuscaLargura verticeOrigem;

    public ArestaBL(double peso, VerticeBuscaLargura verticeDestino, VerticeBuscaLargura verticeOrigem) {
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

    public VerticeBuscaLargura getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(VerticeBuscaLargura verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public VerticeBuscaLargura getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(VerticeBuscaLargura verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }
    
    
}
