package it.lorciv.lexi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.lorciv.lexi.Circle;
import it.lorciv.lexi.Column;
import it.lorciv.lexi.Diamond;
import it.lorciv.lexi.Glyph;
import it.lorciv.lexi.Rectangle;
import it.lorciv.lexi.Row;

public class Window {
	
	private JFrame frame;
	private Glyph root, curRow;
	
	public Window() {
		
		root = new Column();
		curRow = new Row();
		root.add(curRow);
		
		frame = new JFrame("Lexi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		{
			JPanel contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel buttonPane = new JPanel();
				{
					JButton btnChar = new JButton("Character");
					btnChar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Random rand = new Random();
							int code = 'a' + rand.nextInt(25);
							curRow.add(new it.lorciv.lexi.Character((char)code));
							contentPane.repaint();
							System.out.println("pressed character");
						}
					});
					buttonPane.add(btnChar);
					
					JButton btnCircle = new JButton("Circle");
					btnCircle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							curRow.add(new Circle(30+rand.nextInt(20)));
							contentPane.repaint();
							System.out.println("pressed circle");
						}
					});
					buttonPane.add(btnCircle);
					
					JButton btnRect = new JButton("Rectangle");
					btnRect.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							curRow.add(new Rectangle(30+rand.nextInt(10), 20+rand.nextInt(10)));
							contentPane.repaint();
							System.out.println("pressed rectangle");
						}
					});
					buttonPane.add(btnRect);
					
					JButton btnDiam = new JButton("Diamond");
					btnDiam.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Random rand = new Random();
							curRow.add(new Diamond(50+rand.nextInt(50), 50+rand.nextInt(50)));
							contentPane.repaint();
							System.out.println("pressed rectangle");
						}
					});
					buttonPane.add(btnDiam);
					
					JButton btnNewline = new JButton("Newline");
					btnNewline.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Row r = new Row();
							root.add(r);
							curRow = r;
							System.out.println("newline");
						}
					});
					buttonPane.add(btnNewline);
				}
				contentPane.add(buttonPane, BorderLayout.NORTH);
				
				contentPane.add(new GlyphView(root), BorderLayout.CENTER);
			}
			frame.setContentPane(contentPane);
		}
		frame.setVisible(true);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Window();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
