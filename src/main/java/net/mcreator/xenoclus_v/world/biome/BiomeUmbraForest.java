
package net.mcreator.xenoclus_v.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySkeleton;

import net.mcreator.xenoclus_v.block.BlockUmbraSoil;
import net.mcreator.xenoclus_v.block.BlockUmbraGrass;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Random;

@ElementsXenoclusOne.ModElement.Tag
public class BiomeUmbraForest extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:umbraforest")
	public static final BiomeGenCustom biome = null;
	public BiomeUmbraForest(ElementsXenoclusOne instance) {
		super(instance, 459);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SPOOKY);
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Umbra Forest").setRainfall(0.6F).setBaseHeight(0.1F).setWaterColor(-16724992).setHeightVariation(0.2F)
					.setTemperature(0.5F));
			setRegistryName("umbraforest");
			topBlock = BlockUmbraGrass.block.getDefaultState();
			fillerBlock = BlockUmbraSoil.block.getDefaultState();
			decorator.generateFalls = true;
			decorator.treesPerChunk = 7;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 2;
			decorator.bigMushroomsPerChunk = 1;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityZombieVillager.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityWitch.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySpider.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 40, 1, 5));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -10092391;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -10092391;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -13434778;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return BIG_TREE_FEATURE;
		}
	}
}
