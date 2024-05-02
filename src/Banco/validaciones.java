package Banco;
import java.util.Scanner;

public class validaciones {

public String validarNombre(String nombre) {
        boolean band1 = false;
        while(band1==false) {
            for (int i = 0; i < nombre.length(); i++) {
                if (!Character.isLetter(nombre.charAt(i))) {
                    System.out.println("escribe un nombre valido");
                    band1 = false;
                    break;
                } else {
                    band1 = true;
                    System.out.println("nombre valido");
                }
            }
        }
    return nombre;
    }

}

