
package net.mcreator.xenoclus_v.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityCruncherred extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityCruncherred(ElementsXenoclusOne instance) {
		super(instance, 393);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("xenoclus_v", "cruncherred"), ENTITYID).name("cruncherred").tracker(64, 3, true).egg(-3394816, -52).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("hell")),};
		EntityRegistry.addSpawn(EntityCustom.class, 8, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelCruncher(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/cruncher.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.9f, 1.4f);
			experienceValue = 6;
			this.isImmuneToFire = true;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, false));
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(6, new EntityAIBreakDoor(this));
			this.tasks.addTask(7, new EntityAIWander(this, 1));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(9, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.LEATHER, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.skeleton_horse.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.skeleton_horse.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.stray.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelCruncher extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer legzero;
		private final ModelRenderer legone;
		private final ModelRenderer legtwo;
		private final ModelRenderer legthree;
		public ModelCruncher() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.0F, 2.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -2.0F, -10.0F, 12, 10, 18, 0.0F, false));
			legzero = new ModelRenderer(this);
			legzero.setRotationPoint(5.0F, 10.0F, 7.0F);
			setRotationAngle(legzero, 0.0F, -0.3491F, 0.0F);
			legzero.cubeList.add(new ModelBox(legzero, 42, 0, 0.0F, -1.0F, -1.0F, 7, 3, 3, 0.0F, false));
			legzero.cubeList.add(new ModelBox(legzero, 24, 28, 4.0F, 2.0F, -1.0F, 3, 12, 3, 0.0F, false));
			legone = new ModelRenderer(this);
			legone.setRotationPoint(-5.0F, 10.0F, 7.0F);
			setRotationAngle(legone, 0.0F, 0.4363F, 0.0F);
			legone.cubeList.add(new ModelBox(legone, 33, 42, -7.0F, -1.0F, -1.0F, 7, 3, 3, 0.0F, false));
			legone.cubeList.add(new ModelBox(legone, 12, 28, -7.0F, 2.0F, -1.0F, 3, 12, 3, 0.0F, false));
			legtwo = new ModelRenderer(this);
			legtwo.setRotationPoint(6.0F, 11.0F, -4.0F);
			setRotationAngle(legtwo, 0.0F, 0.4363F, 0.0F);
			legtwo.cubeList.add(new ModelBox(legtwo, 36, 28, -1.0F, -2.0F, -1.0F, 7, 3, 3, 0.0F, false));
			legtwo.cubeList.add(new ModelBox(legtwo, 0, 28, 3.0F, 1.0F, -1.0F, 3, 12, 3, 0.0F, false));
			legthree = new ModelRenderer(this);
			legthree.setRotationPoint(-5.0F, 10.0F, -6.0F);
			setRotationAngle(legthree, 0.0F, -0.2618F, 0.0F);
			legthree.cubeList.add(new ModelBox(legthree, 36, 36, -7.0F, -1.0F, 1.0F, 7, 3, 3, 0.0F, false));
			legthree.cubeList.add(new ModelBox(legthree, 0, 0, -7.0F, 2.0F, 1.0F, 3, 12, 3, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			legzero.render(f5);
			legone.render(f5);
			legtwo.render(f5);
			legthree.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.legone.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.legtwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legzero.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legthree.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
