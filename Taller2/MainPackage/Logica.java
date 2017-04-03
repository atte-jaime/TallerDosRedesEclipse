package MainPackage;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import CommonAndroid.*;

public class Logica implements Observer {

	private PApplet app;
	private Comunicacion com;
	private PImage[] interfaz;
	private PImage[] icono;
	private PImage[] iconoP;
	private PImage[] iconoS;
	private PImage[] users;
	private PImage[] enemies;
	private PImage[] orbs;
	// private ArrayList<>
	private PFont fuente;
	private int pantalla;
	private int user;
	private String nombre = "";
	private boolean user1, user2, user3;
	private boolean selected1, selected2, selected3;
	private final String GROUP_ADDRESS;

	public Logica(PApplet app) {
		this.app = app;
		cargarElementos();
		com = new Comunicacion();
		com.addObserver(this);
		new Thread(com).start();
		GROUP_ADDRESS = com.getGROUP_ADDRESS();
		app.textAlign(PApplet.LEFT, PApplet.CENTER);
	}

	@Override
	public void update(Observable obs, Object o) {
		if (o instanceof Anadir) {

		}

		if (o instanceof Nombre) {
			Nombre temp = (Nombre) o;
			if (temp.getPersonaje() == 1) {
				selected1 = true;
			} else if (temp.getPersonaje() == 2) {
				selected2 = true;
			} else if (temp.getPersonaje() == 3) {
				selected3 = true;
			}
		}

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
			seleccionIcono();
			app.imageMode(PApplet.CORNER);
			app.fill(65, 200, 125);
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

		case 4:

			break;

		}
	}

	private void seleccionIcono() {
		if (selected1 == false) {
			if (user1 == true) {
				app.image(iconoP[0], 405, 290);
				user = 1;
			} else {
				app.image(icono[0], 405, 290);
			}
		} else {
			app.image(iconoS[0], 405, 290);

		}

		if (selected2 == false) {
			if (user2 == true) {
				app.image(iconoP[1], 600, 290);
				user = 2;
			} else {
				app.image(icono[1], 600, 290);
			}
		} else {
			app.image(iconoS[1], 600, 290);

		}

		if (selected3 == false) {
			if (user3 == true) {
				app.image(iconoP[2], 795, 290);
				user = 3;
			} else {
				app.image(icono[2], 795, 290);
			}
		} else {
			app.image(iconoS[2], 795, 290);
		}
	}

	private void cargarElementos() {
		fuente = app.createFont("../data/fuentes/ERASDEMI.TTF", 32);
		app.textFont(fuente);

		interfaz = new PImage[4];
		icono = new PImage[3];
		iconoP = new PImage[3];
		iconoS = new PImage[3];

		for (int i = 1; i < 5; i++) {
			interfaz[i - 1] = app.loadImage("../data/interfaz/pag" + (i) + ".png");
		}

		for (int i = 1; i < 4; i++) {
			icono[i - 1] = app.loadImage("../data/personajes/usuario" + i + ".png");
		}

		for (int i = 1; i < 4; i++) {
			iconoP[i - 1] = app.loadImage("../data/personajes/usuario" + i + "p.png");
		}

		for (int i = 1; i < 4; i++) {
			iconoS[i - 1] = app.loadImage("../data/personajes/usuario" + i + "s.png");
		}
	}

	public void key() {
		if (app.key == PApplet.ENTER) {
			if (pantalla >= 0 && pantalla != 1) {
				pantalla++;
			} else if (pantalla == 1 && user != 0 && nombre != "") {
				try {
					com.enviar(new Nombre(nombre, user, com.getId()), GROUP_ADDRESS);
					System.out.println("se envió el nombre");
					pantalla++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (pantalla == 1) {
			entradaNombre();
		}
	}

	public void entradaNombre() {

		if (app.key != PApplet.ENTER && app.key != PApplet.BACKSPACE && app.keyCode != PApplet.RIGHT
				&& app.keyCode != PApplet.LEFT && app.keyCode != 20) {
			nombre += app.key;
		} else if (app.key == PApplet.BACKSPACE && nombre.length() > 0) {
			nombre = nombre.substring(0, nombre.length() - 1);
		}

	}

	public void click() {
		if (pantalla == 1) {
			if (PApplet.dist(app.mouseX, app.mouseY, 450, 290) < 65 && selected1 == false) {
				user1 = true;
				user2 = false;
				user3 = false;
				System.out.println("Usuario # " + user);
			} else if (PApplet.dist(app.mouseX, app.mouseY, 600, 290) < 65 && selected2 == false) {
				user1 = false;
				user2 = true;
				user3 = false;
				System.out.println("Usuario # " + user);
			} else if (PApplet.dist(app.mouseX, app.mouseY, 795, 290) < 65 && selected3 == false) {
				user1 = false;
				user2 = false;
				user3 = true;
				System.out.println("Usuario # " + user);
			}
		}

	}

}
