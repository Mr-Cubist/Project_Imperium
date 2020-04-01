
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemShalverIngot;
import net.mcreator.xenoclus_v.block.BlockShalverOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeShalverIngotRecipe extends ElementsXenoclusOne.ModElement {
	public RecipeShalverIngotRecipe(ElementsXenoclusOne instance) {
		super(instance, 518);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockShalverOre.block, (int) (1)), new ItemStack(ItemShalverIngot.block, (int) (0)), 0F);
	}
}
