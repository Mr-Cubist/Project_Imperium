
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemUnfrozenBerries;
import net.mcreator.xenoclus_v.item.ItemFrozenBerry;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeHeatingBerries extends ElementsXenoclusOne.ModElement {
	public RecipeHeatingBerries(ElementsXenoclusOne instance) {
		super(instance, 640);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemFrozenBerry.block, (int) (1)), new ItemStack(ItemUnfrozenBerries.block, (int) (0)), 0F);
	}
}
