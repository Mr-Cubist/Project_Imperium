//Made with Blockbench
//Paste this code into your mod.

public static class ModelLivingBall extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Bodytwo;
	private final ModelRenderer Head;

	public ModelLivingBall() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 14.0F, 0.0F);
		setRotationAngle(Body, -0.7854F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -7.0F, -6.7861F, -7.1698F,
				14, 14, 14, 0.0F, false));

		Bodytwo = new ModelRenderer(this);
		Bodytwo.setRotationPoint(0.0F, 15.0F, 0.0F);
		setRotationAngle(Bodytwo, 0.0F, 0.6109F, 0.0F);
		Bodytwo.cubeList.add(new ModelBox(Bodytwo, 0, 28, -6.0F, -7.0F, -6.0F,
				12, 12, 12, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 15.0F, -6.0F);
		Head.cubeList.add(new ModelBox(Head, 36, 28, -6.0F, -5.0F, -5.0F, 12,
				7, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Bodytwo.render(f5);
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
		this.Bodytwo.rotateAngleX = f2 / 20.f;
		this.Body.rotateAngleX = f2;
	}
}