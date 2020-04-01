//Made with Blockbench
//Paste this code into your mod.

public static class ModelPrisemnHelmet extends ModelBase {
	private final ModelRenderer Helmet;

	public ModelPrisemnHelmet() {
		textureWidth = 64;
		textureHeight = 64;

		Helmet = new ModelRenderer(this);
		Helmet.setRotationPoint(0.0F, 24.0F, 0.0F);
		Helmet.cubeList.add(new ModelBox(Helmet, 0, 45, -5.0F, -9.0F, -5.0F,
				10, 9, 10, 0.0F, false));
		Helmet.cubeList.add(new ModelBox(Helmet, 0, 25, 0.0F, -11.0F, -4.0F, 0,
				9, 11, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Helmet.render(f5);
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
		this.Helmet.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Helmet.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}