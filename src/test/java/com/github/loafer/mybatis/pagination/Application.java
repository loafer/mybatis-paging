package com.github.loafer.mybatis.pagination;

import com.github.loafer.mybatis.pagination.model.DataPaging;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Date Created  2014-2-17
 *
 * @author loafer[zjh527@gmail.com]
 * @version 1.0
 */
@Configuration
@ComponentScan
@ImportResource("classpath:applicationContext.xml")
public class Application {
    public static void main(String[] args){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        UserService userService = context.getBean(UserService.class);

        TestClient t1 = new TestClient(userService, "AF020FD1269A44C28F4DEC00E2610634");
        TestClient t2 = new TestClient(userService, "AF020FD1269A44C28F4DEC00E2610159");
        TestClient t3 = new TestClient(userService, "AF020FD1269A44C28F4DEC00E2611303");
        TestClient t4 = new TestClient(userService, "AF120FD1269A44C28F4DEC00E2610165");
        TestClient t5 = new TestClient(userService, "AF120FD1269A44C28F4DEC00E2610995");


        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        new Thread(t5).start();
    }


    static class TestClient implements Runnable{
        private UserService userService;
        private Object parameterObject;

        TestClient(UserService userService, Object parameterObject) {
            this.userService = userService;
            this.parameterObject = parameterObject;
        }

        @Override
        public void run() {
            DataPaging dataPaging = userService.paging(parameterObject);
            System.out.println("thread[" + Thread.currentThread().getName() + "] " + dataPaging + " parameter[" + parameterObject + "]");
        }
    }
}
