package Tarjetas;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Credito extends Tarjeta{
    private double limite;
    public Credito(long numeroDeTarjeta, LocalDate fechaDeCreacion, double saldo, int CVV, int clabe, LocalDate fechaDeVencimiento, LocalDate fechaDeUltimoMovimiento, LocalDate horaDeUltimoMovimiento,double limite){
        super(numeroDeTarjeta,fechaDeCreacion,saldo,CVV,clabe,fechaDeVencimiento,fechaDeUltimoMovimiento,horaDeUltimoMovimiento);
        this.limite = limite;
    }
    public void SolicitarTarjetaCredito(){
        System.out.println("**cBienvenido a la opcion de solicitud de tarjeta de credito**");
        System.out.println("Ingrese el tipo de tarjeta a solicitar:");
        //for ()
    }
}
