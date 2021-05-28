package com.xiaohe66.demo.zookeeper;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * @author xiaohe
 * @time 2021.05.14 15:41
 */
@Slf4j
public class ZookeeperTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    static {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger("root");
        logger.setLevel(Level.INFO);
    }

    @Test
    public void test1() throws Exception {
        String str = restTemplate.postForObject("http://localhost:8080/zk/test", null, String.class);

        log.info("ret : {}", str);

    }
}
