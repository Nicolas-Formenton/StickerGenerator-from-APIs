import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        /* fazer uma conexão HTTP */
        
        API minhaAPI = API.NASA;

        var clientHttp = new ClientHttp();
        String json = clientHttp.buscaDados(minhaAPI.url());

        /* exibir e manipular os dados */
        List<Conteudo> conteudos = minhaAPI.extrator().extraiConteudos(json);

        var generator = new StickerGenerator();
        
        for (int i = 0; i < conteudos.size(); i++) {

            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = conteudo.getTitulo().replace(":", "-") + ".png";

                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            

                generator.criar(inputStream, nomeArquivo);

                System.out.println(conteudo.getTitulo());
                System.out.println();
            
        }
    }
}
