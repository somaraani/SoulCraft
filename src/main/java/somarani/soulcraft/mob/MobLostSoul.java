

package somarani.soulcraft.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MobLostSoul extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer Shape1;
  
  public MobLostSoul()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -1F, 4, 9, 4);
      body.setRotationPoint(2F, 6F, -1F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0.0743572F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(0F, 0F, -2F, 2, 3, 4);
      leg1.setRotationPoint(-1F, 13F, 4F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, -0.2792527F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 6, 6, 6);
      Shape1.setRotationPoint(-3F, -1F, -3F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    
    setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    body.render(par7);
    leg1.render(par7);
    Shape1.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    
  }

}
