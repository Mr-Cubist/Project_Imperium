
package net.mcreator.xenoclus_v.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.xenoclus_v.block.BlockIronCage;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class TabXenoclusOverwolrd extends ElementsXenoclusOne.ModElement {
	public TabXenoclusOverwolrd(ElementsXenoclusOne instance) {
		super(instance, 438);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabxenoclusoverwolrd") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockIronCage.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
