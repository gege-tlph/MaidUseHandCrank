package com.sch246.muhc.mixin;

import com.sch246.muhc.util.IMaidHandCrank;
import com.zurrtum.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.zurrtum.create.content.kinetics.crank.HandCrankBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandCrankBlockEntity.class)
public abstract class HandCrankBlockEntityMixin extends GeneratingKineticBlockEntity implements IMaidHandCrank {

    @Unique
    private float muhc$stress = 0;

    @Unique
    private int muhc$tick = 0;

    @Unique
    public float muhc$getStress() {
        return muhc$stress;
    }

    @Unique
    public int muhc$getTick() {
        return muhc$tick;
    }

    public HandCrankBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Unique
    public void muhc$setStress(float stress, int tick) {
        muhc$stress = stress;
        muhc$tick = tick;
        this.sendData(); // 发送数据包到客户端
    }

    // write/read/tick 是 Create 自有方法（非 vanilla 覆写），remap=false；
    // 1.21.11 存取体系已从 CompoundTag 换为 ValueOutput/ValueInput，NBT 键保持 muhc_stress/muhc_tick 不变
    @Inject(method = "write", at = @At("TAIL"), remap = false)
    private void onWrite(ValueOutput view, boolean clientPacket, CallbackInfo ci) {
        // 将自定义数据写入NBT
        view.putFloat("muhc_stress", muhc$stress);
        view.putInt("muhc_tick", muhc$tick);
    }

    @Inject(method = "read", at = @At("TAIL"), remap = false)
    private void onRead(ValueInput view, boolean clientPacket, CallbackInfo ci) {
        // 从NBT读取自定义数据
        muhc$stress = view.getFloatOr("muhc_stress", 0.0F);
        muhc$tick = view.getIntOr("muhc_tick", 0);
    }

    @Inject(method = "tick", at = @At("TAIL"), remap = false)
    private void onTick(CallbackInfo ci) {
        if (muhc$tick > 0) {
            --muhc$tick;
            if (muhc$tick == 0) {
                muhc$stress = 0;
            }
        }
    }
}
