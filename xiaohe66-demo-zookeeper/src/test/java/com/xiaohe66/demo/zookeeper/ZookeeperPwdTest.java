package com.xiaohe66.demo.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * @author xiaohe
 * @time 2021.04.28 11:37
 */
@Slf4j
public class ZookeeperPwdTest {

    @Test
    public void test() throws NoSuchAlgorithmException {

        String user = "xiaohe";
        String pwd = "xiaohe";


        // xh:rQHOQHKNv1WZ0UUHc2Fp2VTcMhM=
        String sId = DigestAuthenticationProvider.generateDigest(user + ":" + pwd);

        log.info(sId);



    }
}
