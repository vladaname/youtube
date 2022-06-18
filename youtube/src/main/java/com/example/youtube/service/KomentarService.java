package com.example.youtube.service;

import com.example.youtube.dto.KomentarDto;
import com.example.youtube.dto.LajkovanjeDto;
import com.example.youtube.model.Komentar;
import com.example.youtube.model.Korisnik;

import java.util.List;

public interface KomentarService {

    Komentar createKomentar(KomentarDto komentarDto, Korisnik ko);

    List<Komentar> findAllKomentar(int idVideo);

    boolean lajkuj(LajkovanjeDto lajkovanjeDto, Korisnik ko);


    String findKomentarById(int idKomentar);

    String findKomentarById1(int idKomentar);
}
