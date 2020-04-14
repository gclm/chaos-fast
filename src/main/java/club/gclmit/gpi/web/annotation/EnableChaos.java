package club.gclmit.gpi.web.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * <p>
 *  Spring Boot启动注解。主要用户自动扫描chaos组件的包
 * </p>
 *
 * @author: gclm
 * @date: 2020/2/19 12:07 下午
 * @version: V1.0
 * @since 1.8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MapperScan(basePackages= {
        "club.gclmit.chaos.*.mapper"
})
@ComponentScan(basePackages={
        "club.gclmit.chaos"
})
@ConditionalOnWebApplication
public @interface EnableChaos {

}
