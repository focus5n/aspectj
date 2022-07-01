package x.y.aspectj.model;

import lombok.Data;

@Data
public class ExamScore {
    private String grade;
    private int korean;
    private int english;
    private int math;
    private Double avg;

    public ExamScore() {
        this.avg = (double) (korean + english + math) / 3;
    }
}
