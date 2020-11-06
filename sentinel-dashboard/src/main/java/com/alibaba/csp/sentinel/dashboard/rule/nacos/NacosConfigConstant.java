package com.alibaba.csp.sentinel.dashboard.rule.nacos;

/**
 * 常量配置
 */
public class NacosConfigConstant {
    /**
     * 流控规则文件后缀
     */
    public static final String FLOW_POSTFIX = ".flow";

    /**
     * 降流规则文件后缀
     */
    public static final String DEGRADE_POSTFIX = ".degrade";

    /**
     * 黑白名单规则文件后缀
     */
    public static final String AUTHORITY_POSTFIX = ".authority";

    /**
     * 系统规则文件后缀
     */
    public static final String SYSTEM_POSTFIX = ".system";

    /**
     * 热点规则文件后缀
     */
    public static final String PARAM_FLOW_POSTFIX = ".paramFlow";

    /**
     * 网关流控后缀
     */
    public static final String GATEWAY_FLOW_POSTFIX = ".gatewayFlow";

    /**
     * 网关API组
     */
    public static final String GATEWAY_API_POSTFIX = ".gatewayApi";


    /**
     * 默认GROUP等于DEFAULT_GROUP
     */
    public static final String GROUP_ID = "DEFAULT_GROUP";

    /**
     * 默认IP地址
     */
    public static final String IP = "localhost";

    /**
     * 默认端口号
     */
    public static final String PORT = "8848";

    /**
     * 默认namespace等于public
     */
    public static final String NAMESPACE = "";
}