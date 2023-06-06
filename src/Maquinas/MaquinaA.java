/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquinas;

import Comportamientos.CiclicoA;
import Modelos.Tablero;
import jade.core.Agent;

/**
 *
 * @author AgenteA
 */
public class MaquinaA extends Agent{
    
    public Tablero tablero;
    
    protected void setup(){
        
        addBehaviour(new CiclicoA(this));
        
    }
    
    public MaquinaA(){
        tablero = new Tablero();
    }
}
