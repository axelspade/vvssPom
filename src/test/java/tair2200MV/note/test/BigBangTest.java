package tair2200MV.note.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import sun.nio.cs.StreamDecoder;
import tair2200MV.note.controller.NoteController;
import tair2200MV.note.main.StartApp;
import tair2200MV.note.repository.ClasaRepositoryMock;
import tair2200MV.note.repository.NoteRepositoryMock;
import tair2200MV.note.validator.ClasaException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class BigBangTest {

    private static byte[] oprire = ("0" + System.lineSeparator()).getBytes();
    private ClasaRepositoryMock clasaRepositoryMock;
    private NoteRepositoryMock noteRepositoryMock;

    @Before
    public void init() {
        clasaRepositoryMock = new ClasaRepositoryMock();
    }

   @Test
   public void runBigBang(){
        Result result = JUnitCore.runClasses(BigBang_IntegrationsSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    @Test
    public void runTopDown() throws ClasaException {
        String args[] = {"elevi.txt","note.txt"};

        System.setIn(new ByteArrayInputStream((
                "1" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "trist" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                "4" + System.lineSeparator()
        ).getBytes()));
        StartApp.main(args);

        NoteController lastCtrl = StartApp.lastCtrl;

        Assert.assertEquals(7,lastCtrl.getNote().size());

        System.setIn(new ByteArrayInputStream((
                "2" + System.lineSeparator() +
                        "4" + System.lineSeparator()
        ).getBytes()));
        StartApp.main(args);

        Assert.assertEquals(3,StartApp.lastMedii.size());

        System.setIn(new ByteArrayInputStream((
                "3" + System.lineSeparator() +
                        "4" + System.lineSeparator()
        ).getBytes()));
        StartApp.main(args);

        Assert.assertEquals(1,StartApp.lastCorigenti.size());
    }
}
