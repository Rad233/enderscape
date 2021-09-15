package net.enderscape.world.biomes;

import net.enderscape.registry.EndMusic;
import net.enderscape.registry.EndSounds;
import net.enderscape.world.EndBiomeFeatures;
import net.enderscape.world.EndSurfaces;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.biome.*;

public class NormalEndIslandsBiome extends EnderscapeIslandsBiome {
    public NormalEndIslandsBiome() {
        super(new NormalEndBiome(), "end_islands");
    }

    @Override
    public Biome getBiome() {
        SoundEvent loopSound = EndSounds.AMBIENT_END_LOOP;
        SoundEvent additionsSound = EndSounds.AMBIENT_END_ADDITIONS;

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        builder.surfaceBuilder(EndSurfaces.END);
        EndBiomeFeatures.addIslandsFeatures(builder, spawnSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.THEEND)
                .depth(0.1F)
                .scale(0.1F)
                .temperature(0.7F)
                .downfall(0)

                .effects((new BiomeEffects.Builder()
                        .music(EndMusic.NORMAL)
                        .loopSound(loopSound)
                        .additionsSound(new BiomeAdditionsSound(additionsSound, 0.001))
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.MYCELIUM, 0.001F)))

                        .waterColor(54527)
                        .waterFogColor(54527)
                        .fogColor(0x130F1B)
                        .skyColor(util.getSkyColor())
                        .build())
                .spawnSettings(spawnSettings.build()).generationSettings(builder.build()).build();
    }
}