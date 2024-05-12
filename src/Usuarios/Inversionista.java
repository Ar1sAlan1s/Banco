package Usuarios;

import Banco.Banco;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inversionista extends  Usuario{
    double DineroInvertido;

    public Inversionista(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol,double DineroInvertido) {
        super(usuario, password, nombre, apellidos, fechaNacimiento, ciudad, estado, RFC, Curp, direccion, sucursales, rol);
        this.DineroInvertido=DineroInvertido;
    }
    public void RegistrarInversionista(Empleado gerente) {
        Banco banco=new Banco();
        ArrayList<String> datosComunes = banco.RegistrarDatosComunes();
        String nombre = datosComunes.get(0);
        String apellido = datosComunes.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComunes.get(2));
        String ciudad = datosComunes.get(3);
        String estado = datosComunes.get(4);
        String RFC = datosComunes.get(5);
        String Curp = datosComunes.get(6);
        String direccion = datosComunes.get(7);
        String usuario = datosComunes.get(8);
        String contraseña = datosComunes.get(9);
        Sucursales sucursales = gerente.getSucursales();

        Inversionista inversionista = new Inversionista(usuario, contraseña, nombre, apellido, fechaNacimiento, ciudad, estado, RFC, Curp, direccion, sucursales, Rol.Inversionista, 0);
        banco.listaInversionista.put(inversionista.getUsuario(), inversionista);
        Banco.listaUsuarios.get(inversionista.getRol()).add(inversionista);
    }
}
