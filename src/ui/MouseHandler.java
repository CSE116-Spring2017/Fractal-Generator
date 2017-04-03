package ui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import code.Model;

public class MouseHandler implements MouseListener, MouseMotionListener {
	private Model _m;
	private Point _p;

	public MouseHandler(Model m) {
		_m = m;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_p = e.getPoint();
		System.out.println("x: " + _p.x + " y: " + _p.y);
		System.out.println();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = new Point(checkBound(e.getPoint()));
		Point p2 = new Point(_p);

		if (p2.x > p.x) {
			int x = p.x;
			p.setLocation(p2.x, p.y);
			p2.setLocation(x, p2.y);
		}
		if (p2.y > p.y) {
			int y = p.y;
			p.setLocation(p.x, p2.y);
			p2.setLocation(p2.x, y);
		}
		_m.selectionBox(p2.x, p2.y, Math.abs(p2.x - p.x), Math.abs(p2.y - p.y));

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

	@Override
	public void mouseReleased(MouseEvent e) {
		Point p = new Point(checkBound(e.getPoint()));
		mouseDragged(e);
		_m.setNew(_p, p);
		System.out.println("x: " + _p.x + " y: " + _p.y);
		System.out.println("x: " + p.x + " y: " + p.y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
