//Made with Blockbench
//Paste this code into your mod.

public static class ModelTickGeo extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Leg1;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg3;
	private final ModelRenderer Leg4;
	private final ModelRenderer Leg5;
	private final ModelRenderer Leg6;

	public ModelTickGeo() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -8.0F, -14.0F, -4.0F, 16, 9,
				19, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 28, -8.0F, -14.0F, -8.0F, 16,
				9, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -2.0F, -5.0F, -8.0F, 4, 4,
				0, 0.0F, false));

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-7.0F, 19.0F, -3.0F);
		setRotationAngle(Leg1, 0.0F, -0.0873F, 0.0F);
		Leg1.cubeList.add(new ModelBox(Leg1, 50, 41, -4.7652F, 0.0F, -2.6215F,
				5, 5, 5, 0.0F, false));

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(-7.0F, 19.0F, 5.0F);
		Leg2.cubeList.add(new ModelBox(Leg2, 50, 28, -5.0F, 0.0F, -3.0F, 5, 5,
				5, 0.0F, false));

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(-6.0F, 19.0F, 12.0F);
		setRotationAngle(Leg3, 0.0F, 0.0873F, 0.0F);
		Leg3.cubeList.add(new ModelBox(Leg3, 35, 46, -4.977F, 0.0F, -2.4314F,
				5, 5, 5, 0.0F, false));

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(7.0F, 18.0F, 11.0F);
		setRotationAngle(Leg4, 0.0F, -0.0873F, 0.0F);
		Leg4.cubeList.add(new ModelBox(Leg4, 20, 41, -0.9321F, 1.0F, -1.3481F,
				5, 5, 5, 0.0F, false));

		Leg5 = new ModelRenderer(this);
		Leg5.setRotationPoint(7.0F, 19.0F, 4.0F);
		Leg5.cubeList.add(new ModelBox(Leg5, 0, 41, 0.0F, 0.0F, -2.0F, 5, 5, 5,
				0.0F, false));

		Leg6 = new ModelRenderer(this);
		Leg6.setRotationPoint(7.0F, 19.0F, -2.0F);
		setRotationAngle(Leg6, 0.0F, 0.1745F, 0.0F);
		Leg6.cubeList.add(new ModelBox(Leg6, 35, 36, -0.241F, 0.0F, -3.2459F,
				5, 5, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Leg5.render(f5);
		Leg6.render(f5);
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
		this.Leg2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.Leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Leg4.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Leg5.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.Leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Leg6.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}