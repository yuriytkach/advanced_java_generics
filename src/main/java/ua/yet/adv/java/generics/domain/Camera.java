package ua.yet.adv.java.generics.domain;

import java.io.Serializable;

public class Camera extends Product<Camera> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int pixel;

	public Camera(String name) {
		super(name);
	}

	@Override
	protected int deepCompare(Camera camera) {
	    return (camera != null) ? pixel - camera.getPixel() : -1;
	}

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

	
}
