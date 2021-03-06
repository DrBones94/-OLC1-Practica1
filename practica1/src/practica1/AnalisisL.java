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
 *
  S ::= corcheteA CONJUNTOS ERS div LEXEMAS corcheteC;

  CONJUNTOS :: =conj dp id asignacion EXP pc CONJUNTOS'
   
  CONJUNTOS' ::= conj dp id asignacion EXP pc CONJUNTOS'
      | epsilon

  EXP ::= CHARLIST
      | CONJUNTO;

  CHARLIST = NUMCHAR CHARLIST'
  
  CHARLIST' ::= coma NUMCHAR CHARLIST'
      | epsilon

  NUMCHAR ::= caracter
      | numero;

  CONJUNTO ::= NUMCHAR separador NUMCHAR;

  ERS ::= id asignacion ER pc ERS'
  
  ERS' ::= id asignacion ER pc ERS'
      | epsilon

  ER ::= punto EX 
      | pipe EX
      | interrogacionC EX
      | asterisco EX
      | mas EX
       
  EX ::= 
      
 *
 * @author drbones
 * 
 * Clase dedicada a ser el analizador lexico de nuestro lenguaje
 * Analizador Lexico hecho a patita.
 */
public class AnalisisL {
    static ArrayList<Token> LTokens = new ArrayList<Token>(); //Lista de tokens a enviar al Analizador Sintactico
    static ArrayList<ErrorA> LErrores = new ArrayList<ErrorA>(); //Lista de errores lexicos encontrados
    
    static int posicion;
    static Type preanalisis;
    
    /*Analizador Lexico*/
    public void A_Lexico (String entrada){
        String entradaA[] = entrada.split("\n");
        int caracter = 0; //ASCII del caracter.
        int estado = 0;
        boolean isChar = true; //Para saber si es caracter
        char car;
        String lexema= "";
        
        
        System.out.println("EntradaA " + entradaA.length);
        for(int i = 0; i <= entradaA.length - 1; i++){
            String linea = entradaA[i] + " \n";
            System.out.println("Linea: " + linea.length());
            
            for(int j = 0; j <= linea.length() -1; j++){
                caracter = linea.codePointAt(j);
                car = linea.charAt(j);
                
                switch(estado){
                    case 0:
                        if(caracter == 32 || caracter == 9 || caracter == 10 || caracter == 13){ //Espacio en blanco
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
                        }else if(caracter == 123){ //Corchete Abierto {
                            lexema += car;
                            Token s = new Token(lexema, Type.corcheteA, "Corchete Abierto", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 125){ //Corchete Cerrado }
                            lexema += car;
                            Token s = new Token(lexema, Type.corcheteC, "Corchete Cerrado", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 43){ //Signo +
                            lexema += car;
                            Token s = new Token(lexema, Type.mas, "Signo +", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 42){ //Signo *
                            lexema += car;
                            Token s = new Token(lexema, Type.asterisco, "Signo *", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 63){ //Signo ?
                            lexema += car;
                            Token s = new Token(lexema, Type.interrogacionC, "Signo ?", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 46){ //Punto .
                            lexema += car;
                            Token s = new Token(lexema, Type.punto, "Punto", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 45){ //Signo -
                            estado = 3;
                            lexema += car;
                        }else if(caracter == 166){ //Pipe |
                            lexema += car;
                            Token s = new Token(lexema, Type.or, "Or", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 129){ //Separador ~
                            lexema += car;
                            Token s = new Token(lexema, Type.separador, "Separador ~", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 58){ //Dos Puntos :
                            lexema += car;
                            Token s = new Token(lexema, Type.dosP, "Dos Puntos", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 59){ //Punto y Coma ;
                            lexema += car;
                            Token s = new Token(lexema, Type.puntoC, "Punto y Coma", i, j);
                            LTokens.add(s);
                            estado = 0;
                            lexema = "";
                        }else if(caracter == 37){ //Porcentaje %
                          estado = 4;  
                          lexema += car;
                        }else if(caracter == 47){ //Simbolo /
                          estado = 5;
                          lexema += car;
                        }else if(caracter == 60){//Simbolo <
                          estado = 7;
                          lexema += car;
                        }else if(caracter == 34){//Simbolo "
                          estado = 10;
                          lexema += car;
                        }else if(caracter > 32 || caracter <= 125){
                          lexema += car;
                          Token s = new Token(lexema, Type.caracter, "Caracter", i, j);
                          LTokens.add(s);
                          estado = 0;
                          lexema = "";
                        }else{
                          lexema += car;
                          ErrorA e = new ErrorA(lexema, "Error Léxico", "Carácter Desconocido", i, j);
                          LErrores.add(e);
                          lexema = "";
                          estado = 0;
                        }
                    break;
                    //ID
                    case 1:
                      if(65 <= caracter && caracter <= 90){ //Letras Mayusculas
                        estado = 1;
                        isChar = false;
                        lexema += car;
                      }else if(caracter == 241 || caracter == 209){ // ñ y Ñ
                        estado = 1;
                        isChar = false;
                        lexema += car;
                      }else if(97 <= caracter && caracter <= 122){ //Letras minusculas
                        estado = 1;
                        isChar = false;
                        lexema += car;
                      }else if(48 <= caracter && caracter <= 57){ //Números
                        estado = 1;
                        isChar = false;
                        lexema += car;
                      }else if(caracter == 95){ //Guion Bajo _
                        estado = 1;
                        isChar = false;
                        lexema += car;
                      }else{
                        if(lexema.equalsIgnoreCase("CONJ")){
                          Token t = new Token(lexema, Type.prConj, "Palabra Reservada", i, j);
                          LTokens.add(t);
                          lexema = "";
                          estado = 0;
                          isChar = true;
                          j = j - 1;
                        }else{
                          Token t = new Token(lexema, Type.id, "Identificador", i, j);
                          LTokens.add(t);
                          lexema = "";
                          estado = 0;
                          isChar = true;
                          j = j - 1;
                        }
                      }
                    break;
                    
                    //Numero
                    case 2:
                       if(48 <= caracter && caracter <= 57){ // Números
                         estado = 2;
                         lexema += car;
                       }else{
                         Token t = new Token(lexema, Type.numero, "Numero", i, j);
                         LTokens.add(t);
                         lexema = "";
                         estado = 0;
                         j = j - 1;
                       }
                    break;
                    
                    //Asignacion ->
                    case 3:
                      if(caracter == 62){ // Simbolo >
                        lexema += car;
                        Token s = new Token(lexema, Type.flecha, "Asignacion", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                      }else{
                        Token s = new Token(lexema, Type.caracter, "Caracter", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                        j = j - 1;
                      }
                    break;
                    
                    //Divisor %%
                    case 4:
                      if(caracter == 37){ // Simbolo %
                        lexema += car;
                        Token s = new Token(lexema, Type.div, "Divisor", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                      }else{
                        Token s =  new Token(lexema, Type.caracter, "Caracter", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                        j = j - 1;
                      }
                    break;
                    
                    // Inicio de comentarios
                    case 5:
                      switch (caracter) {
                        case 47:
                          //Simbolo /
                          //Comentario de una linea
                          estado = 6;
                          lexema += car;
                          break;
                        default:
                          Token s = new Token(lexema, Type.caracter, "Caracter", i, j);
                          LTokens.add(s);
                          lexema = "";
                          estado = 0;
                          j = j - 1;
                          break;
                      }
                    break;
                    
                    //Comentario de una linea
                    case 6:
                      if(caracter == 10 || caracter == 13){ //Salto de Linea
                        Token c = new Token(lexema, Type.comentario, "Comentario L", i, j);
                        lexema = "";
                        estado = 0;
                        j = j - 1;
                      }else{
                        System.out.println("Caracter: " + caracter);
                        estado = 6;
                        lexema += car;
                      }
                    break;
                    
                    //Comentario Multilinea
                    case 7:
                      if(caracter == 33){ //Simbolo !
                        estado = 8;
                        lexema += car;
                      }else{
                        Token s = new Token(lexema, Type.caracter, "Caracter", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                        j = j - 1;
                      }
                    break;
                    
                    case 8:
                      if(caracter == 33){ //Simbolo !
                        estado = 9;
                        lexema += car;
                      }else{
                        estado = 8;
                        lexema += car;
                      }
                    break;
                    
                    case 9:
                      if(caracter == 62){ //Simbolo >
                        lexema += car;
                        Token c = new Token(lexema, Type.comentario, "Comentario", i, j);
                        lexema = "";
                        estado = 0;
                      }else{
                        estado = 8;
                        lexema += car;
                      }
                    break;
                    
                    case 10:
                      if(caracter == 34){
                        lexema += car;
                        Token s = new Token(lexema, Type.cadena, "Cadena", i, j);
                        LTokens.add(s);
                        lexema = "";
                        estado = 0;
                      }else{
                        lexema += car;
                        estado = 10;
                      }
                    break;
                }
            }
        }
    }
    
    public void A_Sintactico(){
      posicion = 0;
      preanalisis = LTokens.get(posicion).getId();
      
    }
}
