package net.mcreator.xenoclus_v.procedure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import net.mcreator.xenoclus_v.ElementsXenoclusOne;

@ElementsXenoclusOne.ModElement.Tag
public class ProcedureTreeChoice extends ElementsXenoclusOne.ModElement {
	public ProcedureTreeChoice(ElementsXenoclusOne instance) {
		super(instance, 763);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TreeChoice!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TreeChoice!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TreeChoice!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TreeChoice!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double RandomNumberAttack = 0;
		if ((Math.random() < 0.6)) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("xenoclus_v", "p_tree_small"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		} else {
			if ((Math.random() < 0.6)) {
				if (!world.isRemote) {
					Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
							new ResourceLocation("xenoclus_v", "p_tree_medium"));
					if (template != null) {
						BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) z);
						IBlockState iblockstate = world.getBlockState(spawnTo);
						world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
						template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
								.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
					}
				}
			} else {
				if ((Math.random() < 0.6)) {
					if (!world.isRemote) {
						Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
								new ResourceLocation("xenoclus_v", "p_tree_three"));
						if (template != null) {
							BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) z);
							IBlockState iblockstate = world.getBlockState(spawnTo);
							world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
							template.addBlocksToWorldChunk(world, spawnTo,
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
											.setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
						}
					}
				} else {
					if (!world.isRemote) {
						Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
								new ResourceLocation("xenoclus_v", "p_tree_big"));
						if (template != null) {
							BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) z);
							IBlockState iblockstate = world.getBlockState(spawnTo);
							world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
							template.addBlocksToWorldChunk(world, spawnTo,
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
											.setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
						}
					}
				}
			}
		}
		world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
	}
}
