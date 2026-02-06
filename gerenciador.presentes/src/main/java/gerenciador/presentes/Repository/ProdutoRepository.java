package gerenciador.presentes.Repository;

import gerenciador.presentes.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProdutoRepository extends JpaRepository<Produtos,Long> {
    List<Produtos>findByNomeContainingIgnoreCase(String nome);
    //Isso gera: SELECT * FROM produtos WHERE nome LIKE %nome% (ignorando maiúsculas/minúsculas)
}



/* JpaRepository ao colocar isso informo pra criar um repositorio da minha entity produto
e ponho o tipo da minha PK
Ao herdar de JpaRepository, o Spring "fabrica" automaticamente para você os métodos:

    save(produto): Salva ou atualiza um produto.

    findAll(): Lista todos os produtos da tabela.

    findById(id): Busca um produto específico pelo ID.

    deleteById(id): Deleta um produto.

    LEMBRAR Q O REPOSITORY É UMA INTERFACE !!!!
 */
