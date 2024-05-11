package Tarjetas;

import Tarjetas.Utils.TiposCredito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tarjeta {
    Scanner scan = new Scanner(System.in);
    boolean band=true;
    public ArrayList<String> numerosDeTarjeta = new ArrayList<>();
    protected long numeroDeTarjeta;
    protected LocalDate fechaDeCreacion;
    protected double saldo;
    protected int CVV;
    protected long Clabe;
    protected LocalDate fechaDeVencimiento;
    protected LocalDate fechaDeUltimoMovimiento;
    protected LocalDate HoraDeUltimoMovimiento;
    Random rand = new Random();

    public Tarjeta(String usurio, String password, TiposCredito tipo) {
        this.numeroDeTarjeta = crearNumeroDeTarjeta();
        this.fechaDeCreacion = LocalDate.now();
        this.saldo = saldo;
        this.CVV = crearCVV();
        this.Clabe = crearClabe();
        this.fechaDeVencimiento = LocalDate.now().plusYears(5);
        this.fechaDeUltimoMovimiento = fechaDeUltimoMovimiento;
        this.HoraDeUltimoMovimiento = HoraDeUltimoMovimiento;
    }

    public long crearNumeroDeTarjeta() {
        long numeroDeTarjeta = rand.nextLong(9000000000000000L) + 1000000000000000L;
        String numeroDeTarjetaStr = Long.toString(numeroDeTarjeta);
        for (int i = 0; i < numerosDeTarjeta.size(); i++) {
            if (numeroDeTarjetaStr.equals(numerosDeTarjeta.get(i))) {
                numeroDeTarjeta = rand.nextLong(9000000000000000L) + 1000000000000000L;
                numeroDeTarjetaStr = Long.toString(numeroDeTarjeta);
                i = 0;
            }


        }
        numerosDeTarjeta.add(numeroDeTarjetaStr);
        return Long.parseLong(numeroDeTarjetaStr);
    }

    public int crearCVV() {
        return rand.nextInt(899) + 100;
    }

    public long crearClabe() {
        long numeroDeTarjeta = rand.nextLong(900000000000000000L) + 100000000000000000L;
        String numeroDeTarjetaStr = Long.toString(numeroDeTarjeta);
        for (int i = 0; i < numerosDeTarjeta.size(); i++) {
            if (numeroDeTarjetaStr.equals(numerosDeTarjeta.get(i))) {
                numeroDeTarjeta = rand.nextLong(900000000000000000L) + 100000000000000000L;
                numeroDeTarjetaStr = Long.toString(numeroDeTarjeta);
                i = 0;  // Reiniciar el bucle si el número ya existe
            }
        }


        numerosDeTarjeta.add(numeroDeTarjetaStr);
        return numeroDeTarjeta;
    }


    public long getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }


    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }


    public double getSaldo() {
        return saldo;
    }


    public int getCVV() {
        return CVV;
    }


    public long getClabe() {
        return Clabe;
    }


    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }


    public LocalDate getFechaDeUltimoMovimiento() {
        return fechaDeUltimoMovimiento;
    }


    public LocalDate getHoraDeUltimoMovimiento() {
        return HoraDeUltimoMovimiento;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void setFechaDeUltimoMovimiento(LocalDate fechaDeUltimoMovimiento) {
        this.fechaDeUltimoMovimiento = fechaDeUltimoMovimiento;
    }


    public void setHoraDeUltimoMovimiento(LocalDate horaDeUltimoMovimiento) {
        HoraDeUltimoMovimiento = horaDeUltimoMovimiento;
    }


}