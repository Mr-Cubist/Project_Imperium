
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import net.mcreator.xenoclus_v.block.BlockShiverPlanks;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSpruceWoodR2 extends ElementsXenoclusOne.ModElement {
	public RecipeSpruceWoodR2(ElementsXenoclusOne instance) {
		super(instance, 570);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockShiverPlanks.block, (int) (1)), new ItemStack(Blocks.PLANKS, (int) (0), 1), 0F);
	}
}
