import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
    
        /* fazer uma conexão HTTP e buscar os top 250 filmes */

        //api = k_7gmger3z
        /* String apikey = System.getenv("API_KEY"); */

        String url = "https://api.mocki.io/v2/549a5d8b/Top250TVs"; /* + apikey; */
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        /* extrair apenas os dados que interessam (titulo, poster, classificação)  */
        /* Map = Estrutura de Dados associativa */
        var parser = new jsonParser();
        List<Map<String, String>> listaDeSeries = parser.parse(body);
       /*  System.out.println(listaDeSeries.size());
        System.out.println(listaDeSeries.get(0)); */

        /* exibir e manipular os dados */
        for (Map<String,String> serie : listaDeSeries) {
            
            System.out.print("\u001b[48;2;42;122;228mTítulo: \u001b[m");
            System.out.println(serie.get("title"));

            System.out.print("\u001b[48;2;42;122;228mPoster: \u001b[m");
            System.out.println(serie.get("image"));



            String imdbRating = serie.get("imDbRating");
            Double imdbRatingDouble = Double.parseDouble(imdbRating);
            long roundedRating = Math.round(imdbRatingDouble); 

            System.out.print("\u001b[48;2;42;122;228mNota: \u001b[m");
            System.out.println(serie.get("imDbRating"));
            
            //Estrelas            
            for(int i=0; i < roundedRating; i++){
            System.out.print("\u2b50");
            }

            System.out.println();
            
        }
    }
}
