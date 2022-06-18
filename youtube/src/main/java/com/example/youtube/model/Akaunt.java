package com.example.youtube.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the akaunt database table.
 * 
 */
@Entity
@NamedQuery(name="Akaunt.findAll", query="SELECT a FROM Akaunt a")
public class Akaunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_akaunt")
	private int idAkaunt;

	private String adresa;

	private int godine;

	private String ime;

	private String nick;

	private String prezime;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="akaunt")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy="akaunt")
	private List<Video> videos;

	public Akaunt() {
	}

	public int getIdAkaunt() {
		return this.idAkaunt;
	}

	public void setIdAkaunt(int idAkaunt) {
		this.idAkaunt = idAkaunt;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getGodine() {
		return this.godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setAkaunt(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setAkaunt(null);

		return komentar;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setAkaunt(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setAkaunt(null);

		return video;
	}

}