package kr.ac.knu.knures.repository;

import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class MerchandiseRepositoryTest {
    @Autowired //만들어진 bean 객체를 찾아서 넣어준다.
    private MerchandiseRepository repository;
    @Autowired
    private MemberRepository memberRepository;
    //dependency injection

    //Junit
//    @Transactional
    @Test
    public void testInsertDummies(){
        List<MemberEntity> members = memberRepository.findAll();
        int membersCount = members.size();
        int idx = (int)(Math.random() * (membersCount - 1));
        MerchandiseEntity entity = MerchandiseEntity.builder()
                .writer(members.get(idx))
                .title("나눔합니다  ")
                .price(500L)
                .content("라면이 너무 많아서 나눠 드려요  ")
                .category("etc")
                .state("share")
                .imgURL1("/assets/img/라면1.jpeg")
                .imgURL2("/assets/img/라면2.jpeg")
                .imgURL3(null)
                .build();

//        repository.save(entity);
//        MerchandiseEntity entity1 = MerchandiseEntity.builder()
//                .writer(members.get(idx))
//                .title("판합니다  ")
//                .price(180000L)
//                .content("상주화폐 ")
//                .category("etc")
//                .state("sell")
//                .imgURL1("")
//                .imgURL2(null)
//                .imgURL3(null)
//                .build();
//
//        repository.save(entity1);



//        IntStream.range(1, 5).forEach(i -> {
//            int idx = (int)(Math.random() * (membersCount - 1));
//            MerchandiseEntity entity = MerchandiseEntity.builder()
//                    .writer(members.get(idx))
//                    .title("나눔합니다  ")
//                    .price(500L)
//                    .content("라면 나눠드림")
//                    .category("etc")
//                    .state("share")
//                    .imgURL1("https://www.google.com/imgres?imgurl=https%3A%2F%2Fimagescdn.gettyimagesbank.com%2F500%2F201708%2Fjv10951098.jpg&imgrefurl=https%3A%2F%2Fwww.gettyimagesbank.com%2Fview%2F%25EB%2583%2584%25EB%25B9%2584%25EB%259D%25BC%25EB%25A9%25B4%2Fjv10951098&tbnid=6MRvWZg8NAEqoM&vet=12ahUKEwiv9set5crwAhXJIaYKHQPGD48QMygAegUIARDZAQ..i&docid=soQElkPYEgjmwM&w=500&h=375&q=%EB%9D%BC%EB%A9%B4%EC%9D%B4%EB%AF%B8%EC%A7%80&ved=2ahUKEwiv9set5crwAhXJIaYKHQPGD48QMygAegUIARDZAQ")
//                    .imgURL2("https://www.google.com/imgres?imgurl=https%3A%2F%2Fimagescdn.gettyimagesbank.com%2F500%2F201708%2Fjv10951098.jpg&imgrefurl=https%3A%2F%2Fwww.gettyimagesbank.com%2Fview%2F%25EB%2583%2584%25EB%25B9%2584%25EB%259D%25BC%25EB%25A9%25B4%2Fjv10951098&tbnid=6MRvWZg8NAEqoM&vet=12ahUKEwiv9set5crwAhXJIaYKHQPGD48QMygAegUIARDZAQ..i&docid=soQElkPYEgjmwM&w=500&h=375&q=%EB%9D%BC%EB%A9%B4%EC%9D%B4%EB%AF%B8%EC%A7%80&ved=2ahUKEwiv9set5crwAhXJIaYKHQPGD48QMygAegUIARDZAQ")
//                    .imgURL3(null)
//                    .build();
//
//            repository.save(entity);
//        });
    }

    // @Commit
    // @Transactional
//    @Test
    public void testDeleteDummies() {

        IntStream.range(0, 10).forEach(i -> {
            System.out.println(i);

            repository.deleteById((long) (i+1));
        });
    }
}
