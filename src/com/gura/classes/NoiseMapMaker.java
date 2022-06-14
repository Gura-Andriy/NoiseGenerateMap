package com.gura.classes;

import com.gura.Enums.Biomes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class NoiseMapMaker {
    private int height;
    private int width;
    private int featureSize;

    private PerlinNoise noise;
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public NoiseMapMaker(int height, int width, int featureSize) {
        this.height = height;
        this.width = width;
        this.featureSize = featureSize;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        noise = new PerlinNoise((int) (Math.random() * 1000000000));
    }

    public void imageMap() {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                double nx = x / featureSize - (featureSize * 0.4208),
                        ny = y / featureSize - (featureSize * 0.4208);

                double d = sqrt(nx*nx + ny*ny) / sqrt(150);
                d = pow(d, 1.5);

                double e = noise.noise( nx, ny)
                        + 0.5 * noise.noise(2 * nx, 2 * ny)
                        + 0.25 * noise.noise(4 * nx, 4 * ny)
                        + 0.125 * noise.noise(8 * nx, 8 * ny)
                        + 0.0625 * noise.noise(16 * nx, 16 * ny)
                        + 0.03125 * noise.noise(32 * nx, 32 * ny)
                        + 0.015625 * noise.noise(64 * nx, 64 * ny)
                        + 0.0078125 * noise.noise(128 * nx, 128 * ny)
                        + 0.00390625 * noise.noise(256 * nx, 256 * ny);
                e = (1 + e - d) / 2;
                double value = pow(e, 1.01);

                Biomes bioms = new Biom().biome(e, value);
                int rgb = bioms.getBiom();

                image.setRGB(x, y, rgb);
            }
        }
    }

    public void imageWrite() throws IOException {
        ImageIO.write(getImage(), "png", new File("map.png"));
    }
}
