package tair2200MV.note.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tair2200MV.note.model.Elev;
import tair2200MV.note.model.Medie;
import tair2200MV.note.model.Nota;
import tair2200MV.note.repository.ClasaRepositoryMock;
import tair2200MV.note.repository.EleviRepositoryMock;
import tair2200MV.note.repository.NoteRepositoryMock;
import tair2200MV.note.validator.ClasaException;

import java.util.HashMap;
import java.util.List;


public class F02_CalculMedii {

    private ClasaRepositoryMock clasaRepositoryMock;
    private EleviRepositoryMock eleviRepositoryMock;
    private NoteRepositoryMock noteRepositoryMock;
    private HashMap<Elev, HashMap<String, List<Double>>> clasa;
    private List<Elev> elev;
    private List<Nota> note;

    @Before
    public void init() {
        clasaRepositoryMock = new ClasaRepositoryMock();
        noteRepositoryMock = new NoteRepositoryMock();
        eleviRepositoryMock = new EleviRepositoryMock();

    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void F02_TC02() throws ClasaException {
        eleviRepositoryMock.readElevi("eleviTest1.txt");
        noteRepositoryMock.readNote("note.txt");
        elev = eleviRepositoryMock.getElevi();
        note = noteRepositoryMock.getNote();
        clasaRepositoryMock.creazaClasa(elev,note);
        clasa = clasaRepositoryMock.getClasa();
        List<Medie> rezultate = clasaRepositoryMock.calculeazaMedii();
        Assert.assertEquals(rezultate.size(),0);
    }

    @Test
    public void F02_TC04() throws ClasaException {
        eleviRepositoryMock.readElevi("eleviTest2.txt");
        noteRepositoryMock.readNote("note2.txt");
        elev = eleviRepositoryMock.getElevi();
        note = noteRepositoryMock.getNote();
        clasaRepositoryMock.creazaClasa(elev,note);
        clasa = clasaRepositoryMock.getClasa();
        List<Medie> rezultate = clasaRepositoryMock.calculeazaMedii();
        Assert.assertEquals(rezultate.size(),2);
    }


    @Test
    public void F02_TC05() throws ClasaException {
        eleviRepositoryMock.readElevi("eleviTest2.txt");
        noteRepositoryMock.readNote("note.txt");
        elev = eleviRepositoryMock.getElevi();
        note = noteRepositoryMock.getNote();
        clasaRepositoryMock.creazaClasa(elev,note);
        clasa = clasaRepositoryMock.getClasa();
        List<Medie> rezultate = clasaRepositoryMock.calculeazaMedii();
        Assert.assertEquals(rezultate.size(),2);
    }



}
