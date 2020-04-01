//Made with Blockbench
//Paste this code into your mod.

public static class ModelMothLure extends ModelBase {
	private final ModelRenderer Legs;
	private final ModelRenderer Body;
	private final ModelRenderer Wing1;
	private final ModelRenderer Wing2;

	public ModelMothLure() {
		textureWidth = 64;
		textureHeight = 64;

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
		Legs.cubeList.add(new ModelBox(Legs, 0, 16, -2.0F, -4.0F, -3.0F, 4, 4,
				0, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 0, 4, -2.0F, -4.0F, -1.0F, 4, 4,
				0, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 0, 0, -2.0F, -4.0F, 1.0F, 4, 4, 0,
				0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, -8.0F, -5.0F, 6, 5,
				11, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -2.0F, -9.0F, -3.0F, 4, 1,
				0, 0.0F, false));

		Wing1 = new ModelRenderer(this);
		Wing1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Wing1.cubeList.add(new ModelBox(Wing1, 0, 16, 1.0F, -7.0F, -3.0F, 12,
				0, 8, 0.0F, false));

		Wing2 = new ModelRenderer(this);
		Wing2.setRotationPoint(0.0F, 24.0F, 0.0F);
		Wing2.cubeList.add(new ModelBox(Wing2, 15, 0, -13.0F, -7.0F, -3.0F, 12,
				0, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Legs.render(f5);
		Wing1.render(f5);
		Wing2.render(f5);
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
		this.Wing2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Wing1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}