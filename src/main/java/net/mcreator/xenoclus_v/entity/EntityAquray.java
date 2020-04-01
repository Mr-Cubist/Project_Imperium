
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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityAquray extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 114;
	public static final int ENTITYID_RANGED = 115;
	public EntityAquray(ElementsXenoclusOne instance) {
		super(instance, 420);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "aquray"), ENTITYID)
				.name("aquray").tracker(65, 3, true).egg(-16724839, -10027060).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:kelpforest")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothaquabeach")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:brightreef")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothmountains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 4, 1, 2, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelStingray(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/aquray.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.5f);
			experienceValue = 3;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAILookIdle(this));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAIPanic(this, 1.2));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
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
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(13D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelStingray extends ModelBase {
		private final ModelRenderer Body;
		private final ModelRenderer tail;
		private final ModelRenderer FinOne;
		private final ModelRenderer Fintwo;
		public ModelStingray() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 24, 24, -4.0F, -3.0F, -8.0F, 8, 3, 11, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 39, 4, -2.0F, -2.0F, -6.0F, 4, 1, 8, 0.0F, false));
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 23.0F, 3.0F);
			tail.cubeList.add(new ModelBox(tail, 0, 27, -2.0F, -1.0F, 0.0F, 4, 2, 3, 0.0F, false));
			tail.cubeList.add(new ModelBox(tail, 0, 12, 0.0F, 0.0F, 3.0F, 0, 1, 14, 0.0F, false));
			FinOne = new ModelRenderer(this);
			FinOne.setRotationPoint(2.0F, 23.0F, -2.0F);
			FinOne.cubeList.add(new ModelBox(FinOne, 0, 13, 0.0F, 0.0F, -7.0F, 11, 0, 13, 0.0F, false));
			Fintwo = new ModelRenderer(this);
			Fintwo.setRotationPoint(-2.0F, 23.0F, -2.0F);
			Fintwo.cubeList.add(new ModelBox(Fintwo, 0, 0, -11.0F, 0.0F, -7.0F, 11, 0, 13, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Body.render(f5);
			tail.render(f5);
			FinOne.render(f5);
			Fintwo.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.FinOne.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Fintwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
