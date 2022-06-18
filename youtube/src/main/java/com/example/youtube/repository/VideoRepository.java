package com.example.youtube.repository;

import com.example.youtube.dto.PretragaVideaPoNaslovuDto;
import com.example.youtube.model.Akaunt;
import com.example.youtube.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface VideoRepository extends JpaRepository<Video, Integer> {


    List<Video> findAllByAkaunt(Akaunt a);


    List<Video> findAllBylogickoBrisanje(int i);

//    Video findAllByUzrast();

    List<Video> findAllByNaslov(String naslov);

    List<Video> findAllByUzrastLessThanEqual(int godine);

 //   String findById1(int idVideo);

       List<Video> findAll();

}
