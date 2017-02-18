package code;

public class MandelbrotSet {

	private double[][] _x;
	private double[][] _y;
	private int[][] _finalFractal;

	public MandelbrotSet() {
		_x = new double[512][512];
		_y = new double[512][512];
		_finalFractal = new int[512][512];
		
	}
	public static void main(String[] args) {
		MandelbrotSet m = new MandelbrotSet();
		double [][] x = m.setCoordinateX();
		double [][] y = m.setCoordinateY();
		int [][] f = m.fractals();
		System.out.println(x[1][1]+","+y[1][1]);
		System.out.println("escape time: "+f[489][450]);
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
	
	public double xCoordinate(int x, int y) {
		return _x[x][y];
	}
	public double yCoordinate(int x, int y) {
		return _y[x][y];
	}
	
	
	public int escapeTime(double currentx, double currenty) {
		double xCalc = currentx;
		double yCalc = currenty;
		
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		
		while(dist <= 2 && passes<255) {
			xCalc = (xCalc*xCalc) - (yCalc*yCalc) + currentx;
			yCalc = 2 * xCalc * yCalc + currenty;
			passes = passes+1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		
		return passes;
	}
	
	public int[][] fractals() {
		 int[][] result = new int[512][512];
		 for(int row = 0; row < result.length; row++) {
			 for(int col = 0; col < result[row].length; col++) {
				 result[row][col] = escapeTime(xCoordinate(row,col),yCoordinate(row,col));
			 }
		 } 
		 return result;
	}

	public void coordinate(double x, double y) {

	}
}
