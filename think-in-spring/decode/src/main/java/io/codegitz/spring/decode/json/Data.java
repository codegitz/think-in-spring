package io.codegitz.spring.decode.json;

import java.util.List;

/**
 * @author 张观权
 * @date 2021/3/29 16:19
 **/
public class Data {
    private String id;
    private List<Car> cars = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
