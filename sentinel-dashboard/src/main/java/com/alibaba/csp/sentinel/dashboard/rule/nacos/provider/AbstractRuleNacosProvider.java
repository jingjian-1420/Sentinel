package com.alibaba.csp.sentinel.dashboard.rule.nacos.provider;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象nacos提供者
 * @author: wei
 * @date：2020/11/6
 */
public abstract class AbstractRuleNacosProvider<T> implements DynamicRuleProvider<List<T>> {

    private static Logger logger = LoggerFactory.getLogger(AbstractRuleNacosProvider.class);

    public static final long DEFAULT_TIMEOUT = 3000;

    @Autowired
    protected NacosConfigProperties nacosConfigProperties;

    @Autowired
    protected ConfigService nacosConfigService;


    @Override
    public List<T> getRules(String app) throws Exception {
        String dataId = getDataId(app);
        String rules = nacosConfigService.getConfig(dataId, nacosConfigProperties.getGroupId(), DEFAULT_TIMEOUT);
        logger.info("从Nacos 服务器 serverAddr={},Namespace={},Group={},DataId={}中拉取规则信息:{}",
                nacosConfigProperties.getServerAddr(), nacosConfigProperties.getNamespace(), nacosConfigProperties.getGroupId(), dataId, rules);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return this.getRuleEntityDecoder().convert(rules);
    }

    /**
     * 构建dataId
     * @param app
     * @return
     */
    public abstract String getDataId(String app);

    public abstract Converter<String, List<T>> getRuleEntityDecoder();

}
