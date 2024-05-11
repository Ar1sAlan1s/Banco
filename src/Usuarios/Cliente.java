package Usuarios;

import Tarjetas.Credito;
import Tarjetas.Debito;
import Tarjetas.Utils.TiposCredito;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;
import Tarjetas.Tarjeta;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;
    Debito debito;
    Rol rol;
    HashMap<String,String> solicitudes = new HashMap<>();
    Scanner scan=new Scanner(System.in);
    HashMap<Cliente,Credito>Tarjetas;
    public HashMap tarjetasCredito;
    public Cliente(String usuario, String password, String nombre, String apellidos, LocalDate fechaNacimiento, String ciudad, String estado, String RFC, String Curp, String direccion, Sucursales sucursales, Rol rol) {
        super(usuario, password, nombre, apellidos, fechaNacimiento, ciudad, estado , RFC, Curp, direccion, sucursales, Rol.Cliente);//Asigno de una vez el Rol Cliente
        this.rol=rol;
        this.tarjetasCredito=new HashMap<>();
        this.debito= new Debito(usuario,password, TiposCredito.debito);
    }

    public void solicitarTarjetaCredito(){
        boolean band=true;
        System.out.println("Bienvenido al proceso de Solicitud de credito");
        System.out.println("La o las tarjetas que se le ofrezcan dependeran de la cantidad de dinero que tenga su tarjeta de Debito");
        if (debito.getSaldo()>=200000){
            System.out.println("Usted califica para poder solicitar la tarjeta Oro\nTiene un credito de $150,000 ");
            System.out.println("Para solicitarla ingrese 'ORO'");
            String Opcion=scan.nextLine();
            while (band) {
                if (Opcion.equals("ORO")) {
                    solicitudes.put(getUsuario(),Opcion);
                    band=false;
                    System.out.println("Solicitud Completada");
                }else{
                    System.out.println("Opcion incorrecta intente de nuevo");
                    System.out.println("Si deseas cancelar el proceso de solicitud ingrese'EXIT,");
                }
                if (Opcion.equals("EXIT")) {
                    band=false;
                    System.out.println("Solicitud Cancelada");
                }
            }
        }
        if (debito.getSaldo()>=100000){
            System.out.println("Usted califica para poder solicitar la tarjeta Platino\nTiene un credito de $150,000 ");
            System.out.println("Para solicitarla ingrese 'PLT'");
            String Opcion=scan.nextLine();
            while (band) {
                if (Opcion.equals("PLT")) {
                    solicitudes.put(getUsuario(),Opcion);
                    band=false;
                    System.out.println("Solicitud Completada");
                }else{
                    System.out.println("Opcion incorrecta intente de nuevo");
                    System.out.println("Si deseas cancelar el proceso de solicitud ingrese'EXIT,");
                }
                if (Opcion.equals("EXIT")) {
                    band=false;
                    System.out.println("Solicitud Cancelada");
                }
            }
        }
        if (debito.getSaldo()>=50000){
            System.out.println("Usted califica para poder solicitar la tarjeta Simplicity\nTiene un credito de $60,000 ");
            System.out.println("Para solicitarla ingrese 'SMP'");
            String Opcion=scan.nextLine();
            while (band) {
                if (Opcion.equals("SMP")) {
                    solicitudes.put(getUsuario(),Opcion);
                    band=false;
                    System.out.println("Solicitud Completada");
                }else{
                    System.out.println("Opcion incorrecta intente de nuevo");
                    System.out.println("Si deseas cancelar el proceso de solicitud ingrese'EXIT,");
                }
                if (Opcion.equals("EXIT")) {
                    band=false;
                    System.out.println("Solicitud Cancelada");
                }
            }
        }
    }

}