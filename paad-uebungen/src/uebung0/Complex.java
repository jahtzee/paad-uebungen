package uebung0;

import java.math.BigDecimal;

public class Complex {
	private BigDecimal[] expression = new BigDecimal[2];
	
	public Complex(BigDecimal real, BigDecimal imaginary) {
		this.expression[0] = real;
		this.expression[1] = imaginary;
	}
	
	public Complex(String real, String imaginary) {
		this.expression[0] = new BigDecimal(real);
		this.expression[1] = new BigDecimal(imaginary);
	}
	
	public Complex add(Complex summand) {
		Complex result = new Complex(this.getReal().add(summand.getReal()), this.getImaginary().add(summand.getImaginary()));
		return result;
	}
	
	public Complex subtract(Complex subtrahend) {
		Complex result = new Complex(this.getReal().subtract(subtrahend.getReal()), this.getImaginary().subtract(subtrahend.getImaginary()));
		return result;
	}
	
	public Complex multiply(Complex multiplicand) {
		Complex result = new Complex( (this.getReal().multiply(multiplicand.getReal())).subtract((this.getImaginary().multiply(multiplicand.getImaginary()))), 
				(this.getReal().multiply(multiplicand.getImaginary()).add(multiplicand.getReal().multiply(this.getImaginary()))));
		return result;
	}
	
	public BigDecimal getReal() {
		return this.expression[0];
	}
	
	public BigDecimal getImaginary() {
		return this.expression[1];
	}
	
	public BigDecimal[] getExpression() {
		return this.expression;
	}
	
	@Override
	public String toString() {
		String str = this.getReal().toString();
		if (this.getImaginary().compareTo(new BigDecimal("0")) >= 0) {
			str += "+";
		}
		str += this.getImaginary().toString() + "i";
		return str;
	}
}
