package tair2200MV.note.repository;



import tair2200MV.note.validator.ClasaException;
import tair2200MV.note.model.Corigent;
import tair2200MV.note.model.Elev;
import tair2200MV.note.model.Medie;
import tair2200MV.note.model.Nota;

import java.util.HashMap;
import java.util.List;

public interface ClasaRepository {
	void creazaClasa(List<Elev> e, List<Nota> n);
	HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	List<Medie> calculeazaMedii() throws ClasaException;
	void afiseazaClasa();
	List<Corigent> getCorigenti();
}
