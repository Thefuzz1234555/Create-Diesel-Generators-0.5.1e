package com.jesz.createdieselgenerators.compat.jei;

import com.jesz.createdieselgenerators.blocks.BlockRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.gui.element.GuiGameElement;
import mezz.jei.api.gui.drawable.IDrawable;

import static com.jesz.createdieselgenerators.blocks.BasinLidBlock.ON_A_BASIN;

public class BasinFermentingStationElement implements IDrawable {
    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    public void draw(PoseStack poseStack, int xOffset, int yOffset) {
        poseStack.pushPose();
        poseStack.translate(xOffset, yOffset, 200);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(-15.5f));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(22.5f));
        int scale = 23;

        GuiGameElement.of(BlockRegistry.BASIN_LID.getDefaultState().setValue(ON_A_BASIN, true))
                .atLocal(0, 0, 0)
                .scale(scale)
                .render(poseStack);

        GuiGameElement.of(AllBlocks.BASIN.getDefaultState())
                .atLocal(0, 1, 0)
                .scale(scale)
                .render(poseStack);

        poseStack.popPose();
    }
}
