
package net.mcreator.xenoclus_v.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
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
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.item.ItemCruncherTooth;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityBoneCruncher extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 96;
	public static final int ENTITYID_RANGED = 97;
	public EntityBoneCruncher(ElementsXenoclusOne instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "bonecruncher"), ENTITYID)
						.name("bonecruncher").tracker(64, 3, true).egg(-52, -3355444).build());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelBoneCruncher(), 1.1f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/bonecruncher.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(2f, 3.3f);
			experienceValue = 20;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
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
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemCruncherTooth.block, (int) (1)).getItem();
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.skeleton_horse.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelBoneCruncher extends ModelBase {
		private final ModelRenderer Body;
		private final ModelRenderer Legone;
		private final ModelRenderer LegTwo;
		private final ModelRenderer Legthree;
		private final ModelRenderer LegFour;
		public ModelBoneCruncher() {
			textureWidth = 256;
			textureHeight = 256;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -7.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 86, 76, -7.0F, -4.0F, -10.0F, 14, 10, 0, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 50, 51, -10.0F, 6.0F, -11.0F, 20, 3, 10, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 0, 38, -10.0F, -7.0F, -11.0F, 20, 13, 10, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 0, 0, -10.0F, -7.0F, -1.0F, 20, 16, 22, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 0, 39, 0.0F, -12.0F, -2.0F, 0, 5, 22, 0.0F, false));
			Legone = new ModelRenderer(this);
			Legone.setRotationPoint(8.0F, -4.0F, 0.0F);
			setRotationAngle(Legone, 0.0F, 0.5236F, 0.0F);
			Legone.cubeList.add(new ModelBox(Legone, 84, 0, 9.0F, 2.0F, -4.0F, 6, 26, 6, 0.0F, false));
			Legone.cubeList.add(new ModelBox(Legone, 94, 32, 1.0F, -4.0F, -4.0F, 14, 6, 6, 0.0F, false));
			LegTwo = new ModelRenderer(this);
			LegTwo.setRotationPoint(8.0F, -5.0F, 17.0F);
			setRotationAngle(LegTwo, 0.0F, -0.4363F, 0.0F);
			LegTwo.cubeList.add(new ModelBox(LegTwo, 0, 66, 9.0F, 3.0F, -3.0F, 6, 26, 6, 0.0F, false));
			LegTwo.cubeList.add(new ModelBox(LegTwo, 86, 64, 1.0F, -3.0F, -3.0F, 14, 6, 6, 0.0F, false));
			Legthree = new ModelRenderer(this);
			Legthree.setRotationPoint(-9.0F, -4.0F, 0.0F);
			setRotationAngle(Legthree, 0.0F, -0.5236F, 0.0F);
			Legthree.cubeList.add(new ModelBox(Legthree, 62, 64, -13.0F, 2.0F, -4.0F, 6, 26, 6, 0.0F, false));
			Legthree.cubeList.add(new ModelBox(Legthree, 86, 86, -13.0F, -4.0F, -4.0F, 14, 6, 6, 0.0F, false));
			LegFour = new ModelRenderer(this);
			LegFour.setRotationPoint(-8.0F, -5.0F, 14.0F);
			setRotationAngle(LegFour, 0.0F, 0.4363F, 0.0F);
			LegFour.cubeList.add(new ModelBox(LegFour, 38, 64, -14.0F, 3.0F, 0.0F, 6, 26, 6, 0.0F, false));
			LegFour.cubeList.add(new ModelBox(LegFour, 60, 38, -14.0F, -3.0F, 0.0F, 14, 6, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Body.render(f5);
			Legone.render(f5);
			LegTwo.render(f5);
			Legthree.render(f5);
			LegFour.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.LegTwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LegFour.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Legthree.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Legone.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
