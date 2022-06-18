package com.example.youtube.impl;

import com.example.youtube.dto.ObrisiVideoDto;
import com.example.youtube.dto.PretragaVideaPoNaslovuDto;
import com.example.youtube.dto.VideoDto;
import com.example.youtube.dto.VideoIdDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Komentar;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;
import com.example.youtube.repository.AkauntRepository;
import com.example.youtube.repository.KomentarRepository;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    AkauntRepository akauntRepository;

    @Autowired
    KomentarRepository komentarRepository;

    @Override
    public boolean createVideo(VideoDto videoDto, Korisnik k) {
        try {
            Akaunt a = akauntRepository.findByKorisnik(k);
            if(a == null){
                return false;
            }
            Video v = new Video();
            v.setAkaunt(a);
            v.setNaslov(videoDto.getNaslov());
            v.setOpis(videoDto.getOpis());
            v.setLink(videoDto.getLink());
            v.setUzrast(Integer.parseInt(videoDto.getUzrast()));
            v.setBrLajkova(0);
            v.setBrDislajkova(0);
            v.setLogickoBrisanje(0);

            videoRepository.save(v);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Video> listaVideo(Korisnik k) {
        Akaunt a = akauntRepository.findByKorisnik(k);
        if(a != null) {
            List<Video> findAllByAk = videoRepository.findAllByAkaunt(a);
            return findAllByAk;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Video> searchByName(PretragaVideaPoNaslovuDto pretragaVideaPoNaslovuDto) {
            List<Video> findAllByName = videoRepository.findAllByNaslov(pretragaVideaPoNaslovuDto.getNaslov());
            return findAllByName;
    }

    @Override
    public boolean obrisiVideo(ObrisiVideoDto obrisiVideoDto) {

        Optional<Video> getVideo = videoRepository.findById(obrisiVideoDto.getIdVideo());
        if(getVideo.isPresent()){
            Video v = getVideo.get();
            v.setLogickoBrisanje(1);
            videoRepository.saveAndFlush(v);
            return true;
        }
        return false;
    }

    @Override
    public List<Video> getAllVideo() {
        List<Video> listaSvihVidea = videoRepository.findAllBylogickoBrisanje(0);
        return listaSvihVidea;
    }

    @Override
    public List<Video> listaNePrilagodjenSadrzaj(Korisnik k) {
        Akaunt a = akauntRepository.findByKorisnik(k);
//        List<Video> listaSvihVidea = videoRepository.findAll();
//        int godeneZaFilter = a.getGodine();
//        //flou patern
//        List<Video> returnList = listaSvihVidea.stream().filter(v -> v.getUzrast() <= godeneZaFilter)
//                .collect(Collectors.toList());
//        List<Video> returnList2 = new ArrayList<>();
//        for (Video v: listaSvihVidea) {
//            if(v.getUzrast() <= godeneZaFilter){
//                returnList2.add(v);
//            }
//        }
//        return returnList;
       return videoRepository.findAllByUzrastLessThanEqual(a.getGodine());

    }

    @Override
    public Video pregledajVideoById(int idVideo) {
        Optional<Video> getVideoById = videoRepository.findById(idVideo);
        if(getVideoById.isPresent()){
            Video v = getVideoById.get();
//            if(v != null) {
//                List<Komentar> getAllKomentarByIdVide = komentarRepository.findAllByVideo(v.getIdVideo());
//            }
            return v;
        }
        else{
            return null;
        }

    }

    @Override
    public boolean lajkuVideo(VideoIdDto videoIdDto) {
        Optional<Video> getIdVideo = videoRepository.findById(videoIdDto.getIdVideo());
        if(getIdVideo.isPresent()){
            Video v = getIdVideo.get();
            int brojLajkova = v.getBrLajkova();
            int brojDislajkova = v.getBrDislajkova();
            int vrednost = videoIdDto.getVrednost();
            if(vrednost > 0) {
                brojLajkova = brojLajkova + vrednost;
            }
            else{
                brojDislajkova = brojDislajkova - vrednost;
            }
            v.setBrLajkova(brojLajkova);
            v.setBrDislajkova(brojDislajkova);
            videoRepository.saveAndFlush(v);
            return true;
        }
        return false;
    }

    @Override
    public List<Video> getAllVideo1() {
        return videoRepository.findAll();
    }

    @Override
    public String pregledajVideoById1(int idVideo) {
        Optional<Video> findById = videoRepository.findById(idVideo);
        if(findById.isPresent()){
            Video v = findById.get();
            return v.getLink();
        }
        return null;
    }


}
