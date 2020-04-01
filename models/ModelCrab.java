//Made with Blockbench
//Paste this code into your mod.

public static class ModelCrab extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer eyes;
	private final ModelRenderer Clawuno;
	private final ModelRenderer Clawtwo;
	private final ModelRenderer LEGONE;
	private final ModelRenderer LEGDos;
	private final ModelRenderer LEGTres;
	private final ModelRenderer LEGFOUR;
	private final ModelRenderer LEGTWORIGHT;
	private final ModelRenderer LEGTHREERIGHT;
	private final ModelRenderer LEGONERIGHT;
	private final ModelRenderer LEGFOURRIGHT;

	public ModelCrab() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 15.0F, -1.0F);
		body.cubeList.add(new ModelBox(body, 0, 17, -6.0F, -1.0F, -6.0F, 12, 4,
				12, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -7.0F, -2.0F, -7.0F, 14, 3,
				14, 0.0F, false));

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(0.0F, 15.0F, -7.0F);
		setRotationAngle(eyes, 0.6109F, 0.0F, 0.0F);
		eyes.cubeList.add(new ModelBox(eyes, 0, 0, -3.0F, -4.0F, -1.0F, 6, 5,
				0, 0.0F, false));

		Clawuno = new ModelRenderer(this);
		Clawuno.setRotationPoint(-5.0F, 16.0F, -6.0F);
		setRotationAngle(Clawuno, 0.0F, 0.2618F, 0.0F);
		Clawuno.cubeList.add(new ModelBox(Clawuno, 18, 39, -2.0F, -2.0F, -7.0F,
				3, 4, 6, 0.0F, false));

		Clawtwo = new ModelRenderer(this);
		Clawtwo.setRotationPoint(5.0F, 17.0F, -6.0F);
		setRotationAngle(Clawtwo, 0.0F, -0.3491F, 0.0F);
		Clawtwo.cubeList.add(new ModelBox(Clawtwo, 0, 39, -1.0F, -3.0F, -7.0F,
				3, 4, 6, 0.0F, false));

		LEGONE = new ModelRenderer(this);
		LEGONE.setRotationPoint(5.0F, 16.0F, -3.0F);
		setRotationAngle(LEGONE, 0.1745F, 0.4363F, 0.7854F);
		LEGONE.cubeList.add(new ModelBox(LEGONE, 36, 26, 0.5774F, -0.8426F,
				-1.1075F, 11, 1, 2, 0.0F, false));

		LEGDos = new ModelRenderer(this);
		LEGDos.setRotationPoint(5.0F, 16.0F, -1.0F);
		setRotationAngle(LEGDos, 0.0F, 0.0873F, 0.6981F);
		LEGDos.cubeList.add(new ModelBox(LEGDos, 36, 23, 1.0872F, -1.0F,
				-0.9962F, 11, 1, 2, 0.0F, false));

		LEGTres = new ModelRenderer(this);
		LEGTres.setRotationPoint(5.0F, 16.0F, 1.0F);
		setRotationAngle(LEGTres, 0.0F, -0.0873F, 0.6981F);
		LEGTres.cubeList.add(new ModelBox(LEGTres, 36, 20, 0.7385F, -1.0F,
				-0.9886F, 11, 1, 2, 0.0F, false));

		LEGFOUR = new ModelRenderer(this);
		LEGFOUR.setRotationPoint(5.0F, 16.0F, 4.0F);
		setRotationAngle(LEGFOUR, 0.0F, -0.2618F, 0.7854F);
		LEGFOUR.cubeList.add(new ModelBox(LEGFOUR, 36, 17, -0.5529F, -1.0F,
				-1.7956F, 11, 1, 2, 0.0F, false));

		LEGTWORIGHT = new ModelRenderer(this);
		LEGTWORIGHT.setRotationPoint(-5.0F, 16.0F, -1.0F);
		setRotationAngle(LEGTWORIGHT, 0.0F, 0.1047F, 2.4435F);
		LEGTWORIGHT.cubeList.add(new ModelBox(LEGTWORIGHT, 26, 36, 1.0887F,
				0.0F, -1.1707F, 11, 1, 2, 0.0F, false));

		LEGTHREERIGHT = new ModelRenderer(this);
		LEGTHREERIGHT.setRotationPoint(-5.0F, 16.0F, 1.0F);
		setRotationAngle(LEGTHREERIGHT, 0.0F, -0.0698F, 2.4435F);
		LEGTHREERIGHT.cubeList.add(new ModelBox(LEGTHREERIGHT, 0, 36, 0.9492F,
				0.0F, -1.1658F, 11, 1, 2, 0.0F, false));

		LEGONERIGHT = new ModelRenderer(this);
		LEGONERIGHT.setRotationPoint(-5.0F, 16.0F, -4.0F);
		setRotationAngle(LEGONERIGHT, 0.0F, 0.3665F, 2.3562F);
		LEGONERIGHT.cubeList.add(new ModelBox(LEGONERIGHT, 26, 33, 0.0136F,
				0.0F, -0.37F, 11, 1, 2, 0.0F, false));

		LEGFOURRIGHT = new ModelRenderer(this);
		LEGFOURRIGHT.setRotationPoint(-5.0F, 16.0F, 3.0F);
		setRotationAngle(LEGFOURRIGHT, 0.0F, -0.3316F, 2.3562F);
		LEGFOURRIGHT.cubeList.add(new ModelBox(LEGFOURRIGHT, 0, 33, 0.298F,
				0.0F, -1.0569F, 11, 1, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		eyes.render(f5);
		Clawuno.render(f5);
		Clawtwo.render(f5);
		LEGONE.render(f5);
		LEGDos.render(f5);
		LEGTres.render(f5);
		LEGFOUR.render(f5);
		LEGTWORIGHT.render(f5);
		LEGTHREERIGHT.render(f5);
		LEGONERIGHT.render(f5);
		LEGFOURRIGHT.render(f5);
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
		this.LEGTres.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LEGTHREERIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LEGFOUR.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LEGONE.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LEGONERIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LEGDos.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LEGTWORIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LEGFOURRIGHT.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}