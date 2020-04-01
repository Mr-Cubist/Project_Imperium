
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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.procedure.ProcedureWendigoEscape;
import net.mcreator.xenoclus_v.procedure.ProcedureWendigoEngage;
import net.mcreator.xenoclus_v.item.ItemShadeWraps;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class EntityWendigo extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 61;
	public static final int ENTITYID_RANGED = 62;
	public EntityWendigo(ElementsXenoclusOne instance) {
		super(instance, 414);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("xenoclus_v", "wendigo"), ENTITYID)
				.name("wendigo").tracker(64, 3, true).egg(-16777216, -16764109).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("xenoclus_v:iceplains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 2, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelWendigo(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/wendigocopy.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 14;
			this.isImmuneToFire = true;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIBreakDoor(this));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.7, false));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAITempt(this, 1, new ItemStack(Items.COOKED_MUTTON, (int) (1)).getItem(), true));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityWolf.class, true, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntitySheep.class, true, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityPolarBear.class, true, false));
			this.tasks.addTask(8, new EntityAIAvoidEntity(this, EntityPlayerMP.class, (float) 10, 0.8, 1));
			this.tasks.addTask(9, new EntityAIAvoidEntity(this, EntityPlayer.class, (float) 10, 0.8, 1));
			this.tasks.addTask(10, new EntityAIRestrictSun(this));
			this.tasks.addTask(11, new EntityAIWander(this, 0.1));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemShadeWraps.block, (int) (1)).getItem();
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
			if (source == DamageSource.LIGHTNING_BOLT)
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
				ProcedureWendigoEscape.executeProcedure($_dependencies);
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
				ProcedureWendigoEngage.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelWendigo extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer leftArm;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftLeg;
		private final ModelRenderer rightLeg;
		public ModelWendigo() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -15.0F, -2.0F, 8, 29, 4, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 14, 31, 0.0F, -11.0F, 2.0F, 0, 17, 2, 0.0F, false));
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(-5.0F, -7.0F, 0.0F);
			setRotationAngle(leftArm, -0.3491F, 0.0F, 0.0F);
			leftArm.cubeList.add(new ModelBox(leftArm, 0, 33, -2.0F, -3.0F, -2.0F, 3, 25, 4, 0.0F, false));
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(5.0F, -7.0F, 0.0F);
			setRotationAngle(rightArm, -0.3491F, 0.0F, 0.0F);
			rightArm.cubeList.add(new ModelBox(rightArm, 24, 24, -1.0F, -3.0F, -2.0F, 3, 25, 4, 0.0F, false));
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(-1.9F, 14.0F, 0.0F);
			leftLeg.cubeList.add(new ModelBox(leftLeg, 34, 14, -2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F, false));
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(1.9F, 14.0F, 0.0F);
			rightLeg.cubeList.add(new ModelBox(rightLeg, 24, 0, -2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
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
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
