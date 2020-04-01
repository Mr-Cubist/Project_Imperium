
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.xenoclus_v.block.BlockIronSunkenStone;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSunkenIronSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeSunkenIronSmelting(ElementsXenoclusOne instance) {
		super(instance, 778);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockIronSunkenStone.block, (int) (1)), new ItemStack(Items.IRON_INGOT, (int) (0)), 0F);
	}
}
