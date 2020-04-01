//Made with Blockbench
//Paste this code into your mod.

public static class ModelFleeFish extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Tail;

	public ModelFleeFish() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -2.0F, -6.0F, -5.0F, 4, 4,
				8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 4, 0.0F, -9.0F, -5.0F, 0, 3, 8,
				0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 11, -2.0F, -2.0F, -4.0F, 0, 2,
				6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 9, 2.0F, -2.0F, -4.0F, 0, 2, 6,
				0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 12, 12, 0.0F, -7.0F, 3.0F, 0, 6,
				4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
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