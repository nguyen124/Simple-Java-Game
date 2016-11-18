package com.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseButton = -1;

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		mouseButton = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		mouseButton = -1;
	}

	public static int getX() {
		return mouseX;
	}

	public static void setX(int mouseX) {
		Mouse.mouseX = mouseX;
	}

	public static int getY() {
		return mouseY;
	}

	public static void setY(int mouseY) {
		Mouse.mouseY = mouseY;
	}

	public static int getButton() {
		return mouseButton;
	}

	public static void setButton(int mouseB) {
		Mouse.mouseButton = mouseB;
	}

}
