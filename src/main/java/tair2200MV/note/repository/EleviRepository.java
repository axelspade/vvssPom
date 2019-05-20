package tair2200MV.note.repository;

import tair2200MV.note.model.Elev;

import java.util.List;


public interface EleviRepository {
	void addElev(Elev e);
	List<Elev> getElevi();
	void readElevi(String f); //f - input file .txt
}
