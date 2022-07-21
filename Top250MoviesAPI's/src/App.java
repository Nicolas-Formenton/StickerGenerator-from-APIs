import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    
    public static void main(String[] args) throws Exception {

        /* fazer uma conexão HTTP */
        /* ExtratorDeConteudo extrator = new ExtratorConteudoNASA();
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; */

        ExtratorDeConteudo extrator = new ExtratorConteudoIMDB();
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        

        var clientHttp = new ClientHttp();
        String json = clientHttp.buscaDados(url);

        /* exibir e manipular os dados */
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var generator = new StickerGenerator();
        
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = conteudo.getTitulo().replace(":", "-") + ".png";

                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
           /*  String nomeArquivo = "saida/"+ conteudo.getTitulo() +".png"; */
            

                generator.criar(inputStream, nomeArquivo);

                System.out.println(conteudo.getTitulo());
                System.out.println();
            
        }
    }
}
