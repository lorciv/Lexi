package it.lorciv.lexi.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.lorciv.lexi.Circle;
import it.lorciv.lexi.Composition;
import it.lorciv.lexi.Diamond;
import it.lorciv.lexi.Glyph;
import it.lorciv.lexi.Rectangle;
import it.lorciv.lexi.contr.Controller;

public class Window implements KeyListener {
	
	private JFrame frame;
	private Controller controller;
	
	public Window(Composition root) {
		frame = new JFrame("Lexi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setFocusable(true);
		frame.addKeyListener(this);
		{
			JPanel contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel buttonPane = new JPanel();
				{	
					JButton btnCircle = new JButton("Circle");
					btnCircle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							root.add(new Circle(30+rand.nextInt(20)));
							contentPane.repaint();
							System.out.println("pressed circle");
						}
					});
					buttonPane.add(btnCircle);
					
					JButton btnRect = new JButton("Rectangle");
					btnRect.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							root.add(new Rectangle(30+rand.nextInt(10), 20+rand.nextInt(10)));
							contentPane.repaint();
							System.out.println("pressed rectangle");
						}
					});
					buttonPane.add(btnRect);
					
					JButton btnDiam = new JButton("Diamond");
					btnDiam.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							root.add(new Diamond(50+rand.nextInt(50), 50+rand.nextInt(50)));
							contentPane.repaint();
							System.out.println("pressed rectangle");
						}
					});
					buttonPane.add(btnDiam);
				}
				contentPane.add(buttonPane, BorderLayout.NORTH);
				
				contentPane.add(new GlyphPanel(root), BorderLayout.CENTER);
			}
			frame.setContentPane(contentPane);
		}
		frame.setVisible(true);
	}

	public void setController(Controller c) {
		this.controller = c;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		System.out.println("pressed key '" + c + "'");
		
		if (controller == null) {
			return;
		}
		controller.handleKey(c);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
