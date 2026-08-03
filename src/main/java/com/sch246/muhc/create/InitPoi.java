package com.sch246.muhc.create;

import com.sch246.muhc.MaidUseHandCrank;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class InitPoi {
    /** 注册 id 与 NeoForge 版逐字一致：muhc:hand_crank */
    public static PoiType HAND_CRANK;

    public static void init() {
        PoiType proto = PoiManager.getCrankPoiType();
        HAND_CRANK = PointOfInterestHelper.register(
                Identifier.fromNamespaceAndPath(MaidUseHandCrank.MODID, "hand_crank"),
                proto.maxTickets(), proto.validRange(), proto.matchingStates());
    }
}
