# Bootcamp Alura - Java
![Bootcamp Alura - Java - Bootcamp Alura - Java (2)](https://user-images.githubusercontent.com/81488809/180497143-72ae1471-6760-4c98-958a-e413cfeb3f7b.png)


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
