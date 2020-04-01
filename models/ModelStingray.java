//Made with Blockbench
//Paste this code into your mod.

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
		Body.cubeList.add(new ModelBox(Body, 24, 24, -4.0F, -3.0F, -8.0F, 8, 3,
				11, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 39, 4, -2.0F, -2.0F, -6.0F, 4, 1,
				8, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 23.0F, 3.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 27, -2.0F, -1.0F, 0.0F, 4, 2,
				3, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 0, 12, 0.0F, 0.0F, 3.0F, 0, 1, 14,
				0.0F, false));

		FinOne = new ModelRenderer(this);
		FinOne.setRotationPoint(2.0F, 23.0F, -2.0F);
		FinOne.cubeList.add(new ModelBox(FinOne, 0, 13, 0.0F, 0.0F, -7.0F, 11,
				0, 13, 0.0F, false));

		Fintwo = new ModelRenderer(this);
		Fintwo.setRotationPoint(-2.0F, 23.0F, -2.0F);
		Fintwo.cubeList.add(new ModelBox(Fintwo, 0, 0, -11.0F, 0.0F, -7.0F, 11,
				0, 13, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		tail.render(f5);
		FinOne.render(f5);
		Fintwo.render(f5);
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
		this.FinOne.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.Fintwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}