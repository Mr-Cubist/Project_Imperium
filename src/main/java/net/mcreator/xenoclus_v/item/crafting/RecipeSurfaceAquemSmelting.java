
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.xenoclus_v.item.ItemAquemIngot;
import net.mcreator.xenoclus_v.block.BlockSunkenAquemOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSurfaceAquemSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeSurfaceAquemSmelting(ElementsXenoclusOne instance) {
		super(instance, 776);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockSunkenAquemOre.block, (int) (1)), new ItemStack(ItemAquemIngot.block, (int) (0)), 0F);
	}
}
