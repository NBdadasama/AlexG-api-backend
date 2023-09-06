package com.alexg.springbootinit.service.impl.inner;

import cn.hutool.core.util.StrUtil;
import com.alexg.apicommon.model.entity.User;
import com.alexg.apicommon.service.InnerUserService;
import com.alexg.springbootinit.common.ErrorCode;
import com.alexg.springbootinit.exception.BusinessException;
import com.alexg.springbootinit.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getInvokeUser(String accessKey) {
		if (StrUtil.isBlank(accessKey)) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(User::getAccessKey, accessKey);
		return userMapper.selectOne(lambdaQueryWrapper);
	}
}