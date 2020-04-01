//Made with Blockbench
//Paste this code into your mod.

public static class ModelJellyfish extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer Tentacles;

	public ModelJellyfish() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -5.0F, -3.0F, -5.0F, 10, 6,
				10, 0.0F, false));

		Tentacles = new ModelRenderer(this);
		Tentacles.setRotationPoint(0.0F, 12.0F, 0.0F);
		Tentacles.cubeList.add(new ModelBox(Tentacles, 0, 16, -4.0F, -2.0F,
				-4.0F, 8, 13, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		Tentacles.render(f5);
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
		this.Tentacles.rotateAngleY = f2;
		this.body.rotateAngleY = f2 / 20.f;
	}
}