package net.mcreator.xenoclus_v.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureLifeLEECHPRO extends ElementsXenoclusOne.ModElement {
	public ProcedureLifeLEECHPRO(ElementsXenoclusOne instance) {
		super(instance, 577);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LifeLEECHPRO!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) -6);
	}
}
