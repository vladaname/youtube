package com.example.youtube.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_video")
	private int idVideo;

	@Column(name="br_dislajkova")
	private int brDislajkova;

	@Column(name="br_lajkova")
	private int brLajkova;

	private String link;

	@Column(name="logicko_brisanje")
	private int logickoBrisanje;

	private String naslov;

	private String opis;

	private int uzrast;

	@JsonIgnore
	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="video")
	private List<Komentar> komentars;

	@JsonIgnore
	//bi-directional many-to-one association to Akaunt
	@ManyToOne
	private Akaunt akaunt;

	public Video() {
	}

	public int getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}

	public int getBrDislajkova() {
		return this.brDislajkova;
	}

	public void setBrDislajkova(int brDislajkova) {
		this.brDislajkova = brDislajkova;
	}

	public int getBrLajkova() {
		return this.brLajkova;
	}

	public void setBrLajkova(int brLajkova) {
		this.brLajkova = brLajkova;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getLogickoBrisanje() {
		return this.logickoBrisanje;
	}

	public void setLogickoBrisanje(int logickoBrisanje) {
		this.logickoBrisanje = logickoBrisanje;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getUzrast() {
		return this.uzrast;
	}

	public void setUzrast(int uzrast) {
		this.uzrast = uzrast;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setVideo(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setVideo(null);

		return komentar;
	}

	public Akaunt getAkaunt() {
		return this.akaunt;
	}

	public void setAkaunt(Akaunt akaunt) {
		this.akaunt = akaunt;
	}

}