package dio.aprendendo;

import org.springframework.stereotype.Component;

@Component
//tranformo a calculado em beens
public class Calculadora {
    public int somar (int numero1,int numero2){
        return  numero1+numero2;
    }

}
