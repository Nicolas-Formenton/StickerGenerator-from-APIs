package br.com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "linguagensProgramacao")

public class Linguagem {
    
    @Id
    private String id;
    private String title;
    private String image;
    private String ranking;

    public Linguagem(String title, String image, String ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getRanking() {
        return ranking;
    }

    
}
