package com.example.youtube.repository;

import com.example.youtube.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {


    Korisnik findByUsername(String username);

    Korisnik findByToken(String token);

    Korisnik findByUsernameAndPass(String username, String password);

    Optional<Korisnik> findById(int idKorisnik);
}
