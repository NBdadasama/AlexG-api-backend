package com.alexg.springbootinit.mapper;

import com.alexg.apicommon.model.entity.UserInterfaceInfo;
import com.alexg.springbootinit.model.vo.InvokeInterfaceInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
* @author 86185
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2023-08-08 14:41:16
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<InvokeInterfaceInfoVO> listTopInvokeInterfaceInfo(int limit);
}




