package easyexcel.web;

import easyexcel.DemoData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImp implements DataService {
    public void readExcel(List<DemoData> students) {
        for (DemoData student : students) {
            System.out.println("student = " + student);
        }
    }
}
