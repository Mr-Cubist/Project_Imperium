
package net.mcreator.xenoclus_v.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockWall;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.procedure.ProcedureSubzeroachievementPro;
import net.mcreator.xenoclus_v.creativetab.TabBorealarkTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class BlockIceBrickWall extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:icebrickwall")
	public static final Block block = null;
	public BlockIceBrickWall(ElementsXenoclusOne instance) {
		super(instance, 352);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("icebrickwall"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("xenoclus_v:icebrickwall", "inventory"));
	}
	public static class BlockCustom extends BlockWall {
		public BlockCustom() {
			super(new Block(Material.ROCK));
			setUnlocalizedName("icebrickwall");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(1.2F);
			setResistance(12.5F);
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

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.ICE;
		}

		@Override
		public void onBlockClicked(World world, BlockPos pos, EntityPlayer entity) {
			super.onBlockClicked(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureSubzeroachievementPro.executeProcedure($_dependencies);
			}
		}
	}
}
