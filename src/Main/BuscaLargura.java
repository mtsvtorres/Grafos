/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *
 * @author Mateus Torres
 */
public class BuscaLargura {
    ArrayList<VerticeBuscaLargura> queue = new ArrayList<>();

    public ArrayList<VerticeBuscaLargura> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<VerticeBuscaLargura> queue) {
        this.queue = queue;
    }
    
    public void buscaLargura_init(Grafo grafo,String vertice){       
        //Setando todos os vertices menos o inicial como:
        //brancos, distancia nula e sem predecessor
        for (String str : grafo.getListaAdjacenciaBL().keySet()) {
            for (ArestaBL ar : grafo.getListaAdjacenciaBL().get(str)) {
                if(!ar.getVerticeDestino().getId().equals(vertice)){
                    ar.getVerticeDestino().setCor(Color.WHITE);
                    ar.getVerticeDestino().setD(Infinity);
                    ar.getVerticeDestino().setPi(null);
                }
            }
        }
        
        VerticeBuscaLargura verticeInicial = new VerticeBuscaLargura("");
        for (String str : grafo.getListaAdjacenciaBL().keySet()) {
            for (ArestaBL ar : grafo.getListaAdjacenciaBL().get(str)) {
                if(ar.getVerticeDestino().getId().equals(vertice)){
                    ar.getVerticeDestino().setCor(Color.GRAY);
                    ar.getVerticeDestino().setD(0.0);
                    ar.getVerticeDestino().setPi(null);
                    verticeInicial = ar.getVerticeDestino();
                    System.out.println(ar.getVerticeDestino().getId()+" -> "+ar.getVerticeDestino().getCorNome()+", "+ar.getVerticeDestino().getD());
                }
            }
        }
        
        queue.add(verticeInicial);
    }
    
    public void buscaLargura(Grafo grafo) {
        
        while (!getQueue().isEmpty()) {
            VerticeBuscaLargura vertice;

            vertice = getQueue().remove(0);

            for (ArestaBL ar : grafo.getListaAdjacenciaBL().get(vertice.getId())) {
                //Pintar somente os valores referente a key
                if (ar.getVerticeDestino().getCor().equals(Color.WHITE)) {
                    ar.getVerticeDestino().setCor(Color.GRAY);
                    ar.getVerticeDestino().setD(vertice.getD() + 1);
                    ar.getVerticeDestino().setPi(vertice);
                    getQueue().add(ar.getVerticeDestino());
                    System.out.println(ar.getVerticeDestino().getId()+" -> "+ar.getVerticeDestino().getCorNome()+", "+ar.getVerticeDestino().getD());
                    //Pintar os demais valores do map tambem
                    for (ArrayList<ArestaBL> ar1 : grafo.getListaAdjacenciaBL().values()) {
                        for (ArestaBL ar2 : ar1) {
                            if(ar2.getVerticeDestino().getId().equals(ar.getVerticeDestino().getId())){
                                ar2.setVerticeDestino(ar.getVerticeDestino());
                            }
                        
                        }
                    }
                }
            }

            vertice.setCor(Color.BLACK);
           System.out.println(vertice.getId()+" -> "+vertice.getCorNome()+", "+vertice.getD());
            for (ArrayList<ArestaBL> ar : grafo.getListaAdjacenciaBL().values()) {
                for (ArestaBL ar1 : ar) {
                    if(vertice.getId().equals(ar1.getVerticeDestino().getId())){
                        ar1.setVerticeDestino(vertice);
                    }
                }
            }
            
            //Debug step by step do busca em largura
            /*map.verMap(grafo);*/
        }
        
        System.out.println("\tTermino Busca em Largura");
    }
}
