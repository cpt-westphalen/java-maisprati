import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<Funcionario> funcionarios = new ArrayList<>();

        Programador programador = new Programador("Pedro", 35, 44);
        Contador contador = new Contador("Zé", 35, 44);
        Administrador administrador = new Administrador("Pietro", 35, 44);

        funcionarios.add(programador);
        funcionarios.add(contador);
        funcionarios.add(administrador);

        funcionarios.forEach((Funcionario funcionario) -> {
            System.out.println(funcionario);
        });
    }
}
