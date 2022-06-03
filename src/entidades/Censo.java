package entidades;

import java.util.ArrayList;
import java.util.List;

public class Censo {

	private RadioCensal radioCensal;
	private List<Censista> censistas;

	public Censo() {
		this.censistas = new ArrayList<Censista>();
		this.radioCensal = new RadioCensal();
	}

	public RadioCensal getRadioCensal() {
		return radioCensal;
	}

	public List<Censista> getCensistas() {
		return censistas;
	}

}
