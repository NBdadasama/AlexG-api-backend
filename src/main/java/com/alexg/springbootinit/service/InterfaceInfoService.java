package com.alexg.springbootinit.service;

import com.alexg.apicommon.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author 86185
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-02 16:58:27
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
