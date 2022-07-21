package br.com.alura.linguagens.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;
    

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        
        //abrir conexao do Banco de Dados
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem adicionarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

/*     public Linguagem deletarLinguaguem(@RequestBody Linguagem linguagem){
        Linguagem linguagemDeleta = repositorio.delete(linguagem);
        return linguagemDeleta;
    } */
}
//Teste
/*     @GetMapping("/linguagem-preferida")
    public String processaLinguagemPreferida(){
        return "Oi, Java!";
    } */

/*     private List<Linguagem> linguagens =
        List.of(
            new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
            new Linguagem("JavaScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png", 2),
            new Linguagem("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 3)
        ); */
