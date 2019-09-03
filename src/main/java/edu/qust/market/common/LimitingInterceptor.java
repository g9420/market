package edu.qust.market.common;

import edu.qust.market.service.RedisService;
import edu.qust.market.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author g9420
 * @date 2019/8/31 15:40
 */
@Slf4j
@Configuration
public class LimitingInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //如果请求输入方法
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit != null) {
                long seconds = accessLimit.seconds();
                int maxCount = accessLimit.maxCount();
//关于key的生成规则可以自己定义 本项目需求是对每个方法都加上限流功能，如果你只是针对ip地址限流，那么key只需要只用ip就好
                String key = IpUtils.getIpAddr(httpServletRequest);

                //从redis中获取用户访问的次数
                try {
                    //此操作代表获取该key对应的值自增1后的结果
                    long q = redisService.incr(key, seconds);
                    if (q > maxCount) {
                        //加1
                        httpServletResponse.sendError(300,"请求频繁");
                        return false;
                    }
                    return true;
                }catch (RedisConnectionFailureException e){
                    log.info("redis错误"+e.getMessage().toString());
                    return true;
                }
            }
        }
        return false;
    }
}
