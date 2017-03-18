package code;

/**
 * An interface that allows the model to properly get all the details for each fractal. 
 * Just an easy way to access all the data
 * 
 */

public interface Set {
	
	public double[][] setCoordinateX();

	public double[][] setCoordinateY();

	public int escapeTime(int escapeDis, double currentx, double currenty);

	public int[][] getEscapeTime();

	public void setEscapeDis(int escapeDis);
}
