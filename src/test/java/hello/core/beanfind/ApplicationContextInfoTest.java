package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter -> iteration 배열 반복문 자동 생성!!
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object");

        }
    }

    // command+D -> 복사 후 붙혀넣기
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter -> iteration 배열 반복문 자동 생성!!
        for (String beanDefinitionName : beanDefinitionNames) {
            // Object bean = ac.getBean(beanDefinitionName);
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + beanDefinitionName + " object");
            }

        }
    }

    @Test
    @DisplayName("인프라스트럭쳐 빈 출력하기")
    void findAllInfrastructureBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter -> iteration 배열 반복문 자동 생성!!
        for (String beanDefinitionName : beanDefinitionNames) {
            // Object bean = ac.getBean(beanDefinitionName);
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                System.out.println("name = " + beanDefinitionName + " object");
            }

        }
    }
}
