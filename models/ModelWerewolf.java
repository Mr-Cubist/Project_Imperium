//Made with Blockbench
//Paste this code into your mod.

public static class ModelWerewolf extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public ModelWerewolf() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 1.0F);
		body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -25.75F, -2.0F, 8,
				8, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 24, 0, -3.0F, -17.75F, -2.0F, 6,
				4, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 36, 27, -2.0F, -26.75F, -2.0F, 4,
				1, 4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -26.0F, 0.0F);
		body.addChild(head);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8,
				8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 4, -3.75F, -10.0F, -2.0F, 3, 3,
				1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 0.75F, -10.0F, -2.0F, 3, 3,
				1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 44, -2.0F, -3.0F, -8.0F, 4, 3,
				4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 45, 15, -1.0F, 10.0F, 1.0F, 2, 2,
				3, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 11.0F, 3.0F);
		setRotationAngle(tail, -0.8727F, 0.0F, 0.0F);
		head.addChild(tail);
		tail.cubeList.add(new ModelBox(tail, 32, 32, -1.75F, -1.25F, -0.25F, 3,
				3, 7, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 28, 30, -1.25F, -0.75F, 6.75F, 2,
				2, 1, 0.0F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(6.0F, -25.0F, 0.0F);
		body.addChild(leftarm);
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 28, -2.0F, -0.75F, -2.0F,
				4, 12, 4, 0.0F, false));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-6.0F, -25.0F, 0.0F);
		body.addChild(rightarm);
		rightarm.cubeList.add(new ModelBox(rightarm, 16, 30, -2.0F, -0.75F,
				-2.0F, 4, 12, 4, 0.0F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -14.0F, 0.0F);
		body.addChild(leftleg);
		leftleg.cubeList.add(new ModelBox(leftleg, 32, 18, -2.0F, 0.25F, -2.0F,
				4, 5, 4, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 40, 42, -1.0F, 5.25F, -2.0F,
				2, 7, 4, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 16, 20, -2.0F, 11.0F, -5.0F,
				4, 2, 8, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 20, 18, -1.5F, 12.0F, -6.0F,
				3, 1, 1, 0.0F, false));

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -14.0F, 0.0F);
		body.addChild(rightleg);
		rightleg.cubeList.add(new ModelBox(rightleg, 28, 42, -1.0F, 5.25F,
				-2.0F, 2, 7, 4, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 40, 4, -2.0F, 0.25F,
				-2.0F, 4, 5, 4, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 24, 8, -2.0F, 11.0F,
				-5.0F, 4, 2, 8, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 28, 18, -1.5F, 12.0F,
				-6.0F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
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
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}