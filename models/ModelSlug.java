//Made with Blockbench
//Paste this code into your mod.

public static class ModelSlug extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer Middle;

	public ModelSlug() {
		textureWidth = 32;
		textureHeight = 32;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -3.0F, -5.0F, -8.0F, 6, 5,
				5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 13, 13, -3.0F, -7.0F, -8.0F, 6, 2,
				0, 0.0F, false));

		Middle = new ModelRenderer(this);
		Middle.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Middle);
		Middle.cubeList.add(new ModelBox(Middle, 0, 10, -2.0F, -4.0F, -3.0F, 4,
				4, 5, 0.0F, false));
		Middle.cubeList.add(new ModelBox(Middle, 14, 15, -1.0F, -3.0F, 2.0F, 2,
				3, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
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
		this.Middle.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}