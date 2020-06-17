package cn.qqhxj.demo.rxtxdemo;

import cn.qqhxj.common.rxtx.SerialContext;
import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RxtxDemoApplication implements SerialDataProcessor<String> {
    @Override
    public void process(String s) {
        log.info("message received = {}", s);
        // todo 处理消息 这里做了一个回显
        SerialContext.sendData(("return " + s).getBytes());
    }

    public static void main(String[] args) {
        SpringApplication.run(RxtxDemoApplication.class, args);
        while (true) {
            ;
        }
    }

}

