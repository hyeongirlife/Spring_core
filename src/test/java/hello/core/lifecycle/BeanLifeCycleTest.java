package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // 스프링 빈에 등록
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        // 빈에 등록된 클래스 가져오기
        NetworkClient client = ac.getBean(NetworkClient.class);
        // 스프링 컨테이너를 종료. ConfigurableApplicationContext 필요
        // 스프링 빈의 라이프 사이클
        // 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백(빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출) -> 소멸전 콜백(빈이 소멸되기 직전에 호출) -> 스프링 종료
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
