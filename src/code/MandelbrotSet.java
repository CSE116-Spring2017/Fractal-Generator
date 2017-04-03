package code;

/**
 * Class which calculates the Escape-Time Algorithms for Mandelbrot Set with
 * X-Coordinate range from -2.15 to 0.6 Y-Coordinate range from -1.3 to 1.3
 *
 * @author Wenqian Zhao
 */

public class MandelbrotSet implements Set {
	/** Array of all the x-coordinate */
	private double[][] _x;
	/** Array of all the y-coordinate */
	private double[][] _y;
	private int _escapeDis;
	private int _maxEscTime;

	/**
	 * Create a Mandelbrot Set with array of x coordinate range from -2.15 to
	 * 0.6 with 512 equally-spaced array of y coordinate range from -1.3 to 1.3
	 * with 512 equally-spaced array of escape-time for each of 262144 pairs
	 */
	public MandelbrotSet() {
		reset();
	}

	@Override
	public void reset() {
		setCoordinateX(-2.15, 0.6);
		setCoordinateY(-1.3, 1.3);
	}

	/**
	 * Set up all the x according to Cartesian plane return a 2-d array of
	 * double with 512 rows and 512 columns find the change of x first double is
	 * the start of the x range which is -2.15 x + change of x when row increase
	 * by one increase of column does not effect anything
	 * 
	 */
	@Override
	public void setCoordinateX(double x1, double x2) {
		double[][] xx = new double[512][512];
		double dx = Math.abs(x1 - x2) / 511;
		double x = x1;
		for (int row = 0; row < xx.length; row++) {
			for (int col = 0; col < xx[row].length; col++) {
				xx[row][col] = x;
			}
			x = x + dx;
		}
		_x = xx;
	}

	/**
	 * Set up all the y according to Cartesian plane return a 2-d array of
	 * double with 512 rows and 512 columns find the change of y first double is
	 * the start of the y range which is -1.3 y + change of y when column
	 * increase by one increase of row does not effect anything
	 * 
	 */
	@Override
	public void setCoordinateY(double y1, double y2) {
		double[][] yy = new double[512][512];
		double dy = Math.abs(y1 - y2) / 511;
		for (int row = 0; row < yy.length; row++) {
			double y = y1;
			for (int col = 0; col < yy[row].length; col++) {
				yy[row][col] = y;
				y = y + dy;
			}
		}
		_y = yy;
	}

	@Override
	public double[][] getCoordinateX() {
		return _x;
	}

	@Override
	public double[][] getCoordinateY() {
		return _y;
	}

	/**
	 * return int of escape-time by Set xCalc = {@code currentx} Set yCalc =
	 * {@code currenty} Set dist = distance from the point (xCalc, yCalc) to
	 * (0,0) using the Pythagorean theorem Set passes = 0 While dist <= 2 and
	 * passes < 255 do Update xCalc and yCalc equal using the update function
	 * defined for the fractal being generated Update by using x' = x*x - y*y +
	 * current point's x-coordinate y' = 2 * x * y + current point's
	 * y-coordinate Increase passes by 1 Set dist distance from the point
	 * (xCalc, yCalc) to (0,0) using the Pythagorean theorem EndWhile
	 *
	 * @param int
	 *            maxEscTime
	 * @param int
	 *            escapeDis
	 * @param double
	 *            currentx (x coordinate for which we will search)
	 * @param double
	 *            currenty (y coordinate for which we will search)
	 * @return int of escape-time for coordinate ({@code currentx} ,
	 *         {@code currenty})
	 */
	@Override
	public int escapeTime(int maxEscTime, int escapeDis, double currentx, double currenty) {
		double xCalc = currentx;
		double yCalc = currenty;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;

		while (dist <= escapeDis && passes < maxEscTime) {
			double xtemp = xCalc;
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + currentx;
			yCalc = 2 * xtemp * yCalc + currenty;
			passes = passes + 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}

		return passes;
	}

	/**
	 * Update the escape distance {@code _escapeDis} of the Mandelbrot Set by
	 * {@code escapeDis}
	 */
	@Override
	public void setEscapeDis(int escapeDis) {
		_escapeDis = escapeDis;
	}

	/**
	 * Update the max escape time {@code _maxEscTime} of the Mandelbrot Set by
	 * {@code maxEscTime}
	 */
	@Override
	public void setMaxEscapeTime(int maxEscTime) {
		_maxEscTime = maxEscTime;
	}

	/**
	 * return 2-d array of escape-time for each of these 262144 coordinate pairs
	 * 
	 * @return 2-d array of double
	 */
	@Override
	public int[][] getEscapeTime() {
		int[][] result = new int[512][512];
		for (int row = 0; row < result.length; row = row + 1) {
			for (int col = 0; col < result[row].length; col = col + 1) {
				result[row][col] = escapeTime(_maxEscTime, _escapeDis, _x[row][col], _y[row][col]);
			}
		}
		return result;
	}
}
