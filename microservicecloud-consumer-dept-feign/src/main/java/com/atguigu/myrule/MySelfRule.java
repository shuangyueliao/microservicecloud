package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule_ZY();
    }
}
