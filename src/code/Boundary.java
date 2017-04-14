package code;

import java.awt.Point;

public class Boundary {

	public Boundary() {

	}

	/**
	 * Compare the two points {@code p} and {@code p} and get the minimum x -
	 * coordinate and y - coordinate
	 * 
	 * @param p
	 * @param p1
	 * @return rp Point with minimum x and y from {@code p} and {@code p1}
	 */
	public Point min(Point p, Point p1) {
		Point rp = new Point();
		if (p.x >= p1.x) {
			rp.x = p1.x;
		} else if (p.x < p1.x) {
			rp.x = p.x;
		}
		if (p.y >= p1.y) {
			rp.y = p1.y;
		} else if (p.y < p1.y) {
			rp.y = p.y;
		}
		return rp;
	}

	/**
	 * Compare the two points {@code p} and {@code p} and get the maximum x -
	 * coordinate and y - coordinate
	 * 
	 * @param p
	 * @param p1
	 * @return rp Point with maximum x and y from {@code p} and {@code p1}
	 */
	public Point max(Point p, Point p1) {
		Point rp = new Point();
		if (p.x <= p1.x) {
			rp.x = p1.x;
		} else if (p.x > p1.x) {
			rp.x = p.x;
		}
		if (p.y <= p1.y) {
			rp.y = p1.y;
		} else if (p.y > p1.y) {
			rp.y = p.y;
		}
		return rp;
	}

	/**
	 * Checks the bound of Point {@code p} if either x - coordinate or y -
	 * coordinate are greater than 511 or smaller than 0 should limit the max x
	 * - coordinate and y - coordinate in between 0 and 512 exclusively
	 * 
	 * @param p
	 * @return rp Point with limited x and y
	 */
	public Point checkBound(Point p) {
		Point rp = new Point(p);
		if (rp.x > 511) {
			rp.setLocation(511, rp.y);
		} else if (rp.x < 0) {
			rp.setLocation(0, rp.y);
		}
		if (rp.y > 511) {
			rp.setLocation(rp.x, 511);
		} else if (rp.y < 0) {
			rp.setLocation(rp.x, 0);
		}
		return rp;
	}

	/**
	 * check the bound of the points {@code p} and {@code p1} then find the
	 * minimum x - y - coordinate and maximum x - y - coordinate and assign the
	 * new points to {@code pp} and {@code ppp} respectively, So {@code pp} will
	 * be the coordinates of upper-left corner of the region then calculate the
	 * width and height of the selected region and call method
	 * {@code selectionBox()} in Model {@code m} to pass the selected region
	 * 
	 * @param m
	 * @param p
	 * @param p1
	 */
	public void selection(Model m, Point p, Point p1) {
		Point pp = min(checkBound(p), checkBound(p1));
		Point ppp = max(checkBound(p), checkBound(p1));
		m.selectionBox(pp.x, pp.y, Math.abs(pp.x - ppp.x), Math.abs(pp.y - ppp.y));
	}

	/**
	 * check the bound of the points {@code p} and {@code p1} first then assign
	 * the new points to {@code pp} and {@code ppp} find the minimum coordinates
	 * and maximum coordinates if minimum coordinates and maximum coordinates
	 * and not equal update the fractal set's x range and y range
	 * 
	 * @param s
	 * @param p
	 * @param p1
	 */
	public void setNew(Set s, Point p, Point p1) {
		Point minP = min(checkBound(p), checkBound(p1));
		Point maxP = max(checkBound(p), checkBound(p1));
		if (!minP.equals(maxP)) {
			s.setCoordinateX(s.getCoordinateX()[minP.x][minP.y], s.getCoordinateX()[maxP.x][maxP.y]);
			s.setCoordinateY(s.getCoordinateY()[minP.x][minP.y], s.getCoordinateY()[maxP.x][maxP.y]);
		}

	}

}
