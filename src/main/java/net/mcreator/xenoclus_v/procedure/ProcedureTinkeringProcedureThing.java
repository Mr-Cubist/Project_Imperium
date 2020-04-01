package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.gui.GuiTinkeringTableGUI;
import net.mcreator.xenoclus_v.XenoclusOne;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureTinkeringProcedureThing extends ElementsXenoclusOne.ModElement {
	public ProcedureTinkeringProcedureThing(ElementsXenoclusOne instance) {
		super(instance, 537);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TinkeringProcedureThing!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TinkeringProcedureThing!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TinkeringProcedureThing!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TinkeringProcedureThing!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TinkeringProcedureThing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(XenoclusOne.instance, GuiTinkeringTableGUI.GUIID, world, x, y, z);
	}
}
