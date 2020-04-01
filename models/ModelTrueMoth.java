//Made with Blockbench
//Paste this code into your mod.

public static class ModelTrueMoth extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Wing1;
	private final ModelRenderer Wing2;

	public ModelTrueMoth() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 26, -5.0F, -13.0F, -7.0F, 10,
				10, 17, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 22, -2.0F, -13.0F, -11.0F, 4,
				2, 4, 0.0F, false));

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
		Legs.cubeList.add(new ModelBox(Legs, 37, 29, -5.0F, -3.0F, -2.0F, 10,
				3, 0, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 37, 37, -5.0F, -3.0F, 1.0F, 10, 3,
				0, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 37, 26, -5.0F, -3.0F, 0.0F, 10, 3,
				0, 0.0F, false));

		Wing1 = new ModelRenderer(this);
		Wing1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Wing1.cubeList.add(new ModelBox(Wing1, 0, 13, -1.0F, -11.0F, -5.0F, 23,
				0, 13, 0.0F, false));

		Wing2 = new ModelRenderer(this);
		Wing2.setRotationPoint(0.0F, 24.0F, 0.0F);
		Wing2.cubeList.add(new ModelBox(Wing2, 0, 0, -22.0F, -11.0F, -5.0F, 23,
				0, 13, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
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