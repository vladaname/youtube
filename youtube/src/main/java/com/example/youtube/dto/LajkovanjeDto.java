package com.example.youtube.dto;


public class LajkovanjeDto {

    private int idKomentar;
    private int idVideo;
    private int vrednost;

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }



    public int getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(int idKomentar) {
        this.idKomentar = idKomentar;
    }



}
