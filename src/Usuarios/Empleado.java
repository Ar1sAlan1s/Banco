package Usuarios;

import Banco.Banco;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import Banco.ValidacionesYRegistros;


public class Empleado extends Usuario{

    double Salario;
    LocalDate fechaDeInicioLaboral;



    public Empleado(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol, double Salario,LocalDate fechaDeInicioLaboral){
        super(usuario,password,nombre,apellidos,fechaNacimiento,ciudad,estado,RFC,Curp,direccion,sucursales,rol);
        this.Salario=Salario;
        this.fechaDeInicioLaboral=fechaDeInicioLaboral;
    }

    public void RegistrarEjecutivo(Empleado gerente){
        Banco banco=new Banco();
        ArrayList<String> datosComunes= banco.RegistrarDatosComunes();
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
        double Salario= ValidacionesYRegistros.RegistrarSalario();

        Empleado empleado=new Empleado(usuario,contraseña,nombre,apellido,fechaNacimiento, ciudad,estado,RFC,Curp,direccion,sucursales,Rol.Ejecutivos,Salario,LocalDate.now());
        banco.listaEmpleado.put(empleado.getUsuario(), empleado);
        Banco.listaUsuarios.get(empleado.rol).add(empleado);
    }
    public void RegistrarCapturista(Empleado gerente){
        Banco banco=new Banco();
        ArrayList<String> datosComunes= banco.RegistrarDatosComunes();
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
        double Salario= ValidacionesYRegistros.RegistrarSalario();

        Empleado empleado=new Empleado(usuario,contraseña,nombre,apellido,fechaNacimiento, ciudad,estado,RFC,Curp,direccion,sucursales,Rol.Capturista,Salario,LocalDate.now());
        banco.listaEmpleado.put(empleado.getUsuario(), empleado);
        Banco.listaUsuarios.get(empleado.rol).add(empleado);
    }






    //getters and Setters
    public double getSalario(){
        return Salario;
    }
    public void setSalario(double salario) {
        Salario = salario;
    }

}
