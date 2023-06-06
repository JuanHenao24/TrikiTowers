/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
/**
 *
 * @author Usuario
 */
public class Tablero implements Serializable{
    public int[][] matriz;
    
    public String toString(){
        String temp="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                temp+=matriz[i][j];
                
            }
            temp+="\n";
        }
        return temp;
    }
    public Tablero(){
        matriz = new int[3][3]; //inicializa en 0
    }
    
   public void imprimir(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                System.out.print(" |"+matriz[i][j]+" |");
                
            }
            System.out.println("");
        }
    }
    
    public void marcar(int posX, int posY, String jugador){
        if (posX < matriz.length  && posY < matriz[posX].length && posX >= 0 && posY >= 0){
            if (matriz[posX][posY] == 0){
                if (jugador.equals("A")){
                    matriz[posX][posY] = 1;    
                }
                else if (jugador.equals("B")) {
                    matriz[posX][posY] = 2;    
                }
            }
        }
        
    }
    
    
    public boolean validar(int X, int Y, String jugador){
        if (matriz[X][Y] != 0) {
            return true;
        }
        return false;   
    }
    
    
}
