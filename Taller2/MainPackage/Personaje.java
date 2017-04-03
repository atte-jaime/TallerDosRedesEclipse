package MainPackage;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

public abstract class Personaje {

	private PApplet app;
	private PImage personaje;
	private PVector pos;
	private PVector vel;
	private PVector ace;
	private float fuerzaMax;
	private float velMax;

	public Personaje(PImage p, PApplet app) {
		this.app = app;
		vel = new PVector(0, 0);
		ace = new PVector(0, 0);
		pos = new PVector(app.width / 2, app.height / 2);
		fuerzaMax = (float) 0.1;
		velMax = 5;
		personaje = p;
	}

	public void actualizar() {
		vel.add(ace);
		vel.limit(velMax);
		pos.add(vel);
		ace.mult(0);
	}

	private void aplicarFuerza(PVector fuerza) {
		ace.add(fuerza);
	}
	
	 void mover() {
		// TODO Auto-generated method stub

	}

	/*public void perseguir() {
		PVector objetivo = new PVector(app.mouseX, app.mouseY);
		PVector distancia = PVector.sub(objetivo, pos);
		float d = distancia.mag();
		distancia.normalize();
		if (d < 100) {
			float m = PApplet.map(d, 0, 100, 0, velMax);
			distancia.mult(m);
		} else {
			distancia.mult(velMax);
		}

		PVector direccion = PVector.sub(distancia, vel);
		direccion.limit(fuerzaMax);
		aplicarFuerza(direccion);
	}*/

	public void pintar() {
		app.imageMode(PApplet.CENTER);
		app.image(personaje, pos.x, pos.y);
		app.imageMode(PApplet.CORNER);
		
	}

	public PVector getPos() {
		return pos;
	}


	public boolean validarDist(int x, int y) {
		if (PApplet.dist(x, y, pos.x, pos.y) < 50) {
			return true;
		} else {
			return false;
		}
	}

}
