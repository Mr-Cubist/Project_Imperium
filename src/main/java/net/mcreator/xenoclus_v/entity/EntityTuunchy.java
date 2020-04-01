
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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
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
public class EntityTuunchy extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 63;
	public static final int ENTITYID_RANGED = 64;
	public EntityTuunchy(ElementsXenoclusOne instance) {
		super(instance, 416);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "tuunchy"), ENTITYID)
				.name("tuunchy").tracker(64, 3, true).egg(-16724737, -16737844).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothaquabeach")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:pastelpalms")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:kelpforest")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:brightreef")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothmountains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 7, 2, 5, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelTuunchy(), 0.3f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/tuunchy.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 4;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIPanic(this, 1.2));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.FISH, (int) (1), 0).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelTuunchy extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer leg0;
		private final ModelRenderer leg1;
		private final ModelRenderer wing0;
		private final ModelRenderer wing1;
		private final ModelRenderer Tail;
		public ModelTuunchy() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 16.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -10.0F, -2.0F, 6, 14, 5, 0.0F, false));
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(2.0F, 19.0F, 1.0F);
			leg0.cubeList.add(new ModelBox(leg0, 24, 24, -2.0F, 0.0F, -2.0F, 3, 5, 3, 0.0F, false));
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-1.0F, 19.0F, 1.0F);
			leg1.cubeList.add(new ModelBox(leg1, 22, 0, -2.0F, 0.0F, -2.0F, 3, 5, 3, 0.0F, false));
			wing0 = new ModelRenderer(this);
			wing0.setRotationPoint(3.0F, 13.0F, 0.0F);
			wing0.cubeList.add(new ModelBox(wing0, 12, 19, 0.0F, -3.0F, -2.0F, 1, 7, 5, 0.0F, false));
			wing1 = new ModelRenderer(this);
			wing1.setRotationPoint(-3.0F, 13.0F, 0.0F);
			wing1.cubeList.add(new ModelBox(wing1, 0, 19, -1.0F, -3.0F, -2.0F, 1, 7, 5, 0.0F, false));
			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.0F, 17.0F, 1.0F);
			setRotationAngle(Tail, -0.6109F, 0.0F, 0.0F);
			Tail.cubeList.add(new ModelBox(Tail, 13, 13, -2.0F, 0.0F, 1.0F, 4, 0, 9, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			leg0.render(f5);
			leg1.render(f5);
			wing0.render(f5);
			wing1.render(f5);
			Tail.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
