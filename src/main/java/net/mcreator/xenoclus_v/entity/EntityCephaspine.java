
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
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;

import net.mcreator.xenoclus_v.item.ItemSpikeFORICTIOUSE;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityCephaspine extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 112;
	public static final int ENTITYID_RANGED = 113;
	public EntityCephaspine(ElementsXenoclusOne instance) {
		super(instance, 427);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "cephaspine"), ENTITYID)
						.name("cephaspine").tracker(66, 3, true).egg(-10066330, -39424).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("xenoclus_v", "entitybulletcephaspine"), ENTITYID_RANGED).name("entitybulletcephaspine").tracker(64, 1, true)
				.build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:pastelpalms")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothaquabeach")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:brightreef")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothmountains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 5, 1, 5, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelOctopus(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/octopus.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(ItemSpikeFORICTIOUSE.block, (int) (1));
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
			experienceValue = 7;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.3, true));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(5, new EntityAIWander(this, 1));
			this.tasks.addTask(6, new EntityAILookIdle(this));
			this.tasks.addTask(7, new EntityAISwimming(this));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.DYE, (int) (1), 0).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.squid.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.squid.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelOctopus extends ModelBase {
		private final ModelRenderer Head;
		private final ModelRenderer TentacleOne;
		private final ModelRenderer TentacleTwo;
		private final ModelRenderer TentacleThree;
		private final ModelRenderer TentacleFour;
		private final ModelRenderer TentacleFive;
		private final ModelRenderer TentacleSix;
		private final ModelRenderer TentacleSeven;
		private final ModelRenderer TentacleEight;
		public ModelOctopus() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 21.0F, 0.0F);
			Head.cubeList.add(new ModelBox(Head, 34, 43, -4.0F, -11.0F, -4.0F, 8, 11, 8, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 0, 0, -5.0F, -12.0F, -5.0F, 10, 13, 10, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 46, 0, -7.0F, -15.0F, 0.0F, 14, 16, 0, 0.0F, false));
			TentacleOne = new ModelRenderer(this);
			TentacleOne.setRotationPoint(-2.0F, 23.0F, -2.0F);
			setRotationAngle(TentacleOne, 0.0F, 0.0873F, 0.0F);
			TentacleOne.cubeList.add(new ModelBox(TentacleOne, 0, 40, -2.091F, -2.0F, -13.9166F, 3, 3, 14, 0.0F, false));
			TentacleTwo = new ModelRenderer(this);
			TentacleTwo.setRotationPoint(2.0F, 23.0F, -2.0F);
			setRotationAngle(TentacleTwo, 0.0F, -0.0873F, 0.0F);
			TentacleTwo.cubeList.add(new ModelBox(TentacleTwo, 26, 9, -0.909F, -2.0F, -13.9166F, 3, 3, 14, 0.0F, false));
			TentacleThree = new ModelRenderer(this);
			TentacleThree.setRotationPoint(2.0F, 23.0F, 2.0F);
			setRotationAngle(TentacleThree, 0.0F, 0.0873F, 0.0F);
			TentacleThree.cubeList.add(new ModelBox(TentacleThree, 20, 26, -0.909F, -2.0F, -0.0834F, 3, 3, 14, 0.0F, false));
			TentacleFour = new ModelRenderer(this);
			TentacleFour.setRotationPoint(-2.0F, 23.0F, 2.0F);
			setRotationAngle(TentacleFour, 0.0F, -0.0873F, 0.0F);
			TentacleFour.cubeList.add(new ModelBox(TentacleFour, 0, 23, -2.091F, -2.0F, -0.0834F, 3, 3, 14, 0.0F, false));
			TentacleFive = new ModelRenderer(this);
			TentacleFive.setRotationPoint(-2.0F, 23.0F, 2.0F);
			setRotationAngle(TentacleFive, 0.0F, 0.0873F, 0.0F);
			TentacleFive.cubeList.add(new ModelBox(TentacleFive, 0, 57, -14.0F, -2.0F, -1.0F, 14, 3, 3, 0.0F, false));
			TentacleSix = new ModelRenderer(this);
			TentacleSix.setRotationPoint(-2.0F, 23.0F, -2.0F);
			setRotationAngle(TentacleSix, 0.0F, -0.0873F, 0.0F);
			TentacleSix.cubeList.add(new ModelBox(TentacleSix, 46, 16, -14.0F, -2.0F, -2.0F, 14, 3, 3, 0.0F, false));
			TentacleSeven = new ModelRenderer(this);
			TentacleSeven.setRotationPoint(2.0F, 23.0F, -2.0F);
			setRotationAngle(TentacleSeven, 0.0F, 0.0873F, 0.0F);
			TentacleSeven.cubeList.add(new ModelBox(TentacleSeven, 40, 32, 0.0F, -2.0F, -2.0F, 14, 3, 3, 0.0F, false));
			TentacleEight = new ModelRenderer(this);
			TentacleEight.setRotationPoint(2.0F, 23.0F, 2.0F);
			setRotationAngle(TentacleEight, 0.0F, -0.0873F, 0.0F);
			TentacleEight.cubeList.add(new ModelBox(TentacleEight, 40, 26, 0.0F, -2.0F, -1.0F, 14, 3, 3, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Head.render(f5);
			TentacleOne.render(f5);
			TentacleTwo.render(f5);
			TentacleThree.render(f5);
			TentacleFour.render(f5);
			TentacleFive.render(f5);
			TentacleSix.render(f5);
			TentacleSeven.render(f5);
			TentacleEight.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.TentacleSix.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.TentacleThree.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.TentacleFour.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.TentacleOne.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.TentacleSeven.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.TentacleEight.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.TentacleFive.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.TentacleTwo.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
