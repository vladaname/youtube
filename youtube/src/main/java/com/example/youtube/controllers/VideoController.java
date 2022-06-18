package com.example.youtube.controllers;

import com.example.youtube.dto.*;
import com.example.youtube.model.Komentar;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;
import com.example.youtube.service.KomentarService;
import com.example.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    KomentarService komentarService;

    @GetMapping("/createVideo")
    public ModelAndView createVideoGET(){
        return new ModelAndView("createVideo", "videoDto", new VideoDto());
    }
    @PostMapping("/createVideo")
    public String createVideoPOST(Model model, @ModelAttribute("videoDto")VideoDto videoDto, HttpServletRequest request){
        Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
        boolean b = videoService.createVideo(videoDto, k);
        if(b){
            return "redirect:/listaVideo";
        }
        else{
            model.addAttribute("poruka", "Greska! Pokusajte ponovo.");
            return "createVideo";
        }
    }

    @GetMapping("/listaSvihVidea")
    public String listaSvihVidea(Model model){
        List<Video> listaSvihVidea = videoService.getAllVideo();

            if(listaSvihVidea != null){
                model.addAttribute("listaSvihVidea", listaSvihVidea);
                model.addAttribute("videoIdDto", new VideoIdDto());


            }
            else{
                model.addAttribute("poruka", "Lista je prazna");
            }
        return "listaSvihVidea";



    }

    @GetMapping("/listaVideo")
    public String listaVideoGET(Model model, HttpServletRequest request){

        Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
        System.out.println(k);

        List<Video> listaVideo = videoService.listaVideo(k);
        System.out.println(listaVideo);
        if(listaVideo != null){
            model.addAttribute("listaVideo", listaVideo);
            return "listaVideo";
        }
        else{
            return "redirect:/createVideo";
        }
    }
    @GetMapping("/searchByNaslov")
    public ModelAndView searchByNaslov(){
        return new ModelAndView("pretraga", "pretragaVideaPoNaslovu", new PretragaVideaPoNaslovuDto());
    }
    @PostMapping("/searchByName")
    public String searchByName(Model model, @ModelAttribute("pretragaVideaPoNaslovu")PretragaVideaPoNaslovuDto pretragaVideaPoNaslovuDto,
                               HttpServletRequest request) {
        List<Video> srcByName = videoService.searchByName(pretragaVideaPoNaslovuDto);
        if (srcByName != null) {
            model.addAttribute("listaByNaziv", srcByName);
            model.addAttribute("obrisiVideoDto", new ObrisiVideoDto());
            return "listaVideo";
        }
        else{
            model.addAttribute("poruka", "Nema podataka.");
            return "listaVideo";
        }
    }

    @PostMapping("/obrisiVideo")
    public String obrisiVideo(Model model, @ModelAttribute("obrisiVideoDto")ObrisiVideoDto obrisiVideoDto, HttpServletRequest request){

        boolean obrisi = videoService.obrisiVideo(obrisiVideoDto);
        if(obrisi){
            return "listaVideo";
        }
        else{
            model.addAttribute("poruka", "Greska. Video nije obrisan.");
            return "listaVideo";
        }
    }
    @GetMapping("/nePrilagodjenSadrzaj")
    public String nePrilagodjenSadrzaj(Model model, HttpServletRequest request){
        Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
        List<Video> listaNePrilagodjenSadrzaj = videoService.listaNePrilagodjenSadrzaj(k);
        if(listaNePrilagodjenSadrzaj != null){
            model.addAttribute("listaSvihVideo", listaNePrilagodjenSadrzaj);
            return "listaSvihVidea";
        }
        else{
            return null;
        }
    }
//
//    @GetMapping("/pregledajVideo")
//    public String pregledajVideoGET(Model model, @ModelAttribute("komentarDto")KomentarDto komentarDto){
//
//        List<Komentar> listaKomentara = komentarService.findAllKomentar(komentarDto.getIdVideo());
//        System.out.println(listaKomentara);
//        if(listaKomentara != null){
//            model.addAttribute("listaKomentara", listaKomentara);
//            return "video";
//        }
//        else{
//            model.addAttribute("poruka", "Greska");
//            return "video";
//        }
//    }

    @PostMapping("/pregledajVideo")
    public String pregledajVideo(Model model, @ModelAttribute("pregledajVideoDto")PregledajVideoDto pregledajVideoDto){
        Video v = videoService.pregledajVideoById(pregledajVideoDto.getIdVideo());
        if(v != null){
            List<Komentar> listaKomentara = komentarService.findAllKomentar(v.getIdVideo());
            model.addAttribute("listaKomentara", listaKomentara);
            model.addAttribute("video", v);
            model.addAttribute("lajkovanjeDto", new LajkovanjeDto());

            return "video";
        }
        else{
            model.addAttribute("poruka", "Greska.");
            return "listaVideo";
        }
    }

    @PostMapping("/lajkujVideo")
    public String lajkovanje(Model model, @ModelAttribute("videoIdDto")VideoIdDto videoIdDto){
        Video v = videoService.pregledajVideoById(videoIdDto.getIdVideo());
        if (v != null){
            boolean lajkujVideo = videoService.lajkuVideo(videoIdDto);
            model.addAttribute("brojLajkova", lajkujVideo);
            return "redirect:/listaSvihVidea";
        }
        else {
            model.addAttribute("poruka", "Greska!");
            return "redirect:/listaSvihVidea";
        }


    }
}
