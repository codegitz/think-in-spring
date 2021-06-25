package io.codegitz.spring.common.mistakes.entity;

/**
 * @author 张观权
 * @date 2021/6/25 17:32
 **/
public class Employee {
    private int id;
    private Department department;

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department=" + department +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
