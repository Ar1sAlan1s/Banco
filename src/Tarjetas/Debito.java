package Tarjetas;

import java.time.LocalDate;

public class  Debito extends Tarjeta{
    public Debito(long numeroDeTarjeta, LocalDate fechaDeCreacion, double saldo, int CVV, int clabe, LocalDate fechaDeVencimiento, LocalDate fechaDeUltimoMovimiento, LocalDate horaDeUltimoMovimiento){
        super(numeroDeTarjeta,fechaDeCreacion,saldo,CVV,clabe,fechaDeVencimiento,fechaDeUltimoMovimiento,horaDeUltimoMovimiento);


    }
}
