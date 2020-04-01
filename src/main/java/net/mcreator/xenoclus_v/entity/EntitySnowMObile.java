
package net.mcreator.xenoclus_v.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.procedure.ProcedureSnowMobileReturn;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@ElementsXenoclusOne.ModElement.Tag
public class EntitySnowMObile extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 50;
	public static final int ENTITYID_RANGED = 51;
	public EntitySnowMObile(ElementsXenoclusOne instance) {
		super(instance, 412);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("xenoclus_v", "snowmobile"), ENTITYID).name("snowmobile").tracker(64, 3, true).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelSnowmobile(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/snowmobileboyoyy.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.9f, 0.3f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
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
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureSnowMobileReturn.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			super.processInteract(entity, hand);
			entity.startRiding(this);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			return true;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof EntityLivingBase) {
					this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
					float forward = ((EntityLivingBase) entity).moveForward;
					float strafe = 0;
					super.travel(strafe, 0, forward);
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(ti, tj, tk);
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (double) ((float) i + 0.5) + (double) (random.nextFloat() - 0.5) * 0.4000000014901161D;
					double d1 = ((double) ((float) j + 0.7) + (double) (random.nextFloat() - 0.5) * 0.4000000014901161D) + 0.5;
					double d2 = (double) ((float) k + 0.5) + (double) (random.nextFloat() - 0.5) * 0.4000000014901161D;
					world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0, 0, 0);
				}
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelSnowmobile extends ModelBase {
		private final ModelRenderer Snowmobile;
		private final ModelRenderer Minecart;
		private final ModelRenderer boneneedmilk;
		private final ModelRenderer bone;
		private final ModelRenderer Winshield;
		private final ModelRenderer front;
		private final ModelRenderer bonesuck;
		private final ModelRenderer bonedaddy;
		private final ModelRenderer boned;
		private final ModelRenderer boner;
		private final ModelRenderer skil;
		private final ModelRenderer leaningpart;
		private final ModelRenderer forntofski;
		private final ModelRenderer Skitwo;
		private final ModelRenderer LeaningUno;
		private final ModelRenderer Frontofskiuno;
		private final ModelRenderer motor_stuff;
		private final ModelRenderer trackone;
		private final ModelRenderer tracktwo;
		public ModelSnowmobile() {
			textureWidth = 128;
			textureHeight = 128;
			Snowmobile = new ModelRenderer(this);
			Snowmobile.setRotationPoint(-2.0F, 14.0F, 6.0F);
			Minecart = new ModelRenderer(this);
			Minecart.setRotationPoint(0.0F, 0.0F, 0.0F);
			Snowmobile.addChild(Minecart);
			Minecart.cubeList.add(new ModelBox(Minecart, 0, 0, -6.0F, 5.7F, -16.0F, 16, 1, 20, 0.0F, false));
			Minecart.cubeList.add(new ModelBox(Minecart, 46, 21, -6.0F, -3.3F, -14.0F, 2, 9, 16, 0.0F, false));
			Minecart.cubeList.add(new ModelBox(Minecart, 46, 46, 8.0F, -3.3F, -14.0F, 2, 9, 16, 0.0F, false));
			boneneedmilk = new ModelRenderer(this);
			boneneedmilk.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(boneneedmilk, 0.0F, 1.5708F, 0.0F);
			Minecart.addChild(boneneedmilk);
			boneneedmilk.cubeList.add(new ModelBox(boneneedmilk, 0, 46, 14.0F, -3.3F, -6.0F, 2, 9, 16, 0.0F, false));
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
			Minecart.addChild(bone);
			bone.cubeList.add(new ModelBox(bone, 26, 30, -4.0F, -3.3F, -6.0F, 2, 9, 16, 0.0F, false));
			Winshield = new ModelRenderer(this);
			Winshield.setRotationPoint(2.0F, -3.334F, -8.5911F);
			setRotationAngle(Winshield, -0.4363F, 0.0F, 0.0F);
			Snowmobile.addChild(Winshield);
			Winshield.cubeList.add(new ModelBox(Winshield, 66, 54, -7.0F, -1.9643F, -5.4378F, 14, 5, 0, 0.0F, false));
			front = new ModelRenderer(this);
			front.setRotationPoint(0.0F, 10.0F, 0.0F);
			Snowmobile.addChild(front);
			front.cubeList.add(new ModelBox(front, 39, 21, -3.0F, -8.3F, -29.0F, 10, 3, 1, 0.0F, false));
			front.cubeList.add(new ModelBox(front, 0, 21, -2.0F, -14.3F, -21.0F, 4, 3, 5, 0.0F, false));
			bonesuck = new ModelRenderer(this);
			bonesuck.setRotationPoint(0.0F, -14.5F, -10.5F);
			setRotationAngle(bonesuck, -1.309F, 0.0F, 0.0F);
			front.addChild(bonesuck);
			bonesuck.cubeList.add(new ModelBox(bonesuck, 73, 0, -4.0F, 3.7708F, 0.4529F, 12, 16, 1, 0.0F, false));
			bonedaddy = new ModelRenderer(this);
			bonedaddy.setRotationPoint(0.0F, -14.5F, -10.5F);
			setRotationAngle(bonedaddy, -1.6581F, 0.0F, 0.0F);
			front.addChild(bonedaddy);
			bonedaddy.cubeList.add(new ModelBox(bonedaddy, 30, 73, -4.0F, 1.9804F, 10.7012F, 12, 16, 1, 0.0F, false));
			boned = new ModelRenderer(this);
			boned.setRotationPoint(-5.5F, -11.5F, -16.0F);
			setRotationAngle(boned, -0.0873F, 0.0F, 0.0F);
			front.addChild(boned);
			boned.cubeList.add(new ModelBox(boned, 0, 71, 1.5F, 3.7012F, -12.4804F, 1, 4, 14, 0.0F, false));
			boned.cubeList.add(new ModelBox(boned, 0, 71, 12.5F, 3.7012F, -12.4804F, 1, 4, 14, 0.0F, false));
			boner = new ModelRenderer(this);
			boner.setRotationPoint(-5.5F, -15.9829F, -15.6078F);
			setRotationAngle(boner, 0.2618F, 0.0F, 0.0F);
			front.addChild(boner);
			boner.cubeList.add(new ModelBox(boner, 68, 36, 1.5F, 3.9529F, -14.2708F, 1, 4, 14, 0.0F, false));
			boner.cubeList.add(new ModelBox(boner, 68, 36, 12.5F, 3.9529F, -14.2708F, 1, 4, 14, 0.0F, false));
			skil = new ModelRenderer(this);
			skil.setRotationPoint(13.0F, 10.0F, 0.0F);
			Snowmobile.addChild(skil);
			skil.cubeList.add(new ModelBox(skil, 8, 21, -7.0F, -0.3F, -34.0F, 4, 0, 15, 0.0F, false));
			skil.cubeList.add(new ModelBox(skil, 8, 6, -5.0F, -5.3F, -23.0F, 1, 5, 1, 0.0F, false));
			skil.cubeList.add(new ModelBox(skil, 15, 0, -5.0F, -2.3F, -28.0F, 1, 2, 1, 0.0F, false));
			skil.cubeList.add(new ModelBox(skil, 8, 0, -5.0F, -3.3F, -28.0F, 1, 1, 5, 0.0F, false));
			leaningpart = new ModelRenderer(this);
			leaningpart.setRotationPoint(-4.5F, -5.65F, -16.5637F);
			setRotationAngle(leaningpart, -1.0472F, 0.0F, 0.0F);
			skil.addChild(leaningpart);
			leaningpart.cubeList.add(new ModelBox(leaningpart, 0, 29, -0.5F, -3.3038F, -3.5F, 1, 9, 1, 0.0F, false));
			forntofski = new ModelRenderer(this);
			forntofski.setRotationPoint(-5.0F, -0.7758F, -28.7078F);
			setRotationAngle(forntofski, -0.5236F, 0.0F, 0.0F);
			skil.addChild(forntofski);
			forntofski.cubeList.add(new ModelBox(forntofski, 5, 14, -2.0F, 3.0F, -7.3962F, 4, 0, 3, 0.0F, false));
			Skitwo = new ModelRenderer(this);
			Skitwo.setRotationPoint(13.0F, 10.0F, 0.0F);
			Snowmobile.addChild(Skitwo);
			Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 21, -19.0F, -0.3F, -34.0F, 4, 0, 15, 0.0F, false));
			Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 6, -18.0F, -5.3F, -23.0F, 1, 5, 1, 0.0F, false));
			Skitwo.cubeList.add(new ModelBox(Skitwo, 15, 0, -18.0F, -2.3F, -28.0F, 1, 2, 1, 0.0F, false));
			Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 0, -18.0F, -3.3F, -28.0F, 1, 1, 5, 0.0F, false));
			LeaningUno = new ModelRenderer(this);
			LeaningUno.setRotationPoint(-4.5F, -5.65F, -16.5637F);
			setRotationAngle(LeaningUno, -1.0472F, 0.0F, 0.0F);
			Skitwo.addChild(LeaningUno);
			LeaningUno.cubeList.add(new ModelBox(LeaningUno, 0, 29, -13.5F, -3.3038F, -3.5F, 1, 9, 1, 0.0F, false));
			Frontofskiuno = new ModelRenderer(this);
			Frontofskiuno.setRotationPoint(-5.0F, -0.7758F, -28.7078F);
			setRotationAngle(Frontofskiuno, -0.5236F, 0.0F, 0.0F);
			Skitwo.addChild(Frontofskiuno);
			Frontofskiuno.cubeList.add(new ModelBox(Frontofskiuno, 5, 14, -14.0F, 3.0F, -7.3962F, 4, 0, 3, 0.0F, false));
			motor_stuff = new ModelRenderer(this);
			motor_stuff.setRotationPoint(0.0F, 10.0F, 0.0F);
			Snowmobile.addChild(motor_stuff);
			motor_stuff.cubeList.add(new ModelBox(motor_stuff, 0, 0, 5.0F, -25.3F, -19.0F, 2, 16, 2, 0.0F, false));
			trackone = new ModelRenderer(this);
			trackone.setRotationPoint(2.0F, 10.0F, -6.0F);
			Snowmobile.addChild(trackone);
			trackone.cubeList.add(new ModelBox(trackone, 0, 21, -10.0F, -7.0F, -10.0F, 2, 6, 19, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 8, 29, -10.0F, -7.0F, -11.0F, 2, 6, 1, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 8, 29, -10.0F, -7.0F, 9.0F, 2, 6, 1, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 13, 21, -10.0F, -6.0F, -12.0F, 2, 4, 1, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 13, 21, -10.0F, -6.0F, 10.0F, 2, 4, 1, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 19, 55, -10.0F, -8.0F, -9.0F, 2, 1, 17, 0.0F, false));
			trackone.cubeList.add(new ModelBox(trackone, 52, 0, -10.0F, -1.0F, -9.0F, 2, 1, 17, 0.0F, false));
			tracktwo = new ModelRenderer(this);
			tracktwo.setRotationPoint(20.0F, 10.0F, -6.0F);
			Snowmobile.addChild(tracktwo);
			tracktwo.cubeList.add(new ModelBox(tracktwo, 0, 21, -10.0F, -7.0F, -10.0F, 2, 6, 19, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 8, 29, -10.0F, -7.0F, -11.0F, 2, 6, 1, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 8, 29, -10.0F, -7.0F, 9.0F, 2, 6, 1, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 13, 21, -10.0F, -6.0F, -12.0F, 2, 4, 1, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 13, 21, -10.0F, -6.0F, 10.0F, 2, 4, 1, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 19, 55, -10.0F, -8.0F, -9.0F, 2, 1, 17, 0.0F, false));
			tracktwo.cubeList.add(new ModelBox(tracktwo, 52, 0, -10.0F, -1.0F, -9.0F, 2, 1, 17, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Snowmobile.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
