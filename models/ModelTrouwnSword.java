//Made with Blockbench
//Paste this code into your mod.

public static class ModelTrouwnSword extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelTrouwnSword() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 19, -4.0F, -8.0F, -5.0F, 8, 8,
				8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 24, 10, 0.0F, -10.0F, -4.0F, 0, 8,
				9, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 30, 0, -4.0F, 0.0F, -2.0F, 8, 12,
				3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -5.0F, -1.0F, -3.0F, 10, 14,
				5, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(leftArm, -1.4835F, 0.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 41, 41, -2.0F, -2.0F, -2.0F,
				3, 12, 3, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 19, -1.0F, 6.0F, -3.0F,
				2, 6, 1, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 24, 0.0F, 7.0F, -14.0F,
				0, 6, 11, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 12, 41, -1.0F, -2.0F,
				-2.0F, 3, 12, 3, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-2.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 41, -1.0F, 0.0F, -2.0F,
				3, 12, 3, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(2.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 29, 32, -2.0F, 0.0F,
				-2.0F, 3, 12, 3, 0.0F, false));
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