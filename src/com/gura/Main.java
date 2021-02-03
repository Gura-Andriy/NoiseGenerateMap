package com.gura;

import com.gura.Enums.Biomes;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import static java.lang.Math.*;

public class Main {

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final double FEATURE_SIZE = 24;

    public static void main(String[] args) throws IOException {

        PerlinNoise noise = new PerlinNoise((int) (Math.random() * 1000000000));
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                double nx = x / FEATURE_SIZE - (FEATURE_SIZE * 0.43),
                        ny = y / FEATURE_SIZE - (FEATURE_SIZE * 0.43);

                double d = sqrt(nx*nx + ny*ny) / sqrt(60);
                d = pow(d, 1.5);

                double e = noise.noise( nx, ny)
                        + 0.5 * noise.noise(2 * nx, 2 * ny)
                        + 0.25 * noise.noise(4 * nx, 4 * ny);
                e = (1 + e - d) / 2;
                double value = pow(e, 2);

//                int rgb = 0x0000FF * (int)((value + 1) * 127.5);
//                if (e < 0.15) rgb = 0x90CCFB;

                Biomes bioms = new Biom().biome(e, value);
                int rgb = bioms.getBiom();

                image.setRGB(x, y, rgb);
            }
        }
        ImageIO.write(image, "png", new File("map.png"));



    }
}
