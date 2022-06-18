package com.example.youtube.impl;

import com.example.youtube.dto.KorisnikDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Korisnik;
import com.example.youtube.repository.AkauntRepository;
import com.example.youtube.repository.KorisnikRepository;
import com.example.youtube.service.KorisnikService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    KorisnikRepository korisnikRepository;
    @Autowired
    AkauntRepository akauntRepository;

    @Override
    public Korisnik login(KorisnikDto korisnikDto) {

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        Korisnik k = korisnikRepository.findByUsername(korisnikDto.getUsername());
        String encryptPass = k.getPass();
        if(korisnikDto.getPass().equals(k.getPass()) || passwordEncryptor.checkPassword(korisnikDto.getPass(), encryptPass)){
            return k;
        }
        else{
            return null;
        }
    }


    @Override
    public Korisnik findById(int idKorisnik) {
        //       return korisnikRepository.findById(idKorisnik).get();

        Optional<Korisnik> findById = korisnikRepository.findById(idKorisnik);
        if(findById.isPresent()){
            Korisnik k = findById.get();
            return k;
        }
        return null;
    }

    @Override
    public Korisnik loginRest(KorisnikDto korisnikDto) {

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        Korisnik k = korisnikRepository.findByUsername(korisnikDto.getUsername());
        String encryptPass = k.getPass();
        if(korisnikDto.getPass().equals(k.getPass()) || passwordEncryptor.checkPassword(korisnikDto.getPass(), encryptPass)){
            String token = UUID.randomUUID().toString();
            k.setToken(token);
            korisnikRepository.saveAndFlush(k);
            return k;
        }
        else{
            return null;
        }

    }

    @Override
    public Korisnik findByToken(String token) {
        return korisnikRepository.findByToken(token);
    }


}


