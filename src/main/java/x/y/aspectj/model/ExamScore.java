package x.y.aspectj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ExamScore {
    private String grade;
    private int korean;
    private int english;
    private int math;
}
