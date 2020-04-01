package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.entity.EntityCreepaliskMinion;
import net.mcreator.xenoclus_v.block.BlockDisapearingblock;
import net.mcreator.xenoclus_v.block.BlockCreeperBOSSBOMB;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureCreepaliskChooseAttack extends ElementsXenoclusOne.ModElement {
	public ProcedureCreepaliskChooseAttack(ElementsXenoclusOne instance) {
		super(instance, 742);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CreepaliskChooseAttack!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CreepaliskChooseAttack!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CreepaliskChooseAttack!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CreepaliskChooseAttack!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double RandomNumberAttack = 0;
		if ((Math.random() < 0.6)) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), BlockDisapearingblock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 3), (int) z), BlockCreeperBOSSBOMB.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 3), (int) z), BlockCreeperBOSSBOMB.block.getDefaultState(), 3);
		} else {
			if ((Math.random() < 0.6)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityCreepaliskMinion.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, (y + 1), z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityCreepaliskMinion.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, (y + 1), z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				if (!world.isRemote) {
					world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
				}
			}
		}
	}
}
