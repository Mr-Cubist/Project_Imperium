
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

import net.mcreator.xenoclus_v.creativetab.TabUmbraTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemSilver extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:silverhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("xenoclus_v:silverbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("xenoclus_v:silverlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("xenoclus_v:silverboots")
	public static final Item boots = null;
	public ItemSilver(ElementsXenoclusOne instance) {
		super(instance, 295);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SILVER", "xenoclus_v:iron_ copy", 37, new int[]{7, 7, 9, 7}, 9, null, 1.6f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("silverhelmet").setRegistryName("silverhelmet")
				.setCreativeTab(TabUmbraTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("silverbody").setRegistryName("silverbody")
				.setCreativeTab(TabUmbraTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("silverlegs").setRegistryName("silverlegs")
				.setCreativeTab(TabUmbraTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("silverboots").setRegistryName("silverboots")
				.setCreativeTab(TabUmbraTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("xenoclus_v:silverhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("xenoclus_v:silverbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("xenoclus_v:silverlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("xenoclus_v:silverboots", "inventory"));
	}
}
