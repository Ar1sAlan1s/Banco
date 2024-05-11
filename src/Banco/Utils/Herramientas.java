package Banco.Utils;

import java.util.Scanner;

public class Herramientas {
    private static Scanner sc = new Scanner(System.in);

public static int nextInt(){
    String numero;
    int respuesta;
    while(true){
        numero = sc.nextLine();
        try{
            respuesta = Integer.parseInt(numero);
            break;
        }catch(Exception e){
            System.out.println("Por favor ingrese un número.");
        }
    }
    return respuesta;
  }
  public static double nextDouble(){
      String numero;
      double respuesta;
      while(true){
          numero = sc.nextLine();
          try{
              respuesta = Double.parseDouble(numero);
              break;
          }catch(Exception e){
              System.out.println("Por favor ingrese un número.");
          }
      }
      return respuesta;
  }
}
