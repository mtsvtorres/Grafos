/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *
 * @author leotr
 */
public class BuscaProfundidade {
    double tempo;
    
    public void DFS(Grafo grafo){
        for (String str : grafo.getListaAdjacenciaBP().keySet()) {
            for (ArestaBP ar : grafo.getListaAdjacenciaBP().get(str)) {
                ar.getVerticeDestino().setCor(Color.WHITE);
                ar.getVerticeDestino().setPi(null);
            }
        }
        
        tempo = 0;
        
        for (String str : grafo.getListaAdjacenciaBP().keySet()) {
            for (ArestaBP ar : grafo.getListaAdjacenciaBP().get(str)) {
                if(ar.getVerticeDestino().getCor().equals(Color.WHITE)){
                    DFS_Visit(grafo, ar.getVerticeDestino());
                }
            }
        }
    }
    
    public void DFS_Visit(Grafo grafo, VerticeBuscaProfundidade u){
        tempo += 1;
        u.setD(tempo);
        u.setCor(Color.GRAY);
        grafo.ajustaVerticeBP(u);
        for (ArestaBP ar : grafo.getListaAdjacenciaBP().get(u.getId())) {
            if(ar.getVerticeDestino().getCor().equals(Color.WHITE)){
                ar.getVerticeDestino().setPi(u);
                DFS_Visit(grafo, ar.getVerticeDestino());
            }
        }
        u.setCor(Color.BLACK);
        tempo += 1;
        u.setF(tempo);
        grafo.ajustaVerticeBP(u);
    }
}
