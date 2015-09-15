/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.logico;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author andre_000
 */
public class TablaFrecuencias {

    private LinkedList<Double> listaDatos;
    private double rang;
    private int classes;
    private int amplitude;
    private double unity;
    private int n;

    public TablaFrecuencias(double[] datos) {
        listaDatos = new LinkedList<>();
        for (int i = 0; i < datos.length; i++) {
            listaDatos.add(datos[i]);
        }
        Collections.sort(listaDatos);
        rang = 0;
        classes = 0;
        amplitude = 0;
        unity = 0;
        n = listaDatos.size();
    }

    public void setRang() {
        double datoMayor = listaDatos.getFirst();
        double datoMenor = listaDatos.getFirst();
        for (int i = 0; i < listaDatos.size(); i++) {
            if (listaDatos.get(i) > datoMayor) {
                datoMayor = listaDatos.get(i);
            } else if (listaDatos.get(i) < datoMenor) {
                datoMenor = listaDatos.get(i);
            }
        }
        double r = datoMayor - datoMenor;
        this.rang = r;
    }

    public LinkedList<Double> getListaDatos() {
        return listaDatos;
    }

    public double getRang() {
        return rang;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses() {
        Double c;
        c = 1 + 3.3 * Math.log10(this.n);
        this.classes = c.intValue() + 1;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public void setAmplitude() {
        Double w;
        w = (this.rang / this.classes) + 1;
        this.amplitude = w.intValue();
    }

    public double getUnity() {
        return unity;
    }

    public void setUnity() {
        double u;
        int uni = this.cuantosDecimales(this.listaDatos.getFirst());
        u = 1 * Math.pow(10, -uni);
        this.unity = u;

    }

    public int cuantosDecimales(double num) {

        int cont = 0;
        int contador = 0;
        String cadenaNumero = "" + num;

        BigDecimal Bnumero = new BigDecimal(cadenaNumero);
        String cadenaParteEntera = "" + Bnumero.intValue();
        BigDecimal BPEntera = new BigDecimal(cadenaParteEntera);
        String cadenaParteDecimal = "" + Bnumero.subtract(BPEntera);
        BigDecimal BparteDecimal = new BigDecimal(cadenaParteDecimal);
        BigDecimal Bcero = new BigDecimal("0.0");
        BigDecimal Bdiez = new BigDecimal("10.0");

        while (BparteDecimal.compareTo(Bcero) != 0) {
            BparteDecimal = BparteDecimal.multiply(Bdiez);
            String CadenaNuevaParteEntera = "" + BparteDecimal.intValue();
            BigDecimal BNuevaPEntera = new BigDecimal(CadenaNuevaParteEntera);
            BparteDecimal = BparteDecimal.subtract(BNuevaPEntera);

            cont += 1;
        }

        return cont;

    }

}
