//Made with Blockbench
//Paste this code into your mod.

public static class ModelTrouwnHeavy extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelTrouwnHeavy() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 32, 40, -4.0F, -9.0F, -4.0F, 8, 8,
				8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 30, 19, 0.0F, -12.0F, -3.0F, 0,
				10, 10, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 29, -5.0F, -10.0F, -5.0F, 10,
				9, 10, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -1.0F, -2.0F, 8, 13,
				4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 31, 0, -5.0F, -1.0F, -3.0F, 10,
				14, 6, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(leftArm, -1.4835F, 0.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 48, -4.0F, -3.0F, -2.0F,
				4, 13, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 32, 56, -5.0F, -4.0F, -3.0F,
				5, 4, 6, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 0, -3.0F, 7.0F, -13.0F,
				2, 2, 27, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 7, -2.0F, 6.0F, -14.0F,
				0, 10, 10, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 29, -4.0F, 6.0F, 12.0F,
				4, 4, 1, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 16, 48, 0.0F, -3.0F,
				-2.0F, 4, 13, 4, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 50, 29, 0.0F, -4.0F,
				-3.0F, 5, 4, 6, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 63, 0, -2.0F, 0.0F, -2.0F,
				4, 12, 4, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 54, 56, -2.0F, 0.0F,
				-2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		head.render(f5);
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
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}