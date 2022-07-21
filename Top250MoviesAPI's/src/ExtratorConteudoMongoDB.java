import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoMongoDB implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json){
        /* extrair apenas os dados que interessam (titulo, imagem, ranking)  */
        /* Map = Estrutura de Dados associativa */
        var parser = new jsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteúdos
        for (Map<String, String> atributos : listaDeAtributos) {
            
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");

            System.out.println();
            System.out.println();

            System.out.println("\u001b[48;2;42;122;228mTítulo:\u001b[m" + atributos.get("title"));
            System.out.println("\u001b[48;2;42;122;228mImagem:\u001b[m" + atributos.get("image"));
            System.out.println("\u001b[48;2;42;122;228mRank:\u001b[m" + atributos.get("ranking")); 

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        
        System.out.println();
        System.out.println();
        return conteudos;
    }
}
