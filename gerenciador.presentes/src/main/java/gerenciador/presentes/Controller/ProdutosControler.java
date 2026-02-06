package gerenciador.presentes.Controller;

import gerenciador.presentes.Entity.Produtos;
import gerenciador.presentes.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //informo q é uma API
@RequestMapping("/produtos") // determino o endereço de acesso

public class ProdutosControler {

    @Autowired // injeção de dependencia e trago a interface produtosrepository
    // q é onde eu realizo as ações na tabela
    private ProdutoRepository repository;

    @GetMapping //listo os produtos
    public List<Produtos>ListarProdutos(){
        return repository.findAll();
    }
    @GetMapping ("/buscar")
    public List<Produtos>BuscarProduto(@RequestParam("nome")String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
        //quero buscar um produto por nome: findByNomeContainingIgnoreCase(nome), esse mtodo
        // criei la no repository pra funcionar

    }
    @PostMapping //adc os produtos
    //no metodo eu chamo o nom da classe da entity a ação
    //@RequestBody diz que o produto virá no "corpo" da requisição (JSON)
    public Produtos cadastrar(@RequestBody Produtos produtos){
        return repository.save(produtos);
    }
    @DeleteMapping("/{id}")
    public String deletar (@PathVariable Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Produto do id: "+id+ "foi deletado";
        }
        else {
            return "Produto não encontrado";
        }
    }

    @DeleteMapping("/nome/{nome}")
    public String deletarNome(@PathVariable String nome){
        List<Produtos>lista = repository.findByNomeContainingIgnoreCase(nome);
        if (lista.isEmpty()){
            return "Não foi encotrado nenhum produto com o nome: "+ nome;
        }
        repository.deleteAll(lista);
        return "Sua lista atualizada"+lista.size() + "de produtos deletados";
        // Deleto por nome

    }
    @PutMapping ("/{id}")
    public Produtos atualizar(@PathVariable Long id, @RequestBody Produtos produtoAtualizado)
    {
        return repository.findById(id).map(produtoExistente -> {
            // 2. Atualizamos os campos com os novos valores que vieram no JSON
            produtoExistente.setNomeprod(produtoAtualizado.getNomeprod());
            produtoExistente.setValor(produtoAtualizado.getValor());
            produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
            // 3. Salvamos o produto já atualizado
            return repository.save(produtoExistente);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    }
//@PathVariable Long id: Identifica qual produto você quer mudar.
//
//@RequestBody Produtos produtoAtualizado: Recebe o JSON com os novos dados.
//
//.findById(id): Antes de mudar, precisamos ter certeza de que o produto existe.
//
//.map(...): Se o produto for encontrado, entramos nessa lógica para trocar os valores
// antigos pelos novos.
//
//.save(): O Spring Data JPA é inteligente: se você chama o save em um objeto que já tem
// um ID que existe no banco, ele não cria um novo, ele apenas atualiza a linha existente.




