package com.codegym.models;


public class Email {
    Integer id;
    String language;
    Integer pagesize;
    Boolean Spamsfilter;
    String Signature;

    public Email() {
    }

    public Email(Integer id, String language, Integer pagesize, Boolean spamsfilter, String signature) {
        this.id = id;
        this.language = language;
        this.pagesize = pagesize;
        Spamsfilter = spamsfilter;
        Signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Boolean getSpamsfilter() {
        return Spamsfilter;
    }

    public void setSpamsfilter(Boolean spamsfilter) {
        Spamsfilter = spamsfilter;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
