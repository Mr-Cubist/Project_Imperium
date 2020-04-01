
package net.mcreator.xenoclus_v.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.creativetab.TabAzathothTab;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemPrisemn extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:prisemnhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("xenoclus_v:prisemnbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("xenoclus_v:prisemnlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("xenoclus_v:prisemnboots")
	public static final Item boots = null;
	public ItemPrisemn(ElementsXenoclusOne instance) {
		super(instance, 198);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PRISEMN", "xenoclus_v:prisemn_", 34, new int[]{7, 6, 10, 9}, 16,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 1.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			@SideOnly(Side.CLIENT)
			public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped defaultModel) {
				ModelBiped armorModel = new ModelBiped();
				armorModel.bipedHead = new ModelPrisemnHelmet().Helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isRiding = living.isRiding();
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
				return "xenoclus_v:textures/helm.png";
			}
		}.setUnlocalizedName("prisemnhelmet").setRegistryName("prisemnhelmet").setCreativeTab(TabAzathothTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("prisemnbody").setRegistryName("prisemnbody")
				.setCreativeTab(TabAzathothTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("prisemnlegs").setRegistryName("prisemnlegs")
				.setCreativeTab(TabAzathothTab.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("prisemnboots").setRegistryName("prisemnboots")
				.setCreativeTab(TabAzathothTab.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("xenoclus_v:prisemnhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("xenoclus_v:prisemnbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("xenoclus_v:prisemnlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("xenoclus_v:prisemnboots", "inventory"));
	}
	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelPrisemnHelmet extends ModelBase {
		private final ModelRenderer Helmet;
		public ModelPrisemnHelmet() {
			textureWidth = 64;
			textureHeight = 64;
			Helmet = new ModelRenderer(this);
			Helmet.setRotationPoint(0.0F, 24.0F, 0.0F);
			Helmet.cubeList.add(new ModelBox(Helmet, 0, 45, -5.0F, -9.0F, -5.0F, 10, 9, 10, 0.0F, false));
			Helmet.cubeList.add(new ModelBox(Helmet, 0, 25, 0.0F, -11.0F, -4.0F, 0, 9, 11, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Helmet.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Helmet.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Helmet.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
