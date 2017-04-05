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
 * @author Mateus Torres
 */
public class BuscaLargura {
    public void buscaLargura_init(Grafo grafo,VerticeBuscaLargura vertice){       
        //Setando todos os vertices menos o inicial como:
        //brancos, distancia nula e sem predecessor
        for (String str : grafo.getListaAdjacenciaBL().keySet()) {
            for (ArestaBL ar : grafo.getListaAdjacenciaBL().get(str)) {
                if(!ar.getVerticeDestino().getId().equals(vertice.getId())){
                    ar.getVerticeDestino().setCor(Color.WHITE);
                    ar.getVerticeDestino().setD(Infinity);
                    ar.getVerticeDestino().setPi(null);
                }
            }
        }
    }
}
