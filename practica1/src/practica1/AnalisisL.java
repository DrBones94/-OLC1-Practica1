/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import practica1.Token.Type;

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
        
        for(int i = 0; i <= entradaA.length - 1; i++){
            linea = entradaA[i] + " ";
            
            for(int j = 0; j <= linea.length() -1; j++){
                caracter = linea.codePointAt(j);
                car = linea.charAt(j);
                
                switch(estado){
                    case 0:
                        if(caracter == 32){ //Espacio en blanco
                            estado = 0;
                        }else if(caracter == 9){ //Tabulación
                            estado = 0;
                        }else if(caracter == 10){ //Salto de línea
                            estado = 0;
                        }else if(caracter == 209 || caracter == 241){ //Letra ñ y Ñ
                            estado = 1;
                            lexema += car;
                        }else if(65 <= caracter && caracter <= 90){ //Letras Mayusculas
                            estado = 1;
                            lexema += car;
                        }else if(97 <= caracter && caracter <= 122){ //Letras Minusculas
                            estado = 1;
                            lexema += car;
                        }else if(48 <= caracter && caracter <= 57){ //Numeros
                            estado = 2;
                            lexema += car;
                        }else if(caracter == 44){ // Coma ,
                            lexema += car;
                            Token s = new Token(lexema, Type.coma,"Coma", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }
                    break;
                }
            }
        }
    }
}
