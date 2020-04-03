package uebung0;

public class ComplexMatrix {
	private Complex[][] matrix;
	private int y;
	private int x;
	
	public ComplexMatrix(Complex[][] matrix) {
		this.matrix = matrix;
		this.y = matrix.length;
		this.x = matrix[1].length;
	}
	
	public Complex[][] getMatrix() {
		return this.matrix;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public ComplexMatrix add(ComplexMatrix summandMatrix) {
		Complex[][] matrix = new Complex[this.y][this.x];
		
		for (int y = 0; y<this.y; y++) {
			for (int x = 0; x<this.x; x++) {
				matrix[y][x] = this.matrix[y][x].add(summandMatrix.getMatrix()[y][x]);
			}
		}
		return new ComplexMatrix(matrix);
	}
	
	public ComplexMatrix multiply(ComplexMatrix multiplicand) {
		Complex[][] matrix = new Complex[this.y][multiplicand.getX()];
		Complex[] rowVector = new Complex[this.x];
		Complex[] columnVector = new Complex[multiplicand.getY()];
		Complex scalarProduct = null;
		
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
		
		return new ComplexMatrix(matrix);
		
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
