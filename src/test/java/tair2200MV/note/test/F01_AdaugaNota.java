package tair2200MV.note.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tair2200MV.note.controller.NoteController;
import tair2200MV.note.model.Nota;
import tair2200MV.note.utils.Constants;
import tair2200MV.note.validator.ClasaException;


import static junit.framework.TestCase.assertEquals;

public class F01_AdaugaNota {

    private NoteController ctrl;

    @Before
    public void init(){ ctrl = new NoteController();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void  ECP_valid() throws ClasaException
    {
        Nota nota = new Nota(5,"Matematica",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  ECP_invalid_01() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        Nota nota = new Nota(5,"Matematica",-1);
        ctrl.addNota(nota);
    }

    @Test
    public void  ECP_invalid_02() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(5,"Matematica",8.9);
        ctrl.addNota(nota);
    }

    @Test
    public void  ECP_invalid_04() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(5,"MatematicaMatematicaMatematica",10);
        ctrl.addNota(nota);
    }


    @Test
    public void  ECP_invalid_05() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNrmatricol);
        Nota nota = new Nota(10002,"Matematica",8);
        ctrl.addNota(nota);
    }


    @Test
    public void  BVA_invalid_01() throws ClasaException
    {
        Nota nota = new Nota(1,"Matematica",1);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_02() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(1,"Matematica",0);
        ctrl.addNota(nota);
        assertEquals(0,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_03() throws ClasaException
    {
        Nota nota = new Nota(1,"Matematica",2);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_04() throws ClasaException
    {
        Nota nota = new Nota(1,"Matematica",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_05() throws ClasaException
    {
        Nota nota = new Nota(1,"Matematica",9);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_06() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNota);
        Nota nota = new Nota(1,"Matematica",11);
        ctrl.addNota(nota);
    }

    @Test
    public void  BVA_invalid_07() throws ClasaException
    {
        Nota nota = new Nota(1,"Informatica",6);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_08() throws ClasaException
    {
        Nota nota = new Nota(2,"Informatica",6);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_09() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNrmatricol);
        Nota nota = new Nota(0,"Matematica",8);
        ctrl.addNota(nota);
    }

    @Test
    public void  BVA_invalid_10() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNrmatricol);
        Nota nota = new Nota(1001,"Engleza",8);
        ctrl.addNota(nota);
    }


    @Test
    public void  BVA_invalid_11() throws ClasaException
    {
        Nota nota = new Nota(1000,"Engleza",8);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_12() throws ClasaException
    {
        Nota nota = new Nota(999,"Engleza",8);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_13() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(5,"Mate",10);
        ctrl.addNota(nota);
    }

    @Test
    public void  BVA_invalid_14() throws ClasaException
    {
        Nota nota = new Nota(5,"Matem",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_15() throws ClasaException
    {
        Nota nota = new Nota(5,"Matema",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_16() throws ClasaException
    {
        Nota nota = new Nota(5,"MatematicaMatematica",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_17() throws ClasaException
    {
        Nota nota = new Nota(5,"MatematicaMatematic",10);
        ctrl.addNota(nota);
        assertEquals(1,ctrl.getNote().size());
    }

    @Test
    public void  BVA_invalid_18() throws ClasaException
    {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidMateria);
        Nota nota = new Nota(5,"MatematicaMatematicaM",10);
        ctrl.addNota(nota);
    }





}
