package com.example.youtube.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonRootName(value = "komentar")
//@JsonPropertyOrder({"brLajkova", "brDislajkova", "sadrzaj", "idKomentar"})
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_komentar")
	private int idKomentar;

	@Column(name="br_dislajkova")
	private int brDislajkova;

	@Column(name="br_lajkova")
	private int brLajkova;

	private String sadrzaj;

	@JsonIgnore
	//bi-directional many-to-one association to Akaunt
	@ManyToOne
	private Akaunt akaunt;

	@JsonIgnore
	//bi-directional many-to-one association to Video
	@ManyToOne
	private Video video;

	public Komentar() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
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

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Akaunt getAkaunt() {
		return this.akaunt;
	}

	public void setAkaunt(Akaunt akaunt) {
		this.akaunt = akaunt;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}