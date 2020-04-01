//Made with Blockbench
//Paste this code into your mod.

public static class ModelDiskThrown extends ModelBase {
	private final ModelRenderer Thrown;

	public ModelDiskThrown() {
		textureWidth = 64;
		textureHeight = 64;

		Thrown = new ModelRenderer(this);
		Thrown.setRotationPoint(0.0F, 24.0F, 0.0F);
		Thrown.cubeList.add(new ModelBox(Thrown, 0, 0, -8.0F, -5.0F, -8.0F, 16,
				1, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Thrown.render(f5);
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
		this.Thrown.rotateAngleX = f2 / 20.f;
	}
}