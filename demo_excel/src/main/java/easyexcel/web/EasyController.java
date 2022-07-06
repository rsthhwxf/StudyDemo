package easyexcel.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import easyexcel.DemoData;
import easyexcel.EasyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
public class EasyController {

    @Autowired
    WebDataListener webDataListener;

    @RequestMapping("/read")
    public String read(@RequestBody MultipartFile uploadExcel) throws IOException {
        try {
            //工作簿
            ExcelReaderBuilder readWorkBook = EasyExcel.read(uploadExcel.getInputStream(), DemoData.class, webDataListener);
            //工作表
            readWorkBook.sheet().doRead();
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/write")
    public void write(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 防止中文乱码
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName + ".xlsx");
        OutputStream outputStream = response.getOutputStream();
        System.out.println(new EasyTest().data());
        EasyExcel.write(outputStream,DemoData.class).sheet().doWrite(new EasyTest().data());
    }
}
