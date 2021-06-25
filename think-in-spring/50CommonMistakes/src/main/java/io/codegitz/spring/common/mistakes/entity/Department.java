package io.codegitz.spring.common.mistakes.entity;

/**
 * @author 张观权
 * @date 2021/6/25 17:33
 **/
public class Department {
    private String departmentId;

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                '}';
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
