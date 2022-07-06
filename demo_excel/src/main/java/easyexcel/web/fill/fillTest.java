package easyexcel.web.fill;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import easyexcel.DemoData;
import easyexcel.DemoDataListener;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fillTest {

    String path = "C:\\Users\\wxf\\IdeaProjects\\demo_internships\\demo_excel\\src\\main\\resources\\static\\b.xlsx";
    String path2 = "C:\\Users\\wxf\\IdeaProjects\\demo_internships\\demo_excel\\src\\main\\resources\\static\\水平填充.xlsx";


    @Test
    public void write(){
        Map<String,Object> map = new HashMap<>();
        map.put("rank",1);
        ExcelWriter excelWriter = EasyExcel.write(path2, DemoData.class).withTemplate(path).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 组合填充时，因为多组填充的数据量不确定，需要在多组填充完之后另起一行,避免覆盖冲突
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
        excelWriter.fill(initFillData(),fillConfig,writeSheet);
        excelWriter.finish();
    }

     private List<FillData> initFillData() {
         ArrayList<FillData> fillDatas = new ArrayList<FillData>();
         for (int i = 0; i < 10; i++) {
             FillData fillData = new FillData();
             fillData.setName("杭州黑马" + i);
             fillData.setScore(999);
             fillData.setRank(8);
             fillDatas.add(fillData);
         }
         return fillDatas;
     }


}
