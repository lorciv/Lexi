package it.lorciv.lexi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import it.lorciv.lexi.Document;
import it.lorciv.lexi.glyphs.Circle;
import it.lorciv.lexi.glyphs.Diamond;
import it.lorciv.lexi.glyphs.Rectangle;

public class Window {
	
	private JFrame frame;
	
	public Window(Document root, Controller controller) {
		frame = new JFrame("Lexi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setFocusable(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controller.handleKey(e.getKeyChar());
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					controller.handleMove("left");
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					controller.handleMove("right");
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		{
			JMenu fileMenu = new JMenu("File");
			{
				JMenuItem save = new JMenuItem("Save");
				fileMenu.add(save);
			}
			menuBar.add(fileMenu);
			
			JMenu insertMenu = new JMenu("Insert");
			{
				JMenuItem insertRect = new JMenuItem("Rectangle");
				insertMenu.add(insertRect);
				
				JMenuItem insertCircle = new JMenuItem("Circle");
				insertMenu.add(insertCircle);
				
				JMenuItem insertDiam = new JMenuItem("Diamond");
				insertMenu.add(insertDiam);
			}
			menuBar.add(insertMenu);
		}
		frame.setJMenuBar(menuBar);
		
		JPanel contentPane = new JPanel(new BorderLayout());
		{
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.add(new DocumentView(root, controller), BorderLayout.CENTER);
		}
		frame.setContentPane(contentPane);
		
		frame.setVisible(true);
	}

}
