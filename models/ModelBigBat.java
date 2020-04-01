//Made with Blockbench
//Paste this code into your mod.

public static class ModelBigBat extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Wing1;
	private final ModelRenderer Wing2;

	public ModelBigBat() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Body, 0.3491F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, -14.0F, -3.0F, 6, 11,
				6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 18, 18, -3.0F, -3.0F, 0.0F, 6, 3,
				0, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Head, 0.3491F, 0.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 17, -3.0F, -19.0F, -3.0F, 6, 5,
				6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 3, -3.0F, -21.0F, -1.0F, 2, 2,
				1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, 1.0F, -21.0F, -1.0F, 2, 2,
				1, 0.0F, false));

		Wing1 = new ModelRenderer(this);
		Wing1.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Wing1, 0.3491F, 0.0F, 0.0F);
		Wing1.cubeList.add(new ModelBox(Wing1, 24, 0, -15.0F, -15.0F, 0.0F, 13,
				10, 0, 0.0F, false));

		Wing2 = new ModelRenderer(this);
		Wing2.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Wing2, 0.3491F, 0.0F, 0.0F);
		Wing2.cubeList.add(new ModelBox(Wing2, 24, 24, 2.0F, -15.0F, 0.0F, 13,
				10, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
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
		this.Wing2.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Wing1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}