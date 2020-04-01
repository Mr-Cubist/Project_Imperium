package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.xenoclus_v.block.BlockUmbraGrass;
import net.mcreator.xenoclus_v.block.BlockSwampGrassBorder;
import net.mcreator.xenoclus_v.block.BlockSwampGrassAutumnBorder;
import net.mcreator.xenoclus_v.block.BlockPaintedGrass;
import net.mcreator.xenoclus_v.block.BlockEbonyGrassAutumnBorder;
import net.mcreator.xenoclus_v.block.BlockEbonyGrass;
import net.mcreator.xenoclus_v.block.BlockEbonyBorderGrass;
import net.mcreator.xenoclus_v.block.BlockAutumnGrassBorder;
import net.mcreator.xenoclus_v.block.BlockAutumnDIrt;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureSpawnLeavesAtBottom extends ElementsXenoclusOne.ModElement {
	public ProcedureSpawnLeavesAtBottom(ElementsXenoclusOne instance) {
		super(instance, 739);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpawnLeavesAtBottom!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpawnLeavesAtBottom!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpawnLeavesAtBottom!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpawnLeavesAtBottom!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockUmbraGrass.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockAutumnGrassBorder.block.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), BlockAutumnDIrt.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockEbonyGrass.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockEbonyBorderGrass.block.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), BlockEbonyGrassAutumnBorder.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockPaintedGrass.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockSwampGrassBorder.block.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), BlockSwampGrassAutumnBorder.block.getDefaultState(), 3);
		}
	}
}
