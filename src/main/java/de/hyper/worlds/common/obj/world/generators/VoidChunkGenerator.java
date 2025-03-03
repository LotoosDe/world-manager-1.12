package de.hyper.worlds.common.obj.world.generators;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;


public class VoidChunkGenerator extends ChunkGenerator {


    @Override
    public ChunkData generateChunkData(World world, Random random, int x, int z,
                                       ChunkGenerator.BiomeGrid biome) {
        return createChunkData(world);
    }
}
