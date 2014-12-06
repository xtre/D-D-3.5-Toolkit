package com.ezreb.graphics.HUD;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Healthbar extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1586260475434936946L;

	public Healthbar() {
		this(100, 0);
	}
	public Healthbar(int maxHealth) {
		this(maxHealth, 0);
	}
	public Healthbar(int maxHealth, int curHealth) {
		this.setPreferredSize(new Dimension(200, 20));
		this.setSize(new Dimension(200, 20));
		this.setVisible(true);
		this.g = (Graphics2D) this.getGraphics();
		this.setVisible(false);
		try {
			this.health = new Rectangle(0, 0, (int) Math.abs((curHealth/maxHealth)*200), 20);
		} catch(ArithmeticException e) {
			this.health = new Rectangle(0, 0, 1, 20);
		}
		g.setColor(new Color(255, 5, 5));
		g.fillRect(0, 0, health.width, health.height);
		MouseListener l = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				draw();
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				getGraphics().drawString("Health", 0, 0);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseListener(l);
	}
	private Graphics2D g;
	private Rectangle health;
	private int maxHealth;
	private int curHealth;
	private void draw() {
		g.clearRect(0, 0, 200, 20);
		if(this.curHealth>0) {
			this.health = new Rectangle(0, 0, (int) Math.abs((curHealth/maxHealth)*200), 20);
			g.setColor(Color.red);
			g.fillRect(0, 0, health.width, health.height);
		}
	}
	public Healthbar setHealthMax(int h) {
		this.maxHealth = h;
		draw();
		return this;
	}
	public Healthbar setHealth(int h) {
		this.curHealth = h;
		draw();
		return this;
	}

}
