
package net.mcreator.xenoclus_v.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockWall;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.creativetab.TabBorealarkTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class BlockFrostedBrickWall extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:frostedbrickwall")
	public static final Block block = null;
	public BlockFrostedBrickWall(ElementsXenoclusOne instance) {
		super(instance, 344);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("frostedbrickwall"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("xenoclus_v:frostedbrickwall", "inventory"));
	}
	public static class BlockCustom extends BlockWall {
		public BlockCustom() {
			super(new Block(Material.ROCK));
			setUnlocalizedName("frostedbrickwall");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(1.3F);
			setResistance(12F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabBorealarkTab.tab);
		}

		@Override
		public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
			items.add(new ItemStack(this));
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}
}
