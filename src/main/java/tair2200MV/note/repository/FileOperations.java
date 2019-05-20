package tair2200MV.note.repository;

import java.io.*;

public class FileOperations {

    static BufferedReader openFileToRead(String fisier) throws FileNotFoundException {
        FileInputStream fstream = new FileInputStream(fisier);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        return br;
    }
}
