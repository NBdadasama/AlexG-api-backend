package com.alexg.springbootinit.controller;

import com.alexg.springbootinit.common.BaseResponse;
import com.alexg.springbootinit.common.ResultUtils;
import com.alexg.springbootinit.model.vo.InvokeInterfaceInfoVO;
import com.alexg.springbootinit.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chart")
public class ChartController {

	@Resource
	private ChartService chartService;

	@GetMapping("/top/interface/invoke")
	BaseResponse<List<InvokeInterfaceInfoVO>> listTopInvokeInterfaceInfo () {
		List<InvokeInterfaceInfoVO> listTopInvokeInterfaceInfo = chartService.listTopInvokeInterfaceInfo(3);
		return ResultUtils.success(listTopInvokeInterfaceInfo);
	}

}