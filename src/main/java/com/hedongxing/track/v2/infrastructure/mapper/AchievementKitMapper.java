package com.hedongxing.track.v2.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hedongxing.track.v2.infrastructure.po.AchievementKitPO;

import java.util.List;

public interface AchievementKitMapper extends BaseMapper<AchievementKitPO> {

    List<AchievementKitPO> selectAchievementKitsByGlobalUserId(String globalUserId);
}
