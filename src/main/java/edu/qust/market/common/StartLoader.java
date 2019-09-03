package edu.qust.market.common;

import edu.qust.market.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author g9420
 * @date 2019/9/1 9:57
 */
@Slf4j
@Component
public class StartLoader implements ApplicationRunner {

    @Autowired
    private RedisService redisService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisTest();
    }

    public void redisTest(){
        try{
            redisService.expire("test",2);
        }catch (Exception e){
            log.error("启动失败，{}",e.getMessage());
            log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
        }
    }

}
