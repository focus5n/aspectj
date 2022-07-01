package x.y.aspectj.model;

import java.util.ArrayList;
import java.util.HashMap;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import x.y.aspectj.ui.Printer;

@Data
@RequiredArgsConstructor
public class Person {
    private String name;
    private String major;
    private ArrayList<ExamScore> examScores;

    @Autowired
    private Printer printer;

    public void print() {
        var message = "[name: " + name + ", major: " + major + ", examScores: " + examScores + "]";
        printer.print(message);
    }

    public HashMap<String, Float> getTotal(String grade) {
        var examScores = this.examScores;
        var gradeAvg = new HashMap<String, Float>();

        for (var examScore : examScores) {
            var avg =
                (float) (examScore.getKorean() + examScore.getEnglish() + examScore.getMath()) / 3;
            gradeAvg.put(examScore.getGrade(), avg);
        }

        System.out.println(gradeAvg);
        return gradeAvg;
    }

    public void printThrowException() {
        throw new IllegalArgumentException(" => 고의로 발생시킴.");
    }

}
