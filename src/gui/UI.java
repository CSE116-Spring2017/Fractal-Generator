package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import code.BurningShip;
import code.JuliaSet;
import code.MandelbrotSet;
import code.MultibrotSet;
import edu.buffalo.fractal.FractalPanel;

public class UI {

	private JFrame _frame;
	private JPanel _panel2;
	private JPanel _panel1;

	private JMenuBar _menuBar;

	private JMenu _fileMenu;
	private JMenu _fractalsMenu;
	private JMenu _colorMenu;

	private JMenuItem _exit;
	private JMenuItem _mandelbrotItem;
	private JMenuItem _juliaItem;
	private JMenuItem _burningShipItem;
	private JMenuItem _multibrotItem;

	private FractalPanel _fractalPanel;
	private MandelbrotSet _mandelbrot;
	private JuliaSet _julia;
	private BurningShip _burningShip;
	private MultibrotSet _multibrot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frame = new JFrame("Fractals");
		_panel1 = new JPanel();
		_panel2 = new JPanel();

		_fractalPanel = new FractalPanel();
		_mandelbrot = new MandelbrotSet();
		_julia = new JuliaSet();
		_burningShip = new BurningShip();
		_multibrot = new MultibrotSet();

		_frame.setBounds(100, 100, 496, 318);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(new GridLayout(2, 1));
		_frame.getContentPane().add(_panel2);
		_frame.getContentPane().add(_panel1);

		_menuBar = new JMenuBar();
		_menuBar.setMargin(null);
		_panel2.add(_menuBar);

		_fileMenu = new JMenu("File");
		_fractalsMenu = new JMenu("Fractals");
		_colorMenu = new JMenu("Colors");

		_menuBar.add(_fileMenu);
		_menuBar.add(_fractalsMenu);
		_menuBar.add(_colorMenu);

		_exit = new JMenuItem("Exit");
		_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		_fileMenu.add(_exit);

		_mandelbrotItem = new JMenuItem("Mandelbrot Set");
		_juliaItem = new JMenuItem("Julia Set");
		_burningShipItem = new JMenuItem("Burning Ship Set");
		_multibrotItem = new JMenuItem("Multibrot Set");

		_mandelbrotItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_mandelbrot.fractals());
			}

		});

		_juliaItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_julia.fractals());
			}

		});

		_burningShipItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_burningShip.fractals());
			}

		});

		_multibrotItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_multibrot.fractals());
			}

		});

		_fractalsMenu.add(_mandelbrotItem);
		_fractalsMenu.add(_juliaItem);
		_fractalsMenu.add(_burningShipItem);
		_fractalsMenu.add(_multibrotItem);
	}
}
