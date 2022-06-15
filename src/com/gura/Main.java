package com.gura;

import com.gura.classes.*;
import com.gura.interfaces.Map;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

    Map imageMaker = new IslandMap(2048, 2048, 50);
    imageMaker.generateImage();
    imageMaker.imageWrite();
    }
}
