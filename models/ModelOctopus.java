//Made with Blockbench
//Paste this code into your mod.

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
		Head.cubeList.add(new ModelBox(Head, 34, 43, -4.0F, -11.0F, -4.0F, 8,
				11, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -5.0F, -12.0F, -5.0F, 10,
				13, 10, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 0, -7.0F, -15.0F, 0.0F, 14,
				16, 0, 0.0F, false));

		TentacleOne = new ModelRenderer(this);
		TentacleOne.setRotationPoint(-2.0F, 23.0F, -2.0F);
		setRotationAngle(TentacleOne, 0.0F, 0.0873F, 0.0F);
		TentacleOne.cubeList.add(new ModelBox(TentacleOne, 0, 40, -2.091F,
				-2.0F, -13.9166F, 3, 3, 14, 0.0F, false));

		TentacleTwo = new ModelRenderer(this);
		TentacleTwo.setRotationPoint(2.0F, 23.0F, -2.0F);
		setRotationAngle(TentacleTwo, 0.0F, -0.0873F, 0.0F);
		TentacleTwo.cubeList.add(new ModelBox(TentacleTwo, 26, 9, -0.909F,
				-2.0F, -13.9166F, 3, 3, 14, 0.0F, false));

		TentacleThree = new ModelRenderer(this);
		TentacleThree.setRotationPoint(2.0F, 23.0F, 2.0F);
		setRotationAngle(TentacleThree, 0.0F, 0.0873F, 0.0F);
		TentacleThree.cubeList.add(new ModelBox(TentacleThree, 20, 26, -0.909F,
				-2.0F, -0.0834F, 3, 3, 14, 0.0F, false));

		TentacleFour = new ModelRenderer(this);
		TentacleFour.setRotationPoint(-2.0F, 23.0F, 2.0F);
		setRotationAngle(TentacleFour, 0.0F, -0.0873F, 0.0F);
		TentacleFour.cubeList.add(new ModelBox(TentacleFour, 0, 23, -2.091F,
				-2.0F, -0.0834F, 3, 3, 14, 0.0F, false));

		TentacleFive = new ModelRenderer(this);
		TentacleFive.setRotationPoint(-2.0F, 23.0F, 2.0F);
		setRotationAngle(TentacleFive, 0.0F, 0.0873F, 0.0F);
		TentacleFive.cubeList.add(new ModelBox(TentacleFive, 0, 57, -14.0F,
				-2.0F, -1.0F, 14, 3, 3, 0.0F, false));

		TentacleSix = new ModelRenderer(this);
		TentacleSix.setRotationPoint(-2.0F, 23.0F, -2.0F);
		setRotationAngle(TentacleSix, 0.0F, -0.0873F, 0.0F);
		TentacleSix.cubeList.add(new ModelBox(TentacleSix, 46, 16, -14.0F,
				-2.0F, -2.0F, 14, 3, 3, 0.0F, false));

		TentacleSeven = new ModelRenderer(this);
		TentacleSeven.setRotationPoint(2.0F, 23.0F, -2.0F);
		setRotationAngle(TentacleSeven, 0.0F, 0.0873F, 0.0F);
		TentacleSeven.cubeList.add(new ModelBox(TentacleSeven, 40, 32, 0.0F,
				-2.0F, -2.0F, 14, 3, 3, 0.0F, false));

		TentacleEight = new ModelRenderer(this);
		TentacleEight.setRotationPoint(2.0F, 23.0F, 2.0F);
		setRotationAngle(TentacleEight, 0.0F, -0.0873F, 0.0F);
		TentacleEight.cubeList.add(new ModelBox(TentacleEight, 40, 26, 0.0F,
				-2.0F, -1.0F, 14, 3, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
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
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
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