package annotate.demo;

import annotate.ExcelField;
import lombok.Data;

@Data
public class Excel{

    @ExcelField
    private String a;

    @ExcelField
    private String b;
}