package tair2200MV.note.model;

public class Nota {
	
	private int nrMatricol; // it was before double - refactor the class
	private String materie; // unde e specificat ca materia are intre 5 si 20 de caractere nu stiu ...
	private double nota; //schimbat din double in int pentru ca validarea cerea int si nu avea sens...
	                  // refactorizat mai jos
	
	public Nota(int nrMatricol, String materie, double nota) {
		this.setNrMatricol(nrMatricol);
		this.setMaterie(materie);
		this.setNota(nota);
	}

	/**
	 * @return the nrMatricol
	 */
	public int getNrMatricol() {
		return nrMatricol;
	}

	/**
	 * @param nrMatricol the nrMatricol to set
	 */
	public void setNrMatricol(int nrMatricol) {
		this.nrMatricol = nrMatricol;
	}

	/**
	 * @return the materie
	 */
	public String getMaterie() {
		return materie;
	}

	/**
	 * @param materie the materie to set
	 */
	public void setMaterie(String materie) {
		this.materie = materie;
	}

	/**
	 * @return the nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
