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
		System.out.println(x[1][2]+","+y[7][0]);
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
			xCalc = (xCalc*xCalc) - (yCalc*yCalc) + currentx;
			yCalc = 2 * xCalc * yCalc + currenty;
			passes = passes+1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		
		return passes;
	}
	
	

	public void coordinate(double x, double y) {

	}
}
