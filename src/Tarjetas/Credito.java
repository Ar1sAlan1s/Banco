package Tarjetas;

import Tarjetas.Utils.TiposCredito;


import java.time.LocalDate;

public class Credito extends Tarjeta{



    public Credito(String usuario, String password, TiposCredito tipo) {
        super(usuario, password, tipo);
        if(tipo==TiposCredito.simplicity){
            setSaldo(60000);
        } else if (tipo==TiposCredito.platino) {
            setSaldo(150000);
        } else if (tipo==TiposCredito.oro) {
            setSaldo(40000);
        }
    }


}