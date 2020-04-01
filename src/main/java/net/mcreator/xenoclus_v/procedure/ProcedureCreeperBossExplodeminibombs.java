package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureCreeperBossExplodeminibombs extends ElementsXenoclusOne.ModElement {
	public ProcedureCreeperBossExplodeminibombs(ElementsXenoclusOne instance) {
		super(instance, 741);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CreeperBossExplodeminibombs!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CreeperBossExplodeminibombs!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CreeperBossExplodeminibombs!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CreeperBossExplodeminibombs!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CreeperBossExplodeminibombs!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity instanceof EntityPlayer) || (entity instanceof EntityPlayerMP))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
			world.playSound((EntityPlayer) null, x, y, z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.explode")),
					SoundCategory.NEUTRAL, (float) 2, (float) 1);
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x, y, z, (int) 6, 2, 1, 2, 1, new int[0]);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
		}
	}
}
