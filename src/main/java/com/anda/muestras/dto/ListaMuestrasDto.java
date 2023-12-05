package com.anda.muestras.dto;

import java.util.ArrayList;

public class ListaMuestrasDto {

	private ArrayList<MuestraDtoPost> muestras;

	public ListaMuestrasDto() {
		
	}
	
	public ArrayList<MuestraDtoPost> getMuestras() {
		return muestras;
	}

	public void setMuestras(ArrayList<MuestraDtoPost> muestras) {
		this.muestras = muestras;
	}
	
}
