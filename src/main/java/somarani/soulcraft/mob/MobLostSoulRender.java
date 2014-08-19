package somarani.soulcraft.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class MobLostSoulRender extends RenderLiving {
	
	protected MobLostSoul mobModel;
	
	private static final ResourceLocation field_20002_a = new ResourceLocation("soulcraft:textures/mobs/soultexture.png");


	public MobLostSoulRender(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return field_20002_a;
	}

}
