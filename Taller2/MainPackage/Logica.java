package MainPackage;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Logica implements Observer {

	private PApplet app;
	private PImage[] interfaz;
	private PImage[] icono;
	private PImage[] iconoP;
	private PFont fuente;
	private int pantalla;
	private int user;
	private String nombre="";
	private boolean user1, user2, user3;

	public Logica(PApplet app) {
		this.app = app;
		cargarElementos();
		app.textAlign(PApplet.LEFT, PApplet.CENTER);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void ejecutar() {
		pantallas();
	}

	public void pantallas() {
		switch (pantalla) {
		case 0:
			app.image(interfaz[0], 0, 0);
			break;

		case 1:
			app.image(interfaz[1], 0, 0);
			app.imageMode(PApplet.CENTER);
			if (user1 == true) {
				app.image(iconoP[0], 405, 290);
				user = 1;
			} else {
				app.image(icono[0], 405, 290);
			}

			if (user2 == true) {
				app.image(iconoP[1], 600, 290);
				user = 2;
			} else {
				app.image(icono[1], 600, 290);
			}

			if (user3 == true) {
				app.image(iconoP[2], 795, 290);
				user = 3;
			} else {
				app.image(icono[2], 795, 290);
			}

			app.imageMode(PApplet.CORNER);
			app.fill(65,200,125);
			app.textSize(25);
			app.text(nombre, 431, 525);
			app.noFill();
			break;

		case 2:
			app.image(interfaz[2], 0, 0);
			break;

		case 3:
			app.image(interfaz[3], 0, 0);
			break;

		}
	}

	private void cargarElementos() {
		fuente = app.createFont("../data/fuentes/ERASDEMI.TTF", 32);
		app.textFont(fuente);

		interfaz = new PImage[4];
		icono = new PImage[3];
		iconoP = new PImage[3];

		for (int i = 1; i < 5; i++) {
			interfaz[i - 1] = app.loadImage("../data/interfaz/pag" + (i) + ".png");
		}

		for (int i = 1; i < 4; i++) {
			icono[i - 1] = app.loadImage("../data/personajes/usuario" + i + ".png");
		}

		for (int i = 1; i < 4; i++) {
			iconoP[i - 1] = app.loadImage("../data/personajes/usuario" + i + "p.png");
		}
	}

	public void key() {
		if (app.key == PApplet.ENTER) {
			if (pantalla >= 0 &&  pantalla !=1) {
				pantalla++;
			} else if (pantalla == 1 && user!=0 && nombre!="") {
				pantalla++;
			}
		}
		
		if (pantalla==1) {
			entradaNombre();
		}
	}

	public void entradaNombre() {

		if (app.key != PApplet.ENTER && app.key != PApplet.BACKSPACE && app.keyCode != PApplet.RIGHT
				&& app.keyCode != PApplet.LEFT && app.keyCode != 20) {
			nombre += app.key;
		} else if (app.key == PApplet.BACKSPACE && nombre.length()>0) {
			nombre = nombre.substring(0, nombre.length() - 1);
		}

	}

	public void click() {
		if (PApplet.dist(app.mouseX, app.mouseY, 450, 290) < 65) {
			user1 = true;
			user2 = false;
			user3 = false;
			System.out.println("Usuario # " + user);
		} else if (PApplet.dist(app.mouseX, app.mouseY, 600, 290) < 65) {
			user1 = false;
			user2 = true;
			user3 = false;
			System.out.println("Usuario # " + user);
		} else if (PApplet.dist(app.mouseX, app.mouseY, 795, 290) < 65) {
			user1 = false;
			user2 = false;
			user3 = true;
			System.out.println("Usuario # " + user);
		}

	}

}
