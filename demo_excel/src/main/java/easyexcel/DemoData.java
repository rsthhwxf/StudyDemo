package easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ContentRowHeight(20)
@EqualsAndHashCode
public class DemoData {
    @ExcelProperty("姓名")
    @ColumnWidth(20)
    String name;
    @ExcelProperty("分数")
    @ColumnWidth(20)
    int score;
    @ExcelProperty("排名")
    @ColumnWidth(20)
    int rank;
}
