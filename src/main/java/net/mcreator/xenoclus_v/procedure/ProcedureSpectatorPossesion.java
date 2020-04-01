package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.entity.EntitySpectator;
import net.mcreator.xenoclus_v.block.BlockTrappedVase;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureSpectatorPossesion extends ElementsXenoclusOne.ModElement {
	public ProcedureSpectatorPossesion(ElementsXenoclusOne instance) {
		super(instance, 697);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpectatorPossesion!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpectatorPossesion!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpectatorPossesion!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpectatorPossesion!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpectatorPossesion!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((entity instanceof EntitySpectator.EntityCustom)) {
			entity.world.removeEntity(entity);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockTrappedVase.block.getDefaultState(), 3);
		}
	}
}
