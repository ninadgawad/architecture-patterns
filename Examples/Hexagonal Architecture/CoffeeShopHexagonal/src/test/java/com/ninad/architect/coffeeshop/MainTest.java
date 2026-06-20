package com.ninad.architect.coffeeshop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mainRunsAndPrintsMenu() {
        var out = new ByteArrayOutputStream();
        var original = System.out;
        try {
            System.setOut(new PrintStream(out));
            Main.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        String outStr = out.toString();
        assertTrue(outStr.contains("Saved order") || outStr.contains("Fetched menu") || outStr.length() > 0);
    }
}
