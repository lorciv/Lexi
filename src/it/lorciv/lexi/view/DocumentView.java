package it.lorciv.lexi.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import it.lorciv.lexi.Document;
import it.lorciv.lexi.util.Observer;
import it.lorciv.lexi.util.Point;

public class DocumentView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private Document document;
	
	public DocumentView(Document document, Controller controller) {
		this.document = document;
		this.document.attach(this);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.handleMouse(new Point(e.getX(), e.getY()));
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		document.draw(g, new Point(0, 0));
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(document.getWidth(), document.getHeight());
	}

	@Override
	public void update() {
		this.repaint();
	}

}
