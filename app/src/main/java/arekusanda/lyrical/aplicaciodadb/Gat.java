package arekusanda.lyrical.aplicaciodadb;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ALEJANDRO on 25/11/2016.
 */
public class Gat implements Serializable{
    private String nombre, genero, raza, causa_def, caracter;
    private int anyo_nacimiento, avatar, num_chip;
    private Date fecha_def;

    /**
     *
     * @param nombre nombre
     * @param genero genero
     * @param raza raza
     * @param causa_def causa defunción
     * @param caracter caracter
     * @param anyo_nacimiento año nacimiento
     * @param avatar avatar
     * @param fecha_def fecha defuncion
     * @param num_chip numero chip
     */
    public Gat(String nombre, String genero, String raza, int num_chip, String causa_def, String caracter, int anyo_nacimiento, int avatar, Date fecha_def) {
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.causa_def = causa_def;
        this.caracter = caracter;
        this.anyo_nacimiento = anyo_nacimiento;
        this.avatar = avatar;
        this.fecha_def = fecha_def;
        this.num_chip = num_chip;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCausa_def() {
        return causa_def;
    }

    public void setCausa_def(String causa_def) {
        this.causa_def = causa_def;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public int getAnyo_nacimiento() {
        return anyo_nacimiento;
    }

    public void setAnyo_nacimiento(int anyo_nacimiento) {
        this.anyo_nacimiento = anyo_nacimiento;
    }

    public Date getFecha_def() {
        return fecha_def;
    }

    public void setFecha_def(Date fecha_def) {
        this.fecha_def = fecha_def;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getNum_chip() {
        return num_chip;
    }

    public void setNum_chip(int num_chip) {
        this.num_chip = num_chip;
    }

    @Override
    public String toString() {
        return "Gat{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", raza='" + raza + '\'' +
                ", causa_def='" + causa_def + '\'' +
                ", caracter='" + caracter + '\'' +
                ", anyo_nacimiento=" + anyo_nacimiento +
                ", fecha_def=" + fecha_def +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass())
            return isEqual((Gat) obj);
        return super.equals(obj);
    }

    public boolean isEqual(Gat gat) {
        return this.nombre.compareTo(gat.getNombre()) == 0 &&
                this.genero.compareTo(gat.getGenero()) == 0 &&
                this.raza.compareTo(gat.getRaza()) == 0 &&
                this.causa_def.compareTo(gat.getCausa_def()) == 0 &&
                this.caracter.compareTo(gat.getCaracter()) == 0 &&
                this.anyo_nacimiento == gat.anyo_nacimiento &&
                this.fecha_def.compareTo(gat.getFecha_def()) == 0;
    }
}
