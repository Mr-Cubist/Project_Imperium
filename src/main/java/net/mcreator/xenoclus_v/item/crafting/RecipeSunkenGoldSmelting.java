
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.xenoclus_v.block.BlockGoldSunkenStone;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSunkenGoldSmelting extends ElementsXenoclusOne.ModElement {
	public RecipeSunkenGoldSmelting(ElementsXenoclusOne instance) {
		super(instance, 779);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGoldSunkenStone.block, (int) (1)), new ItemStack(Items.GOLD_INGOT, (int) (0)), 0F);
	}
}
