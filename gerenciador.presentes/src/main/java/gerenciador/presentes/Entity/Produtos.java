package gerenciador.presentes.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // aviso ao spring q é uma tabela
@Table(name = "Tb_produtos") //determino o nome da tabela, n pode ter espaço
@Data //Essa anotação do Lombok cria Getters, Setters, toString e Equals automaticamente!
@NoArgsConstructor //neses 2 gero os contrutores
@AllArgsConstructor

public class Produtos {
    @Id //coloco para deter,inar minha primary key, logo abaixo coloco ela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // a id é gerada automomaticanente
    // a cada produto q for add
    private Long id; // PK
    private  String nomeprod;
    private  double valor;
    private int quantidade;


}
