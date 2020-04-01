
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemPrisornIngot;
import net.mcreator.xenoclus_v.block.BlockSunkenPrisornOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSurfacePrisornSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeSurfacePrisornSmelting(ElementsXenoclusOne instance) {
		super(instance, 774);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockSunkenPrisornOre.block, (int) (1)), new ItemStack(ItemPrisornIngot.block, (int) (0)), 0F);
	}
}
