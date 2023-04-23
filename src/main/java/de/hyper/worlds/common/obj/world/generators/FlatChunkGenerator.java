package de.hyper.worlds.common.obj.world.generators;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class FlatChunkGenerator extends ChunkGenerator {


    @Override
    public ChunkData generateChunkData( World world,  Random random, int x, int z,
                                        ChunkGenerator.BiomeGrid biome) {
        ChunkData chunk = createChunkData(world);
        for (int X = 0; X < 16; X++) {
            for (int Z = 0; Z < 16; Z++) {
                for (int Y = 0; Y < 5; Y++) {
                    chunk.setBlock(X, Y, Z, getMaterialByY(Y));
                }
            }
        }
        return chunk;
    }

    public Material getMaterialByY(int y) {
        Material mat = Material.DIRT;
        if (y == 0) {
            mat = Material.BEDROCK;
        } else if (y == 1) {
            mat = Material.STONE;
        } else if (y == 2 || y == 3) {
            mat = Material.DIRT;
        } else if (y == 4) {
            mat = Material.GRASS;
        }
        return mat;
    }
}