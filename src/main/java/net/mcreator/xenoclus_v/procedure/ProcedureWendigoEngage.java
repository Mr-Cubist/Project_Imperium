package net.mcreator.xenoclus_v.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureWendigoEngage extends ElementsXenoclusOne.ModElement {
	public ProcedureWendigoEngage(ElementsXenoclusOne instance) {
		super(instance, 638);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WendigoEngage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.COOKED_BEEF, (int) (1)).getItem(), -1, (int) 1, null);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.COOKED_CHICKEN, (int) (1)).getItem(), -1, (int) 1, null);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.COOKED_MUTTON, (int) (1)).getItem(), -1, (int) 1, null);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.GOLDEN_APPLE, (int) (1)).getItem(), -1, (int) 1, null);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.COOKED_FISH, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
