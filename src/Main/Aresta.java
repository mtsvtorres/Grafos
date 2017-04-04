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
public class Aresta {
    
    
    double peso;
    Vertice verticeDestino;
    Vertice verticeOrigem;

    public Aresta(double peso, Vertice verticeOrigem, Vertice verticeDestino) {

        this.peso = peso;
        this.verticeDestino = verticeDestino;
        this.verticeOrigem = verticeOrigem;
    }

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(Vertice verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public double getPeso() {
        return peso;
    }

}
