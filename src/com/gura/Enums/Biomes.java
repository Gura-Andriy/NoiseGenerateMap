package com.gura.Enums;

public enum Biomes {
    OCEAN(0x484875),
    BEACH(0xa09177),
    SCORCHED(0x555555),
    BARE(0x888888),
    TUNDRA(0xbbbca9),
    SNOW(0xdadbe2),
    TEMPERATE_DESERT(0xd2b98b),
    SHRUBLAND(0xbcbcab),
    TAIGA(0x889977),
    GRASSLAND(0x88ab55),
    TEMPERATE_DECIDUOUS_FOREST(0xd2b98b),
    TEMPERATE_RAIN_FOREST(0xd2b98b),
    SUBTROPICAL_DESERT(0xd2b98b),
    TROPICAL_SEASONAL_FOREST(0x569944),
    TROPICAL_RAIN_FOREST(0x569944);

    private final int label;
    private Biomes(int label) {
        this.label = label;
    }

    public int getBiom() {
        return label;
    }
}
