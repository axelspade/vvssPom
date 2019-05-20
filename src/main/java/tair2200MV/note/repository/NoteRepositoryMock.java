package tair2200MV.note.repository;

import tair2200MV.note.validator.ClasaException;
import tair2200MV.note.model.Nota;
import tair2200MV.note.utils.Constants;

import java.io.*;
import java.util.LinkedList;
import java.util.List;



public class NoteRepositoryMock implements NoteRepository{
	private List<Nota> note;
	
	public NoteRepositoryMock() {
		note = new LinkedList<Nota>();
	}


	@Override
	public void addNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(!validareNota(nota))
			return;
		note.add(nota);
	}

	private boolean validareNota(Nota nota) throws ClasaException {
		// TODO Auto-generated method stub
		if(nota.getMaterie().length() < 5 || nota.getMaterie().length() > 20)
			throw new ClasaException(Constants.invalidMateria);
		if(nota.getNrMatricol() < Constants.minNrmatricol || nota.getNrMatricol() > Constants.maxNrmatricol)
			throw new ClasaException(Constants.invalidNrmatricol);
		if(nota.getNota() < Constants.minNota || nota.getNota() > Constants.maxNota)
			throw new ClasaException(Constants.invalidNota);
		if(nota.getNota() != (int)nota.getNota())
			throw new ClasaException(Constants.invalidNota);
		return true;
	}

	@Override
	public List<Nota> getNote() {
		// TODO Auto-generated method stub
		return note;
	}
	
	public void readNote(String fisier) {
		try {

			BufferedReader br = FileOperations.openFileToRead(fisier);
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Nota nota = new Nota(Integer.valueOf(values[0]), values[1], (int) Double.parseDouble(values[2]));
				//note.add(nota);
				addNota(nota);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClasaException e) {
			e.printStackTrace();
		}
	}
	

}
