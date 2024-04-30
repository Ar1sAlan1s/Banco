package Usuarios;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;

import java.time.LocalDate;
public class Usuario {
    private String usuario;
    private String password;
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    protected String ciudad;
    protected String estado;
    protected String RFC;
    protected String Curp;
    protected String direccion;
    protected Sucursales sucursales;
    protected Rol rol;
    //Constructor
    public Usuario(String usuario,String password,String nombre,String apellidos,LocalDate fechaNacimiento,String ciudad,String estado,String RFC,String Curp,String direccion,Sucursales sucursales,Rol rol){
        this.usuario=usuario;
        this.password=password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.RFC = RFC;
        this.Curp = Curp;
        this.direccion = direccion;
        this.sucursales = sucursales;
        this.rol = rol;
    }

}
