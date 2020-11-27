package io.codegitz.spring.decode;

import io.codegitz.spring.decode.dto.InfoDTO;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/11/25 16:27
 **/
public class ListToMap {
    public static void main(String[] args) {
        List<InfoDTO> list = new ArrayList<>();
        List<InfoDTO> listToMap = new ArrayList<>();
        InfoDTO infoDTO = new InfoDTO();
        InfoDTO infoDTO1 = new InfoDTO();
        InfoDTO infoDTO2 = new InfoDTO();
        InfoDTO infoDTO3 = new InfoDTO();
        InfoDTO infoDTO4 = new InfoDTO();
        InfoDTO infoDTO5 = new InfoDTO();
        InfoDTO infoDTO6 = new InfoDTO();
        infoDTO.setInfo("0");
        infoDTO1.setInfo("1");
        infoDTO2.setInfo("2");
        infoDTO3.setInfo("3");
        infoDTO4.setInfo("4");
        infoDTO5.setInfo("5");
        infoDTO6.setInfo("6");
        list.add(infoDTO3);
        list.add(infoDTO4);
        infoDTO1.setList(list);
        listToMap.add(infoDTO);
        listToMap.add(infoDTO1);
        listToMap.add(infoDTO2);
        listToMap.add(infoDTO5);
        listToMap.add(infoDTO6);
        Map<String, InfoDTO> collect = listToMap.stream().collect(Collectors.toMap(InfoDTO::getInfo, InfoDTO -> InfoDTO));
        System.out.println(collect);
        collect.entrySet().forEach(m ->{
            System.out.println(m.getKey()+m.getValue());
        });

    }
}
