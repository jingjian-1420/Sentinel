/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstant;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统规则
 * @author: wei
 * @date：2020/11/06
 */
@Component
public class SystemRuleNacosPublisher extends AbstractRuleNacosPublisher<SystemRuleEntity> {


    @Override
    public String getDataId(String app) {
        return app+NacosConfigConstant.SYSTEM_POSTFIX;
    }

    @Override
    public Converter<List<SystemRuleEntity>, String> getRuleEntityEncoder() {
        return JSON::toJSONString;
    }
}
