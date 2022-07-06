package easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EasyTest {

    String path = "C:\\Users\\wxf\\IdeaProjects\\demo_internships\\demo_excel\\src\\main\\resources\\static\\will_fill.xls";

    public List<DemoData> data(){
        List<DemoData> list = new ArrayList<DemoData>();
        for(int i=0;i<10;i++){
            DemoData tableData = new DemoData("测试"+i,i*11,10-i);
            list.add(tableData);
        }
        return list;
    }

    @Test
    public void write(){
        System.out.println(EasyExcel.write(path, DemoData.class));
        EasyExcel.write(path, DemoData.class).sheet().doWrite(data());
    }

    @Test
    public void read(){
        EasyExcel.read(path, DemoData.class,new DemoDataListener()).sheet().doRead();
    }
}
