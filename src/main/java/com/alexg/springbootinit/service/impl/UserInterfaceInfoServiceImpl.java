package com.alexg.springbootinit.service.impl;

import com.alexg.apicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alexg.springbootinit.common.ErrorCode;
import com.alexg.springbootinit.exception.BusinessException;
import com.alexg.springbootinit.mapper.UserInterfaceInfoMapper;
import com.alexg.springbootinit.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author 86185
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2023-08-08 14:41:16
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Long userId = userInterfaceInfo.getUserId();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer status = userInterfaceInfo.getStatus();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Date createTime = userInterfaceInfo.getCreateTime();

        // 创建时，所有参数必须非空
        // ObjectUtils.anyNull(userId, status)
        if (add) {
            if(interfaceInfoId<=0||userId<=0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户或接口不存在");
            }
            if (leftNum<0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"剩余次数不能小于0");
            }
        }
        if(leftNum<0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"剩余次数不能小于0");
        }
    }

    @Override
    public Boolean invokeCount(long interfaceInfoId, long userId) {
        //判断
        if(interfaceInfoId<=0 || userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.setSql("leftNum = leftNum - 1,totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }


}




