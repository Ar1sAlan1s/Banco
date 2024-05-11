package Tarjetas;

import Tarjetas.Utils.TiposCredito;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Credito extends Tarjeta{
    private double limite;


    public Credito(String usuario, String password, TiposCredito tipo,double limite) {
        super(usuario, password, tipo);
        this.limite=limite;
  }


}

