package com.sch246.muhc.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.zurrtum.create.content.kinetics.crank.HandCrankBlockEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemFrame.class)
public class ItemFrameMixin {
    // 1.21.11：survives() 不再调 Level.noCollision(Entity)，碰撞检查换成了 HangingEntity.hasLevelCollision(AABB)，
    // 故由基线的 @Redirect 改打此调用；语义不变——展示框与手摇曲柄重叠时视为无碰撞，允许存活
    @WrapOperation(method = "survives",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/decoration/ItemFrame;hasLevelCollision(Lnet/minecraft/world/phys/AABB;)Z"))
    private boolean allowCollisionWithCrank(ItemFrame frame, AABB box, Operation<Boolean> original) {
        if (frame.level().getBlockEntity(frame.blockPosition()) instanceof HandCrankBlockEntity) {
            return false;
        }
        // 否则使用原版逻辑
        return original.call(frame, box);
    }

}
