package application;

import javafx.scene.control.Alert;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    public void calculate() {

        if ((widerstand != 0.0 && strom != 0.0 && spannung != 0.0)
                || (leistung != 0.0 && strom != 0.0 && widerstand != 0.0)
                || (spannung != 0.0 && leistung != 0.0 && widerstand != 0.0)
                || (spannung != 0.0 && leistung != 0.0 && strom != 0.0)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exception!!!!");
            alert.setHeaderText(null);
            alert.setContentText("Bitte geben Sie zwei Werte an!");

            alert.showAndWait();

        } else {

            if (spannung != 0.0 && strom != 0.0) {
                leistung = pAusUundI(spannung, strom);
                System.out.println("Leistung wird aus Spannung und Strom berechnet");
                System.out.println(spannung+"*"+strom+"="+leistung);
                System.out.println("-----------------------------------------------");

                widerstand = rAusUundI(spannung, strom);
                System.out.println("Widerstand wird aus Spannung und Strom berechnet");
                System.out.println(spannung+"/"+strom+"="+widerstand);
                System.out.println("-----------------------------------------------");
            }

            if (widerstand != 0.0 && strom != 0.0) {
                leistung = pAusRundI(widerstand, strom);
                System.out.println("Leistung wird aus Widerstand und Strom berechnet");
                System.out.println(widerstand+"*"+strom*strom+"="+leistung);
                System.out.println("-----------------------------------------------");

                spannung = uAusRundI(widerstand, strom);
                System.out.println("Spannung wird aus Widerstand und Strom berechnet");
                System.out.println(widerstand+"*"+strom+"="+spannung);
                System.out.println("-----------------------------------------------");

            }

            if (spannung != 0.0 && widerstand != 0.0) {
                leistung = pAusUundR(spannung, widerstand);
                System.out.println("Leistung wird aus Spannung und Widerstand berechnet");
                System.out.println(spannung*spannung+"/"+widerstand+"="+leistung);
                System.out.println("-----------------------------------------------");

                strom = iAusUundR(spannung, widerstand);
                System.out.println("Strom wird aus Spannung und Widerstand berechnet");
                System.out.println(spannung+"/"+widerstand+"="+strom);
                System.out.println("-----------------------------------------------");
            }

            if (leistung != 0.0 && strom != 0.0) {
                spannung = uAusPundI(leistung, strom);
                System.out.println("Spannung wird aus Leistung und Strom berechnet");
                System.out.println(leistung+"/"+strom+"="+spannung);
                System.out.println("-----------------------------------------------");

                widerstand = rAusPundI(leistung, strom);
                System.out.println("Widerstand wird aus Leistung und Strom berechnet");
                System.out.println(leistung+"/"+strom*strom+"="+widerstand);
                System.out.println("-----------------------------------------------");
            }

            if (leistung != 0.0 && widerstand != 0.0) {
                spannung = uAusPundR(leistung, widerstand);
                strom = iAusPundR(leistung, widerstand);
            }

            if (leistung != 0.0 && spannung != 0.0) {
                strom = iAusPundU(leistung, spannung);
                widerstand = rAusUundP(spannung, leistung);
            }
        }
    }


    public double pAusUundI(double u, double i) {
        return u * i;
    }

    public double pAusRundI(double r, double i) {
        return r * (i * i);
    }

    public double pAusUundR(double u, double r) {
        return (u * u) / r;
    }


    public double uAusRundI(double r, double i) {
        return r * i;
    }

    public double uAusPundI(double p, double i) {
        return p / i;
    }

    public double uAusPundR(double p, double r) {
        return Math.sqrt(p * r);
    }

    public double rAusUundI(double u, double i) {
        return u / i;
    }

    public double rAusPundI(double p, double i) {
        return p / (i * i);
    }

    public double rAusUundP(double u, double p) {
        return (u * u) / p;
    }


    public double iAusPundR(double p, double r) {
        return Math.sqrt(p / r);
    }

    public double iAusPundU(double p, double u) {
        return p / u;
    }

    public double iAusUundR(double u, double r) {
        return u / r;
    }

}
