/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Gegic
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package model;

import java.io.Serializable;

public class Korisnik implements Serializable {
    private String username;
    private String password;
    private TipKorisnika tip;
    private Kupac kupac;

    public Korisnik() {
        username = "";
        password = "";
        tip = TipKorisnika.obican;
    }

    public Korisnik(String username, String password, TipKorisnika tip) {
        this.username = username;
        this.password = password;
        this.tip = tip;
    }

    public Korisnik(String username, String password, TipKorisnika tip, Korpa k) {
        this.username = username;
        this.password = password;
        this.tip = tip;
    }


    public boolean provera_informacija(String u, String p) {
        if (u.equals(username) && p.equals(password))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tip=" + tip +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipKorisnika getTip() {
        return tip;
    }

    public void setTip(TipKorisnika tip) {
        this.tip = tip;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
}