//Made with Blockbench
//Paste this code into your mod.

public static class ModelEndGhost extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Tendrils;
	private final ModelRenderer TendrilsDos;
	private final ModelRenderer Head;

	public ModelEndGhost() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -4.0F, -30.0F, -5.0F, 8, 19,
				8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 27, -6.0F, -24.0F, -3.0F, 12,
				12, 0, 0.0F, false));

		Tendrils = new ModelRenderer(this);
		Tendrils.setRotationPoint(0.0F, 15.0F, 0.0F);
		setRotationAngle(Tendrils, 0.0F, -0.7854F, 0.0F);
		Tendrils.cubeList.add(new ModelBox(Tendrils, 32, 0, -4.0F, -7.0F,
				-1.0F, 7, 13, 0, 0.0F, false));

		TendrilsDos = new ModelRenderer(this);
		TendrilsDos.setRotationPoint(0.0F, 15.0F, 0.0F);
		setRotationAngle(TendrilsDos, 0.0F, -2.3562F, 0.0F);
		TendrilsDos.cubeList.add(new ModelBox(TendrilsDos, 24, 27, -4.0F,
				-7.0F, 1.0F, 7, 13, 0, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -3.0F, -1.0F);
		Head.cubeList.add(new ModelBox(Head, 23, 50, -2.0F, -2.0F, -5.0F, 4, 4,
				4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Body.render(f5);
		Tendrils.render(f5);
		TendrilsDos.render(f5);
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