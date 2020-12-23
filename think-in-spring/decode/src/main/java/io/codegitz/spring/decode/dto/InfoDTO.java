package io.codegitz.spring.decode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author 张观权
 * @date 2020/11/17 16:11
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfoDTO {

    private String name;

    private String info;

    public InfoDTO() {
    }

    public InfoDTO(String name) {
        this.name = name;
    }

    private List<InfoDTO> list;

    public List<InfoDTO> getList() {
        return list;
    }

    public void setList(List<InfoDTO> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
