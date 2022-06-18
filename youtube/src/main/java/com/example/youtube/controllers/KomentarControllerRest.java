package com.example.youtube.controllers;

import com.example.youtube.dto.KomentarDto;
import com.example.youtube.model.Komentar;
import com.example.youtube.model.Korisnik;
import com.example.youtube.model.Video;
import com.example.youtube.service.KomentarService;
import com.example.youtube.service.KorisnikService;
import com.example.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@RestController
public class KomentarControllerRest {
    @Autowired
    KomentarService komentarService;
    @Autowired
    VideoService videoService;
    @Autowired
    KorisnikService korisnikService;


    @PostMapping("/createComentarRest")
    public String createComentar(@RequestBody KomentarDto komentarDto, @RequestHeader("Id-Korisnik") int idKorisnik, HttpServletRequest request){
 //       Korisnik ko = (Korisnik) request.getSession().getAttribute("korisnik");
        Korisnik ko = korisnikService.findById(idKorisnik);
        Komentar k = komentarService.createKomentar(komentarDto,ko);
 //       Video v = videoService.pregledajVideoById(komentarDto.getIdVideo());
//        List<Komentar> listaKomentara = komentarService.findAllKomentar(komentarDto.getIdVideo());
        if(k != null){
          return "Commentar is created" + k.getIdKomentar() + " for video with id: " + k.getVideo().getIdVideo()
                  + "for user: " + ko.getIdKorisnik();
        }
        else{
            return "Error creating commentar";
        }
    }
    @PostMapping("/listaKomentaraRest")
    public List<Komentar> listaKomentara(@RequestBody KomentarDto komentarDto){
        List<Komentar> listaKomentara = komentarService.findAllKomentar(komentarDto.getIdVideo());
        for (Komentar k: listaKomentara) {
            System.out.println(k.getSadrzaj());
        }
            if(listaKomentara != null){
       //          return "Lista komentara za video: " + komentarDto.getIdVideo() + " " + "je: " + listaKomentara;
                return listaKomentara;
        }
        else{
            return null;
        }
    }

    @PostMapping("/listaKomentara")
    public List<Komentar> findAllKomentarByIdVideo(@RequestBody KomentarDto komentarDto){
        Video v = videoService.pregledajVideoById(komentarDto.getIdVideo());
        List<Komentar> listaKomentara = komentarService.findAllKomentar(v.getIdVideo());
        if(listaKomentara != null){
            return listaKomentara;
        }
        else{
            return null;
        }
    }

    @PostMapping("/listaKomentaraRE")
    public ResponseEntity<List<Komentar>> findAllKomentarByIdVideoRE(@RequestBody KomentarDto komentarDto){
        Video v = videoService.pregledajVideoById(komentarDto.getIdVideo());
        List<Komentar> listaKomentara = komentarService.findAllKomentar(v.getIdVideo());
        if(listaKomentara != null){
  //          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  //          return new ResponseEntity<>(listaKomentara, HttpStatus.OK);
  //          return ResponseEntity.ok(listaKomentara);
  //          return ResponseEntity.status(HttpStatus.OK).body(listaKomentara);
            return ResponseEntity.ok().header("moj heder", "moja vrednost").body(listaKomentara);

        }
        else{
   //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(null);
        }
    }
//
//    @GetMapping("/findKomentarByIdRest/{idKomentar}")
//    public String findKomentarById(@RequestBody KomentarDto komentarDto){
//       return komentarService.findKomentarById(komentarDto.getIdKomentar());
//    }

    @GetMapping("/findKomentarByIdRest/{idKomentar}")
    public String findKomentarById(@PathVariable("idKomentar") int idKomentar){
        return komentarService.findKomentarById1(idKomentar);
    }

}
