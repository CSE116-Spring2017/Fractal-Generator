package code;

public class JuliaSet {

	private int[][] _juliaFractal;
	private double[][] _x;
	private double[][] _y;

	public JuliaSet() {
		_x = setCoordinateX();
		_y = setCoordinateY();
		_juliaFractal = fractals();
	}
	
	public static void main(String[] args) {
		JuliaSet m = new JuliaSet();
		double [][] x = m.setCoordinateX();
		double [][] y = m.setCoordinateY();
		int [][] f = m.fractals();
		System.out.println(x[0][0]+","+y[0][0]);
		System.out.println("escape time: "+f[0][0]);
		System.out.println(m.escapeTime(-1.7, -1.0));
	}

	public int escapeTime(double x, double y) {
		double xCalc = x;
		double yCalc = y;
		double distance = 0.0;
		int passes = 0;

		distance = Math.sqrt(((xCalc) * (xCalc)) + ((yCalc) * (yCalc)));
		while (distance <= 2.0 && passes < 255) {
			update(xCalc, yCalc);
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

	public void update(double x, double y) {
		if (x >= -1.7 && x <= 1.7 && x >= -1.0 && x <= 1.0) {
			double x1 = ((x * x) - (y * y)) + (-0.72689);
			double y1 = (2 * x * y) + 0.188887;
		}
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
