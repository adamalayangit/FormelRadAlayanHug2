package application;

/**
 * Berechnet das Formelrad
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
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {

		if (spannung != 0.0 && strom != 0.0){
			pAusUundI(spannung, strom);
		}
		if (widerstand != 0.0 && strom != 0.0){
			pAusRundI(widerstand, strom);
		}
		if (spannung != 0.0 && widerstand != 0.0){
			pAusUundR(spannung, widerstand);
		}

		if (widerstand != 0.0 && strom != 0.0){
			uAusRundI(widerstand, strom);
		}
		if (leistung != 0.0 && strom != 0.0){
			uAusPundI(leistung, strom);
		}
		if (leistung != 0.0 && widerstand != 0.0){
			uAusPundR(leistung, widerstand);
		}

		if (leistung != 0.0 && widerstand != 0.0){
			iAusPundR(leistung, widerstand);
		}
		if (leistung != 0.0 && spannung != 0.0){
			iAusPundU(leistung, spannung);
		}
		if (spannung != 0.0 && widerstand != 0.0){
			iAusUundR(spannung, widerstand);
		}
	}


	public double pAusUundI(double u, double i) {
		return u*i;
	}

	public double pAusRundI(double r, double i) {
		return r*(i*i);
	}

	public double pAusUundR(double u, double r) {
		return (u*u)/r;
	}
	
	
	public double uAusRundI(double r, double i) {
		return r*i;
	}
	
	public double uAusPundI(double p, double i) {
		return p/i;
	}
	
	public double uAusPundR(double p, double r) {
		return Math.sqrt(p*r);
	}
	
	public double rAusUundI(double u, double i) {
		return u/i;
	}
	
	public double rAusPundI(double p, double i) {
		return p/(i*i);
	}
	
	public double rAusUundP(double u, double p) {
		return (u*u)/p;
	}


	public double iAusPundR(double p, double r) {
		return Math.sqrt(p/r);
	}

	public double iAusPundU(double p, double u) {
		return p/u;
	}

	public double iAusUundR(double u, double r) {
		return u/r;
	}

}
