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
		double [][] p = m.setCoordinateX();
		System.out.println(p[1][2]);
	}
	
	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (2.15+0.6)/512;
		for(int row = 0; row < xx.length; row++) {
			double x = -2.15;
			for(int col = 0; col < xx[row].length; col++) {
				x = x + dx;
				xx[row][col] = x;
			}
		}
		return xx;
	}
	public double[][] setCoordinateY() {
		double[][] yy = new double[512][512];
		double dy = (1.3+1.3)/512;
		double y = -1.3;
		for(int row = 0; row < yy.length; row++) {
			y = y + dy;
			for(int col = 0; col < yy[row].length; col++) {
				yy[row][col] = y;
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
