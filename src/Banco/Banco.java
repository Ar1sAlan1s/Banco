package Banco;

import Usuarios.Cliente;
import Usuarios.Empleado;
import Usuarios.Usuario;
import java.util.HashMap;
import java.util.Scanner;


public class Banco {
    static Scanner leer=new Scanner(System.in);
    HashMap<String,Usuario> listaUsuarios=new HashMap<>();
    HashMap<String,Empleado>listaEmpleado=new HashMap<>();
    HashMap<String,Cliente> listaCliente =new HashMap<>();
    public void insertarEmpleado(Empleado empleado){
        listaEmpleado.put(empleado.getUsuario(),empleado);
        listaUsuarios.put(empleado.getUsuario(),empleado);
    }
    public void insertarCliente(Cliente cliente){
        listaCliente.put(cliente.getUsuario(),cliente);
        listaUsuarios.put(cliente.getUsuario(),cliente);
    }
    public void RegistrarUsuarios(){
        System.out.println("ingrese su nombre: ");
        String nombre=leer.nextLine();

    }

}
