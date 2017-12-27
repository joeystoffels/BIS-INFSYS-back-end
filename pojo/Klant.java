package com.my.db;

public class Klant {
  private String emailadres;
  private String merk_eigen_console;
  private String type_eigen_console;
  private String voornamen;
  private String achternaam;
  private String straatnaam;
  private String huisnummer;
  private String postcode;
  private String woonplaats;
  private java.sql.Timestamp geboortedatum;
  private String geslacht;
  private String wachtwoord;

  public String getEmailadres() {
    return emailadres;
  }

  public void setEmailadres(String emailadres) {
    this.emailadres = emailadres;
  }

  public String getMerk_eigen_console() {
    return merk_eigen_console;
  }

  public void setMerk_eigen_console(String merk_eigen_console) {
    this.merk_eigen_console = merk_eigen_console;
  }

  public String getType_eigen_console() {
    return type_eigen_console;
  }

  public void setType_eigen_console(String type_eigen_console) {
    this.type_eigen_console = type_eigen_console;
  }

  public String getVoornamen() {
    return voornamen;
  }

  public void setVoornamen(String voornamen) {
    this.voornamen = voornamen;
  }

  public String getAchternaam() {
    return achternaam;
  }

  public void setAchternaam(String achternaam) {
    this.achternaam = achternaam;
  }

  public String getStraatnaam() {
    return straatnaam;
  }

  public void setStraatnaam(String straatnaam) {
    this.straatnaam = straatnaam;
  }

  public String getHuisnummer() {
    return huisnummer;
  }

  public void setHuisnummer(String huisnummer) {
    this.huisnummer = huisnummer;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getWoonplaats() {
    return woonplaats;
  }

  public void setWoonplaats(String woonplaats) {
    this.woonplaats = woonplaats;
  }

  public java.sql.Timestamp getGeboortedatum() {
    return geboortedatum;
  }

  public void setGeboortedatum(java.sql.Timestamp geboortedatum) {
    this.geboortedatum = geboortedatum;
  }

  public String getGeslacht() {
    return geslacht;
  }

  public void setGeslacht(String geslacht) {
    this.geslacht = geslacht;
  }

  public String getWachtwoord() {
    return wachtwoord;
  }

  public void setWachtwoord(String wachtwoord) {
    this.wachtwoord = wachtwoord;
  }
}
