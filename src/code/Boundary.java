package code;

import java.awt.Point;

public class Boundary {

	public Boundary() {

	}

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
			rp.setLocation(p.x, 0);
		}
		return rp;
	}

	public void selection(Model m, Point p, Point p1) {
		Point pp = new Point(p);
		Point pp1 = new Point(checkBound(p1));

		if (pp.x > pp1.x) {
			int x = pp1.x;
			pp1.setLocation(pp.x, pp1.y);
			pp.setLocation(x, pp.y);
		}
		if (pp.y > pp1.y) {
			int y = pp1.y;
			pp1.setLocation(pp1.x, pp.y);
			pp.setLocation(pp.x, y);
		}
		m.selectionBox(pp.x, pp.y, Math.abs(pp.x - pp1.x), Math.abs(pp.y - pp1.y));
	}

	public void setNew(Set s, Point p, Point p1) {
		Point pp = new Point(checkBound(p1));
		Point minP = min(p, pp);
		Point maxP = max(p, pp);
		s.setCoordinateX(s.getCoordinateX()[minP.x][minP.y], s.getCoordinateX()[maxP.x][maxP.y]);
		s.setCoordinateY(s.getCoordinateY()[minP.x][minP.y], s.getCoordinateY()[maxP.x][maxP.y]);

	}

}
