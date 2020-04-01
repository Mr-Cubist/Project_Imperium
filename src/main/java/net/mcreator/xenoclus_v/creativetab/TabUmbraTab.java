
package net.mcreator.xenoclus_v.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.xenoclus_v.block.BlockUmbraGrass;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class TabUmbraTab extends ElementsXenoclusOne.ModElement {
	public TabUmbraTab(ElementsXenoclusOne instance) {
		super(instance, 475);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabumbratab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockUmbraGrass.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
