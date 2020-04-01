
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.xenoclus_v.block.BlockFrostyCoalOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSmeltCoalF extends ElementsXenoclusOne.ModElement {
	public RecipeSmeltCoalF(ElementsXenoclusOne instance) {
		super(instance, 608);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockFrostyCoalOre.block, (int) (1)), new ItemStack(Items.COAL, (int) (0), 0), 0F);
	}
}
