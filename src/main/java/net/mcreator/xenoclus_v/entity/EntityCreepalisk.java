
package net.mcreator.xenoclus_v.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.xenoclus_v.procedure.ProcedureOKBOOMERGIVEN;
import net.mcreator.xenoclus_v.procedure.ProcedureCreepaliskChooseAttack;
import net.mcreator.xenoclus_v.item.ItemAncientOverworldShard;
import net.mcreator.xenoclus_v.ElementsXenoclusOne;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsXenoclusOne.ModElement.Tag
public class EntityCreepalisk extends ElementsXenoclusOne.ModElement {
	public static final int ENTITYID = 98;
	public static final int ENTITYID_RANGED = 99;
	public EntityCreepalisk(ElementsXenoclusOne instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("xenoclus_v", "creepalisk"), ENTITYID).name("creepalisk").tracker(65, 3, true).build());
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
			return new RenderLiving(renderManager, new ModelCreepalisk(), 0.6f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("xenoclus_v:textures/creepalisk.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.7f, 1.8f);
			experienceValue = 9;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(6, new EntityAIWander(this, 1));
			this.tasks.addTask(7, new EntityAILookIdle(this));
			this.tasks.addTask(8, new EntityAISwimming(this));
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
			return new ItemStack(ItemAncientOverworldShard.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.fire.extinguish"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wither.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureCreepaliskChooseAttack.executeProcedure($_dependencies);
			}
			if (source == DamageSource.FALL)
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
				ProcedureOKBOOMERGIVEN.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(165D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(11D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);
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
	public static class ModelCreepalisk extends ModelBase {
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer Torso;
		private final ModelRenderer LegOne;
		private final ModelRenderer LegTwo;
		private final ModelRenderer LegThree;
		private final ModelRenderer LegFour;
		public ModelCreepalisk() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -4.0F, -5.0F);
			Head.cubeList.add(new ModelBox(Head, 44, 48, -5.0F, -8.0F, -11.0F, 10, 10, 10, 0.0F, false));
			Head.cubeList.add(new ModelBox(Head, 37, 0, -5.0F, 2.0F, -11.0F, 10, 5, 0, 0.0F, false));
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -31.0F, -7.0F, 14, 12, 9, 0.0F, false));
			Body.cubeList.add(new ModelBox(Body, 56, 14, 0.0F, -34.0F, -6.0F, 0, 15, 11, 0.0F, false));
			Torso = new ModelRenderer(this);
			Torso.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(Torso, 0.0873F, 0.0F, 0.0F);
			Torso.cubeList.add(new ModelBox(Torso, 0, 61, -5.0F, -23.0F, -1.0F, 10, 16, 6, 0.0F, false));
			LegOne = new ModelRenderer(this);
			LegOne.setRotationPoint(3.0F, 15.0F, 2.0F);
			setRotationAngle(LegOne, 0.0F, -0.5236F, 0.0F);
			LegOne.cubeList.add(new ModelBox(LegOne, 0, 41, -4.0F, -1.0F, -17.7321F, 6, 4, 16, 0.0F, false));
			LegOne.cubeList.add(new ModelBox(LegOne, 73, 35, -4.0F, 3.0F, -17.7321F, 6, 6, 5, 0.0F, false));
			LegTwo = new ModelRenderer(this);
			LegTwo.setRotationPoint(-3.0F, 15.0F, 2.0F);
			setRotationAngle(LegTwo, 0.0F, 0.5236F, 0.0F);
			LegTwo.cubeList.add(new ModelBox(LegTwo, 30, 5, -2.0F, -1.0F, -17.7321F, 6, 4, 16, 0.0F, false));
			LegTwo.cubeList.add(new ModelBox(LegTwo, 54, 68, -2.0F, 3.0F, -17.7321F, 6, 6, 5, 0.0F, false));
			LegThree = new ModelRenderer(this);
			LegThree.setRotationPoint(3.0F, 15.0F, 2.0F);
			setRotationAngle(LegThree, 0.0F, -2.5307F, 0.0F);
			LegThree.cubeList.add(new ModelBox(LegThree, 28, 28, -2.0F, -1.0F, -15.7321F, 6, 4, 16, 0.0F, false));
			LegThree.cubeList.add(new ModelBox(LegThree, 32, 68, -2.0F, 3.0F, -15.7321F, 6, 6, 5, 0.0F, false));
			LegFour = new ModelRenderer(this);
			LegFour.setRotationPoint(-3.0F, 15.0F, 2.0F);
			setRotationAngle(LegFour, 0.0F, 2.5307F, 0.0F);
			LegFour.cubeList.add(new ModelBox(LegFour, 0, 21, -4.0F, -1.0F, -15.7321F, 6, 4, 16, 0.0F, false));
			LegFour.cubeList.add(new ModelBox(LegFour, 58, 0, -4.0F, 3.0F, -15.7321F, 6, 6, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Head.render(f5);
			Body.render(f5);
			Torso.render(f5);
			LegOne.render(f5);
			LegTwo.render(f5);
			LegThree.render(f5);
			LegFour.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.LegTwo.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LegThree.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LegFour.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LegOne.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
