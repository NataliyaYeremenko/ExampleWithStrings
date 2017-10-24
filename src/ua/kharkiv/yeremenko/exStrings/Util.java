package ua.kharkiv.yeremenko.exStrings;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Nataliya on 18.07.2017.
 */
public class Util {
    private static final String ENCODING = "UTF8";
    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }
}
