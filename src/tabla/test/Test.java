/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.test;
import tabla.logico.TablaFrecuencias;
/**
 *
 * @author andre_000
 */
public class Test {
    public static void main(String[] args) {
        double[] datos = {21.48, 21.15, 25.12, 23.17, 27.81, 19.81, 36.05, 28.50, 26.66, 20.35, 30.22, 25.49, 20.80, 23.83, 25.35, 23.98, 25.81, 21.07, 26.83, 30.96, 33.38, 20.77, 19.98, 37.87, 22.02};
        TablaFrecuencias frecuen =  new TablaFrecuencias(datos);
        frecuen.setRang();
        frecuen.setClasses();
        frecuen.setAmplitude();
        frecuen.setUnity();
        System.out.println(frecuen.getRang());
        System.out.println(frecuen.getClasses());
        System.out.println(frecuen.getAmplitude());
        System.out.println(frecuen.getUnity());
    }
}
