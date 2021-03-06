package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Grafo<X, Y> {

	private HashMap<X, HashMap<X, Y>> vertices;
	private List<Arista<X, Y>> aristas;

	public Grafo() {
		this.vertices = new HashMap<X, HashMap<X, Y>>();
		this.aristas = new ArrayList<Arista<X, Y>>();
	}

	public void agregarVertice(X vertice) {
		if (vertices.containsKey(vertice))
			throw new IllegalArgumentException("Ya existe el vertice en el Grafo");
		vertices.put(vertice, new HashMap<X, Y>());
	}

	public void agregarArista(X vertice1, X vertice2, Y peso) {
		verificarArista(vertice1, vertice2);
		vertices.get(vertice1).put(vertice2, peso);
		vertices.get(vertice2).put(vertice1, peso);
		aristas.add(new Arista<X, Y>(vertice1, vertice2, peso));
	}

	public boolean existeArista(X vertice1, X vertice2) {
		verificarArista(vertice1, vertice2);
		return vertices.get(vertice1).get(vertice2) != null;
	}

	public boolean existeVertice(X vertice) {
		return vertices.get(vertice) != null;
	}

	public Y peso(X vertice1, X vertice2) {
		verificarArista(vertice1, vertice2);
		if (!existeArista(vertice1, vertice2))
			throw new IllegalArgumentException("No existe la arista: (" + vertice1 + ";" + vertice2 + ")");
		return vertices.get(vertice1).get(vertice2);
	}

	public Set<X> vertices() {
		return vertices.keySet();
	}

	public Set<X> vecinos(X vertice) {
		if (!vertices.containsKey(vertice))
			throw new IllegalArgumentException("No existe el vertice: " + vertice);
		return vertices.get(vertice).keySet();
	}

	public List<Arista<X, Y>> aristas() {
		return this.aristas;
	}

	public int maxVecinos() {
		int max = 0;
		for (X vertice : vertices())
			if (vecinos(vertice).size() >= max)
				max = vecinos(vertice).size();
		return max;
	}

	public int tamanio() {
		return vertices().size();
	}

	private void verificarArista(X vertice1, X vertice2) {
		if (!vertices.containsKey(vertice1) || !vertices.containsKey(vertice2))
			throw new IllegalArgumentException("El/Los vertices no existen");

		if (vertice1.equals(vertice2))
			throw new IllegalArgumentException("No se permiten loops");

	}

	@Override
	public String toString() {
		String ret = "";
		for (X vertice : vertices.keySet()) {
			String vecinos = "{";
			ret = ret + vertice + ": ";
			for (X vecino : vecinos(vertice)) {
				vecinos = vecinos + vecino + ",";
			}
			ret = ret + vecinos + "} // \n";
		}
		return ret;
	}
}
