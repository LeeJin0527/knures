package kr.ac.knu.knures.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorizationServiceTest {
    @Autowired
    private AuthorizationService service;

    @Test
    public void testVerify() {
        assert service.isVerifyCode("testcode", "user11@aaa.com");
    }
}
