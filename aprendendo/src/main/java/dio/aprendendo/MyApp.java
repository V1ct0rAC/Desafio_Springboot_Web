package dio.aprendendo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//coloco o component para determinar q os objetos serão beens
public class MyApp implements CommandLineRunner {
    //implemento o command linerunner/
    @Autowired
    //implemento a injeção para n precisar por o new
    private Calculadora calculadora;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("O resultado é " + calculadora.somar (12,58));
        //coloco o nome da classe instanciado.metodo


    }
}
