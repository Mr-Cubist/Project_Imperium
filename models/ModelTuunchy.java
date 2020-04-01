//Made with Blockbench
//Paste this code into your mod.

public static class ModelTuunchy extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer wing0;
	private final ModelRenderer wing1;
	private final ModelRenderer Tail;

	public ModelTuunchy() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -10.0F, -2.0F, 6, 14,
				5, 0.0F, false));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(2.0F, 19.0F, 1.0F);
		leg0.cubeList.add(new ModelBox(leg0, 24, 24, -2.0F, 0.0F, -2.0F, 3, 5,
				3, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-1.0F, 19.0F, 1.0F);
		leg1.cubeList.add(new ModelBox(leg1, 22, 0, -2.0F, 0.0F, -2.0F, 3, 5,
				3, 0.0F, false));

		wing0 = new ModelRenderer(this);
		wing0.setRotationPoint(3.0F, 13.0F, 0.0F);
		wing0.cubeList.add(new ModelBox(wing0, 12, 19, 0.0F, -3.0F, -2.0F, 1,
				7, 5, 0.0F, false));

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(-3.0F, 13.0F, 0.0F);
		wing1.cubeList.add(new ModelBox(wing1, 0, 19, -1.0F, -3.0F, -2.0F, 1,
				7, 5, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 17.0F, 1.0F);
		setRotationAngle(Tail, -0.6109F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 13, 13, -2.0F, 0.0F, 1.0F, 4, 0,
				9, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		wing0.render(f5);
		wing1.render(f5);
		Tail.render(f5);
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
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}