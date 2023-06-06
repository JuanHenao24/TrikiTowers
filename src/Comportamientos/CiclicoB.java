/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import Maquinas.MaquinaB;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class CiclicoB extends CyclicBehaviour{
    
    MaquinaB jugadorB;
    
    public CiclicoB(MaquinaB jugadorB) {
        this.jugadorB = jugadorB;
    }

    @Override
    public void action() {
        
            ACLMessage response = this.jugadorB.blockingReceive();
        
        
       jugadorB.tablero.imprimir();
       int X;
       int Y;
       
       X = randomX();
       Y= randomY();
       while(!jugadorB.tablero.validar(X,Y,"B")){
           X = randomX();
           Y = randomY();
       }
       
       jugadorB.tablero.marcar(X, Y, "B");
       
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(response.getSender());
        message.setContent(jugadorB.tablero.toString());
        jugadorB.send(message);
    }
    
    public int randomX(){
        return  new Random().nextInt(jugadorB.tablero.matriz.length);
        
    }
    
    public int randomY(){
        return  new Random().nextInt(jugadorB.tablero.matriz.length);
        
    }
}
