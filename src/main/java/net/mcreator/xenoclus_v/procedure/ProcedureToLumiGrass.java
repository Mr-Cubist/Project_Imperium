package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.xenoclus_v.block.BlockLumiGrass;
import net.mcreator.xenoclus_v.block.BlockAbyssalGrass;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureToLumiGrass extends ElementsXenoclusOne.ModElement {
	public ProcedureToLumiGrass(ElementsXenoclusOne instance) {
		super(instance, 762);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ToLumiGrass!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ToLumiGrass!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ToLumiGrass!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ToLumiGrass!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockAbyssalGrass.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockLumiGrass.block.getDefaultState(), 3);
		}
	}
}
