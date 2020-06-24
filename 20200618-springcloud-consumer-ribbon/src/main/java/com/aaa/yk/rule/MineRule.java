package com.aaa.yk.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Param
 * @ClassName MineRule
 * @Description 1.ribbon在自定义负载均衡算法的时候，一定不能把这个包写在主启动类的包下，如果这么写启动的时候直接会抛出异常
 *                  @ComponentScan：
 *                      在官网中有一个明确标识：
 *                          @ComponentScan一定不能和@SpringbootApplication注解放在同一个包或者子包上
 *                          因为@SpringBootApplication注解默认会去扫描所有的注解（controller，service...）
 *                          @ComponentScan这个注解会默认扫描所有@Component注解所标识的类或者组件，而@SpringbootApplication
 *                          在这个注解下已经包含了@ComponentScan注解，为了防止二次扫描，所以不能把它们两个放在一起
 * @Author yk
 * @Date 2020/6/24 0024 15:29
 * @Return
 **/
@Configuration
public class MineRule {


    @Bean
    public IRule mineRule(){
        //里面写业务逻辑
        return new RandomRule();
    }

}
