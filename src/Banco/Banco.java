package Banco;

import Usuarios.Cliente;
import Usuarios.Empleado;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


public class Banco {
    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();
    public static final HashMap<Rol, ArrayList<Usuario>> listaUsuarios = new HashMap<>();
    HashMap<String, Empleado> listaEmpleado = new HashMap<>();
    HashMap<String, Cliente> listaCliente = new HashMap<>();
    public Banco() {
        Empleado Gerente1 = new Empleado("Gerente1","23","Juan","Perez", LocalDate.now(),"Morelia","Mich","12222","12222","Av Tec de morelia", Sucursales.Acueducto, Rol.Gerente);
        insertarEmpleado(Gerente1);
        this.ValidacionesYRegistros = new ValidacionesYRegistros(this);
    }

    ValidacionesYRegistros ValidacionesYRegistros;


    public void insertarEmpleado(Empleado empleado) {
        listaEmpleado.put(empleado.getUsuario(), empleado);
        listaUsuarios.put(Rol.Gerente, new ArrayList<>());
        listaUsuarios.put(Rol.Capturista, new ArrayList<>());
        listaUsuarios.put(Rol.Ejecutivos, new ArrayList<>());
        listaUsuarios.put(Rol.Inversionista, new ArrayList<>());
        listaUsuarios.get(Rol.Gerente).add(empleado);
        listaUsuarios.get(Rol.Capturista).add(empleado);
        listaUsuarios.get(Rol.Ejecutivos).add(empleado);
        listaUsuarios.get(Rol.Inversionista).add(empleado);
    }

    public void insertarCliente(Cliente cliente) {
        listaCliente.put(cliente.getUsuario(), cliente);
        listaUsuarios.put(Rol.Cliente, new ArrayList<>());
        listaUsuarios.get(Rol.Cliente).add(cliente);
    }

    public ArrayList<String> RegistrarDatosComunes(){
        System.out.println("ingrese su(s) nombre(s): ");
        String nombre=leer.nextLine();
        nombre= ValidacionesYRegistros.validarNombre(nombre);
        System.out.println("ingrese sus apellido: ");
        String apellido=leer.nextLine();
        apellido= ValidacionesYRegistros.validarApellido(apellido);
        System.out.println("ingrese su usuario: ");
        String usuario=leer.nextLine();
        usuario= ValidacionesYRegistros.validarUsuario(usuario);
        System.out.println("ingrese su contraseña: ");
        String contraseña=leer.nextLine();
        LocalDate fechaDeNacimiento= ValidacionesYRegistros.RegistrarFEchaDeNacimiento();
        System.out.println("ingrese su ciudad: ");
        String ciudad=leer.nextLine();
        ciudad= ValidacionesYRegistros.validarCiudad(ciudad);
        System.out.println("ingrese su estado: ");
        String estado=leer.nextLine();
        estado= ValidacionesYRegistros.validarEstado(estado);
        String RFC= ValidacionesYRegistros.generarRFC(nombre,apellido,fechaDeNacimiento);
        System.out.println("Ingrese su Curp: ");
        String Curp=leer.nextLine();
        System.out.println("Ingrese su dirección (colonia, calle, número): ");
        String direccion = leer.nextLine();
        direccion = ValidacionesYRegistros.validarDireccion(direccion);
        ArrayList<String> DatosComun = new ArrayList<>();
        DatosComun.addAll(Arrays.asList(nombre,apellido, fechaDeNacimiento.toString(), ciudad, estado, RFC, Curp, usuario,contraseña));
        return DatosComun;
    }
    public Cliente RegistrarCliente(ArrayList<String> datosComunes) {
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
        Cliente cliente = new Cliente(usuario, contraseña, nombre, apellido, fechaNacimiento, ciudad, estado, RFC, Curp, direccion, null, Rol.Cliente);
        insertarCliente(cliente);

        return cliente;
    }




    //getters and setters


    public Usuario comprobarInicioSesion(String usuario, String contraseña){
        for(ArrayList<Usuario> userList : listaUsuarios.values()){
            for(Usuario usuarioActual : userList) {
                if (usuarioActual.getUsuario().equals(usuario) && usuarioActual.getPassword().equals(contraseña)) {
             return usuarioActual;
                }
            }
        }
        return null;
    }
}
