public enum API {

    IMDB("https://api.mocki.io/v2/549a5d8b/Top250Movies", new ExtratorConteudoIMDB()),
    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD", new ExtratorConteudoNASA()),
    MongoDB("https://nicolas-api-linguagens.herokuapp.com/linguagens", new ExtratorConteudoMongoDB());

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