/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author danpu
 * 
 * Clase dedicada a ser el analizador lexico de nuestro lenguaje
 * Analizador Lexico hecho a patita.
 */
public class AnalisisL {
    static ArrayList<Token> LTokens = new ArrayList<Token>(); //Lista de tokens a enviar al Analizador Sintactico
    static ArrayList<ErrorA> LErrores = new ArrayList<ErrorA>(); //Lista de errores lexicos encontrados
    
    static int posicion;
    static int preanalisis;
    
    /*Analizador Lexico*/
    public void A_Lexico (String entrada){
        String entradaA[] = entrada.split("\n");
        String linea = new String();
        int caracter = 0; //ASCII del caracter.
        int estado = 0;
        char car;
        String lexema= "";
        
        for(int i = 0; entradaA.length - 1; i++){
            linea = 
        }
    }
}
