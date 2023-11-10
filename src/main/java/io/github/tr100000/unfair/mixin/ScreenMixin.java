package io.github.tr100000.unfair.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.tr100000.unfair.Unfair;
import io.github.tr100000.unfair.things.ScreenBad;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void uhoh(GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo info) {
        if (Unfair.enabled) {
            Screen screen = (Screen)(Object)this;
            List<Drawable> drawables = new ArrayList<>(((ScreenAccessor)this).getDrawables());
            for (Element element : screen.children()) {
                if (element instanceof Drawable drawable) {
                    drawables.add(drawable);
                }
            }

            for (int i = 0; i < drawables.size(); i++) {
                Drawable drawable = drawables.get(i);
                if (ScreenBad.timeValue % drawables.size() == i) {
                    if (drawable instanceof Widget widget) {
                        widget.setPosition(screen.width / 2 - widget.getWidth() / 2, screen.height / 2 - widget.getHeight() / 2);
                    }
                    drawable.render(graphics, mouseX, mouseY, delta);
                }
                else if (drawable instanceof Widget widget) {
                    widget.setPosition(0, -widget.getHeight() - 50);
                }
            }
        }
    }
}
