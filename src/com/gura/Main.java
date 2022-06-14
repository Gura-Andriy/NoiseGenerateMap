package com.gura;

import com.gura.classes.NoiseMapMaker;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

    NoiseMapMaker imageMaker = new NoiseMapMaker(2048, 2048, 50);
    imageMaker.imageMap();
    imageMaker.imageWrite();
    }
}
