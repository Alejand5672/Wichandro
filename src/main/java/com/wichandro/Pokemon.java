// Luis Alejandro Hernández Márquez (241424)

package com.wichandro;

public class Pokemon {
    private String nombre;
    private String tipo1;
    private String tipo2;
    private String habilidad;

    public Pokemon(String nombre, String tipo1, String tipo2) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public String getHabilidad() {
        return habilidad;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo1='" + tipo1 + '\'' +
                ", tipo2='" + tipo2 + '\'' +
                ", habilidad='" + habilidad + '\'' +
                '}';
    }
}