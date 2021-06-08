package org.mineplugin.locusazzurro.icaruswings.render;

import org.mineplugin.locusazzurro.icaruswings.data.Utils;
import org.mineplugin.locusazzurro.icaruswings.items.FeatherWings;

import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FeatherWingsLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
	
	private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(Utils.MOD_ID, "textures/entity/feather_wings.png");
	private static final ResourceLocation WINGS_LOCATION_2 = new ResourceLocation(Utils.MOD_ID, "textures/entity/colored_feather_wings.png");
	private final ElytraModel<T> modelElytra = new ElytraModel<>();
	public FeatherWingsLayer(IEntityRenderer<T, M> renderIn) {
		super(renderIn);
	}
	
	@Override
	public boolean shouldRender(ItemStack stack, T entity) {
	    return (stack.getItem() instanceof FeatherWings);
	}
	
	@Override
	public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		Item item = stack.getItem();
		if (item instanceof FeatherWings)
		{
			FeatherWings wings = (FeatherWings) item;
			if (wings.getType() == FeatherWings.FeatherWingsType.FEATHER) return WINGS_LOCATION;
			if (wings.getType() == FeatherWings.FeatherWingsType.FEATHER_COLORED) return WINGS_LOCATION_2;
		}
		return WINGS_LOCATION;
	}
	
	/*
	@Override
	public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_)
	{
		super.render(p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_7_, p_225628_8_, p_225628_9_, p_225628_10_);
	}
	*/

}
