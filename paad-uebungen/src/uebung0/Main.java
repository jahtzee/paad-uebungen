package uebung0;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
//		Complex[] a = new Complex[] {
//				new Complex(
//						new BigDecimal("3"),
//						new BigDecimal("0")
//						),
//				new Complex(
//						new BigDecimal("7"),
//						new BigDecimal("0")
//				)
//		};
//		Complex[] b = new Complex[] {
//				new Complex(
//						new BigDecimal("5"),
//						new BigDecimal("0")
//						),
//				new Complex(
//						new BigDecimal("-3"),
//						new BigDecimal("0")
//				)
//		};
//		for (int i = 0; i < 2; i++) {
//			Complex result = a[i].subtract(b[i]);
//			System.out.println(result);
//		}
		
//		Complex[][] matrix = new Complex[][] {
//			{a[0], a[1]},
//			{b[0], b[1]}
//		};
//		
//		ComplexMatrix ComplexMatrix1 = new ComplexMatrix(matrix);
//		ComplexMatrix ComplexMatrix2 = new ComplexMatrix(matrix);
//		System.out.println(ComplexMatrix1);
//		System.out.println("==========================================");
//		System.out.println(ComplexMatrix2);
//		System.out.println("==========================================");
//		System.out.println(ComplexMatrix1.multiply(ComplexMatrix2));
	
		Complex exp1 = new Complex(new BigDecimal(3), new BigDecimal(7));
		Complex exp2 = new Complex(new BigDecimal(-9), new BigDecimal(-2));
		
		System.out.println("Regulär Addition: " + exp1 +" + "+ exp2 + " = " + exp1.add(exp2));
		System.out.println("Regulär Multiplikation: " + exp1 + " * " + exp2 + " = " + exp1.multiply(exp2));
		
		Matrix mat1 = new Matrix(exp1);
		Matrix mat2 = new Matrix(exp2);
		
//		System.out.println("==============================");
//		
//		System.out.println(mat1);
//		System.out.println(mat2);
//		
//		System.out.println("==============================");
		
		System.out.print("Addition als Matrix:\r\n" + mat1.add(mat2));
		System.out.print("Multiplikation als Matrix:\r\n" + mat1.multiply(mat2));
	}
}
