package Tarjetas;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Tarjeta {
    protected long numeroDeTarjeta;
    protected LocalDate fechaDeCreacion;
    protected double saldo;
    protected int CVV;
    protected int Clabe;
    protected LocalDate fechaDeVencimiento;
    protected LocalDate fechaDeUltimoMovimiento;
    protected LocalDate HoraDeUltimoMovimiento;
    Random rand = new Random();
    public Tarjeta(long numeroDeTarjeta, LocalDate fechaDeCreacion, double saldo, int CVV, int clabe, LocalDate fechaDeVencimiento, LocalDate fechaDeUltimoMovimiento, LocalDate horaDeUltimoMovimiento){
        this.numeroDeTarjeta=numeroDeTarjeta;
        this.fechaDeCreacion=fechaDeCreacion;
        this.saldo=saldo;
        this.CVV=CVV;
        this.Clabe=clabe;
        this.fechaDeVencimiento=fechaDeVencimiento;
        this.fechaDeUltimoMovimiento=fechaDeUltimoMovimiento;
        this.HoraDeUltimoMovimiento=horaDeUltimoMovimiento;
    }
    public double crearNumeroDeTarjeta(){
        return rand.nextLong(9000000000000000L)+1000000000000000L;
    }
}




