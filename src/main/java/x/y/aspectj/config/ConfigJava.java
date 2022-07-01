package x.y.aspectj.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import x.y.aspectj.model.ExamScore;
import x.y.aspectj.model.Person;

@Configuration
@ComponentScan(basePackages = "x.y.aspectj")
public class ConfigJava {

    @Bean
    public Person person() {

        ArrayList<ExamScore> examScoreList = new ArrayList<>();
        examScores(examScoreList);

        Person person = new Person();
        person.setName("홍길동");
        person.setMajor("영문학");

        person.setExamScores(examScoreList);
        return person;

    }

    private void examScores(ArrayList<ExamScore> examScoreList) {

        examScoreList.add(new ExamScore("1", 100, 90, 80));
        examScoreList.add(new ExamScore("2", 70, 90, 90));
        examScoreList.add(new ExamScore("3", 85, 90, 50));

    }
}
