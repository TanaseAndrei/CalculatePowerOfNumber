package model;

public class Result {

	private double base;
	private double exponent;
	private double result = 0;
	
	public void setBase(double nr) {
		this.base = nr;
	}
	
	public void setExponent(double nr) {
		this.exponent = nr;
	}
	
	public double compute() {
		return Math.pow(base, exponent);
	}
	
	public double getResult() {
		return result;
	}
	
}
