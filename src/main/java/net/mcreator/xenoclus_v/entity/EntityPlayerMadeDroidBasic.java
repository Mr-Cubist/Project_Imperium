
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
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.item.ItemAlloy;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsXenoclusOne.ModElement.Tag
public class EntityPlayerMadeDroidBasic extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 72;
	public static final int ENTITYID_RANGED = 73;
	public EntityPlayerMadeDroidBasic(ElementsXenoclusOne instance) {
		super(instance, 411);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("xenoclus_v", "playermadedroidbasic"), ENTITYID).name("playermadedroidbasic").tracker(64, 3, true).build());
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
			return new RenderLiving(renderManager, new ModelClockworkDroidMelee(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/playermadedroid.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 6;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAITempt(this, 1, new ItemStack(Items.COAL, (int) (1), 0).getItem(), false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCruncherred.EntityCustom.class, false, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityUmbraZombie.EntityCustom.class, false, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityTrueKlight.EntityCustom.class, false, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySkelemage.EntityCustom.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityLaughingSpider.EntityCustom.class, false, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityGhostyGhostGhost.EntityCustom.class, false, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityTick.EntityCustom.class, false, false));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityBasicFrusk.EntityCustom.class, false, false));
			this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityArmoredFrusk.EntityCustom.class, false, false));
			this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityDrauger.EntityCustom.class, false, false));
			this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityClockworkDroidOne.EntityCustom.class, false, false));
			this.targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntityWendigo.EntityCustom.class, false, false));
			this.targetTasks.addTask(14, new EntityAINearestAttackableTarget(this, EntityBlaze.class, false, false));
			this.targetTasks.addTask(15, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, false, false));
			this.targetTasks.addTask(16, new EntityAINearestAttackableTarget(this, EntityDragon.class, false, false));
			this.targetTasks.addTask(17, new EntityAINearestAttackableTarget(this, EntityElderGuardian.class, false, false));
			this.targetTasks.addTask(18, new EntityAINearestAttackableTarget(this, EntityEndermite.class, false, false));
			this.targetTasks.addTask(19, new EntityAINearestAttackableTarget(this, EntityHusk.class, false, false));
			this.targetTasks.addTask(20, new EntityAINearestAttackableTarget(this, EntityGuardian.class, false, false));
			this.targetTasks.addTask(21, new EntityAINearestAttackableTarget(this, EntityGhast.class, false, false));
			this.targetTasks.addTask(22, new EntityAINearestAttackableTarget(this, EntityIllusionIllager.class, false, false));
			this.targetTasks.addTask(23, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, false, false));
			this.targetTasks.addTask(24, new EntityAINearestAttackableTarget(this, EntityShulker.class, false, false));
			this.targetTasks.addTask(25, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, false, false));
			this.targetTasks.addTask(26, new EntityAINearestAttackableTarget(this, EntitySlime.class, false, false));
			this.targetTasks.addTask(27, new EntityAINearestAttackableTarget(this, EntityWither.class, false, false));
			this.targetTasks.addTask(28, new EntityAINearestAttackableTarget(this, EntityWitch.class, false, false));
			this.targetTasks.addTask(29, new EntityAINearestAttackableTarget(this, EntityVindicator.class, false, false));
			this.targetTasks.addTask(30, new EntityAINearestAttackableTarget(this, EntityVex.class, false, false));
			this.targetTasks.addTask(31, new EntityAINearestAttackableTarget(this, EntitySpellcasterIllager.class, false, false));
			this.targetTasks.addTask(32, new EntityAINearestAttackableTarget(this, EntityStray.class, false, false));
			this.targetTasks.addTask(33, new EntityAINearestAttackableTarget(this, EntitySpider.class, false, false));
			this.targetTasks.addTask(34, new EntityAINearestAttackableTarget(this, EntityZombie.class, false, false));
			this.targetTasks.addTask(35, new EntityAINearestAttackableTarget(this, EntityZombieVillager.class, false, false));
			this.targetTasks.addTask(36, new EntityAINearestAttackableTarget(this, EntityBlaze.class, false, false));
			this.targetTasks.addTask(37, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(38, new EntityAIAttackMelee(this, 0.6, true));
			this.tasks.addTask(39, new EntityAIOpenDoor(this, true));
			this.tasks.addTask(40, new EntityAIWander(this, 0.5));
			this.tasks.addTask(41, new EntityAILookIdle(this));
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
			return new ItemStack(ItemAlloy.block, (int) (1)).getItem();
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
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
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
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelClockworkDroidMelee extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer leftArm;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftLeg;
		private final ModelRenderer rightLeg;
		public ModelClockworkDroidMelee() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -5.0F, -6.0F, 2, 2, 2, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 19, 19, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			setRotationAngle(leftArm, -1.4835F, 0.0F, 0.0F);
			leftArm.cubeList.add(new ModelBox(leftArm, 30, 35, -1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 0, 24, 0.0F, 7.0F, -9.0F, 0, 4, 11, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 0, 16, -2.0F, 9.0F, -9.0F, 4, 0, 11, 0.0F, false));
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			rightArm.cubeList.add(new ModelBox(rightArm, 22, 35, -1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F, false));
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			leftLeg.cubeList.add(new ModelBox(leftLeg, 32, 0, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 16, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			leftArm.render(f5);
			rightArm.render(f5);
			leftLeg.render(f5);
			rightLeg.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
