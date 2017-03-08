package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import javax.swing.*;

import code.BurningShip;
import code.ColorModelFactory;
import code.JuliaSet;
import code.MandelbrotSet;
import code.Model;
import code.MultibrotSet;
import edu.buffalo.fractal.FractalPanel;

public class UI implements Runnable {
	
	private Model _model;
	private JFrame _frame;
	private JMenuBar _menub;
	private FractalPanel _fractalPanel;
	private ArrayList<JLabel> _hint;
	private JPanel _hints;
	public UI() {
		_model = new Model();
	}
	
	@Override
	public void run() {
		
		_frame = new JFrame();
		_menub = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{ 
				System.exit(0);
			}
		});
		file.add(quit);
		
		JMenu fractal = new JMenu("Fractal");
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot Set");
		mandelbrot.addActionListener(new EventHandler(_model,new MandelbrotSet()));
		JMenuItem julia = new JMenuItem("Julia Set");
		julia.addActionListener(new EventHandler(_model, new JuliaSet()));
		JMenuItem burningShip = new JMenuItem("Burning Ship Set");
		burningShip.addActionListener(new EventHandler(_model, new BurningShip()));
		JMenuItem multibrot = new JMenuItem("Multibrot Set");
		multibrot.addActionListener(new EventHandler(_model, new MultibrotSet()));
		fractal.add(mandelbrot);
		fractal.add(julia);
		fractal.add(burningShip);
		fractal.add(multibrot);
		
		JMenu color = new JMenu("Color");
		JMenuItem rainbow = new JMenuItem("Rainbow");
		rainbow.addActionListener(new ColorHandler(_model,ColorModelFactory.createRainbowColorModel(255)));
		JMenuItem blue = new JMenuItem("Blue");
		blue.addActionListener(new ColorHandler(_model,ColorModelFactory.createBluesColorModel(255)));
		JMenuItem gray = new JMenuItem("Gray");
		gray.addActionListener(new ColorHandler(_model,ColorModelFactory.createGrayColorModel(255)));
		JMenuItem red = new JMenuItem("Red");
		red.addActionListener(new ColorHandler(_model,ColorModelFactory.createRedColorModel(255)));
		JMenuItem green = new JMenuItem("Green");
		green.addActionListener(new ColorHandler(_model,ColorModelFactory.createGreenColorModel(255)));
		JMenuItem white = new JMenuItem("White");
		white.addActionListener(new ColorHandler(_model,ColorModelFactory.createWhiteColorModel(255)));
		JMenuItem black = new JMenuItem("Black");
		black.addActionListener(new ColorHandler(_model,ColorModelFactory.createBlackColorModel(255)));
		JMenuItem ran = new JMenuItem("UnKnown");
		ran.addActionListener(new ColorHandler(_model,ColorModelFactory.createRandColorModel(255)));
		color.add(rainbow);
		color.add(blue);
		color.add(gray);
		color.add(red);
		color.add(green);
		color.add(white);
		color.add(black);
		color.add(ran);
		
		_menub.add(file);
		_menub.add(fractal);
		_menub.add(color);
		_model.addObserver(this);
		
		_menub.setLayout(new GridLayout(1,3));
		_frame.add(_menub);
		
		_fractalPanel = new FractalPanel();
		_frame.add(_fractalPanel);
		
		_hints = new JPanel();
		_hints.setLayout(new GridLayout(16,1));
		_hint = new ArrayList<JLabel>();
		for(int x = 0; x < 16; x++) {
			JLabel hint = new JLabel();
			hint.setBackground(new Color(50,50,50));
			hint.setForeground(Color.WHITE);
			hint.setOpaque(true);
			hint.setFont(new Font("Consolas", Font.PLAIN, 18));
			hint.setHorizontalAlignment(JLabel.CENTER);
			_hints.add(hint);
			_hint.add(hint);
		}
		_frame.add(_hints);
		
		_frame.getContentPane().setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		
		_model.addObserver(this);
		update();

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		
	}
	
	public void newFractal() {
		_frame.remove(_fractalPanel);
		_fractalPanel.updateImage(_model.escapeTime());
		IndexColorModel i = ColorModelFactory.createRainbowColorModel(255);
		_fractalPanel.setIndexColorModel(i);
		_frame.add(_fractalPanel);
		
	}
	
	public void update() {
		if(!_model.newFractal()) {
			_frame.remove(_fractalPanel);
			_hint.get(1).setText("To set up your fractal:             ");
			_hint.get(4).setText("    Select a color from the Color menu    ");
			_hint.get(6).setText("  and  ");
			_hint.get(8).setText("  Select a fractal from the Factal menu   ");
			_hint.get(10).setText(" or ");
			_hint.get(12).setText("Select quit from File menu");
		}	
		else{
			_frame.remove(_hints);
			newFractal();
		}
		_frame.pack();
	}

	

}
