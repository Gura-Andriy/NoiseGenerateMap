package com.gura;

import com.gura.classes.NoiseMapMaker;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

    NoiseMapMaker imageMaker = new NoiseMapMaker(512, 512, 24);
    imageMaker.imageMap();
    imageMaker.imageWrite();
    }
}
