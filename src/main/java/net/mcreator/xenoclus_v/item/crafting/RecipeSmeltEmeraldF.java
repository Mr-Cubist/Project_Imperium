
package net.mcreator.xenoclus_v.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.xenoclus_v.block.BlockFrostyEmeraldOre;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class RecipeSmeltEmeraldF extends ElementsXenoclusOne.ModElement {
	public RecipeSmeltEmeraldF(ElementsXenoclusOne instance) {
		super(instance, 605);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockFrostyEmeraldOre.block, (int) (1)), new ItemStack(Items.EMERALD, (int) (0)), 0F);
	}
}
