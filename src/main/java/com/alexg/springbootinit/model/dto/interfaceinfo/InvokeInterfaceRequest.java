package com.alexg.springbootinit.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author alexg
 */
@Data
public class InvokeInterfaceRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;



    /**
     * 请求参数
     */
    private String requestParams;



}