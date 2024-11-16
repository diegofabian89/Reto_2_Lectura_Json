package com.entities;

import org.json.JSONObject;

public class Heroe {
    private String heroName;
    private String nombre;
    private String link;
    private String img;
    private int size;
    public Heroe() {}
    public Heroe(String heroName, String nombre, String link, String img, int size) {
        this.heroName = heroName;
        this.nombre = nombre;
        this.link = link;
        this.img = img;
        this.size = size;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // Método que devuelve un objeto JSONObject con los datos de un héroe.
    public JSONObject getJsonObject() {
        JSONObject obj = new JSONObject();
        obj.put("heroName", heroName);
        obj.put("nombre", nombre);
        obj.put("link", link);
        obj.put("img", img);
        obj.put("size", size);
        return obj;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "heroName='" + heroName + '\'' +
                ", nombre='" + nombre + '\'' +
                ", link='" + link + '\'' +
                ", img='" + img + '\'' +
                ", size=" + size +
                '}';
    }
}
