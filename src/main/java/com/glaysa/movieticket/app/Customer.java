package com.glaysa.movieticket.app;

public class Customer {
    private String fname;
    private String lname;
    private String email;
    private String film;
    private String tlf;
    private String qty;

    public Customer(String fname, String lname, String email, String film, String tlf, String qty){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.film = film;
        this.tlf = tlf;
        this.qty = qty;
    }

    public Customer(){}

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }

    public String getTlf() {
        return tlf;
    }
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getQty() {
        return qty;
    }
    public void setQty(String qty) {
        this.qty = qty;
    }
}
