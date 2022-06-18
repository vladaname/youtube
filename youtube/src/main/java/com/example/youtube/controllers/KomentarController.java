package com.example.youtube.controllers;

import com.example.youtube.dto.KomentarDto;
import com.example.youtube.dto.LajkovanjeDto;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KomentarController {

    @Autowired
    KomentarService komentarService;

    @Autowired
    VideoService videoService;

    @PostMapping("/createKomentar")
    public String createKomentar(Model model, @ModelAttribute("komentarDto")KomentarDto komentarDto, HttpServletRequest request){
        Korisnik ko = (Korisnik) request.getSession().getAttribute("korisnik");
        Komentar k = komentarService.createKomentar(komentarDto, ko);
        Video v = videoService.pregledajVideoById(komentarDto.getIdVideo());
        List<Komentar> listaKomentara = komentarService.findAllKomentar(komentarDto.getIdVideo());
        if(v != null){
            model.addAttribute("listaKomentara", listaKomentara);
            model.addAttribute("komentar", k);
            model.addAttribute("video", v);
            model.addAttribute("lajkovanjeDto", new LajkovanjeDto());

            return "video";
        }
        else{
            model.addAttribute("poruka", "Greska pri kreiranju komentara");
            return "video";
        }
    }

    @GetMapping("/pregledajVideo1")
    public String listaKomentara(Model model, @ModelAttribute("komentarDto")KomentarDto komentarDto){
        List<Komentar> listaKomentara = komentarService.findAllKomentar(komentarDto.getIdVideo());
        if(listaKomentara != null){
//            model.addAttribute("listaKomentara", listaKomentara);
       //     return "radirect:/listaKomentara";
            return "video";
        }
        else{
            model.addAttribute("poruka", "Greska");
            return "video";
        }
    }


    @PostMapping("/lajkuj")
    public String lajkuj(Model model, @ModelAttribute("lajkovanjeDto") LajkovanjeDto lajkovanjeDto, HttpServletRequest request) {
        Korisnik ko = (Korisnik) request.getSession().getAttribute("korisnik");
        Video v = videoService.pregledajVideoById(lajkovanjeDto.getIdVideo());
        boolean lajkujKomentar = komentarService.lajkuj(lajkovanjeDto, ko);
        if(lajkujKomentar && v!=null) {
            List<Komentar> listaKomentara = komentarService.findAllKomentar(lajkovanjeDto.getIdVideo());
                model.addAttribute("listaKomentara", listaKomentara);
                model.addAttribute("video", v);
                model.addAttribute("lajkovanjeDto", new LajkovanjeDto());
                return "video";
        }
        else{
            List<Komentar> listaKomentara = komentarService.findAllKomentar(lajkovanjeDto.getIdVideo());
            model.addAttribute("listaKomentara", listaKomentara);
            model.addAttribute("video", v);
            model.addAttribute("lajkovanjeDto", new LajkovanjeDto());

            model.addAttribute("poruka", "Greska");
            return "video";
        }

    }
//
//    @PostMapping("/dislajkoj")
//    public String lajkuj(Model model, @ModelAttribute("lajkovanjeDto") LajkovanjeDto lajkovanjeDto, HttpServletRequest request) {
//        Korisnik ko = (Korisnik) request.getSession().getAttribute("korisnik");
//        Video v = videoService.pregledajVideoById(lajkovanjeDto.getIdVideo());
//        boolean lajkujKomentar = komentarService.lajkuj(lajkovanjeDto);
//        if(lajkujKomentar && v!=null) {
//            List<Komentar> listaKomentara = komentarService.findAllKomentar(lajkovanjeDto.getIdVideo());
//            model.addAttribute("listaKomentara", listaKomentara);
//            model.addAttribute("video", v);
//            model.addAttribute("lajkovanjeDto", new LajkovanjeDto());
//            return "video";
//        }
//        else{
//
//            model.addAttribute("poruka", "Greska");
//            return "video";
//        }
//
//    }
}
