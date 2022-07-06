package easyexcel.web;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import easyexcel.DemoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")// 作者要求每次读取都要使用新的Listener
public class WebDataListener extends AnalysisEventListener<DemoData> {
    @Autowired
    DataService dataService;
    ArrayList<DemoData> datas = new ArrayList<DemoData>();
    public void invoke(DemoData student, AnalysisContext analysisContext) {
        System.out.println("*");
        datas.add(student);
        if (datas.size() % 5 == 0) {
            dataService.readExcel(datas);
            datas.clear();
        }
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
