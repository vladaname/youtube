package com.example.youtube.service;

import com.example.youtube.dto.ObrisiVideoDto;
import com.example.youtube.dto.PretragaVideaPoNaslovuDto;
import com.example.youtube.dto.VideoDto;
import com.example.youtube.dto.VideoIdDto;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;

import java.util.List;

public interface VideoService {

    boolean createVideo(VideoDto videoDto, Korisnik k);

    List<Video> listaVideo(Korisnik k);

    List<Video> searchByName(PretragaVideaPoNaslovuDto pretragaVideaPoNaslovuDto);

    boolean obrisiVideo(ObrisiVideoDto obrisiVideoDto);

    List<Video> getAllVideo();

    List<Video> listaNePrilagodjenSadrzaj(Korisnik k);

    Video pregledajVideoById(int idVideo);

    boolean lajkuVideo(VideoIdDto videoIdDto);

    List<Video> getAllVideo1();

    String pregledajVideoById1(int idVideo);

}
