package Tarjetas;

import Tarjetas.Utils.TiposCredito;

import java.time.LocalDate;

public class  Debito extends Tarjeta{

    public Debito(String usuario, String password, TiposCredito tipo) {
        super(usuario, password, TiposCredito.debito);
    }
}