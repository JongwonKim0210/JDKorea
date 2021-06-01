package biz.jdkorea.com.config;

import biz.jdkorea.com.security.AuthCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    // TODO : 인터셉터 주석처리 해제
    private AuthCheckInterceptor authCheckInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authCheckInterceptor)
//                .excludePathPatterns("/login")  // 여기에 인터셉트 예외 할 url 패턴 입력
//                .addPathPatterns("/*");    // 여기에 인터셉트 걸 url 패턴 입력
//    }
}
