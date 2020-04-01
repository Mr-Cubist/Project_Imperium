
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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.procedure.ProcedureLifeLEECHPRO;
import net.mcreator.xenoclus_v.item.ItemBloodSack;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityTick extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 44;
	public static final int ENTITYID_RANGED = 45;
	public EntityTick(ElementsXenoclusOne instance) {
		super(instance, 407);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "tick"), ENTITYID)
				.name("tick").tracker(64, 3, true).egg(-6684673, -16764058).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:iceplains")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:shiverlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:insanemountains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 6, 2, 4, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelTickGeo(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/tickgeocopy.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.9f, 2f);
			experienceValue = 6;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, false));
			this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityArmoredFrusk.EntityCustom.class, (float) 6, 0.8, 0.9));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntitySheep.class, true, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityBasicFrusk.EntityCustom.class, true, false));
			this.tasks.addTask(8, new EntityAIWander(this, 0.8));
			this.tasks.addTask(9, new EntityAILookIdle(this));
			this.tasks.addTask(10, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemBloodSack.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.silverfish.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.silverfish.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.silverfish.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onKillEntity(EntityLivingBase entity) {
			super.onKillEntity(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureLifeLEECHPRO.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onCollideWithPlayer(EntityPlayer entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureLifeLEECHPRO.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelTickGeo extends ModelBase {
		private final ModelRenderer Body;
		private final ModelRenderer Head;
		private final ModelRenderer Leg1;
		private final ModelRenderer Leg2;
		private final ModelRenderer Leg3;
		private final ModelRenderer Leg4;
		private final ModelRenderer Leg5;
		private final ModelRenderer Leg6;
		public ModelTickGeo() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 0, 0, -8.0F, -14.0F, -4.0F, 16, 9, 19, 0.0F, false));
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.cubeList.add(new ModelBox(Head, 0, 28, -8.0F, -14.0F, -8.0F, 16, 9, 4, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 0, 0, -2.0F, -5.0F, -8.0F, 4, 4, 0, 0.0F, false));
			Leg1 = new ModelRenderer(this);
			Leg1.setRotationPoint(-7.0F, 19.0F, -3.0F);
			setRotationAngle(Leg1, 0.0F, -0.0873F, 0.0F);
			Leg1.cubeList.add(new ModelBox(Leg1, 50, 41, -4.7652F, 0.0F, -2.6215F, 5, 5, 5, 0.0F, false));
			Leg2 = new ModelRenderer(this);
			Leg2.setRotationPoint(-7.0F, 19.0F, 5.0F);
			Leg2.cubeList.add(new ModelBox(Leg2, 50, 28, -5.0F, 0.0F, -3.0F, 5, 5, 5, 0.0F, false));
			Leg3 = new ModelRenderer(this);
			Leg3.setRotationPoint(-6.0F, 19.0F, 12.0F);
			setRotationAngle(Leg3, 0.0F, 0.0873F, 0.0F);
			Leg3.cubeList.add(new ModelBox(Leg3, 35, 46, -4.977F, 0.0F, -2.4314F, 5, 5, 5, 0.0F, false));
			Leg4 = new ModelRenderer(this);
			Leg4.setRotationPoint(7.0F, 18.0F, 11.0F);
			setRotationAngle(Leg4, 0.0F, -0.0873F, 0.0F);
			Leg4.cubeList.add(new ModelBox(Leg4, 20, 41, -0.9321F, 1.0F, -1.3481F, 5, 5, 5, 0.0F, false));
			Leg5 = new ModelRenderer(this);
			Leg5.setRotationPoint(7.0F, 19.0F, 4.0F);
			Leg5.cubeList.add(new ModelBox(Leg5, 0, 41, 0.0F, 0.0F, -2.0F, 5, 5, 5, 0.0F, false));
			Leg6 = new ModelRenderer(this);
			Leg6.setRotationPoint(7.0F, 19.0F, -2.0F);
			setRotationAngle(Leg6, 0.0F, 0.1745F, 0.0F);
			Leg6.cubeList.add(new ModelBox(Leg6, 35, 36, -0.241F, 0.0F, -3.2459F, 5, 5, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Body.render(f5);
			Head.render(f5);
			Leg1.render(f5);
			Leg2.render(f5);
			Leg3.render(f5);
			Leg4.render(f5);
			Leg5.render(f5);
			Leg6.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Leg2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg4.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg5.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.Leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Leg6.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
