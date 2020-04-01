
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemRawFleeFish;
import net.mcreator.xenoclus_v.item.ItemCookedFleefFish;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeCookingFleeFish extends ElementsXenoclusOne.ModElement {
	public RecipeCookingFleeFish(ElementsXenoclusOne instance) {
		super(instance, 546);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawFleeFish.block, (int) (1)), new ItemStack(ItemCookedFleefFish.block, (int) (0)), 0F);
	}
}
