package io.codegitz.spring.decode;

import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 张观权
 * @date 2021/1/20 17:13
 **/
public class Person {

	@NotNull
	private String name;
	@NotNull
	private Integer age;

	public Object demoMethod(Person person, Object object,
                             List<Integer> intList, List<Person> personList,
                             Set<Integer> intSet, Set<Person> personSet,
                             Map<String, Object> myMap,
                             String name, Integer age,
                             int number, double money) {
		return "hello parameter";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
