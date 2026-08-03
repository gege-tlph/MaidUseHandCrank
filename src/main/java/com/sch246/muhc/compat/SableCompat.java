package com.sch246.muhc.compat;

import java.util.stream.Stream;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.phys.Vec3;

/**
 * Sable 兼容层（Fabric 空化版）。
 * <p>
 * Sable（动态子维度 mod）是 NeoForge 专属，Fabric 1.21.11 无对应物。
 * 保留公共方法签名，全部走原版路径，使 {@code UseHandCrank} 的调用点零改动。
 * NeoForge 版实现见 tag {@code baseline/neoforge-1.21.1}；若 Sable 未来出 Fabric 版，
 * 按该基线恢复 {@code Internal} 延迟加载模式（见 docs/CURRENT_STATUS.md 决策 2）。
 */
public final class SableCompat {
    private SableCompat() {}

    public static Stream<PoiRecord> getSableCrank(ServerLevel level, BlockPos maidPos, double searchRadiusSqr) {
        return Stream.empty();
    }

    public static double getDistanceSqr(ServerLevel level, BlockPos pos, @Nonnull Vec3 target) {
        return pos.distToCenterSqr(target);
    }

    public static BlockPos toGlobalBlockPos(ServerLevel level, BlockPos pos) {
        return pos;
    }
}
