package uebung0;

import java.math.BigDecimal;

public class Matrix {
	private BigDecimal[][] matrix;
	private int y;
	private int x;
	
	public Matrix(BigDecimal[][] matrix) {
		this.matrix = matrix;
		this.y = matrix.length;
		this.x = matrix[0].length;
	}
	
	public Matrix(Complex complex) {
		BigDecimal[][] matrix = new BigDecimal[][] {
			{complex.getReal(), complex.getImaginary().multiply(new BigDecimal(-1))},
			{complex.getImaginary(), complex.getReal()}
		};
		
		this.matrix = matrix;
		this.y = matrix.length;
		this.x = matrix[0].length;
	}
	
	public BigDecimal[][] getMatrix() {
		return this.matrix;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public Matrix add(Matrix summandMatrix) {
		BigDecimal[][] matrix = new BigDecimal[this.y][this.x];
		
		for (int y = 0; y<this.y; y++) {
			for (int x = 0; x<this.x; x++) {
				matrix[y][x] = this.matrix[y][x].add(summandMatrix.getMatrix()[y][x]);
			}
		}
		return new Matrix(matrix);
	}
	
	public Matrix multiply(Matrix multiplicand) {
		BigDecimal[][] matrix = new BigDecimal[this.y][multiplicand.getX()];
		BigDecimal[] rowVector = new BigDecimal[this.x];
		BigDecimal[] columnVector = new BigDecimal[multiplicand.getY()];
		BigDecimal scalarProduct = null;
		
		for (int y = 0; y<this.y; y++) {
			for (int x = 0; x<multiplicand.getX(); x++) {
				
				for (int xRow = 0; xRow<this.x; xRow++) {
					rowVector[xRow] = this.getMatrix()[y][xRow];
				}
				for (int yCol = 0; yCol<multiplicand.getY(); yCol++) {
					columnVector[yCol] = multiplicand.getMatrix()[yCol][x];
				}
				
				for (int i = 0; i<this.x; i++) {
					if (scalarProduct == null) {
						scalarProduct = rowVector[i].multiply(columnVector[i]);
					} else {
						scalarProduct = scalarProduct.add(rowVector[i].multiply(columnVector[i]));
					}
				}
				
				matrix[y][x] = scalarProduct;
				scalarProduct = null;
			}
		}
		
		return new Matrix(matrix);
		
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (int y = 0; y<this.y; y++) {
			for (int x = 0; x<this.x; x++) {
				str += this.matrix[y][x]+" ";
			}
			str += "\r\n";
		}
		return str;
	}
}
