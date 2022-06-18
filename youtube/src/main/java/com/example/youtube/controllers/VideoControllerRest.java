package com.example.youtube.controllers;

import com.example.youtube.dto.KorisnikDto;
import com.example.youtube.dto.LajkovanjeDto;
import com.example.youtube.dto.VideoDto;
import com.example.youtube.dto.VideoIdDto;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.service.KorisnikService;
import com.example.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoControllerRest {
    @Autowired
    VideoService videoService;
    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/findAllVideo")
    public List<Video> findAllVideo(){
        return videoService.getAllVideo1();
    }

    @PostMapping("/createVideoRest")
    public String createVideoRest(@RequestBody VideoDto videoDto, @RequestHeader("Id-Korisnik") int idKorisnik){
        Korisnik ko = korisnikService.findById(idKorisnik);
        boolean v = videoService.createVideo(videoDto, ko);
        if(v){
            return "Video je kreiran"  + ko.getIdKorisnik();
        }
        else{
            return "Video nije kreiran za korisnika";
        }
    }

    @GetMapping("/findVideoById/{idVideo}")
    public String findVideoById(@PathVariable("idVideo") int idVideo){
 //       Korisnik ko = korisnikService.findById(idVideo);
        return videoService.pregledajVideoById1(idVideo);
    }

    @PostMapping("/lajkujVideo1")
    public String lajkuj(@RequestBody VideoIdDto videoIdDto){
        Video v = videoService.pregledajVideoById(videoIdDto.getIdVideo());
        if(v != null) {
            boolean lajkujVideo = videoService.lajkuVideo(videoIdDto);
            return lajkujVideo + " +1";
        }
        else{
            return "Greska";
        }
    }



}
