package tair2200MV.note.repository;

import tair2200MV.note.validator.ClasaException;
import tair2200MV.note.model.Nota;

import java.util.List;


public interface NoteRepository {
	//deeted public acces modifier
	void addNota(Nota n) throws ClasaException;
	List<Nota> getNote();
	void readNote(String f); // f input file .txt
	
}
