package code;

public class BurningShip {

	private double[][] _x;
	private double[][] _y;
	private int[][] _finalFractal;

	public BurningShip() {
		
		_x = setCoordinateX();
		_y = setCoordinateY();
		_finalFractal= fractals();
	}
	
	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (.1)/512;
		double x = -1.8;
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
		double dy = (.08+.025)/512;
		for(int row = 0; row < yy.length; row++) {
			double y = -0.08;
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
			
			double xtemp = xCalc;
			xCalc = (xCalc*xCalc) - (yCalc*yCalc) + currentx;
			yCalc = Math.abs(2 * xtemp * yCalc) + currenty;
			passes = passes+1;
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

