
package net.mcreator.xenoclus_v.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.creativetab.TabXenoclusOverwolrd;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Random;

@ElementsXenoclusOne.ModElement.Tag
public class BlockRootStoNeOre extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:rootstoneore")
	public static final Block block = null;
	public BlockRootStoNeOre(ElementsXenoclusOne instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("rootstoneore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("xenoclus_v:rootstoneore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("plains")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("taiga")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("forest_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_jungle")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("jungle_edge")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("jungle")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("jungle_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_roofed_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("forest_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("taiga_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("savanna")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("extreme_hills_with_trees")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_swampland")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("birch_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("birch_forest_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("roofed_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_birch_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_birch_forest_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_roofed_forest")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_extreme_hills_with_trees")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		for (int i = 0; i < 14; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(91) + 19;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 18, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == Blocks.STONE.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("rootstoneore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(2F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabXenoclusOverwolrd.tab);
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.STONE;
		}

		@Override
		public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
			return false;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Items.STICK, (int) (2)));
		}
	}
}
