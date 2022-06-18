package com.example.youtube.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class KomentarDto {

    private int brDislajkova;
    private int brLajkova;
    private String sadrzaj;

    @JsonAlias({"id_video"})
    private int idVideo;
    private int idKomentar;

    public int getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(int idKomentar) {
        this.idKomentar = idKomentar;
    }

    public int getBrDislajkova() {
        return brDislajkova;
    }

    public void setBrDislajkova(int brDislajkova) {
        this.brDislajkova = brDislajkova;
    }

    public int getBrLajkova() {
        return brLajkova;
    }

    public void setBrLajkova(int brLajkova) {
        this.brLajkova = brLajkova;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }


}
