package code;

/**
 * An interface that allows the model to properly get all the details for each
 * fractal. Just an easy way to access all the data
 * 
 */

public interface Set {

	public void reset();

	public void setCoordinateX(double x1, double x2);

	public double[][] getCoordinateX();

	public void setCoordinateY(double y1, double y2);

	public double[][] getCoordinateY();

	public int escapeTime(int maxEscTime, int escapeDis, double currentx, double currenty);

	public int[][] getEscapeTime();

	public void setEscapeDis(int escapeDis);

	public void setMaxEscapeTime(int maxEscTime);
}
