package com.framos.caloria.model;

import java.io.Serializable;

public class Food implements Serializable {

    private String foodId;
    private String classes;
    private String descricao;
    private String energiaKcal;
    private String energiaKJ;
    private String proteinaG;
    private String colesterolMg;
    private String carboIdratoG;

    public String getFood_id() {
        return foodId;
    }

    public void setFood_id(String foodId) {
        this.foodId = foodId;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEnergiaKcal() {
        return energiaKcal;
    }

    public void setEnergiaKcal(String energiaKcal) {
        this.energiaKcal = energiaKcal;
    }

    public String getEnergiaKJ() {
        return energiaKJ;
    }

    public void setEnergiaKJ(String energiaKJ) {
        this.energiaKJ = energiaKJ;
    }

    public String getProteinaG() {
        return proteinaG;
    }

    public void setProteinaG(String proteinaG) {
        this.proteinaG = proteinaG;
    }

    public String getColesterolMg() {
        return colesterolMg;
    }

    public void setColesterolMg(String colesterolMg) {
        this.colesterolMg = colesterolMg;
    }

    public String getCarboIdratoG() {
        return carboIdratoG;
    }

    public void setCarboIdratoG(String carboIdratoG) {
        this.carboIdratoG = carboIdratoG;
    }

}
