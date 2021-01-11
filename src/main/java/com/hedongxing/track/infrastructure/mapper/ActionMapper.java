package com.hedongxing.track.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hedongxing.track.infrastructure.po.ActionPO;

import java.util.List;

public interface ActionMapper extends BaseMapper<ActionPO> {

    List<ActionPO> getActionsByChildId(String childId);
}
