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
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		_m.selection(_p, e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_m.setNew(_p, e.getPoint());
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
