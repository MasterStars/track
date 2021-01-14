package com.hedongxing.track.v1.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hedongxing.track.v1.infrastructure.po.ActionPO;

import java.util.List;

public interface ActionMapper extends BaseMapper<ActionPO> {

    List<ActionPO> getActionsByChildId(String childId);
}
