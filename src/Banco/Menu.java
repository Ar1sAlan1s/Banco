package Banco;

import Usuarios.Usuario;
import Usuarios.Utils.UsuarioActivo;
import java.util.Scanner;

public class Menu {
    private Banco banco = new Banco();
    private Scanner sc = new Scanner(System.in);

    public void iniciarSesion() {
        boolean sonDatosCorrectos = false;

        do {
            System.out.println("**Bienvenido al Sistema del Banco**");
            System.out.println("Inicie sesión para continuar.");

            System.out.println("Ingresa el nombre de usuario: ");
            String usuario = sc.nextLine();

            System.out.println("Ingresa el password: ");
            String password = sc.nextLine();

            Usuario usuarioActual = banco.comprobarInicioSesion(usuario, password);

            if (usuarioActual != null) {
                UsuarioActivo.getInstance().setUsuario(usuarioActual);
                sonDatosCorrectos = true;
                asignarMenu();
            }else{
                System.out.println("Usuario o contraseña incorrecta. Intenta de nuevo.");
            }
        } while (!sonDatosCorrectos);
    }
    //Función Lambda
    public void asignarMenu() {
        switch (UsuarioActivo.getInstance().getUsuarioActual().getRol()) {
            case Gerente -> seleccionarMenuGerente();
            case Cliente -> seleccionarMenuCliente();

        }
    }

    private void seleccionarMenuCliente() {
        int opcionCliente = 0;
        do {
            System.out.println("MENU CLIENTE");
            System.out.println("1. Realizar una compra.");
            System.out.println("2. Solicitar Tarjeta de crédito.");
            System.out.println("3. Solicitar Tarjeta de debito.");
            System.out.println("4. Verificar estado de solicitud.");
            System.out.println("5. Cerrar sesión Actual.");
            System.out.println("Seleccione algo de la lista por favor: ");

            opcionCliente = sc.nextInt();
            sc.nextLine(); //Limpiar el buffer

            switch (opcionCliente) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Sesion cerrada...");
                    UsuarioActivo.getInstance().cerrarSesionActiva();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción no valida. Elija cualquiera en el rango de 1 a 5.");
            }
        } while (opcionCliente != 5);
    }
    private void seleccionarMenuGerente() {
        int opcionGerente = 0;
        do{
            System.out.println("MENU GERENTE");
            System.out.println("1.-Registrar Cliente, Gerente, Capturista, Ejecutivo o Inversionista");
            System.out.println("2.-Eliminar Cliente, Gerente, Capturista, Ejecutivo o Inversionista");
            System.out.println("3.-Modificar Cliente, Gerente, Capturista, Ejecutivo o Inversionista");
            System.out.println("4.-Mostrar Clientes, Gerentes, Capturistas, Ejecutivos o Inversionistas");
            System.out.println("5.-Consultar solicitudes de tarjetas en el sistema.");
            System.out.println("6.-Consultar Inversiones en el banco.");
            System.out.println("7.-Cerrar sesión Actual.");
            System.out.println("Ingrese la opcion deseada: ");

            opcionGerente = sc.nextInt();
            sc.nextLine(); //Limpiar el Buffer

            switch (opcionGerente){
                case 1:
                    int opcionRegistro = 0;
                    do {
                        System.out.println("Has elegido registrar");
                        System.out.println("¿A quien desea Registrar?");
                        System.out.println("1.-Cliente.");
                        System.out.println("2.-Gerente.");
                        System.out.println("3.-Capturista.");
                        System.out.println("4.-Ejecutivo.");
                        System.out.println("5.-Inversionista.");
                        System.out.println("6.-Salir del Registro.");
                        System.out.println("Seleccione una opcion: ");

                        opcionRegistro = sc.nextInt();
                        sc.nextLine();

                        switch (opcionRegistro){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:
                                System.out.println("\nSaliendo del registro. . .");
                                break;
                            default:
                                System.out.println("Opcion invalida. Vuelva a intentarlo");

                        }

                    }while(opcionRegistro != 6);
                    break;
                case 2:
                    int opcionEliminar = 0;
                    do {
                        System.out.println("Has elegido eliminar");
                        System.out.println("¿A quien desea Eliminar?");
                        System.out.println("1.-Cliente.");
                        System.out.println("2.-Gerente.");
                        System.out.println("3.-Capturista.");
                        System.out.println("4.-Ejecutivo.");
                        System.out.println("5.-Inversionista.");
                        System.out.println("6.-Salir de la eliminación.");
                        System.out.println("Seleccione una opcion: ");

                        opcionEliminar = sc.nextInt();
                        sc.nextLine();

                        switch (opcionEliminar){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:
                                System.out.println("\nSaliendo de la eliminación. . .");
                                break;
                            default:
                                System.out.println("Opcion invalida. Vuelva a intentarlo");
                        }
                    }while(opcionEliminar != 6);
                    break;
                case 3:
                    int opcionModificar = 0;
                    do {
                        System.out.println("Has elegido modificar");
                        System.out.println("¿A quien desea modificar?");
                        System.out.println("1.-Cliente.");
                        System.out.println("2.-Gerente.");
                        System.out.println("3.-Capturista.");
                        System.out.println("4.-Ejecutivo.");
                        System.out.println("5.-Inversionista.");
                        System.out.println("6.-Salir de la modificación.");
                        System.out.println("Seleccione una opción: ");

                        opcionModificar = sc.nextInt();
                        sc.nextLine();

                        switch (opcionModificar){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:
                                System.out.println("\nSaliendo de la modificación. . .");
                                break;
                            default:
                                System.out.println("Opción invalida. Vuelva a intentarlo");
                        }
                    }while(opcionModificar != 6);
                    break;
                case 4:
                    int opcionMostrar = 0;
                    do {
                        System.out.println("Has elegido Mostrar");
                        System.out.println("¿A quienes desea mostrar en especifico?");
                        System.out.println("1.-Cliente.");
                        System.out.println("2.-Gerente.");
                        System.out.println("3.-Capturista.");
                        System.out.println("4.-Ejecutivo.");
                        System.out.println("5.-Inversionista.");
                        System.out.println("6.-Salir.");
                        System.out.println("Seleccione una opción: ");

                        opcionMostrar = sc.nextInt();
                        sc.nextLine();

                        switch (opcionMostrar){
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:
                                System.out.println("\nSaliendo de mostrar en especifico. . .");
                                break;
                            default:
                                System.out.println("Opcion invalida. Vuelva a intentarlo");
                        }
                    }while(opcionMostrar != 6);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("\nCerrando la sesión actual redireccionando al inicio de sesión.");
                    UsuarioActivo.getInstance().cerrarSesionActiva();
                    break;
            }
        }while(opcionGerente != 7);
    }

    public void ejecutarMenuBanco(){
        boolean bandera = true;
        do{
        System.out.println("**BIENVENIDO AL BANCO**");
        System.out.println("1. Iniciar Sesión.");
        System.out.println("2. Cerrar Sesión.");
        System.out.println("Elija su opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();//Limpiar buffer
        switch(opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                System.out.println("Cerrando sesión. . .");
                bandera = false;
                break;
            default:
                System.out.println("Esa no es una opción. Intente de nuevo.");
        }
        }while(bandera);
    }
}