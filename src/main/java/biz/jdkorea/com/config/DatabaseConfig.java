package biz.jdkorea.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class DatabaseConfig {

//    @Bean
//    @Autowired
//    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
//        return new JPAQueryFactory(entityManager);
//    }

}
