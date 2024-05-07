package Banco;
import Usuarios.Usuario;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.Random;

public class ValidacionesYRegistros {
    Scanner leer = new Scanner(System.in);
    Random ran = new Random();
    Banco banco;

    public ValidacionesYRegistros(Banco banco) {
        this.banco = banco;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
                contador = 0;
            } else {
                break;
            }
        }
        System.out.println("El nombre es válido.");
        return nombre;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
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
                cont = 0;
            } else {
                break;
            }
        }
        System.out.println("el apellido es valido.");
        return apellido;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public String validarUsuario(String usuario) {
        boolean nombreUsuarioExistente = false;
        for (Usuario usuarioExistente : banco.listaUsuarios.values()) {
            if (usuarioExistente != null && usuarioExistente.getUsuario().equals(usuario)) {
                nombreUsuarioExistente = true;
                break;
            }
        }
        if (nombreUsuarioExistente) {
            System.out.println("El nombre de usuario ya está en uso. Ingrese otro nombre de usuario: ");
            usuario = leer.nextLine();
            usuario = validarUsuario(usuario); // Llamada recursiva para volver a validar el usuario ingresado
        }
        return usuario;
    }

    public LocalDate RegistrarFEchaDeNacimiento() {
        boolean fechaValida = false;
        LocalDate fechaDeNacimiento = null;
        while (!fechaValida) {
            System.out.println("Ingrese su año de nacimiento: (ingrese el año como el siguiente ejemplo: 2004)");
            int año = leer.nextInt();
            System.out.println("Ingrese su mes de nacimiento: (ingrese el mes como el siguiente ejemplo: 08)");
            int mes = leer.nextInt();
            System.out.println("Ingrese su día de nacimiento: ");
            int dia = leer.nextInt();
            fechaDeNacimiento = LocalDate.of(año, mes, dia);
            int edad = Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
            if (edad >= 18) {
                fechaValida = true;
            } else {
                System.out.println("Ingrese una fecha correcta o no es posible que se pueda registrar por su edad.");
                fechaValida = false;
            }
        }
        return fechaDeNacimiento;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////
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

}
