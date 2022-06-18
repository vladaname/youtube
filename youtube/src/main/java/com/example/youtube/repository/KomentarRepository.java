package com.example.youtube.repository;

import com.example.youtube.model.Komentar;
import com.example.youtube.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface KomentarRepository extends JpaRepository<Komentar, Integer> {

    List<Komentar> findAllByVideo(Video v);

}
