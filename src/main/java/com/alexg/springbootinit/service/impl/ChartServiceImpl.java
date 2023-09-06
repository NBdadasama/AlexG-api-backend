package com.alexg.springbootinit.service.impl;

import com.alexg.apicommon.model.entity.InterfaceInfo;
import com.alexg.springbootinit.common.ErrorCode;
import com.alexg.springbootinit.exception.BusinessException;
import com.alexg.springbootinit.mapper.UserInterfaceInfoMapper;
import com.alexg.springbootinit.model.vo.InvokeInterfaceInfoVO;
import com.alexg.springbootinit.service.ChartService;
import com.alexg.springbootinit.service.InterfaceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Override
    public List<InvokeInterfaceInfoVO> listTopInvokeInterfaceInfo(int limit) {
        List<InvokeInterfaceInfoVO> vos = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(limit);
        if (vos == null || vos.size() == 0) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        // 根据id查询接口名称
        LinkedHashMap<Long, InvokeInterfaceInfoVO> voHashMap = new LinkedHashMap<>(vos.size());
        for (InvokeInterfaceInfoVO vo : vos) {
            voHashMap.put(vo.getId(), vo);
        }
        LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(InterfaceInfo::getId, voHashMap.keySet());
        List<InterfaceInfo> infoList = interfaceInfoService.list(queryWrapper);

        for (InterfaceInfo interfaceInfo : infoList) {
            voHashMap.get(interfaceInfo.getId()).setName(interfaceInfo.getName());
        }

        return new ArrayList<>(voHashMap.values());
    }

}