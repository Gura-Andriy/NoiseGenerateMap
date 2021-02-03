package com.gura;

import com.gura.Enums.Biomes;

public class Biom {
    Biomes biome(double e, double m) {
        if (e < 0.1) return Biomes.OCEAN;
        if (e < 0.12) return Biomes.BEACH;

        if (e > 0.8) {
            if (m < 0.1) return Biomes.SCORCHED;
            if (m < 0.2) return Biomes.BARE;
            if (m < 0.5) return Biomes.TUNDRA;
            return Biomes.SNOW;
        }

        if (e > 0.6) {
            if (m < 0.33) return Biomes.TEMPERATE_DESERT;
            if (m < 0.66) return Biomes.SHRUBLAND;
            return Biomes.TAIGA;
        }

        if (e > 0.3) {
            if (m < 0.16) return Biomes.TEMPERATE_DESERT;
            if (m < 0.50) return Biomes.GRASSLAND;
            if (m < 0.83) return Biomes.TEMPERATE_DECIDUOUS_FOREST;
            return Biomes.TEMPERATE_RAIN_FOREST;
        }

        if (m < 0.16) return Biomes.SUBTROPICAL_DESERT;
        if (m < 0.33) return Biomes.GRASSLAND;
        if (m < 0.66) return Biomes.TROPICAL_SEASONAL_FOREST;
        return Biomes.TROPICAL_RAIN_FOREST;
    }
}
