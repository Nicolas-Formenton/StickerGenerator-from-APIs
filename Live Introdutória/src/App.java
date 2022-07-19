import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        
        //acessar url
        var url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).build();

        //pegar texto JSON
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        //imprimir o JSON
        System.out.println(json);
    }
}
