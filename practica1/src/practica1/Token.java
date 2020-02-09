/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author drbones
 */
public class Token {
    enum Type{
      corcheteA, //Corchete abierto {
      corcheteC, //Corchete cerrado }
      id, //Identificador
      flecha, //Asignacion ->
      puntoC, //Punto y coma ;
      porcentaje, //Signo de porcentaje %
      dosP, //Dos puntos :
      punto, //Punto .
      or, // OR |
      interrogacionC, // Interrogacion Cerrado ?
      asterisco, // Asterisco *
      mas, // Mas +
      separador, // Separador ~
      coma, //Coma ,
      cadena , // Cadena entre comillas dobles
    }
  
  
    private String lexema;
    private Type id;
    private String token;
    private int fila;
    private int columna;
    
    public Token(String lexema, Type id, String token, int fila, int columna){
      this.lexema = lexema;
      this.id = id;
      this.token = token;
      this.fila = fila;
      this.columna = columna;
    }

  /**
   * @return the lexema
   */
  public String getLexema() {
    return lexema;
  }

  /**
   * @param lexema the lexema to set
   */
  public void setLexema(String lexema) {
    this.lexema = lexema;
  }

  /**
   * @return the id
   */
  public Type getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Type id) {
    this.id = id;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @param token the token to set
   */
  public void setToken(String token) {
    this.token = token;
  }

  /**
   * @return the fila
   */
  public int getFila() {
    return fila;
  }

  /**
   * @param fila the fila to set
   */
  public void setFila(int fila) {
    this.fila = fila;
  }

  /**
   * @return the columna
   */
  public int getColumna() {
    return columna;
  }

  /**
   * @param columna the columna to set
   */
  public void setColumna(int columna) {
    this.columna = columna;
  }
    
    
}
