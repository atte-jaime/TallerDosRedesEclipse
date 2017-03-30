package MainPackage;

import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {

	private PApplet app;
	
	public Logica(PApplet app) {
		this.app=app;
	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	
	public void ejecutar(){
		
	}
	
	public void pintar(){
		
	}

}
