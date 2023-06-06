/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquinas;

import Comportamientos.CiclicoB;
import Modelos.Tablero;
import jade.core.Agent;
/**
 *
 * @author Usuario
 */
public class MaquinaB  extends Agent{
    public Tablero tablero;
    
    protected void setup(){
        
        addBehaviour(new CiclicoB(this));
        
    }
    
    public MaquinaB(){
        tablero = new Tablero();
    }
}
