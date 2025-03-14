package it.exolab.aero;

import it.exolab.aero.utils.customUtils.constants.airport_01.DataPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(DataPaths.FILE_DATA_PATH + "aeroporti.txt");
            String contenuto = String.join(" ", Files.readAllLines(path));

            contenuto = contenuto.replace("\n", "").replace("\r", "").replace("\t", "");;

            System.out.println(contenuto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
