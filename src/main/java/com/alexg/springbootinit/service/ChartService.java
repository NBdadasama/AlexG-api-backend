package com.alexg.springbootinit.service;

import com.alexg.springbootinit.model.vo.InvokeInterfaceInfoVO;

import java.util.List;

public interface ChartService {
    public List<InvokeInterfaceInfoVO> listTopInvokeInterfaceInfo(int limit);
}
