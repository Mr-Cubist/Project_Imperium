//Made with Blockbench
//Paste this code into your mod.

public static class ModelPotmimic extends ModelBase {
	private final ModelRenderer PotportionOne;
	private final ModelRenderer PotportionTwo;
	private final ModelRenderer Head;

	public ModelPotmimic() {
		textureWidth = 64;
		textureHeight = 64;

		PotportionOne = new ModelRenderer(this);
		PotportionOne.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(PotportionOne, 0.0F, 2.3562F, 0.0F);
		PotportionOne.cubeList.add(new ModelBox(PotportionOne, 0, 0, -8.0F,
				-16.0F, 0.0F, 16, 16, 0, 0.0F, false));

		PotportionTwo = new ModelRenderer(this);
		PotportionTwo.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(PotportionTwo, 0.0F, -0.7854F, 0.0F);
		PotportionTwo.cubeList.add(new ModelBox(PotportionTwo, 0, 0, 0.0F,
				-16.0F, -8.0F, 0, 16, 16, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 17.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 32, -6.0F, -4.0F, -4.0F, 12, 7,
				0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		PotportionOne.render(f5);
		PotportionTwo.render(f5);
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
	}
}