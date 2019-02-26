/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.util.Random;

/**
 *
 * @author andrei
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Vehiculo() {

    }

    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return matricula + " " + marca + " " + modelo + " " + color + " " + tarifa + " " + disponible;
    }

    public static Vehiculo vehiculoAleatorio() {
        String Matricula = "";

        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {

            if (i < 4) {

                Matricula += rnd.nextInt(10);
            } else {

                Matricula += (char) (rnd.nextInt(90 - 65 + 1) + 65);
            }
        }
        String Color = "";

        int numeroColor = rnd.nextInt(9);

        switch (numeroColor) {
            case 0:
                Color = "Blanco";
                break;
            case 1:
                Color = "Negro";
                break;
            case 2:
                Color = "Azul";
                break;
            case 3:
                Color = "Amarrillo";
                break;
            case 4:
                Color = "Morado";
                break;
            case 5:
                Color = "Naranja";
                break;
            case 6:
                Color = "Verde";
                break;
            case 7:
                Color = "Rojo";
                break;
            case 8:
                Color = "Cian";
                break;
        }
        double Tarifa;

        Tarifa = rnd.nextInt(150 - 100 + 1) + 100;
        boolean disponibilidad;

        if (rnd.nextBoolean()) {
            disponibilidad = true;
        } else {
            disponibilidad = false;
        }
        String[] marca = {"Lexus", "Ferrari", "Maserrati", "Ford", "Renault", "Seat", "Fiat"};
        String[] modelo = {"Marbella", "Pianto", "RSX300", "Focus", "Clio", "Marbella"};

        String marcaElegido = marca[rnd.nextInt(marca.length)];
        String modeloElegido = modelo[rnd.nextInt(modelo.length)];

        Vehiculo v = new Vehiculo(Matricula, marcaElegido, modeloElegido, Color, Tarifa, disponibilidad);
        return v;

    }

    public static void main(String[] args) {
        Vehiculo.vehiculoAleatorio();
    }
}
