package code;

public class JuliaSet {

	private int[][] _juliaFractal;
	private double[][] _coordinates;

	public JuliaSet() {
		_juliaFractal = new int[512][512];
		_coordinates = new double[512][512];
	}

	public void escapeTime(double x, double y) {

	}

	public void coordinates(double x, double y) {
		double xCalc = x;
		double yCals = y;
		double distance = 0.0;
		int passes = 0;

		distance = Math.sqrt(((x - 0) * (x - 0)) + ((y - 0) * (y - 0)));
		while (distance <= 4.0 && passes < 255) {

		}

	}

}
