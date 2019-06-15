package cn.qqhxj.demo.rxtxdemo;

import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RxtxDemoApplication implements SerialDataProcessor<String> {
    @Override
    public void process (String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        SpringApplication.run(RxtxDemoApplication.class, args);
        while (true) {
            ;
        }
    }

}

