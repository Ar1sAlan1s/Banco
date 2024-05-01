import Banco.Banco;
import Usuarios.Empleado;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursales;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Empleado Gerente1=new Empleado("Gerente1","23","Juan","Perez", LocalDate.now(),"Morelia","Mich","12222","12222","Av Tec de morelia", Sucursales.Acueducto, Rol.Gerente);
        banco.insertarEmpleado(Gerente1);
    }
}