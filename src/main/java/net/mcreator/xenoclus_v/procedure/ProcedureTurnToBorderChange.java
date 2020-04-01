package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.xenoclus_v.block.BlockSwampGrassBorder;
import net.mcreator.xenoclus_v.block.BlockPaintedGrass;
import net.mcreator.xenoclus_v.block.BlockEbonyGrass;
import net.mcreator.xenoclus_v.block.BlockEbonyBorderGrass;
import net.mcreator.xenoclus_v.block.BlockAutumnGrassBorder;
import net.mcreator.xenoclus_v.block.BlockAutumnDIrt;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureTurnToBorderChange extends ElementsXenoclusOne.ModElement {
	public ProcedureTurnToBorderChange(ElementsXenoclusOne instance) {
		super(instance, 738);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TurnToBorderChange!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TurnToBorderChange!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TurnToBorderChange!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TurnToBorderChange!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockEbonyGrass.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockEbonyGrass.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockEbonyGrass.block
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockEbonyGrass.block
										.getDefaultState().getBlock()))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockEbonyBorderGrass.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockPaintedGrass.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockPaintedGrass.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockPaintedGrass.block
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockPaintedGrass.block
										.getDefaultState().getBlock()))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockSwampGrassBorder.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockAutumnDIrt.block.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockAutumnDIrt.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockAutumnDIrt.block
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockAutumnDIrt.block
										.getDefaultState().getBlock()))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockAutumnGrassBorder.block.getDefaultState(), 3);
		}
	}
}
