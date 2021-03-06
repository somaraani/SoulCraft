// Date: 7/27/2014 2:28:30 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package somarani.soulcraft.mobboss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MobSoulBoss extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer lost;
    ModelRenderer zombie;
    ModelRenderer skeleton;
    ModelRenderer creeper;
    ModelRenderer spider;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape3;
  
  public MobSoulBoss()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      body = new ModelRenderer(this, 0, 16);
      body.addBox(0F, 0F, 0F, 8, 16, 4);
      body.setRotationPoint(-4F, -9F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      lost = new ModelRenderer(this, 0, 0);
      lost.addBox(0F, 0F, 0F, 8, 8, 8);
      lost.setRotationPoint(-4F, -19F, -2F);
      lost.setTextureSize(128, 64);
      lost.mirror = true;
      setRotation(lost, 0F, 0F, 0F);
      zombie = new ModelRenderer(this, 64, 0);
      zombie.addBox(0F, 0F, 0F, 8, 8, 8);
      zombie.setRotationPoint(6F, -19F, -2F);
      zombie.setTextureSize(128, 64);
      zombie.mirror = true;
      setRotation(zombie, 0F, 0F, 0F);
      skeleton = new ModelRenderer(this, 32, 0);
      skeleton.addBox(0F, 0F, 0F, 8, 8, 8);
      skeleton.setRotationPoint(-14F, -19F, -2F);
      skeleton.setTextureSize(128, 64);
      skeleton.mirror = true;
      setRotation(skeleton, 0F, 0F, 0F);
      creeper = new ModelRenderer(this, 24, 16);
      creeper.addBox(0F, 0F, 0F, 8, 8, 8);
      creeper.setRotationPoint(9F, -9F, -2F);
      creeper.setTextureSize(128, 64);
      creeper.mirror = true;
      setRotation(creeper, 0F, 0F, 0F);
      spider = new ModelRenderer(this, 56, 16);
      spider.addBox(0F, 0F, 0F, 8, 8, 8);
      spider.setRotationPoint(-17F, -9F, -2F);
      spider.setTextureSize(128, 64);
      spider.mirror = true;
      setRotation(spider, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 3, 32);
      Shape1.addBox(0F, 0F, 0F, 6, 10, 4);
      Shape1.setRotationPoint(-3F, 7F, 0F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0.2094395F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 5, 32);
      Shape2.addBox(0F, -11F, 1F, 2, 18, 2);
      Shape2.setRotationPoint(4.7F, 2F, 0F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, -0.0698132F);
      Shape4 = new ModelRenderer(this, 5, 32);
      Shape4.addBox(0F, 0F, 0F, 2, 18, 2);
      Shape4.setRotationPoint(-5.7F, -9F, 1F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0.0698132F);
      Shape3 = new ModelRenderer(this, 9, 38);
      Shape3.addBox(0F, 0F, 0F, 4, 3, 4);
      Shape3.setRotationPoint(-2F, 12F, 5F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0.2443461F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    lost.render(f5);
    zombie.render(f5);
    skeleton.render(f5);
    creeper.render(f5);
    spider.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape4.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    //super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
