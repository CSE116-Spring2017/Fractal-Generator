package code;

/**
 * Class which calculates the Escape-Time Algorithms for Burning Ship Set with
 * X-Coordinate range from -1.8 to -1.7 Y-Coordinate range from -0.08 to 0.025
 *
 * @author Likhith Doddi
 */

public class BurningShip implements Set{

	/** Array of all the x-coordinate */
	private double[][] _x;
	/** Array of all the y-coordinate */
	private double[][] _y;
	private int _escapeDis;

	/**
	 * Create a Burning Ship Set with array of x coordinate range from -1.8 to
	 * -1.7 with 512 equally-spaced array of y coordinate range from -0.08 to 0.025
	 * with 512 equally-spaced array of escape-time for each of 262144 pairs
	 */

	public BurningShip() {

		_x = setCoordinateX();
		_y = setCoordinateY();
		_escapeDis = 2;

	}

	/**
	 * Set up all the x according to Cartesian plane return a 2-d array of
	 * double with 512 rows and 512 columns find the change of x first double is
	 * the start of the x range which is -1.8 x + change of x when row increase
	 * by one increase of column does not effect anything
	 * 
	 * @return 2-d array of double
	 */
	@Override
	public double[][] setCoordinateX() {
		double[][] xx = new double[512][512];
		double dx = (.1) / 511;
		double x = -1.8;
		for (int row = 0; row < xx.length; row++) {
			for (int col = 0; col < xx[row].length; col++) {
				xx[row][col] = x;
			}
			x = x + dx;
		}
		return xx;
	}

	/**
	 * Set up all the y according to Cartesian plane return a 2-d array of
	 * double with 512 rows and 512 columns find the change of y first double is
	 * the start of the y range which is -0.08 y + change of y when column
	 * increase by one increase of row does not effect anything
	 * 
	 * @return 2-d array of double
	 */
	@Override
	public double[][] setCoordinateY() {
		double[][] yy = new double[512][512];
		double dy = (.08 + .025) / 511;
		for (int row = 0; row < yy.length; row++) {
			double y = -0.08;
			for (int col = 0; col < yy[row].length; col++) {
				yy[row][col] = y;
				y = y + dy;
			}
		}
		return yy;
	}

	/**
	 * return int of escape-time by Set xCalc = {@code currentx} Set yCalc =
	 * {@code currenty} Set dist = distance from the point (xCalc, yCalc) to
	 * (0,0) using the Pythagorean theorem Set passes = 0 While dist <= 2 and
	 * passes < 255 do Update xCalc and yCalc equal using the update function
	 * defined for the fractal being generated Update by using x' = x*x - y*y +
	 * current point's x-coordinate y' = absolute vale of|2 * x * y| + current point's
	 * y-coordinate Increase passes by 1 Set dist distance from the point
	 * (xCalc, yCalc) to (0,0) using the Pythagorean theorem EndWhile
	 *
	 * @param double
	 *            currentx (x coordinate for which we will search)
	 * @param double
	 *            currenty (y coordinate for which we will search)
	 * @return int of escape-time for coordinate ({@code currentx} ,
	 *         {@code currenty})
	 */
	@Override
	public int escapeTime(int escapeDis, double currentx, double currenty) {
		double xCalc = currentx;
		double yCalc = currenty;

		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;

		while (dist <= escapeDis && passes < 255) {

			double xtemp = xCalc;
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + currentx;
			yCalc = Math.abs(2 * xtemp * yCalc) + currenty;
			passes = passes + 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}

		return passes;
	}
	@Override
	public void setEscapeDis(int escapeDis){
		_escapeDis = escapeDis;
	}

	/**
	 * return 2-d array of escape-time for each of these 262144 coordinate pairs
	 * 
	 * @return 2-d array of double
	 */
	@Override
	public int[][] getFractals() {
		int[][] result = new int[512][512];
		for (int row = 0; row < result.length; row = row + 1) {
			for (int col = 0; col < result[row].length; col = col + 1) {
				result[row][col] = escapeTime(_escapeDis,_x[row][col], _y[row][col]);

			}
		}
		return result;
	}

}
