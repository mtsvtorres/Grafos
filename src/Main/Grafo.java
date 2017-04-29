/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Mateus Torres
 */
public class Grafo {

    HashMap<String, ArrayList<Aresta>> listaAdjacencia = new HashMap<>();
    HashMap<String, ArrayList<ArestaBL>> listaAdjacenciaBL = new HashMap<>();
    HashMap<String, ArrayList<ArestaBP>> listaAdjacenciaBP = new HashMap<>();
    ArrayList<Vertice> vertices = new ArrayList<>();
    ArrayList<VerticeBuscaProfundidade> verticesBP = new ArrayList<>();
    int[][] matrizAdjacencia;

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<VerticeBuscaProfundidade> getVerticesBP() {
        return verticesBP;
    }

    public void setVerticesBP(ArrayList<VerticeBuscaProfundidade> verticesBP) {
        this.verticesBP = verticesBP;
    }
    boolean ciclico = false;

    public boolean isCiclico() {
        return ciclico;
    }

    public void setCiclico(boolean ciclico) {
        this.ciclico = ciclico;
    }

    public HashMap<String, ArrayList<ArestaBP>> getListaAdjacenciaBP() {
        return listaAdjacenciaBP;
    }

    public void setListaAdjacenciaBP(HashMap<String, ArrayList<ArestaBP>> listaAdjacenciaBP) {
        this.listaAdjacenciaBP = listaAdjacenciaBP;
    }

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

    public void insereListaAdjacenciaBL(ArrayList<Aresta> aresta) {
        ArrayList<ArestaBL> arestas = new ArrayList<>();
        for (int i = 0; i < getVertices().size(); i++) {
            VerticeBuscaProfundidade vbp = new VerticeBuscaProfundidade(getVertices().get(i).getId());
            getVerticesBP().add(vbp);
        }
        for (int i = 0; i < aresta.size(); i++) {
            VerticeBuscaLargura vD = getVerticesBP().indexOf(aresta.get(i).getVerticeDestino().getId());
            VerticeBuscaLargura vO = new VerticeBuscaLargura(aresta.get(i).getVerticeOrigem().getId());
            arestas.add(new ArestaBL(aresta.get(i).getPeso(), vD, vO));
        }

        //Adiciona os vertices key no map;
        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<ArestaBL> aux = new ArrayList<>();
            getListaAdjacenciaBL().put(arestas.get(i).getVerticeDestino().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<ArestaBL> aux = new ArrayList<>();
            getListaAdjacenciaBL().put(arestas.get(i).getVerticeOrigem().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            ArestaBL ar;
            ar = new ArestaBL(arestas.get(i).getPeso(), arestas.get(i).getVerticeDestino(), arestas.get(i).getVerticeOrigem());
            getListaAdjacenciaBL().get(arestas.get(i).getVerticeOrigem().getId()).add(ar);
        }
    }

    public void insereListaAdjacenciaBP(ArrayList<Aresta> are) {
        ArrayList<ArestaBP> arestas = new ArrayList<>();
        for (int i = 0; i < are.size(); i++) {
            VerticeBuscaProfundidade vD = new VerticeBuscaProfundidade(are.get(i).getVerticeDestino().getId());
            VerticeBuscaProfundidade vO = new VerticeBuscaProfundidade(are.get(i).getVerticeOrigem().getId());
            arestas.add(new ArestaBP(are.get(i).getPeso(), vD, vO));
        }

        //Adiciona os vertices key no map;
        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<ArestaBP> aux = new ArrayList<>();
            getListaAdjacenciaBP().put(arestas.get(i).getVerticeDestino().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            ArrayList<ArestaBP> aux = new ArrayList<>();
            getListaAdjacenciaBP().put(arestas.get(i).getVerticeOrigem().getId(), aux);
        }

        for (int i = 0; i < arestas.size(); i++) {
            ArestaBP ar;
            ar = new ArestaBP(arestas.get(i).getPeso(), arestas.get(i).getVerticeDestino(), arestas.get(i).getVerticeOrigem());
            getListaAdjacenciaBP().get(arestas.get(i).getVerticeOrigem().getId()).add(ar);
        }
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

        insereListaAdjacenciaBL(arestas);
        insereListaAdjacenciaBP(arestas);
    }

    public void removeMapVertice(String id) {
        Vertice vertice = new Vertice(id);
        boolean flag = true;
        //Remove o vetice das keys
        //Remove o vertice do alcance dos vertices keys
        for (ArrayList<Aresta> ar : getListaAdjacencia().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getVerticeDestino().getId().equals(vertice.getId())) {
                    ar.remove(i);
                    flag = false;
                }
            }
        }
        if(flag){
            System.out.println("O vertice não existe no grafo!");
        }else{
            getListaAdjacencia().remove(id);
            System.out.println("Remoçao do vertice " + vertice.getId());
//        printListaAdjacencia();
        }
    }

    public void printListaAdjacencia() {
        //Print_results
        System.out.println("Vertices: " + getListaAdjacencia().keySet());

        System.out.println("Lista de adjacencia[" + getListaAdjacencia().values().size() + "]: ");
        for (String str : getListaAdjacencia().keySet()) {
            System.out.print("\t" + str + " -->\t");
            for (Aresta ar : getListaAdjacencia().get(str)) {
                System.out.print(ar.getVerticeDestino().getId() + " | ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void printListaAdjacenciaBL() {
        //Print_results
        System.out.println("Vertices: " + getListaAdjacenciaBL().keySet());

        System.out.println("Lista de adjacencia BL[" + getListaAdjacenciaBL().values().size() + "]: ");
        for (String str : getListaAdjacenciaBL().keySet()) {
            System.out.print("\t" + str + " -->\t");
            for (ArestaBL ar : getListaAdjacenciaBL().get(str)) {
                System.out.print(ar.getVerticeDestino().getId()
                        + "(" + ar.getVerticeDestino().getCorNome()
                        + ", " + ar.getVerticeDestino().getD() + ")" + " - ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void printListaAdjacenciaBP() {
        //Print_results
        System.out.println("Vertices: " + getListaAdjacenciaBP().keySet());

        System.out.println("Lista de adjacencia BP[" + getListaAdjacenciaBP().values().size() + "]: ");
        for (String str : getListaAdjacenciaBP().keySet()) {
            System.out.print("\t" + str + " -->\t");
            for (ArestaBP ar : getListaAdjacenciaBP().get(str)) {
                System.out.print(ar.getVerticeDestino().getId()
                        + "(" + ar.getVerticeDestino().getCorNome()
                        + ", " + ar.getVerticeDestino().getD()
                        + ", " + ar.getVerticeDestino().getF() + ")" + " - ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void criaMatrizAdj() {

        int sizeMatriz = this.listaAdjacencia.size();
        matrizAdjacencia = new int[sizeMatriz][sizeMatriz]; //Cria a matriz sem os indices

        ArrayList<String> vertices = new ArrayList(); // Vetor com o nome(id) de todos os vértices

        for (Entry<String, ArrayList<Aresta>> entry : listaAdjacencia.entrySet()) { //Pega o nome dos vértices 
            vertices.add(entry.getKey());
        }

        for (int i = 0; i < sizeMatriz; i++) { //Concatena os vetores em uma matriz
            for (int j = 0; j < sizeMatriz; j++) {
                matrizAdjacencia[i][j] = matrizAdjLinha(vertices, i)[j];
            }
        }

//Esses dois for's printam os indices para melhor visualização da matriz de adjacencia, porém não estão mais unidos.
//        System.out.print("\t");
//        for (int i = 0; i < sizeMatriz; i++) {
//            System.out.print(vertices.get(i) + "|");
////            System.out.println();
//        }
//        System.out.println();
//
//        for (int i = 0; i < sizeMatriz; i++) {
//            System.out.print(vertices.get(i) + "|");
//            matrizAdjLinha(vertices, i);
//            System.out.println();
//        }
    }

    public int[] matrizAdjLinha(ArrayList<String> vertices, int linhaDaMatriz) {
        int[] vetLinha = new int[vertices.size()];
        for (int i = 0; i < vetLinha.length; i++) {
            vetLinha[i] = 0;
        }

        for (int i = 0; i < getListaAdjacencia().get(vertices.get(linhaDaMatriz)).size(); i++) {
            
            vetLinha[vertices.indexOf(getListaAdjacencia().get(vertices.get(linhaDaMatriz)).get(i).getVerticeDestino().getId())] = 1;
        }

//        for (int i = 0; i < vetLinha.length; i++) {
//            System.out.print("\t" + vetLinha[i] + " ");
//        }
//        
        return vetLinha;
    }

    public void printaMatrizAdj() {
        int sizeMatriz = this.listaAdjacencia.size();

        System.out.println("Matriz de Adjacência :\n");

        for (int i = 0; i < sizeMatriz; i++) {
            for (int j = 0; j < sizeMatriz; j++) {
                System.out.print("\t" + matrizAdjacencia[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void ajustaVerticeBP(VerticeBuscaProfundidade u) {
        for (String str : getListaAdjacenciaBP().keySet()) {
            for (ArestaBP ar : getListaAdjacenciaBP().get(str)) {
                if (ar.getVerticeDestino().getId().equals(u.getId())) {
                    ar.setVerticeDestino(u);
                }
            }
        }
    }
}
