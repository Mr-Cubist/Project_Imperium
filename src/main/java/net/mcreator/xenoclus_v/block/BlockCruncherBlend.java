
package net.mcreator.xenoclus_v.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.creativetab.TabXenoclusOverwolrd;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class BlockCruncherBlend extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:cruncherblend")
	public static final Block block = null;
	public BlockCruncherBlend(ElementsXenoclusOne instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("cruncherblend"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("xenoclus_v:cruncherblend", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.CLAY);
			setUnlocalizedName("cruncherblend");
			setSoundType(SoundType.SLIME);
			setHarvestLevel("shovel", 1);
			setHardness(1.6F);
			setResistance(12F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabXenoclusOverwolrd.tab);
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.RED;
		}
	}
}
