package com.example.youtube.impl;

import com.example.youtube.dto.KomentarDto;
import com.example.youtube.dto.LajkovanjeDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Komentar;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;
import com.example.youtube.repository.AkauntRepository;
import com.example.youtube.repository.KomentarRepository;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.service.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KomentarServiceImpl implements KomentarService {

    @Autowired
    KomentarRepository komentarRepository;

    @Autowired
    AkauntRepository akauntRepository;

    @Autowired
    VideoRepository videoRepository;

    @Override
    public Komentar createKomentar(KomentarDto komentarDto, Korisnik ko) {
        Akaunt a = akauntRepository.findByKorisnik(ko);
        Optional<Video> findVideo = videoRepository.findById(komentarDto.getIdVideo());
        if (findVideo.isPresent()) {
            Video v = findVideo.get();
            Komentar kom = new Komentar();
            kom.setSadrzaj(komentarDto.getSadrzaj());
            kom.setAkaunt(a);
            kom.setVideo(v);
            komentarRepository.saveAndFlush(kom);
            return kom;
        }
        else{
            return null;
        }

    }

    @Override
    public List<Komentar> findAllKomentar(int idVideo) {
        Optional<Video> getIdVideo = videoRepository.findById(idVideo);
        if (getIdVideo.isPresent()) {
            Video v = getIdVideo.get();
            return komentarRepository.findAllByVideo(v);
        }
        return null;
    }

    @Override
    public boolean lajkuj(LajkovanjeDto lajkovanjeDto, Korisnik ko) {
        Akaunt a = akauntRepository.findByKorisnik(ko);

        Optional<Komentar> getIdKomentar = komentarRepository.findById(lajkovanjeDto.getIdKomentar());
        if(getIdKomentar.isPresent()){
            Komentar k = getIdKomentar.get();
  //          Optional<Komentar> kom = komentarRepository.findById(a.getIdAkaunt());
            if(k.getAkaunt().getIdAkaunt() != a.getIdAkaunt()) {
                int brojLajkova = k.getBrLajkova();
                int brojDislajkova = k.getBrDislajkova();
                int vrednost = lajkovanjeDto.getVrednost();
                if (vrednost > 0) {
                    brojLajkova = brojLajkova + vrednost;
                } else {
                    brojDislajkova = brojDislajkova - vrednost;
                }
                k.setBrLajkova(brojLajkova);
                k.setBrDislajkova(brojDislajkova);
                komentarRepository.saveAndFlush(k);
                return true;
            }
        }
        return false;
    }

    @Override
    public String findKomentarById(int idKomentar) {
        Optional<Komentar> finByIdKomentar = komentarRepository.findById(idKomentar);
        if(finByIdKomentar.isPresent()){
            Komentar k = finByIdKomentar.get();
            return k.getSadrzaj();
        }
        return null;
    }

    @Override
    public String findKomentarById1(int idKomentar) {
        Optional<Komentar> finByIdKomentar = komentarRepository.findById(idKomentar);
        if(finByIdKomentar.isPresent()){
            Komentar k = finByIdKomentar.get();
            return k.getSadrzaj();
        }
        return null;
    }

}
