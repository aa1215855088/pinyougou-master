package com.pinyougou.product.config;

import com.pinyougou.common.base.constant.MqQueueConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @program: pinyougou-master
 * @description:
 * @author: 徐子楼
 * @create: 2019-01-19 00:22
 **/
@Configuration
public class RabbitConfig {

    /**
     * 初始化zipkin队列
     *
     * @return
     */
    @Bean
    public Queue initZipkinQueue() {
        return new Queue(MqQueueConstant.ZIPKIN_NAME_QUEUE);
    }
}
