package com.example.meobeou.model;

import java.io.Serializable;

/**
 * Created by qwer on 12/3/2016.
 */
public class Data implements Serializable{
    private  String desc;
    private  String title;
    private  String image;
    private  String kinhdo;
    private  String vido;
    private  String key;

    public String getKinhdo() {
        return kinhdo;
    }

    public void setKinhdo(String kinhdo) {
        this.kinhdo = kinhdo;
    }

    public String getVido() {
        return vido;
    }

    public void setVido(String vido) {
        this.vido = vido;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Data{" +
                "desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", vido='" + vido + '\'' +
                ", kinhdo='" + kinhdo + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
