package code;

public class MandelbrotSet {

	private double[][] _coordinatesx;
	private double[][] _coordinatesy;
	private int[][] _finalFractal;

	public MandelbrotSet() {
		_coordinatesx = new double[512][512];
		_finalFractal = new int[512][512];
	}

	public int escapeTime(double currentx, double currenty) {
		double xCalc = currentx;
		double yCalc = currenty;
		
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		while(dist <= 4 && passes<255) {
			xCalc = (xCalc*xCalc) - (yCalc*yCalc) + currentx;
			yCalc = 2 * xCalc * yCalc + currenty;
			passes ++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		
		return passes;
	}

	public void coordinate(double x, double y) {

	}
}
