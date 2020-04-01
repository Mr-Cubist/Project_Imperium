
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.xenoclus_v.block.BlockFrostyRedstoneOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSmeltRedstoneF extends ElementsXenoclusOne.ModElement {
	public RecipeSmeltRedstoneF(ElementsXenoclusOne instance) {
		super(instance, 606);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockFrostyRedstoneOre.block, (int) (1)), new ItemStack(Items.REDSTONE, (int) (0)), 0F);
	}
}
