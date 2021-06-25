package io.codegitz.spring.common.mistakes.map;

import io.codegitz.spring.common.mistakes.entity.Department;
import io.codegitz.spring.common.mistakes.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2021/6/25 17:33
 **/
public class CollectorsDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(2);
        Employee e3 = new Employee(3);
        Employee e4 = new Employee(4);
        Department d1 = new Department();
        Department d2 = new Department();
        d1.setDepartmentId("d1");
        d2.setDepartmentId("d2");
        e1.setDepartment(d1);
        e2.setDepartment(d1);
        e3.setDepartment(d2);
        e4.setDepartment(d2);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
//        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(s -> s.getDepartment().getDepartmentId()));
//        System.out.println(collect);
//        Map<Boolean, List<Employee>> partition = employees.stream().collect(Collectors.partitioningBy(s -> s.getId() > 2));
//        System.out.println(partition);
//        Map<Integer,Employee> mapEmployee = employees.stream().collect(Collectors.toMap(Employee::getId,Function.identity()));
//        System.out.println(mapEmployee);
//        Map<Department, Long> grouping = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        System.out.println(grouping);
        Map<Department, List<Integer>> grouping = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getId, Collectors.toList())));
        System.out.println(grouping);

    }
}
