//Made with Blockbench
//Paste this code into your mod.

public static class ModelWendigo extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelWendigo() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -15.0F, -2.0F, 8, 29,
				4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 14, 31, 0.0F, -11.0F, 2.0F, 0, 17,
				2, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, -7.0F, 0.0F);
		setRotationAngle(leftArm, -0.3491F, 0.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 33, -2.0F, -3.0F, -2.0F,
				3, 25, 4, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, -7.0F, 0.0F);
		setRotationAngle(rightArm, -0.3491F, 0.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 24, 24, -1.0F, -3.0F,
				-2.0F, 3, 25, 4, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 14.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 34, 14, -2.0F, 0.0F, -2.0F,
				4, 10, 4, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 14.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 24, 0, -2.0F, 0.0F, -2.0F,
				4, 10, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		leftLeg.render(f5);
		rightLeg.render(f5);
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
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}