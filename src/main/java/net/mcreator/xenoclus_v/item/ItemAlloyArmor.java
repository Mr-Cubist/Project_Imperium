
package net.mcreator.xenoclus_v.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.xenoclus_v.creativetab.TabBorealarkTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemAlloyArmor extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:alloyarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("xenoclus_v:alloyarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("xenoclus_v:alloyarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("xenoclus_v:alloyarmorboots")
	public static final Item boots = null;
	public ItemAlloyArmor(ElementsXenoclusOne instance) {
		super(instance, 386);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ALLOYARMOR", "xenoclus_v:alloy_layer_1", 27, new int[]{3, 6, 7, 5}, 7,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0.4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("alloyarmorhelmet")
				.setRegistryName("alloyarmorhelmet").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("alloyarmorbody")
				.setRegistryName("alloyarmorbody").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("alloyarmorlegs")
				.setRegistryName("alloyarmorlegs").setCreativeTab(TabBorealarkTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("alloyarmorboots")
				.setRegistryName("alloyarmorboots").setCreativeTab(TabBorealarkTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("xenoclus_v:alloyarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("xenoclus_v:alloyarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("xenoclus_v:alloyarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("xenoclus_v:alloyarmorboots", "inventory"));
	}
}
