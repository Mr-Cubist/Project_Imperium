package net.mcreator.xenoclus_v.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureBurnOnHit extends ElementsXenoclusOne.ModElement {
	public ProcedureBurnOnHit(ElementsXenoclusOne instance) {
		super(instance, 694);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BurnOnHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 4);
	}
}
