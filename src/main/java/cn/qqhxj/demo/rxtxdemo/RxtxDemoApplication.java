package cn.qqhxj.demo.rxtxdemo;


import cn.qqhxj.rxtx.context.SerialContext;
import cn.qqhxj.rxtx.parse.SerialDataParser;
import cn.qqhxj.rxtx.parse.StringSerialDataParser;
import cn.qqhxj.rxtx.processor.SerialDataProcessor;
import cn.qqhxj.rxtx.starter.annotation.EnableSerialPort;
import cn.qqhxj.rxtx.starter.annotation.EnableSerialPortAutoConfig;
import cn.qqhxj.rxtx.starter.annotation.SerialPortBinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;

@EnableSerialPortAutoConfig
@Slf4j
@SpringBootApplication
@SerialPortBinder("COM1")
@EnableSerialPort(value = "COM1", port = "COM1")
@EnableSerialPort(value = "COM3", port = "COM3")
public class RxtxDemoApplication implements SerialDataProcessor<String> {


    @Lazy
    @Resource
    @Qualifier("COM3.SerialContext")
    private SerialContext serialContext;

    // 处理串口接收的数据 默认是 new String(data)
    @Override
    public void process(String s,SerialContext serialContext) {
        log.info("message received = {}", s);
        // todo 处理消息 这里做了一个回显
        System.out.println(serialContext);
        serialContext.sendData(("return " + s).getBytes());
    }

    @SerialPortBinder("COM1")
    @Bean
    public SerialDataParser serialDataParser() {
        return new StringSerialDataParser();
    }

    @SerialPortBinder("COM3")
    @Bean
    public SerialDataParser serialDataParser2() {
        return new StringSerialDataParser();
    }


    public static void main(String[] args) {
        SpringApplication.run(RxtxDemoApplication.class, args);
        while (true) {
            ;
        }
    }

}

