
package net.mcreator.xenoclus_v.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.xenoclus_v.creativetab.TabAzathothTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemMoonCheese extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:mooncheese")
	public static final Item block = null;
	public ItemMoonCheese(ElementsXenoclusOne instance) {
		super(instance, 195);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("xenoclus_v:mooncheese", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(6, 0.5f, false);
			setUnlocalizedName("mooncheese");
			setRegistryName("mooncheese");
			setCreativeTab(TabAzathothTab.tab);
			setMaxStackSize(64);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 33;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
