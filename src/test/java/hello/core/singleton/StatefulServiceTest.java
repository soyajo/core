package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statusfulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자가 10000월 주문
        Integer userAPrice = statefulService1.order("userA",10000);
        //ThreadA: A사용자가 10000월 주문
        Integer userBPrice = statefulService2.order("userB", 20000);

        //Thread: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        Integer price = statefulService1.get

        System.out.println("price = " + userAPrice);
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class Testconfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}