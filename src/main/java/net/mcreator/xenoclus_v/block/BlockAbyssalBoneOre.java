
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
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.world.WorldAbyss;
import net.mcreator.xenoclus_v.creativetab.TabAzathothTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Random;

@ElementsXenoclusOne.ModElement.Tag
public class BlockAbyssalBoneOre extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:abyssalboneore")
	public static final Block block = null;
	public BlockAbyssalBoneOre(ElementsXenoclusOne instance) {
		super(instance, 103);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("abyssalboneore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("xenoclus_v:abyssalboneore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldAbyss.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("xenoclus_v:trenchsands")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("xenoclus_v:abyssalwastes")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		for (int i = 0; i < 10; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(256) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 15, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == BlockAbyssalStone.block.getDefaultState().getBlock())
						blockCriteria = true;
					if (blockAt.getBlock() == BlockAbyssalStonee.block.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("abyssalboneore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(8.200000000000001F);
			setResistance(35F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabAzathothTab.tab);
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.BLACK;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Items.BONE, (int) (3)));
		}
	}
}
