package cn.qqhxj.demo.rxtxdemo;

import cn.qqhxj.common.rxtx.SerialContext;
import cn.qqhxj.common.rxtx.processor.SerialDataProcessor;
import cn.qqhxj.common.rxtx.reader.AnyDataReader;
import cn.qqhxj.common.rxtx.reader.SerialReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class RxtxDemoApplication implements SerialDataProcessor<String> {

    // 处理串口接收的数据 默认是 new String(data)
    @Override
    public void process(String s) {
        log.info("message received = {}", s);
        // todo 处理消息 这里做了一个回显
        SerialContext.sendData(("return " + s).getBytes());
    }

    // 可以接受所有的串口数据
    @Bean
    public SerialReader serialReader(){
        return new AnyDataReader();
    }

    public static void main(String[] args) {
        SpringApplication.run(RxtxDemoApplication.class, args);
        while (true) {
            ;
        }
    }

}

