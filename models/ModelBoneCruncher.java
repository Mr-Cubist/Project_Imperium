//Made with Blockbench
//Paste this code into your mod.

public static class ModelBoneCruncher extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Legone;
	private final ModelRenderer LegTwo;
	private final ModelRenderer Legthree;
	private final ModelRenderer LegFour;

	public ModelBoneCruncher() {
		textureWidth = 256;
		textureHeight = 256;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -7.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 86, 76, -7.0F, -4.0F, -10.0F, 14,
				10, 0, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 50, 51, -10.0F, 6.0F, -11.0F, 20,
				3, 10, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 38, -10.0F, -7.0F, -11.0F, 20,
				13, 10, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -10.0F, -7.0F, -1.0F, 20,
				16, 22, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 39, 0.0F, -12.0F, -2.0F, 0, 5,
				22, 0.0F, false));

		Legone = new ModelRenderer(this);
		Legone.setRotationPoint(8.0F, -4.0F, 0.0F);
		setRotationAngle(Legone, 0.0F, 0.5236F, 0.0F);
		Legone.cubeList.add(new ModelBox(Legone, 84, 0, 9.0F, 2.0F, -4.0F, 6,
				26, 6, 0.0F, false));
		Legone.cubeList.add(new ModelBox(Legone, 94, 32, 1.0F, -4.0F, -4.0F,
				14, 6, 6, 0.0F, false));

		LegTwo = new ModelRenderer(this);
		LegTwo.setRotationPoint(8.0F, -5.0F, 17.0F);
		setRotationAngle(LegTwo, 0.0F, -0.4363F, 0.0F);
		LegTwo.cubeList.add(new ModelBox(LegTwo, 0, 66, 9.0F, 3.0F, -3.0F, 6,
				26, 6, 0.0F, false));
		LegTwo.cubeList.add(new ModelBox(LegTwo, 86, 64, 1.0F, -3.0F, -3.0F,
				14, 6, 6, 0.0F, false));

		Legthree = new ModelRenderer(this);
		Legthree.setRotationPoint(-9.0F, -4.0F, 0.0F);
		setRotationAngle(Legthree, 0.0F, -0.5236F, 0.0F);
		Legthree.cubeList.add(new ModelBox(Legthree, 62, 64, -13.0F, 2.0F,
				-4.0F, 6, 26, 6, 0.0F, false));
		Legthree.cubeList.add(new ModelBox(Legthree, 86, 86, -13.0F, -4.0F,
				-4.0F, 14, 6, 6, 0.0F, false));

		LegFour = new ModelRenderer(this);
		LegFour.setRotationPoint(-8.0F, -5.0F, 14.0F);
		setRotationAngle(LegFour, 0.0F, 0.4363F, 0.0F);
		LegFour.cubeList.add(new ModelBox(LegFour, 38, 64, -14.0F, 3.0F, 0.0F,
				6, 26, 6, 0.0F, false));
		LegFour.cubeList.add(new ModelBox(LegFour, 60, 38, -14.0F, -3.0F, 0.0F,
				14, 6, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Legone.render(f5);
		LegTwo.render(f5);
		Legthree.render(f5);
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
		this.LegTwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LegFour.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Legthree.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Legone.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}