package somarani.soulcraft.mobboss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class MobSoulBossRender extends RenderLiving {
	
	protected MobSoulBoss mobModel;
	
	private static final ResourceLocation field_20002_a = new ResourceLocation("soulcraft:textures/mobs/Boss.png");

	public MobSoulBossRender(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return field_20002_a;
	}

}
