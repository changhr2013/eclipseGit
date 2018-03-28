package com.dcode.entity;

public class Region {
    private Integer reginonid;

    private String reginonname;

    public Integer getReginonid() {
        return reginonid;
    }

    public void setReginonid(Integer reginonid) {
        this.reginonid = reginonid;
    }

    public String getReginonname() {
        return reginonname;
    }

    public void setReginonname(String reginonname) {
        this.reginonname = reginonname == null ? null : reginonname.trim();
    }
}