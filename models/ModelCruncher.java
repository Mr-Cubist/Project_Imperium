//Made with Blockbench
//Paste this code into your mod.

public static class ModelCruncher extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer legzero;
	private final ModelRenderer legone;
	private final ModelRenderer legtwo;
	private final ModelRenderer legthree;

	public ModelCruncher() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -6.0F, -2.0F, -10.0F, 12,
				10, 18, 0.0F, false));

		legzero = new ModelRenderer(this);
		legzero.setRotationPoint(5.0F, 10.0F, 7.0F);
		setRotationAngle(legzero, 0.0F, -0.3491F, 0.0F);
		legzero.cubeList.add(new ModelBox(legzero, 42, 0, 0.0F, -1.0F, -1.0F,
				7, 3, 3, 0.0F, false));
		legzero.cubeList.add(new ModelBox(legzero, 24, 28, 4.0F, 2.0F, -1.0F,
				3, 12, 3, 0.0F, false));

		legone = new ModelRenderer(this);
		legone.setRotationPoint(-5.0F, 10.0F, 7.0F);
		setRotationAngle(legone, 0.0F, 0.4363F, 0.0F);
		legone.cubeList.add(new ModelBox(legone, 33, 42, -7.0F, -1.0F, -1.0F,
				7, 3, 3, 0.0F, false));
		legone.cubeList.add(new ModelBox(legone, 12, 28, -7.0F, 2.0F, -1.0F, 3,
				12, 3, 0.0F, false));

		legtwo = new ModelRenderer(this);
		legtwo.setRotationPoint(6.0F, 11.0F, -4.0F);
		setRotationAngle(legtwo, 0.0F, 0.4363F, 0.0F);
		legtwo.cubeList.add(new ModelBox(legtwo, 36, 28, -1.0F, -2.0F, -1.0F,
				7, 3, 3, 0.0F, false));
		legtwo.cubeList.add(new ModelBox(legtwo, 0, 28, 3.0F, 1.0F, -1.0F, 3,
				12, 3, 0.0F, false));

		legthree = new ModelRenderer(this);
		legthree.setRotationPoint(-5.0F, 10.0F, -6.0F);
		setRotationAngle(legthree, 0.0F, -0.2618F, 0.0F);
		legthree.cubeList.add(new ModelBox(legthree, 36, 36, -7.0F, -1.0F,
				1.0F, 7, 3, 3, 0.0F, false));
		legthree.cubeList.add(new ModelBox(legthree, 0, 0, -7.0F, 2.0F, 1.0F,
				3, 12, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		legzero.render(f5);
		legone.render(f5);
		legtwo.render(f5);
		legthree.render(f5);
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
		this.legone.rotateAngleZ = MathHelper
				.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.legtwo.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legzero.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legthree.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
	}
}