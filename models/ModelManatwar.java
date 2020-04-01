//Made with Blockbench
//Paste this code into your mod.

public static class ModelManatwar extends ModelBase {
	private final ModelRenderer Cap;
	private final ModelRenderer Bigtentacle;
	private final ModelRenderer Tentacles;

	public ModelManatwar() {
		textureWidth = 128;
		textureHeight = 128;

		Cap = new ModelRenderer(this);
		Cap.setRotationPoint(0.0F, 24.0F, 0.0F);
		Cap.cubeList.add(new ModelBox(Cap, 0, 0, -15.0F, -37.0F, -15.0F, 30,
				15, 30, 0.0F, false));

		Bigtentacle = new ModelRenderer(this);
		Bigtentacle.setRotationPoint(0.0F, 24.0F, 0.0F);
		Bigtentacle.cubeList.add(new ModelBox(Bigtentacle, 64, 64, 0.0F,
				-35.0F, -7.0F, 0, 35, 14, 0.0F, false));
		Bigtentacle.cubeList.add(new ModelBox(Bigtentacle, 92, 92, -7.0F,
				-35.0F, 0.0F, 14, 35, 0, 0.0F, false));

		Tentacles = new ModelRenderer(this);
		Tentacles.setRotationPoint(0.0F, 24.0F, 0.0F);
		Tentacles.cubeList.add(new ModelBox(Tentacles, 0, 45, -8.0F, -35.0F,
				-8.0F, 16, 35, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Cap.render(f5);
		Bigtentacle.render(f5);
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
		this.Tentacles.rotateAngleY = f2 / 20.f;
		this.Cap.rotateAngleY = f2 / 20.f;
		this.Bigtentacle.rotateAngleY = f2 / 20.f;
	}
}