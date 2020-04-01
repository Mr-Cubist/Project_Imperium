
package net.mcreator.xenoclus_v.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.xenoclus_v.block.BlockPastelReefGrass;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class TabAzathothTab extends ElementsXenoclusOne.ModElement {
	public TabAzathothTab(ElementsXenoclusOne instance) {
		super(instance, 642);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabazathothtab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockPastelReefGrass.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
