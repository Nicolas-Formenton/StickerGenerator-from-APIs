import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
    
        /* fazer uma conexão HTTP e buscar os top 250 filmes */
        /* String url = "https://imdb-api.com/en/API/Top250Movies/k_7gmger3z"; */
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        /* extrair apenas os dados que interessam (titulo, poster, classificação)  */
        /* Map = Estrutura de Dados associativa */
        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
       /*  System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes.get(0)); */

        /* exibir e manipular os dados */
        var generator = new StickerGenerator();
        for (Map<String,String> filme : listaDeFilmes){
            
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            generator.criar(inputStream, nomeArquivo);

            System.out.println("\u001b[48;2;42;122;228mTítulo: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[48;2;42;122;228mPoster: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[48;2;42;122;228mNota: \u001b[m" + filme.get("imDbRating"));

            //Notas Arredondadas pareadas com as estrelas
            String imdbRating = filme.get("imDbRating");
            Double imdbRatingDouble = Double.parseDouble(imdbRating);
            long roundedRating = Math.round(imdbRatingDouble); 

            //Estrelas            
            for(int i=0; i < roundedRating; i++){
                System.out.print("\u2b50");
            }            

            System.out.println();
            
        }
    }
}
