package CommonAndroid;

import java.io.Serializable;

public class Añadir implements Serializable {
	
	// el tipo representa si es un orbe o un depredador
	// el receptor es el usuario
	
    private int receptor;
    private int tipo;

    public Añadir(int receptor, int tipo) {
        this.receptor = receptor;
        this.tipo = tipo;

    }

    public int getReceptor() {
        return receptor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
