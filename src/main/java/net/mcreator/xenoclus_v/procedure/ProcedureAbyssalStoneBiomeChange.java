package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Blocks;

import net.mcreator.xenoclus_v.block.BlockTrenchDune;
import net.mcreator.xenoclus_v.block.BlockPoseidonia;
import net.mcreator.xenoclus_v.block.BlockLumialgea;
import net.mcreator.xenoclus_v.block.BlockLumeCoral;
import net.mcreator.xenoclus_v.block.BlockBonePile;
import net.mcreator.xenoclus_v.block.BlockAnemoneDeep;
import net.mcreator.xenoclus_v.block.BlockAbyssalGrass;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureAbyssalStoneBiomeChange extends ElementsXenoclusOne.ModElement {
	public ProcedureAbyssalStoneBiomeChange(ElementsXenoclusOne instance) {
		super(instance, 761);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AbyssalStoneBiomeChange!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AbyssalStoneBiomeChange!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AbyssalStoneBiomeChange!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AbyssalStoneBiomeChange!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockAbyssalGrass.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockPoseidonia.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockLumeCoral.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockBonePile.block
												.getDefaultState().getBlock())
												|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
														.getBlock() == BlockAnemoneDeep.block.getDefaultState().getBlock()))))))) {
			if ((Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
					.equals(new ResourceLocation("xenoclus_v:trenchsands")))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockTrenchDune.block.getDefaultState(), 3);
			}
			if ((Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
					.equals(new ResourceLocation("xenoclus_v:abyssalbasic")))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockLumialgea.block.getDefaultState(), 3);
			}
		}
	}
}
