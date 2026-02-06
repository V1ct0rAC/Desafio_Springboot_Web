package myAPI.web_API.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//determino q ele seja controller

public class Controller {
    @GetMapping
    //mapeio ele
    //crio um metodo q vai voltar algo
    public String welcome()
    {
        return "Welcome";
    }
}

// O controller faz com q minha API apareçã na pag WEB
