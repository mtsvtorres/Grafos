/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *
 * @author leotr
 */
public class OrdemTopologica {

    ArrayList<VerticeBuscaProfundidade> listaDeTopologia = new ArrayList<>();
    double tempo;

    public ArrayList<VerticeBuscaProfundidade> getListaDeTopologia() {
        return listaDeTopologia;
    }

    public void setListaDeTopologia(ArrayList<VerticeBuscaProfundidade> listaDeTopologia) {
        this.listaDeTopologia = listaDeTopologia;
    }

    public void criarOrdemTopologica(Grafo grafo) {
        if (grafo.isCiclico()) {
            System.out.println("Ordem topologica nao pode ser aplicada em grafos com ciclos");
            return;
        }
        BuscaProfundidade bp = new BuscaProfundidade();
        
        bp.DFS(grafo);
        
        for (String str : grafo.getListaAdjacenciaBP().keySet()) {
            for (ArestaBP ar : grafo.getListaAdjacenciaBP().get(str)) {
                getListaDeTopologia().add(ar.getVerticeDestino());
            }
        }
    }

    class ComparadorVertices implements Comparator<VerticeBuscaProfundidade> {

        public int compare(VerticeBuscaProfundidade v1, VerticeBuscaProfundidade v2) {
            if (v1.getF() > v2.getF()) {
                return -1;
            } else if (v1.getF() < v2.getF()) {
                return +1;
            } else {
                return 0;
            }
        }
    }

    public void printTopologia() {
        for (VerticeBuscaProfundidade vbp : getListaDeTopologia()) {
            System.out.print(vbp.getId()+ "("+vbp.getF()+")"+" -> ");
        }
    }
}
