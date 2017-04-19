/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;

/**
 *
 * @author Mateus Torres
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Grafo grafo = new Grafo();
        
        Vertice verticeGOIO = new Vertice("Goioerê");
        Vertice verticeCM = new Vertice("Campo Mourão");
        Vertice verticeMGA = new Vertice("Maringá");
        Vertice verticeLOND = new Vertice("Londrina");
        Vertice verticeSJC = new Vertice("São José");

        Aresta arestaGOIOxCM = new Aresta(110, verticeGOIO, verticeCM);
        Aresta arestaCMxMGA = new Aresta(120, verticeCM, verticeMGA);
        Aresta arestaMGAxLOND = new Aresta(100, verticeMGA, verticeLOND);
        Aresta arestaMGAxGOIO = new Aresta(150, verticeMGA, verticeGOIO);
        Aresta arestaLONDxSJC = new Aresta(450, verticeLOND, verticeSJC);
        Aresta arestaSJCxCM = new Aresta(900, verticeSJC, verticeCM);
        
        ArrayList<Aresta> arestas = new ArrayList<>();
        
        arestas.add(arestaGOIOxCM);
        arestas.add(arestaCMxMGA);
        arestas.add(arestaMGAxLOND);
        arestas.add(arestaMGAxGOIO);
        arestas.add(arestaLONDxSJC);
        arestas.add(arestaSJCxCM);

//        Lista de Adjacência
        grafo.insereListaAdjacencia(arestas);
        grafo.printListaAdjacencia();
        
//        Teste de Busca em Largura
//        BuscaLargura bl = new BuscaLargura();
//        bl.buscaLargura_init(grafo, "Campo Mourão");
//        bl.buscaLargura(grafo);
//        grafo.printListaAdjacenciaBL();
        
//        grafo.printListaAdjacenciaBP();

//        Teste Topologia
//        grafo.ordemTopologica();
//        grafo.printTopologia();
        

//        Teste de remoção de vértice
//        grafo.removeMapVertice("Maringá");
//        grafo.printListaAdjacencia();
        
//        Gera a Matriz de Adjacência
        grafo.criaMatrizAdj();
        grafo.printaMatrizAdj();
        
    }

}
