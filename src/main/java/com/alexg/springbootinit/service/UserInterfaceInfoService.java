package com.alexg.springbootinit.service;

import com.alexg.apicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author 86185
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2023-08-08 14:41:16
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    Boolean invokeCount(long interfaceInfoId,long userId);
}
