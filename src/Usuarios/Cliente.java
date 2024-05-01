package Usuarios;

import Tarjetas.Credito;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;
import Tarjetas.Tarjeta;
import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;
    Rol rol;
    public HashMap<Long, Credito>tarjetasCredito;
    public Cliente(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol, Tarjeta debito, HashMap tarjetasCredito) {
        super(usuario, password, nombre, apellidos, fechaNacimiento, ciudad, estado , RFC, Curp, direccion, sucursales, Rol.Cliente);//Asigno de una vez el Rol Cliente
        this.rol=rol;
        this.tarjetasCredito=tarjetasCredito;
    }
}
