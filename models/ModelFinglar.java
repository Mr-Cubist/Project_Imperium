//Made with Blockbench
//Paste this code into your mod.

public static class ModelFinglar extends ModelBase {
	private final ModelRenderer Tail;
	private final ModelRenderer Body;
	private final ModelRenderer Head;

	public ModelFinglar() {
		textureWidth = 128;
		textureHeight = 128;

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 22.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 53, 32, -3.0F, -4.0F, 0.0F, 6, 6,
				7, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 56, -2.0F, -2.0F, 7.0F, 4, 4,
				6, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 34, 30, 0.0F, -6.0F, 11.0F, 0, 8,
				9, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 45, 45, -3.0F, -8.0F, -7.0F, 6, 8,
				7, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, -14.0F, -7.0F, 6, 6,
				14, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 10.0F, 4.0F);
		Head.cubeList.add(new ModelBox(Head, 49, 13, -3.0F, -11.0F, -3.0F, 6,
				11, 6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 11, 39, -3.0F, -12.0F, -14.0F, 6,
				6, 11, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 15, 0.0F, -16.0F, -3.0F, 0, 20,
				11, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 22, 26, -4.0F, -9.0F, -15.0F, 8,
				2, 11, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, 0.0F, -13.0F, -30.0F, 0, 5,
				21, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 27, 0, -4.0F, -5.0F, -5.0F, 8, 6,
				7, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Tail.render(f5);
		Body.render(f5);
		Head.render(f5);
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
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}