package MainPackage;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("MainPackage.Main");
	}

	public void settings() {
		size(1200, 675);
	}

	Logica log;

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		background(255);
		log.ejecutar();
	}
	
	public void keyPressed(){
	log.key();	
	}
	
	public void mousePressed() {
		log.click();
	}

}

