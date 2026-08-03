package com.sch246.muhc.create;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.zurrtum.create.AllBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;


public final class PoiManager {
    private static final Set<BlockState> ALL_CRANK_STATES;

    public PoiManager() {
    }

    public static PoiType getCrankPoiType() {
        return new PoiType(ALL_CRANK_STATES, 1, 1);
    }

    static {
        // create_connected 无 Fabric 版，曲柄轮/大曲柄轮支持随之移除（docs/CURRENT_STATUS.md 决策 1）
        ALL_CRANK_STATES = AllBlocks.HAND_CRANK
                .getStateDefinition()
                .getPossibleStates()
                .stream()
                .collect(ImmutableSet.toImmutableSet());
    }
}
