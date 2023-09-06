package com.alexg.springbootinit.service.impl.inner;

import cn.hutool.core.util.StrUtil;
import com.alexg.apicommon.model.entity.InterfaceInfo;
import com.alexg.apicommon.service.InnerInterfaceInfoService;
import com.alexg.springbootinit.common.ErrorCode;
import com.alexg.springbootinit.exception.BusinessException;
import com.alexg.springbootinit.mapper.InterfaceInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

	@Resource
	private InterfaceInfoMapper interfaceInfoMapper;

	@Override
	public InterfaceInfo getInvokeInterfaceInfo(String url, String method) {
		if (StrUtil.hasBlank(url, method)) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		LambdaQueryWrapper<InterfaceInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(InterfaceInfo::getUrl, url).eq(InterfaceInfo::getMethod, method);
		return interfaceInfoMapper.selectOne(lambdaQueryWrapper);
	}

}