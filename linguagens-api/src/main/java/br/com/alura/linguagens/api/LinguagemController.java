package br.com.alura.linguagens.api;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return repositorio.findAll();
    }

    @PostMapping("/linguagens")
    public Linguagem adicionarLinguagem(@RequestBody Linguagem linguagem){
        return repositorio.save(linguagem);
    }
    
/* 
    @DeleteMapping("/linguagens/{id}")
    public ResponseEntity<Object> deletarLinguagem(@PathVariable(value = "id") String id){
        Optional<Linguagem> linguagem = repositorio.findById(id);
        
        if(linguagem.isPresent()){
            repositorio.delete(linguagem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
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
