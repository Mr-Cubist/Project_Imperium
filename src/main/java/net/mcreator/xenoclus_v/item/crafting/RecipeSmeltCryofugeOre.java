
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemCryofugeGem;
import net.mcreator.xenoclus_v.block.BlockCryofugeOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSmeltCryofugeOre extends ElementsXenoclusOne.ModElement {
	public RecipeSmeltCryofugeOre(ElementsXenoclusOne instance) {
		super(instance, 607);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockCryofugeOre.block, (int) (1)), new ItemStack(ItemCryofugeGem.block, (int) (0)), 0F);
	}
}
