package io.codegitz.spring.decode;

import io.codegitz.spring.decode.dto.InfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author 张观权
 * @date 2020/11/11 11:01
 **/
@Controller
public class DownloadController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setHeader("content-disposition", "attachment;fileName="+ URLEncoder.encode("哈哈哈","UTF-8"));
        response.setCharacterEncoding("UTF-8");
    }


    @GetMapping("/index")
    public String index()  {
        return "download";
    }

    @GetMapping("/info")
    @ResponseBody
    public InfoDTO infoDTO(){
        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setInfo("info");
        return infoDTO;
    }
}
