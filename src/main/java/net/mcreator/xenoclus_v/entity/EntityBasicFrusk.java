
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
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
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
public class EntityBasicFrusk extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 46;
	public static final int ENTITYID_RANGED = 47;
	public EntityBasicFrusk(ElementsXenoclusOne instance) {
		super(instance, 408);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "basicfrusk"), ENTITYID)
						.name("basicfrusk").tracker(64, 3, true).egg(-3407770, -3342337).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:shiverlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:insanemountains")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:iceplains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 4, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelFrusk(), 0.6f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/frusk.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.9f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityTick.EntityCustom.class, true, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySheep.class, true, false));
			this.tasks.addTask(6, new EntityAIRestrictSun(this));
			this.tasks.addTask(7, new EntityAIWander(this, 0.7));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, true));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
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
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelFrusk extends ModelBase {
		private final ModelRenderer Body;
		private final ModelRenderer Tail;
		public ModelFrusk() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 20.0F, 4.0F);
			Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -7.0F, -14.0F, 14, 11, 14, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 33, 25, -6.0F, -7.0F, -15.0F, 12, 11, 0, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 0, 32, 0.0F, -11.0F, -12.0F, 0, 6, 14, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 42, 0, -6.0F, -12.0F, -12.0F, 12, 5, 0, 0.0F, false));
			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.0F, 20.0F, 4.0F);
			Tail.cubeList.add(new ModelBox(Tail, 0, 25, -5.0F, -4.0F, 0.0F, 10, 8, 13, 0.0F, false));
			Tail.cubeList.add(new ModelBox(Tail, 37, 37, -3.0F, -2.0F, 13.0F, 6, 6, 9, 0.0F, false));
			Tail.cubeList.add(new ModelBox(Tail, 21, 46, -1.0F, 1.0F, 22.0F, 2, 3, 7, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Body.render(f5);
			Tail.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Body.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Body.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
