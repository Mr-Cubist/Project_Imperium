//Made with Blockbench
//Paste this code into your mod.

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
		Head.cubeList.add(new ModelBox(Head, 44, 48, -5.0F, -8.0F, -11.0F, 10,
				10, 10, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 37, 0, -5.0F, 2.0F, -11.0F, 10, 5,
				0, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -31.0F, -7.0F, 14,
				12, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 56, 14, 0.0F, -34.0F, -6.0F, 0,
				15, 11, 0.0F, false));

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Torso, 0.0873F, 0.0F, 0.0F);
		Torso.cubeList.add(new ModelBox(Torso, 0, 61, -5.0F, -23.0F, -1.0F, 10,
				16, 6, 0.0F, false));

		LegOne = new ModelRenderer(this);
		LegOne.setRotationPoint(3.0F, 15.0F, 2.0F);
		setRotationAngle(LegOne, 0.0F, -0.5236F, 0.0F);
		LegOne.cubeList.add(new ModelBox(LegOne, 0, 41, -4.0F, -1.0F,
				-17.7321F, 6, 4, 16, 0.0F, false));
		LegOne.cubeList.add(new ModelBox(LegOne, 73, 35, -4.0F, 3.0F,
				-17.7321F, 6, 6, 5, 0.0F, false));

		LegTwo = new ModelRenderer(this);
		LegTwo.setRotationPoint(-3.0F, 15.0F, 2.0F);
		setRotationAngle(LegTwo, 0.0F, 0.5236F, 0.0F);
		LegTwo.cubeList.add(new ModelBox(LegTwo, 30, 5, -2.0F, -1.0F,
				-17.7321F, 6, 4, 16, 0.0F, false));
		LegTwo.cubeList.add(new ModelBox(LegTwo, 54, 68, -2.0F, 3.0F,
				-17.7321F, 6, 6, 5, 0.0F, false));

		LegThree = new ModelRenderer(this);
		LegThree.setRotationPoint(3.0F, 15.0F, 2.0F);
		setRotationAngle(LegThree, 0.0F, -2.5307F, 0.0F);
		LegThree.cubeList.add(new ModelBox(LegThree, 28, 28, -2.0F, -1.0F,
				-15.7321F, 6, 4, 16, 0.0F, false));
		LegThree.cubeList.add(new ModelBox(LegThree, 32, 68, -2.0F, 3.0F,
				-15.7321F, 6, 6, 5, 0.0F, false));

		LegFour = new ModelRenderer(this);
		LegFour.setRotationPoint(-3.0F, 15.0F, 2.0F);
		setRotationAngle(LegFour, 0.0F, 2.5307F, 0.0F);
		LegFour.cubeList.add(new ModelBox(LegFour, 0, 21, -4.0F, -1.0F,
				-15.7321F, 6, 4, 16, 0.0F, false));
		LegFour.cubeList.add(new ModelBox(LegFour, 58, 0, -4.0F, 3.0F,
				-15.7321F, 6, 6, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		Torso.render(f5);
		LegOne.render(f5);
		LegTwo.render(f5);
		LegThree.render(f5);
		LegFour.render(f5);
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
		this.LegTwo.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LegThree.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LegFour.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LegOne.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}