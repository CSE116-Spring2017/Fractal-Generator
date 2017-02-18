package code;

public class JuliaSet {

	private double[][] _juliaFractal;
	private double[][] _coordinates;

	public JuliaSet() {
		_juliaFractal = new double[512][512];
		_coordinates = new double[512][512];
	}

	public void escapeTime(double x, double y) {
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
		
	}
	
	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (3.4)/512;
		double x = -1.7;
		for(int row = 0; row < xx.length; row++) {
			x = x + dx;
			for(int col = 0; col < xx[row].length; col++) {
				xx[row][col] = x;
			}
		}
		return xx;
	}
	public double[][] setCoordinateY() {
		double[][] yy = new double[512][512];
		double dy = (2.0)/512;
		for(int row = 0; row < yy.length; row++) {
			double y = -1.0;
			for(int col = 0; col < yy[row].length; col++) {
				y = y + dy;
				yy[row][col] = y;
			}
		}
		return yy;
	}
	

	public void update(double x, double y) {
		double x1 = 0.0;
		double y1 = 0.0;
		if (x >= -1.7 && x <= 1.7 && x >= -1.0 && x <= 1.0) {
			x1 = ((x * x) - (y * y)) + (-0.72689);
			y1 = (2 * x * y) + 0.188887;
		}
	}

}
