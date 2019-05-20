package tair2200MV.note.main;

import tair2200MV.note.controller.NoteController;
import tair2200MV.note.model.Corigent;
import tair2200MV.note.model.Medie;
import tair2200MV.note.model.Nota;
import tair2200MV.note.validator.ClasaException;
//import tair2200MV.note.model.Nota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


//functionalitati
//F01.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata);
//F02.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol),
//F03.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat ?i alfabetic dupa nume.


public class StartApp {

	public static NoteController lastCtrl = null;
	public static List<Medie> lastMedii;
	public static List<Corigent> lastCorigenti;

	/**
	 * @param args
	 * @throws ClasaException
	 */
	public static void main(String[] args) throws ClasaException {
		// TODO Auto-generated method stub
		NoteController ctrl = new NoteController();
		List<Medie> medii ;
		List<Corigent> corigenti;
		ctrl.readElevi(args[0]);
		ctrl.readNote(args[1]);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		boolean gasit = false;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		while(!gasit) {
			System.out.println("1. Adaugare Nota");
			System.out.println("2. Calculeaza medii");
			System.out.println("3. Elevi corigenti");
			System.out.println("4. Iesire");
		    try {
				int option = Integer.parseInt(br.readLine());
				switch(option) {
				case 1:
					System.out.println("Numar matricol: ");
						int nrmatricol = Integer.parseInt(br.readLine());
					System.out.println("Materie:");
						String materie = br.readLine();
					System.out.println("Nota:");
						int notaval = Integer.parseInt(br.readLine());
						Nota nota = new Nota(nrmatricol,materie,notaval);
						ctrl.addNota(nota);
						break;
				case 2: medii = ctrl.calculeazaMedii();
						lastMedii = medii;
						for(Medie medie:medii)
							System.out.println(medie.getMedie());
						break;
				case 3: corigenti = ctrl.getCorigenti();
						lastCorigenti = corigenti;
						for(Corigent corigent:corigenti)
							System.out.println(corigent);
						break;
				case 4: gasit = true;
						break;
				default: System.out.println("Introduceti o optiune valida!");
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lastCtrl = ctrl;
	}

}
