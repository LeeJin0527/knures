package kr.ac.knu.knures.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Test
    public void testVerify() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            String email = "user"+(i+1)+"@aaa.com";
            service.verify(email);
        });

    }
}
