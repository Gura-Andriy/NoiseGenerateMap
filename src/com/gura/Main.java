package com.gura;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Main {

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final double FEATURE_SIZE = 24;

    public static void main(String[] args) throws IOException {
//        EventQueue.invokeLater(() -> {
//            var ex = new Frame();
//            ex.setVisible(true);
//        });


        PerlinNoise noise = new PerlinNoise((int) (Math.random() * 1000000000));
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                double nx = x / FEATURE_SIZE, ny =y / FEATURE_SIZE;
                double value = noise.noise(nx, ny)
                        + 0.5 * noise.noise(2 * nx, 2 * ny)
                        + 0.25 * noise.noise(4 * nx, 4 * ny);

                int rgb = 0x010101 * (int)((value + 1) * 127.5);
                image.setRGB(x, y, rgb);
            }
        }
        ImageIO.write(image, "png", new File("noise.png"));



    }
}
