package com.alibaba.csp.sentinel.dashboard.rule.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: wei
 * @date：2020/11/6
 */
public abstract class AbstractRuleNacosPublisher<T> implements DynamicRulePublisher<List<T>> {

    private static Logger logger = LoggerFactory.getLogger(AbstractRuleNacosPublisher.class);

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Autowired
    private ConfigService nacosConfigService;


    @Override
    public void publish(String app, List<T> rules) throws Exception {
        String dataId = this.getDataId(app);
        AssertUtil.notEmpty(dataId, "app name cannot be empty");
        String convert = this.getRuleEntityEncoder().convert(rules);
        logger.info("给Nacos,serverAddr={},Namespace={},Group={},DataId={}更新规则信息:{}",
                nacosConfigProperties.getServerAddr(), nacosConfigProperties.getNamespace(), nacosConfigProperties.getGroupId(), dataId, convert);
        if (rules == null) {
            return;
        }
        nacosConfigService.publishConfig(dataId, nacosConfigProperties.getGroupId(), convert);
    }

    /**
     * 构建dataId
     * @param app
     * @return
     */
    public abstract String getDataId(String app);

    public abstract Converter<List<T>, String> getRuleEntityEncoder();
}
