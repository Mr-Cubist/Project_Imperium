//Made with Blockbench
//Paste this code into your mod.

public static class ModelFlounder extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer Finleft;
	private final ModelRenderer Tail;
	private final ModelRenderer FinRight;

	public ModelFlounder() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -9.0F, -8.0F, -7.0F, 18, 8,
				10, 0.0F, false));

		Finleft = new ModelRenderer(this);
		Finleft.setRotationPoint(9.0F, 23.0F, 1.0F);
		Finleft.cubeList.add(new ModelBox(Finleft, 28, 39, 0.0F, 0.0F, -4.0F,
				6, 0, 6, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 23.0F, 3.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 18, -7.0F, -4.0F, 0.0F, 14, 5,
				11, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 34, -5.0F, -2.0F, 11.0F, 10, 3,
				7, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, 0.0F, -4.0F, 18.0F, 0, 5, 5,
				0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 27, 24, 0.0F, -9.0F, 0.0F, 0, 5,
				10, 0.0F, false));

		FinRight = new ModelRenderer(this);
		FinRight.setRotationPoint(-9.0F, 23.0F, 0.0F);
		FinRight.cubeList.add(new ModelBox(FinRight, 33, 18, -6.0F, 0.0F,
				-3.0F, 6, 0, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Head.render(f5);
		Finleft.render(f5);
		Tail.render(f5);
		FinRight.render(f5);
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
		this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}