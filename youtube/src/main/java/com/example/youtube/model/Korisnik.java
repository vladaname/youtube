package com.example.youtube.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_korisnik")
	private int idKorisnik;

	private String pass;

	private String username;

	private String token;

	//bi-directional many-to-one association to Akaunt
	@OneToMany(mappedBy="korisnik")
	private List<Akaunt> akaunts;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Akaunt> getAkaunts() {
		return this.akaunts;
	}

	public void setAkaunts(List<Akaunt> akaunts) {
		this.akaunts = akaunts;
	}

	public Akaunt addAkaunt(Akaunt akaunt) {
		getAkaunts().add(akaunt);
		akaunt.setKorisnik(this);

		return akaunt;
	}

	public Akaunt removeAkaunt(Akaunt akaunt) {
		getAkaunts().remove(akaunt);
		akaunt.setKorisnik(null);

		return akaunt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}