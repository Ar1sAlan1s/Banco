import Banco.Banco;
import Usuarios.Empleado;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;
import java.time.LocalDate;
import Banco.Menu;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Menu menu = new Menu();
        menu.ejecutarMenuBanco(); //Aquí ejecuto el menu del banco
    }
}