
package net.mcreator.xenoclus_v.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.xenoclus_v.creativetab.TabBorealarkTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemFrostNinjaArmor extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:frostninjaarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("xenoclus_v:frostninjaarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("xenoclus_v:frostninjaarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("xenoclus_v:frostninjaarmorboots")
	public static final Item boots = null;
	public ItemFrostNinjaArmor(ElementsXenoclusOne instance) {
		super(instance, 387);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("FROSTNINJAARMOR", "xenoclus_v:iron_ copy_ copy", 27, new int[]{5, 5, 8, 5}, 32,
				null, 0.3f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("frostninjaarmorhelmet")
				.setRegistryName("frostninjaarmorhelmet").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("frostninjaarmorbody")
				.setRegistryName("frostninjaarmorbody").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("frostninjaarmorlegs")
				.setRegistryName("frostninjaarmorlegs").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("frostninjaarmorboots")
				.setRegistryName("frostninjaarmorboots").setCreativeTab(TabBorealarkTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("xenoclus_v:frostninjaarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("xenoclus_v:frostninjaarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("xenoclus_v:frostninjaarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("xenoclus_v:frostninjaarmorboots", "inventory"));
	}
}
