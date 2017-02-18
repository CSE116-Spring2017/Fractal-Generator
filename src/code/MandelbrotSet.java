package code;

public class MandelbrotSet {

	private double[][] _x;
	private double[][] _y;
	private int[][] _finalFractal;

	public MandelbrotSet() {
		_x = setCoordinateX();
		_y = setCoordinateY();
		_finalFractal = fractals();
		
	}
	public static void main(String[] args) {
		MandelbrotSet m = new MandelbrotSet();
		double [][] x = m.setCoordinateX();
		double [][] y = m.setCoordinateY();
		int [][] f = m.fractals();
		
		System.out.println(m.escapeTime(0.5946289062500001, 1.2949218750000122));
		
		
	}
	
	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (2.15+0.6)/512;
		double x = -2.15;
		for(int row = 0; row < xx.length; row++) {
			for(int col = 0; col < xx[row].length; col++) {
				xx[row][col] = x;
			}
			x = x + dx;
		}
		return xx;
	}
	public double[][] setCoordinateY() {
		double[][] yy = new double[512][512];
		double dy = (1.3+1.3)/512;
		for(int row = 0; row < yy.length; row++) {
			double y = -1.3;
			for(int col = 0; col < yy[row].length; col++) {
				yy[row][col] = y;
				y = y + dy;
			}
		}
		return yy;
	}
	
	public int escapeTime(double currentx, double currenty) {
		double xCalc = currentx;
		double yCalc = currenty;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		
		while(dist <= 2 && passes<255) {
			double xtemp = xCalc;
			xCalc = (xCalc*xCalc) - (yCalc*yCalc) + currentx;
			yCalc = 2 * xtemp * yCalc + currenty;
			passes = passes + 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		
		return passes;
	}
	
	public int[][] fractals() {
		 int[][] result = new int[512][512];
		 for(int row = 0; row < result.length; row=row+1) {
			 for(int col = 0; col < result[row].length; col=col+1) {
				 result[row][col] = escapeTime(_x[row][col],_y[row][col]);
			 }
		 } 
		 return result;
	}

}
