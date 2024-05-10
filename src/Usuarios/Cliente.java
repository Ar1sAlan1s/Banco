package Usuarios;

import Banco.Banco;
import Tarjetas.Credito;
import Tarjetas.Debito;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;
import Tarjetas.Tarjeta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static Banco.Banco.listaUsuarios;

public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;
    Debito debito;
    Rol rol;
    public HashMap<Long, Credito>tarjetasCredito;
    public Cliente(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol, Debito debito, HashMap tarjetasCredito) {
        super(usuario, password, nombre, apellidos, fechaNacimiento, ciudad, estado , RFC, Curp, direccion, sucursales, Rol.Cliente);//Asigno de una vez el Rol Cliente
        this.rol=rol;
        this.tarjetasCredito=tarjetasCredito;
        this.debito=debito;
    }
    public void RegistrarCliente(Empleado capturistaOgerente) {
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
        Sucursales sucursales = capturistaOgerente.getSucursales();
        Cliente cliente = new Cliente(usuario, contraseña, nombre, apellido, fechaNacimiento, ciudad, estado, RFC, Curp, direccion, sucursales, Rol.Cliente, null, null);
        banco.listaCliente.put(cliente.getUsuario(), cliente);
        listaUsuarios.get(cliente.rol).add(cliente);

    }
}
