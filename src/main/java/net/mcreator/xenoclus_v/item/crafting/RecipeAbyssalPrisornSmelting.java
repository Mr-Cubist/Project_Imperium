
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemPrisornIngot;
import net.mcreator.xenoclus_v.block.BlockAbyssalPrisornOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeAbyssalPrisornSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeAbyssalPrisornSmelting(ElementsXenoclusOne instance) {
		super(instance, 775);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAbyssalPrisornOre.block, (int) (1)), new ItemStack(ItemPrisornIngot.block, (int) (0)), 0F);
	}
}
