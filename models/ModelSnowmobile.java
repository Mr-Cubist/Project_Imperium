//Made with Blockbench
//Paste this code into your mod.

public static class ModelSnowmobile extends ModelBase {
	private final ModelRenderer Snowmobile;
	private final ModelRenderer Minecart;
	private final ModelRenderer boneneedmilk;
	private final ModelRenderer bone;
	private final ModelRenderer Winshield;
	private final ModelRenderer front;
	private final ModelRenderer bonesuck;
	private final ModelRenderer bonedaddy;
	private final ModelRenderer boned;
	private final ModelRenderer boner;
	private final ModelRenderer skil;
	private final ModelRenderer leaningpart;
	private final ModelRenderer forntofski;
	private final ModelRenderer Skitwo;
	private final ModelRenderer LeaningUno;
	private final ModelRenderer Frontofskiuno;
	private final ModelRenderer motor_stuff;
	private final ModelRenderer trackone;
	private final ModelRenderer tracktwo;

	public ModelSnowmobile() {
		textureWidth = 128;
		textureHeight = 128;

		Snowmobile = new ModelRenderer(this);
		Snowmobile.setRotationPoint(-2.0F, 14.0F, 6.0F);

		Minecart = new ModelRenderer(this);
		Minecart.setRotationPoint(0.0F, 0.0F, 0.0F);
		Snowmobile.addChild(Minecart);
		Minecart.cubeList.add(new ModelBox(Minecart, 0, 0, -6.0F, 5.7F, -16.0F,
				16, 1, 20, 0.0F, false));
		Minecart.cubeList.add(new ModelBox(Minecart, 46, 21, -6.0F, -3.3F,
				-14.0F, 2, 9, 16, 0.0F, false));
		Minecart.cubeList.add(new ModelBox(Minecart, 46, 46, 8.0F, -3.3F,
				-14.0F, 2, 9, 16, 0.0F, false));

		boneneedmilk = new ModelRenderer(this);
		boneneedmilk.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(boneneedmilk, 0.0F, 1.5708F, 0.0F);
		Minecart.addChild(boneneedmilk);
		boneneedmilk.cubeList.add(new ModelBox(boneneedmilk, 0, 46, 14.0F,
				-3.3F, -6.0F, 2, 9, 16, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
		Minecart.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 26, 30, -4.0F, -3.3F, -6.0F, 2, 9,
				16, 0.0F, false));

		Winshield = new ModelRenderer(this);
		Winshield.setRotationPoint(2.0F, -3.334F, -8.5911F);
		setRotationAngle(Winshield, -0.4363F, 0.0F, 0.0F);
		Snowmobile.addChild(Winshield);
		Winshield.cubeList.add(new ModelBox(Winshield, 66, 54, -7.0F, -1.9643F,
				-5.4378F, 14, 5, 0, 0.0F, false));

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 10.0F, 0.0F);
		Snowmobile.addChild(front);
		front.cubeList.add(new ModelBox(front, 39, 21, -3.0F, -8.3F, -29.0F,
				10, 3, 1, 0.0F, false));
		front.cubeList.add(new ModelBox(front, 0, 21, -2.0F, -14.3F, -21.0F, 4,
				3, 5, 0.0F, false));

		bonesuck = new ModelRenderer(this);
		bonesuck.setRotationPoint(0.0F, -14.5F, -10.5F);
		setRotationAngle(bonesuck, -1.309F, 0.0F, 0.0F);
		front.addChild(bonesuck);
		bonesuck.cubeList.add(new ModelBox(bonesuck, 73, 0, -4.0F, 3.7708F,
				0.4529F, 12, 16, 1, 0.0F, false));

		bonedaddy = new ModelRenderer(this);
		bonedaddy.setRotationPoint(0.0F, -14.5F, -10.5F);
		setRotationAngle(bonedaddy, -1.6581F, 0.0F, 0.0F);
		front.addChild(bonedaddy);
		bonedaddy.cubeList.add(new ModelBox(bonedaddy, 30, 73, -4.0F, 1.9804F,
				10.7012F, 12, 16, 1, 0.0F, false));

		boned = new ModelRenderer(this);
		boned.setRotationPoint(-5.5F, -11.5F, -16.0F);
		setRotationAngle(boned, -0.0873F, 0.0F, 0.0F);
		front.addChild(boned);
		boned.cubeList.add(new ModelBox(boned, 0, 71, 1.5F, 3.7012F, -12.4804F,
				1, 4, 14, 0.0F, false));
		boned.cubeList.add(new ModelBox(boned, 0, 71, 12.5F, 3.7012F,
				-12.4804F, 1, 4, 14, 0.0F, false));

		boner = new ModelRenderer(this);
		boner.setRotationPoint(-5.5F, -15.9829F, -15.6078F);
		setRotationAngle(boner, 0.2618F, 0.0F, 0.0F);
		front.addChild(boner);
		boner.cubeList.add(new ModelBox(boner, 68, 36, 1.5F, 3.9529F,
				-14.2708F, 1, 4, 14, 0.0F, false));
		boner.cubeList.add(new ModelBox(boner, 68, 36, 12.5F, 3.9529F,
				-14.2708F, 1, 4, 14, 0.0F, false));

		skil = new ModelRenderer(this);
		skil.setRotationPoint(13.0F, 10.0F, 0.0F);
		Snowmobile.addChild(skil);
		skil.cubeList.add(new ModelBox(skil, 8, 21, -7.0F, -0.3F, -34.0F, 4, 0,
				15, 0.0F, false));
		skil.cubeList.add(new ModelBox(skil, 8, 6, -5.0F, -5.3F, -23.0F, 1, 5,
				1, 0.0F, false));
		skil.cubeList.add(new ModelBox(skil, 15, 0, -5.0F, -2.3F, -28.0F, 1, 2,
				1, 0.0F, false));
		skil.cubeList.add(new ModelBox(skil, 8, 0, -5.0F, -3.3F, -28.0F, 1, 1,
				5, 0.0F, false));

		leaningpart = new ModelRenderer(this);
		leaningpart.setRotationPoint(-4.5F, -5.65F, -16.5637F);
		setRotationAngle(leaningpart, -1.0472F, 0.0F, 0.0F);
		skil.addChild(leaningpart);
		leaningpart.cubeList.add(new ModelBox(leaningpart, 0, 29, -0.5F,
				-3.3038F, -3.5F, 1, 9, 1, 0.0F, false));

		forntofski = new ModelRenderer(this);
		forntofski.setRotationPoint(-5.0F, -0.7758F, -28.7078F);
		setRotationAngle(forntofski, -0.5236F, 0.0F, 0.0F);
		skil.addChild(forntofski);
		forntofski.cubeList.add(new ModelBox(forntofski, 5, 14, -2.0F, 3.0F,
				-7.3962F, 4, 0, 3, 0.0F, false));

		Skitwo = new ModelRenderer(this);
		Skitwo.setRotationPoint(13.0F, 10.0F, 0.0F);
		Snowmobile.addChild(Skitwo);
		Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 21, -19.0F, -0.3F, -34.0F,
				4, 0, 15, 0.0F, false));
		Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 6, -18.0F, -5.3F, -23.0F,
				1, 5, 1, 0.0F, false));
		Skitwo.cubeList.add(new ModelBox(Skitwo, 15, 0, -18.0F, -2.3F, -28.0F,
				1, 2, 1, 0.0F, false));
		Skitwo.cubeList.add(new ModelBox(Skitwo, 8, 0, -18.0F, -3.3F, -28.0F,
				1, 1, 5, 0.0F, false));

		LeaningUno = new ModelRenderer(this);
		LeaningUno.setRotationPoint(-4.5F, -5.65F, -16.5637F);
		setRotationAngle(LeaningUno, -1.0472F, 0.0F, 0.0F);
		Skitwo.addChild(LeaningUno);
		LeaningUno.cubeList.add(new ModelBox(LeaningUno, 0, 29, -13.5F,
				-3.3038F, -3.5F, 1, 9, 1, 0.0F, false));

		Frontofskiuno = new ModelRenderer(this);
		Frontofskiuno.setRotationPoint(-5.0F, -0.7758F, -28.7078F);
		setRotationAngle(Frontofskiuno, -0.5236F, 0.0F, 0.0F);
		Skitwo.addChild(Frontofskiuno);
		Frontofskiuno.cubeList.add(new ModelBox(Frontofskiuno, 5, 14, -14.0F,
				3.0F, -7.3962F, 4, 0, 3, 0.0F, false));

		motor_stuff = new ModelRenderer(this);
		motor_stuff.setRotationPoint(0.0F, 10.0F, 0.0F);
		Snowmobile.addChild(motor_stuff);
		motor_stuff.cubeList.add(new ModelBox(motor_stuff, 0, 0, 5.0F, -25.3F,
				-19.0F, 2, 16, 2, 0.0F, false));

		trackone = new ModelRenderer(this);
		trackone.setRotationPoint(2.0F, 10.0F, -6.0F);
		Snowmobile.addChild(trackone);
		trackone.cubeList.add(new ModelBox(trackone, 0, 21, -10.0F, -7.0F,
				-10.0F, 2, 6, 19, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 8, 29, -10.0F, -7.0F,
				-11.0F, 2, 6, 1, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 8, 29, -10.0F, -7.0F,
				9.0F, 2, 6, 1, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 13, 21, -10.0F, -6.0F,
				-12.0F, 2, 4, 1, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 13, 21, -10.0F, -6.0F,
				10.0F, 2, 4, 1, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 19, 55, -10.0F, -8.0F,
				-9.0F, 2, 1, 17, 0.0F, false));
		trackone.cubeList.add(new ModelBox(trackone, 52, 0, -10.0F, -1.0F,
				-9.0F, 2, 1, 17, 0.0F, false));

		tracktwo = new ModelRenderer(this);
		tracktwo.setRotationPoint(20.0F, 10.0F, -6.0F);
		Snowmobile.addChild(tracktwo);
		tracktwo.cubeList.add(new ModelBox(tracktwo, 0, 21, -10.0F, -7.0F,
				-10.0F, 2, 6, 19, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 8, 29, -10.0F, -7.0F,
				-11.0F, 2, 6, 1, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 8, 29, -10.0F, -7.0F,
				9.0F, 2, 6, 1, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 13, 21, -10.0F, -6.0F,
				-12.0F, 2, 4, 1, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 13, 21, -10.0F, -6.0F,
				10.0F, 2, 4, 1, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 19, 55, -10.0F, -8.0F,
				-9.0F, 2, 1, 17, 0.0F, false));
		tracktwo.cubeList.add(new ModelBox(tracktwo, 52, 0, -10.0F, -1.0F,
				-9.0F, 2, 1, 17, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Snowmobile.render(f5);
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
	}
}