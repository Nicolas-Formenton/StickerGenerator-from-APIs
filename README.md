# Bootcamp Alura - Java
Para rodar o projeto em sua máquina, vá ate o diretório `src` dentro de `Top250MoviesAPI's` usando `cd Top250MoviesAPI's/src` em seu terminal.
Assim que estiver dentro da pasta, digite `Javac *.java` para compilar o projeto e, em seguida, digite `Java App` para rodar!
<hr>

![Bootcamp Alura - Java - Bootcamp Alura - Java (3)](https://user-images.githubusercontent.com/81488809/180497633-441c53a3-80cf-4195-a735-52d95dc5f5d9.png)

## Aula 01
Vamos construir uma aplicação do zero para consumir a API do IMDb e exibir os filmes mais populares, destacando seus pôsteres e visualizando sua classificação...

Primeiro fizemos o request da conexão HTTP da API do IMDB
```java
String url = "https://api.mocki.io/v2/549a5d8Top250TVs";
URI endereço = URI.create(url);
var client = HttpClient.newHttpClient();
var request = HttpRequest.newBuilder(endereço).GET(build();
HttpResponse<String> response = client.send(requestBodyHandlers.ofString());
String body = response.body();
```
Depois, extraí apenas os dados que interessam para nós no aplicativo utilizando um `Parser`, também utilizando um `List<Map<String, String>>`, sendo o `Map` uma _*Estrutura de Dados Associativa*_.

Um dos desafios foi associar o `imdbRanking` a estrelas por nota

```java
String imdbRating = serie.get("imDbRating");
    
Double imdbRatingDouble = Double.parseDouble(imdbRating);
long roundedRating = Math.round(imdbRatingDouble); 

  System.out.print("\u001b[48;2;42;122;228mNota: \u001b[m");
  System.out.println(serie.get("imDbRating"));
    
  //Estrelas para cada nota            
  for(int i=0; i < roundedRating; i++){
  System.out.print("\u2b50");
  }
```
_Resultado_

![image](https://user-images.githubusercontent.com/81488809/180338933-6aca1b35-deb0-4235-8917-4d36fdc5084d.png)

## Aula 02
Criarei um gerador de figurinhas explorando outras bibliotecas nativas do Java, para que possamos enviar por Whatsapp os nossos filmes preferidos!

`StickerGenerator.java`

## Aula 03
Pegaremos os filmes do IMDb e gerar figurinhas com os pôsteres, aproveitando para melhorar nosso código com as refatorações necessárias para torná-lo mais flexível e fácil de entender.

## Aula 04
Vamos construir uma API REST para expor nosso próprio conteúdo, utilizando ferramentas profissionais como o Spring Framework e um banco de dados NoSQL.

Utilizei o `MongoDB` para armazenar nossa API, também utilizei o `Postman`(Desktop Version, pois a API ainda está em localhost) para conseguir ver (`@GetMapping`) as informações contidas na API como também atualiza-las(`@PostMapping`) diretamente por lá.

Removi o request do HTTP do código principal para ficar mais enxuto e prático de se mexer, criando uma propria class `ClientHttp`

Também atribui todas as API's para uma class própria `enum API`, ficando mais fácil para modificar elas, caso necessário...

```java
public enum API {

    IMDB("https://api.mocki.io/v2/549a5d8b/Top250Movies", new ExtratorConteudoIMDB()),
    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD", new ExtratorConteudoNASA()),
    MongoDB("http://localhost:8080/linguagens", new ExtratorConteudoMongoDB());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator){
        this.url = url;
        this.extrator = extrator;
    }

    public String url(){
        return url;
    }

    public ExtratorDeConteudo extrator(){
        return extrator;
    }
}
```
# Aula 05
Vamos tornar nossa aplicação acessível por qualquer pessoa, fazendo o deploy na nuvem.

Primeiro, instalei o Maven (https://maven.apache.org/download.cgi) e em seguida, dentro da pasta `linguagens-api` usei o comando `./mvnw package` para gerar o arquivo `.jar` dentro da pasta `target` com todas as bibliotecas utilizadas dentro.

Assim, conseguimos rodar o aplicativo a partir do `.jar`, digitando `java -jar .\linguagens-api-0.0.1-SNAPSHOT.jar`

Iremos fazer o deploy no __Heroku__, mas antes temos que definir a versão do Java a ser compilada, criando um arquvio `system.properties` com a informação da versão dentro, que seria `java.runtime.version = 18` (18 é a minha versão, coloque a que estiver usando!).

Meu link de API no __Heroku__: https://nicolas-linguagens-api.herokuapp.com/linguagens


