/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comportamientos;

import Maquinas.MaquinaA;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class CiclicoA extends CyclicBehaviour {

    MaquinaA jugadorA;
    boolean primeraJugada = true;

    public CiclicoA(MaquinaA jugadorA) {
        this.jugadorA = jugadorA;
    }

    @Override
    public void action() {
        if (primeraJugada) {
            jugadorA.tablero.imprimir();
            int X;
            int Y;

            X = randomX();
            Y = randomY();
            while (!jugadorA.tablero.validar(X, Y, "A")) {
                X = randomX();
                Y = randomY();
            }

            jugadorA.tablero.marcar(X, Y, "A");

            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            AID receptor = new AID("B", AID.ISLOCALNAME);
            message.addReceiver(receptor);
            message.setContent(jugadorA.tablero.toString());
            jugadorA.send(message);
            primeraJugada = false;

        } else {
            ACLMessage response = this.jugadorA.blockingReceive();

            try {
                String datos;
                //devuelve tablero en string
                datos = response.getContent();
                this.jugadorA.tablero.matriz = toMatriz(datos);
                int X;
                int Y;
                //jugada
                X = randomX();
                Y = randomY();
                System.out.println("AQUI VA ");
                while (!jugadorA.tablero.validar(X, Y, "A")) {
                    X = randomX();
                    Y = randomY();
                }

                jugadorA.tablero.marcar(X, Y, "A");

                //VALIDAR SI SE GANÓ O NO 
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.addReceiver(response.getSender());
                message.setContent(jugadorA.tablero.toString());
                System.out.println("CACA");
                jugadorA.send(message);
                System.out.println("CURCIO");
            } catch (Exception e) {
            }
        }

    }

    public int randomX() {
        return new Random().nextInt(jugadorA.tablero.matriz.length);

    }

    public int randomY() {
        return new Random().nextInt(jugadorA.tablero.matriz.length);

    }

    public int[][] toMatriz(String tablero) {
        int[][] tempMatriz = new int[3][3];

        return tempMatriz;
    }

}
