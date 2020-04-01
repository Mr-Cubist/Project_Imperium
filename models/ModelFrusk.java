//Made with Blockbench
//Paste this code into your mod.

public static class ModelFrusk extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Tail;

	public ModelFrusk() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 20.0F, 4.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -7.0F, -14.0F, 14,
				11, 14, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 33, 25, -6.0F, -7.0F, -15.0F, 12,
				11, 0, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 32, 0.0F, -11.0F, -12.0F, 0, 6,
				14, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 42, 0, -6.0F, -12.0F, -12.0F, 12,
				5, 0, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 20.0F, 4.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 25, -5.0F, -4.0F, 0.0F, 10, 8,
				13, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 37, 37, -3.0F, -2.0F, 13.0F, 6, 6,
				9, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 21, 46, -1.0F, 1.0F, 22.0F, 2, 3,
				7, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Tail.render(f5);
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
		this.Body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Body.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}