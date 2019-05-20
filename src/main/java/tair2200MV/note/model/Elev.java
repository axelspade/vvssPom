package tair2200MV.note.model;

public class Elev {
	private int nrMatricol;
	private String nume;
	//medie
	
	public Elev(int nrMatricol, String nume) {
		this.setNrMatricol(nrMatricol);
		this.setNume(nume);
	}

	public int getNrMatricol() {
		return nrMatricol;
	}

	public void setNrMatricol(int nrmatricol) {
		this.nrMatricol = nrmatricol;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	
	
	public String toString() {
		return this.nrMatricol + " " + this.nume;
	}
	
}
