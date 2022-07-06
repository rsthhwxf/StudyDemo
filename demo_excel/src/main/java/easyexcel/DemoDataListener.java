package easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import easyexcel.DemoData;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {


    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        System.out.println("data=" + data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }


}
