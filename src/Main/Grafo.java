/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.sun.jmx.mbeanserver.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Mateus Torres
 */
public class Grafo {

    HashMap<String, ArrayList<Aresta>> listaAdjacencia = new HashMap<>();
    HashMap<String, ArrayList<ArestaBL>> listaAdjacenciaBL = new HashMap<>();
    int[][] matrizAdjcencia;

    public HashMap<String, ArrayList<Aresta>> getListaAdjacencia() {
        return listaAdjacencia;
    }

    public void setListaAdjacencia(HashMap<String, ArrayList<Aresta>> listaAdjacencia) {
        this.listaAdjacencia = listaAdjacencia;
    }

    public HashMap<String, ArrayList<ArestaBL>> getListaAdjacenciaBL() {
        return listaAdjacenciaBL;
    }

    public void setListaAdjacenciaBL(HashMap<String, ArrayList<ArestaBL>> listaAdjacenciaBL) {
        this.listaAdjacenciaBL = listaAdjacenciaBL;
    }

    public void criaListaAdjenciaBL(HashMap<String, ArrayList<Aresta>> listaAdjacencia){
        for (Entry<String, ArrayList<Aresta>> entry : listaAdjacencia.entrySet()) {
            ArrayList<ArestaBL> aux = new ArrayList<>();
            listaAdjacenciaBL.put(entry.getKey(), aux);
            for(int i = 0; i < listaAdjacencia.get(entry.getKey()).size(); i++){
                Aresta ar;
                ar = new Aresta(listaAdjacencia.get(entry.getKey()).get(i).getPeso(), listaAdjacencia.get(entry.getKey()).get(i).getVerticeOrigem(), listaAdjacencia.get(entry.getKey()).get(i).getVerticeDestino());
                getListaAdjacencia().get(listaAdjacencia.get(entry.getKey()).get(i).getVerticeOrigem().getId()).add(ar);
            }
        }
        printListaAdjacenciaBL();
    }
    
    public void insereListaAdjacencia(ArrayList<Aresta> arestas) {
        //Adiciona os vertices key no map
        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<Aresta> aux = new ArrayList<>();
            getListaAdjacencia().put(arestas.get(i).getVerticeOrigem().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<Aresta> aux = new ArrayList<>();
            getListaAdjacencia().put(arestas.get(i).getVerticeDestino().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            Aresta ar;
            ar = new Aresta(arestas.get(i).getPeso(), arestas.get(i).getVerticeOrigem(), arestas.get(i).getVerticeDestino());
            getListaAdjacencia().get(arestas.get(i).getVerticeOrigem().getId()).add(ar);
        }
        criaListaAdjenciaBL(listaAdjacencia);
        printListaAdjacencia();
    }

    public void removeMapVertice(String id) {
        Vertice vertice = new Vertice(id);

        //Remove o vetice das keys
        //Remove o vertice do alcance dos vertices keys
        for (ArrayList<Aresta> ar : getListaAdjacencia().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getVerticeDestino().getId().equals(vertice.getId())) {
                    ar.remove(i);
                }
            }
        }
        getListaAdjacencia().remove(id);
        System.out.println("Remoçao do vertice " + vertice.getId());
        printListaAdjacencia();
    }

    public void printListaAdjacencia() {
        //Print_results
        System.out.println("Vertices: " + getListaAdjacencia().keySet());

        System.out.println("Lista de adjacencia[" + getListaAdjacencia().values().size() + "]: ");
        for (String str : getListaAdjacencia().keySet()) {
            System.out.print("\t" + str + " -->\t");
            for (Aresta ar : getListaAdjacencia().get(str)) {
                System.out.print(ar.getVerticeDestino().getId() + " - ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
    
    public void printListaAdjacenciaBL() {
        //Print_results
        System.out.println("Vertices: " + getListaAdjacenciaBL().keySet());

        System.out.println("Lista de adjacencia[" + getListaAdjacenciaBL().values().size() + "]: ");
        for (String str : getListaAdjacenciaBL().keySet()) {
            System.out.print("\t" + str + " -->\t");
            for (ArestaBL ar : getListaAdjacenciaBL().get(str)) {
                System.out.print(ar.getVerticeDestino().getId() + " - ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
    
    public void criaMatrizAdj() {
        int sizeMatriz = this.listaAdjacencia.size();
        matrizAdjcencia = new int[sizeMatriz][sizeMatriz];
        ArrayList<String> vertices = new ArrayList();

        for (Entry<String, ArrayList<Aresta>> entry : listaAdjacencia.entrySet()) {
            vertices.add(entry.getKey());
//            entry.getValue().get(1).getVerticeDestino();
        }

//        for (String str : getListaAdjacencia().keySet()) {
//            System.out.print("\t" + str + " -->\t");
//            for (Aresta ar : getListaAdjacencia().get(str)) {
//                System.out.print(ar.getVerticeDestino().getId() + " - ");
//            }
//            System.out.println("");
//        }

        for (int i = 0; i < sizeMatriz; i++) {
            System.out.println(getListaAdjacencia().get(vertices.get(i)).size());
            System.out.println(vertices.get(i));
            for (int j = 0; j < sizeMatriz; j++) {
                if (false) {
                    matrizAdjcencia[i][j] = 1;
                } else {
                    matrizAdjcencia[i][j] = 0;
                }
            }
        }
    }

    public void printaMatrizAdj() {
        int sizeMatriz = this.listaAdjacencia.size();

        for (int i = 0; i < sizeMatriz; i++) {
            for (int j = 0; j < sizeMatriz; j++) {
                System.out.print(matrizAdjcencia[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
