package Banco;
import Usuarios.Usuario;
import Usuarios.Utils.Sucursales;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class ValidacionesYRegistros {
    Scanner leer = new Scanner(System.in);
    Random ran = new Random();
    Banco banco;
    public String validarNombre(String nombre) {
        while (true) {
            boolean nombreValido = true;
            int contador = 0;
            for (int i = 0; i < nombre.length(); i++) {
                if (!Character.isLetter(nombre.charAt(i)) && !Character.isWhitespace(nombre.charAt(i))) {
                    nombreValido = false;
                    break;
                }
                if (Character.isWhitespace(nombre.charAt(i))) {
                    contador++;
                }
            }
            if (!nombreValido || contador > 1) {
                System.out.println("El/los nombre(s) no es válido(s). Ingrese solo letras y como máximo un espacio entre nombres.");
                System.out.println("Ingrese su nombre nuevamente: ");
                nombre = leer.nextLine();
            } else {
                break;
            }
        }
        System.out.println("El nombre es válido.");
        return nombre;
    }

    public String validarApellido(String apellido) {
        while (true) {
            boolean apellidoValido = true;
            int cont = 0;
            for (int i = 0; i < apellido.length(); i++) {
                if (!Character.isLetter(apellido.charAt(i)) && !Character.isWhitespace(apellido.charAt(i))) {
                    apellidoValido = false;
                    break;
                }
                if (Character.isWhitespace(apellido.charAt(i))) {
                    cont++;
                }
            }
            if (!apellidoValido || cont > 1 || cont == 0) {
                System.out.println("los apellidos no son validos no ingrese caracteres erroneos o coloque mas de 2 apellidos");
                System.out.println("Ingrese sus apellidos nuevamente: ");
                apellido = leer.nextLine();
            } else {
                break;
            }
        }
        System.out.println("el apellido es valido.");
        return apellido;
    }

    public String validarUsuario(String usuario) {
        boolean nombreUsuarioExistente = false;
        for (ArrayList<Usuario> usuarioExistente : Banco.listaUsuarios.values()) {
            if (usuarioExistente != null) {
                for (Usuario usuario1: usuarioExistente) {
                    if(usuario1.getUsuario().equals(usuario)){
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
            }
        }
        if (nombreUsuarioExistente) {
            System.out.println("El nombre de usuario ya está en uso. Ingrese otro nombre de usuario: ");
            usuario = leer.nextLine();
            usuario = validarUsuario(usuario); // Llamada recursiva para volver a validar el usuario ingresado
        }
        return usuario;
    }

    public LocalDate RegistrarFechaDeNacimiento() {
        boolean fechaValida = false;
        LocalDate fechaDeNacimiento = null;
        while (!fechaValida) {
            int año = 0;
            try {
                System.out.println("Ingrese su año de nacimiento: (ingrese el año como el siguiente ejemplo: 2004)");
                año = leer.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero para el año.");
                leer.nextLine(); // Limpiamos el buffer del scanner
                continue; // Volvemos al inicio del bucle
            }


            int mes = 0;
            mesLoop:
            while (true) {
                try {
                    System.out.println("Ingrese su mes de nacimiento: (ingrese el mes como el siguiente ejemplo: 08)");
                    mes = leer.nextInt();
                    if (mes < 1 || mes > 12) {
                        throw new IllegalArgumentException("Mes no válido. Debe ser un número entre 1 y 12.");
                    }
                    break mesLoop; // Salimos del bucle etiquetado si el mes es válido
                } catch (InputMismatchException e) {
                    System.out.println("Error: debe ingresar un número entero para el mes.");
                    leer.nextLine(); // Limpiamos el buffer del scanner
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }


            int dia = 0;
            try {
                System.out.println("Ingrese su día de nacimiento: ");
                dia = leer.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero para el día.");
                leer.nextLine(); // Limpiamos el buffer del scanner
                continue;
            }


            try {
                fechaDeNacimiento = LocalDate.of(año, mes, dia);
            } catch (DateTimeException e) {
                System.out.println("Fecha no válida. Por favor, ingrese una fecha válida.");
                continue;
            }


            int edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
            if (edad >= 18) {
                fechaValida = true;
            } else {
                System.out.println("Lo siento, debe tener al menos 18 años para registrarse.");
                fechaValida = false;
            }
        }
        return fechaDeNacimiento;
    }

    public String validarCiudad(String ciudad) {
        while (true) {
            boolean ciudadValida = true;
            for (int i = 0; i < ciudad.length(); i++) {
                if (!Character.isLetter(ciudad.charAt(i)) && !Character.isWhitespace(ciudad.charAt(i))) {
                    ciudadValida = false;
                    break;
                }
            }
            if (!ciudadValida) {
                System.out.println("La ciudad no es válida. Ingrese caracteres correctos.");
                System.out.println("Ingrese la ciudad nuevamente: ");
                ciudad = leer.nextLine();
            } else {
                break;
            }
        }
        System.out.println("La ciudad es válida.");
        return ciudad;
    }

    public String validarEstado(String estado) {
        while (true) {
            boolean EstadoValido = true;
            for (int i = 0; i < estado.length(); i++) {
                if (!Character.isLetter(estado.charAt(i)) && !Character.isWhitespace(estado.charAt(i))) {
                    EstadoValido = false;
                    break;
                }
            }
            if (!EstadoValido) {
                System.out.println("El estado no es válida. Ingrese caracteres correctos.");
                System.out.println("Ingrese su estado nuevamente: ");
                estado = leer.nextLine();
            } else {
                break;
            }
        }
        System.out.println("El estado es válida.");
        return estado;
    }

    public String generarRFC(String nombre, String apellido, LocalDate fechaDeNacimiento) {
        String PrimeraletraApellidoMaterno = " ";
        for (int i = 0; i < apellido.length(); i++) {
            if (apellido.charAt(i) == ' ') {
                PrimeraletraApellidoMaterno = apellido.substring(i + 1);
                break;
            }
        }
        PrimeraletraApellidoMaterno = PrimeraletraApellidoMaterno.toUpperCase();
        int numeroAleatorio1 = ran.nextInt(10);
        int numeroAleatorio2 = ran.nextInt(10);
        char letraAleatoria = (char) (ran.nextInt(27) + 'A');
        int año = fechaDeNacimiento.getYear();
        int añoDosDigitos = año % 100;
        String añoFormatoDosDigitos = String.format("%02d", añoDosDigitos);
        // Crear RFC
        String RFC = String.valueOf(apellido.charAt(0)) + String.valueOf(apellido.toUpperCase().charAt(1)) + String.valueOf(PrimeraletraApellidoMaterno.charAt(0)) + String.valueOf(nombre.charAt(0)) + String.valueOf(añoFormatoDosDigitos) + String.valueOf(fechaDeNacimiento.getMonthValue()) + String.valueOf(fechaDeNacimiento.getDayOfMonth()) + String.valueOf(numeroAleatorio1) + letraAleatoria + String.valueOf(numeroAleatorio2);
        System.out.println("Su RFC es: " + RFC);
        return RFC;
    }

    public String validarDireccion(String direccion) {
        String[] partesDireccion = direccion.split(",");
        if (partesDireccion.length != 3) {
            System.out.println("La dirección debe contener tres partes: colonia, calle y número.");
            System.out.println("Ingrese la dirección nuevamente en el formato correcto (colonia, calle, número): ");
            direccion = leer.nextLine();
            return validarDireccion(direccion);
        } else {
            String colonia = partesDireccion[0].trim();
            String calle = partesDireccion[1].trim();
            String numero = partesDireccion[2].trim();

            if (colonia.isEmpty() || calle.isEmpty() || numero.isEmpty()) {
                System.out.println("La dirección no puede contener partes vacías.");
                System.out.println("Ingrese la dirección nuevamente en el formato correcto (colonia, calle, número): ");
                direccion = leer.nextLine();
                return validarDireccion(direccion);
            } else {
                System.out.println("La dirección es válida.");
                return direccion;
            }
        }
    }

    public Sucursales ElegirSucursal(){
        boolean SucursalValido = true;
        Sucursales sucursal=null;
        while (SucursalValido) {
            System.out.println("en que sucursal deseas Registrar al Cliente: ");
            System.out.println("ingrese \"1\" para seleccionar la sucursal Madero");
            System.out.println("ingrese \"2\" para seleccionar la sucursal Acueducto");
            int seleccion = leer.nextInt();
            if (seleccion == 1) {
                sucursal=Sucursales.Madero;
                SucursalValido=false;
                break;
            } else if (seleccion == 2) {
                SucursalValido=false;
                sucursal=Sucursales.Acueducto;
            }else{
                System.out.println("ingrese un numero valido");
                SucursalValido=true;


            }
        }
        return sucursal;
    }

    public static double RegistrarSalario() {
        Scanner leer=new Scanner(System.in);
        double salario = 0;
        try {
            System.out.println("Ingrese el salario para el empleado");
            salario = leer.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese caracteres correctos");
        }
        return salario;
    }



}
