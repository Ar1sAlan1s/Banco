package Tarjetas;

import Tarjetas.Utils.TiposCredito;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class  Debito extends Tarjeta{

    public Debito(String usuario, String password, TiposCredito tipo) {
        super(usuario, password, TiposCredito.debito);
    }
    public void agregarDinero() {
        while(band) {
            try {
                System.out.println("Ingresa el dinero a agregar:");
                double dineroAgregado = scan.nextDouble();
                setSaldo(getSaldo() + dineroAgregado);
                band = false;
            } catch (InputMismatchException ex) {
                System.out.println("Ingresa un numero de dinero");
                scan.nextLine();
            }
        }
    }

    public void retirarDinero() {
        while(band) {
            try {
                System.out.println("Ingresa el dinero a retirar:");

                double dineroRetirado = scan.nextDouble();
                if (dineroRetirado <= getSaldo()) {
                    setSaldo(getSaldo() - dineroRetirado);
                    band = false;
                } else {
                    System.out.println("No tienes el suficiente dinero");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ingresa un numero de dinero");
                scan.nextLine();
            }
        }
    }
    public void mostrarSaldo() {
        System.out.println("El saldo de su tarjeta de credito es: " + getSaldo());
    }
}