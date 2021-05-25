package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.MailDTO;
import kr.ac.knu.knures.entity.MailEntity;
import kr.ac.knu.knures.repository.MailRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{
    private final MailRepository repository;

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "YOUR_EMAIL_ADDRESS";

    public String getAuthCode(int n) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < n) {
            num = random.nextInt(10);
            buffer.append(num);
        }
        return buffer.toString();
    }
    //인증코드 난수 발생
    @Override
    public void setNum(String address, String num) {
        repository.save(MailEntity.builder().address(address).num(num).build());
    }

    @Override
    public void mailSend(MailDTO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        String email = mailDto.getAddress();
        String authKey = getAuthCode(6);

        mailDto.setTitle("회원가입 인증번호 도착!");
        mailDto.setMessage("아래의 번호는 이메일 인증 번호입니다.\n" + authKey + "\n 인증번호를 입력해주세요!");

        message.setTo(email + "@knu.ac.kr");
        message.setFrom(MailServiceImpl.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
        setNum(email, authKey);

    }


    @Override
    public boolean checkNum(String email, String num) {
        Optional<MailEntity> res = repository.findById(email);
        if (res.isPresent()){
            MailEntity entity = res.get();
            if (entity.getNum().equals(num)) {
                repository.delete(entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public void register(MailDTO dto) {
        repository.save(dtoToEntity(dto)); //dto -> dao -> repository -> db
    }


    @Override
    public void delete(MailDTO dto) {
        repository.delete(dtoToEntity(dto));
    }

}