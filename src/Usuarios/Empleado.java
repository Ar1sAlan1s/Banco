package Usuarios;

import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;

import java.time.LocalDate;
import java.util.Date;

public class Empleado extends Usuario{
    public Empleado(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol){
        super(usuario,password,nombre,apellidos,fechaNacimiento,ciudad,estado,RFC,Curp,direccion,sucursales,rol);//Asigno de una vez el Rol Cliente
    }
}
