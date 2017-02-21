package code;

public class MultibrotSet {


	private int[][] _multiFractal;
	private double[][] _x;
	private double[][] _y;

	public MultibrotSet() {
		_x = setCoordinateX();
		_y = setCoordinateY();
		_multiFractal = fractals();
	}
	
	public static void main(String[] args) {
		MultibrotSet m = new MultibrotSet();
		double [][] x = m.setCoordinateX();
		double [][] y = m.setCoordinateY();
		int [][] f = m.fractals();
		System.out.println(x[0][0]+","+y[0][0]);
		System.out.println("escape time: "+f[0][0]);
		System.out.println(m.escapeTime(0.9921875, 1.05625));
	}

	public int escapeTime(double x, double y) {
		double xCalc = x;
		double yCalc = y;
		double distance = 0.0;
		int passes = 0;

		distance = Math.sqrt(((xCalc) * (xCalc)) + ((yCalc) * (yCalc)));
		while (distance <= 2.0 && passes < 255) {
			double xtemp = xCalc;
			xCalc = ((x * x) - (y * y)) + (-0.72689);
			yCalc = (2 * x * y) + 0.188887;
			passes = passes + 1;
			distance = Math.sqrt(((xCalc) * (xCalc)) + ((yCalc) * (yCalc)));
		}
		return passes;
	}

	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (3.4) / 512;
		double x = -1.7;
		for (int row = 0; row < xx.length; row++) {
			x = x + dx;
			for (int col = 0; col < xx[row].length; col++) {
				xx[row][col] = x;
			}
		}
		return xx;
	}

	public double[][] setCoordinateY() {
		double[][] yy = new double[512][512];
		double dy = (2.0) / 512;
		for (int row = 0; row < yy.length; row++) {
			double y = -1.0;
			for (int col = 0; col < yy[row].length; col++) {
				y = y + dy;
				yy[row][col] = y;
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
