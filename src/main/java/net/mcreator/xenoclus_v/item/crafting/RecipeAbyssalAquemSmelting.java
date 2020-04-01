
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemAquemIngot;
import net.mcreator.xenoclus_v.block.BlockAbyssalAquemOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeAbyssalAquemSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeAbyssalAquemSmelting(ElementsXenoclusOne instance) {
		super(instance, 777);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAbyssalAquemOre.block, (int) (1)), new ItemStack(ItemAquemIngot.block, (int) (0)), 0F);
	}
}
