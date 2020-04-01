
package net.mcreator.xenoclus_v.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.xenoclus_v.procedure.ProcedureCreepaliskARmorBuffProcedure;
import net.mcreator.xenoclus_v.creativetab.TabXenoclusOverwolrd;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ItemCreepaliskArmor extends ElementsXenoclusOne.ModElement {
	@GameRegistry.ObjectHolder("xenoclus_v:creepaliskarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("xenoclus_v:creepaliskarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("xenoclus_v:creepaliskarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("xenoclus_v:creepaliskarmorboots")
	public static final Item boots = null;
	public ItemCreepaliskArmor(ElementsXenoclusOne instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CREEPALISKARMOR", "xenoclus_v:creepaliskb_", 36, new int[]{5, 8, 9, 5}, 13,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 2f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureCreepaliskARmorBuffProcedure.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("creepaliskarmorhelmet").setRegistryName("creepaliskarmorhelmet").setCreativeTab(TabXenoclusOverwolrd.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureCreepaliskARmorBuffProcedure.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("creepaliskarmorbody").setRegistryName("creepaliskarmorbody").setCreativeTab(TabXenoclusOverwolrd.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureCreepaliskARmorBuffProcedure.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("creepaliskarmorlegs").setRegistryName("creepaliskarmorlegs").setCreativeTab(TabXenoclusOverwolrd.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureCreepaliskARmorBuffProcedure.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("creepaliskarmorboots").setRegistryName("creepaliskarmorboots").setCreativeTab(TabXenoclusOverwolrd.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("xenoclus_v:creepaliskarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("xenoclus_v:creepaliskarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("xenoclus_v:creepaliskarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("xenoclus_v:creepaliskarmorboots", "inventory"));
	}
}
