
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
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
public class EntityCrabbo extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 65;
	public static final int ENTITYID_RANGED = 66;
	public EntityCrabbo(ElementsXenoclusOne instance) {
		super(instance, 424);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "crabbo"), ENTITYID)
				.name("crabbo").tracker(64, 3, true).egg(-6750208, -52).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothaquabeach")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:pastelpalms")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:kelpforest")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:brightreef")),
				Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:azathothmountains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 2, 5, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelCrab(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/crabcopy.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, true));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(5, new EntityAIWander(this, 1));
			this.tasks.addTask(6, new EntityAILookIdle(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.spider.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.stone.break"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.spider.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelCrab extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer eyes;
		private final ModelRenderer Clawuno;
		private final ModelRenderer Clawtwo;
		private final ModelRenderer LEGONE;
		private final ModelRenderer LEGDos;
		private final ModelRenderer LEGTres;
		private final ModelRenderer LEGFOUR;
		private final ModelRenderer LEGTWORIGHT;
		private final ModelRenderer LEGTHREERIGHT;
		private final ModelRenderer LEGONERIGHT;
		private final ModelRenderer LEGFOURRIGHT;
		public ModelCrab() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 15.0F, -1.0F);
			body.cubeList.add(new ModelBox(body, 0, 17, -6.0F, -1.0F, -6.0F, 12, 4, 12, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 0, -7.0F, -2.0F, -7.0F, 14, 3, 14, 0.0F, false));
			eyes = new ModelRenderer(this);
			eyes.setRotationPoint(0.0F, 15.0F, -7.0F);
			setRotationAngle(eyes, 0.6109F, 0.0F, 0.0F);
			eyes.cubeList.add(new ModelBox(eyes, 0, 0, -3.0F, -4.0F, -1.0F, 6, 5, 0, 0.0F, false));
			Clawuno = new ModelRenderer(this);
			Clawuno.setRotationPoint(-5.0F, 16.0F, -6.0F);
			setRotationAngle(Clawuno, 0.0F, 0.2618F, 0.0F);
			Clawuno.cubeList.add(new ModelBox(Clawuno, 18, 39, -2.0F, -2.0F, -7.0F, 3, 4, 6, 0.0F, false));
			Clawtwo = new ModelRenderer(this);
			Clawtwo.setRotationPoint(5.0F, 17.0F, -6.0F);
			setRotationAngle(Clawtwo, 0.0F, -0.3491F, 0.0F);
			Clawtwo.cubeList.add(new ModelBox(Clawtwo, 0, 39, -1.0F, -3.0F, -7.0F, 3, 4, 6, 0.0F, false));
			LEGONE = new ModelRenderer(this);
			LEGONE.setRotationPoint(5.0F, 16.0F, -3.0F);
			setRotationAngle(LEGONE, 0.1745F, 0.4363F, 0.7854F);
			LEGONE.cubeList.add(new ModelBox(LEGONE, 36, 26, 0.5774F, -0.8426F, -1.1075F, 11, 1, 2, 0.0F, false));
			LEGDos = new ModelRenderer(this);
			LEGDos.setRotationPoint(5.0F, 16.0F, -1.0F);
			setRotationAngle(LEGDos, 0.0F, 0.0873F, 0.6981F);
			LEGDos.cubeList.add(new ModelBox(LEGDos, 36, 23, 1.0872F, -1.0F, -0.9962F, 11, 1, 2, 0.0F, false));
			LEGTres = new ModelRenderer(this);
			LEGTres.setRotationPoint(5.0F, 16.0F, 1.0F);
			setRotationAngle(LEGTres, 0.0F, -0.0873F, 0.6981F);
			LEGTres.cubeList.add(new ModelBox(LEGTres, 36, 20, 0.7385F, -1.0F, -0.9886F, 11, 1, 2, 0.0F, false));
			LEGFOUR = new ModelRenderer(this);
			LEGFOUR.setRotationPoint(5.0F, 16.0F, 4.0F);
			setRotationAngle(LEGFOUR, 0.0F, -0.2618F, 0.7854F);
			LEGFOUR.cubeList.add(new ModelBox(LEGFOUR, 36, 17, -0.5529F, -1.0F, -1.7956F, 11, 1, 2, 0.0F, false));
			LEGTWORIGHT = new ModelRenderer(this);
			LEGTWORIGHT.setRotationPoint(-5.0F, 16.0F, -1.0F);
			setRotationAngle(LEGTWORIGHT, 0.0F, 0.1047F, 2.4435F);
			LEGTWORIGHT.cubeList.add(new ModelBox(LEGTWORIGHT, 26, 36, 1.0887F, 0.0F, -1.1707F, 11, 1, 2, 0.0F, false));
			LEGTHREERIGHT = new ModelRenderer(this);
			LEGTHREERIGHT.setRotationPoint(-5.0F, 16.0F, 1.0F);
			setRotationAngle(LEGTHREERIGHT, 0.0F, -0.0698F, 2.4435F);
			LEGTHREERIGHT.cubeList.add(new ModelBox(LEGTHREERIGHT, 0, 36, 0.9492F, 0.0F, -1.1658F, 11, 1, 2, 0.0F, false));
			LEGONERIGHT = new ModelRenderer(this);
			LEGONERIGHT.setRotationPoint(-5.0F, 16.0F, -4.0F);
			setRotationAngle(LEGONERIGHT, 0.0F, 0.3665F, 2.3562F);
			LEGONERIGHT.cubeList.add(new ModelBox(LEGONERIGHT, 26, 33, 0.0136F, 0.0F, -0.37F, 11, 1, 2, 0.0F, false));
			LEGFOURRIGHT = new ModelRenderer(this);
			LEGFOURRIGHT.setRotationPoint(-5.0F, 16.0F, 3.0F);
			setRotationAngle(LEGFOURRIGHT, 0.0F, -0.3316F, 2.3562F);
			LEGFOURRIGHT.cubeList.add(new ModelBox(LEGFOURRIGHT, 0, 33, 0.298F, 0.0F, -1.0569F, 11, 1, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			eyes.render(f5);
			Clawuno.render(f5);
			Clawtwo.render(f5);
			LEGONE.render(f5);
			LEGDos.render(f5);
			LEGTres.render(f5);
			LEGFOUR.render(f5);
			LEGTWORIGHT.render(f5);
			LEGTHREERIGHT.render(f5);
			LEGONERIGHT.render(f5);
			LEGFOURRIGHT.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.LEGTres.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEGTHREERIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEGFOUR.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEGONE.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEGONERIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEGDos.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEGTWORIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEGFOURRIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
