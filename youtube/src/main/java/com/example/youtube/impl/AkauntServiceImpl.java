package com.example.youtube.impl;

import com.example.youtube.dto.AkauntDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Korisnik;
import com.example.youtube.repository.AkauntRepository;
import com.example.youtube.repository.KorisnikRepository;
import com.example.youtube.service.AkauntService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AkauntServiceImpl implements AkauntService {

    @Autowired
    AkauntRepository akauntRepository;

    @Autowired
    KorisnikRepository korisnikRepository;

    @Override
    public boolean registracija(AkauntDto akauntDto) {

        try {

            Korisnik k = new Korisnik();
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            k.setUsername(akauntDto.getUsername());
            k.setPass(passwordEncryptor.encryptPassword(akauntDto.getPass()));
            korisnikRepository.saveAndFlush(k);

            Optional<Korisnik> getIdKorisnik = korisnikRepository.findById(k.getIdKorisnik());
            if(getIdKorisnik.isPresent()) {
                Korisnik kk = getIdKorisnik.get();
                Akaunt a = new Akaunt();
                a.setKorisnik(kk);
                a.setIme(akauntDto.getIme());
                a.setPrezime(akauntDto.getPrezime());
                a.setNick(akauntDto.getNick());
                a.setAdresa(akauntDto.getAdresa());
                a.setGodine(Integer.parseInt(akauntDto.getGodine()));
                akauntRepository.saveAndFlush(a);
            }
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
}
