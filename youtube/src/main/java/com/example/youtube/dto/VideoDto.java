package com.example.youtube.dto;

public class VideoDto {

    private String link;
    private String naslov;
    private String opis;
    private String uzrast;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getUzrast() {
        return uzrast;
    }

    public void setUzrast(String uzrast) {
        this.uzrast = uzrast;
    }
}
