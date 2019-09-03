package edu.qust.market.common;

import java.lang.annotation.*;

/**
 * @author g9420
 * @date 2019/8/31 15:32
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    //指定second 时间内 API请求次数
    int seconds() default 4;

    // 请求次数的指定时间范围  秒数(redis数据过期时间)
    int maxCount() default 10;
}

