package com.epam;

import com.epam.common.CustomFunctionalInterface;
import com.epam.common.Employee;
import com.epam.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAsync
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
/*
		Employee employee1 = new Employee(101, "sydu", "finance", 100l);
		Employee employee2 = new Employee(102, "siva", "computer", 200l);
		Employee employee3 = new Employee(103, "vinay", "learning", 300l);
		Employee employee4 = new Employee(104, "varma", "learning", 400l);

		LinkedList<Employee> linkedList = new LinkedList();

		linkedList.add(employee1);
		linkedList.add(employee2);
		linkedList.add(employee3);
		linkedList.add(employee4);

		Map<String , List<Employee>> map = null;
		map = linkedList.stream().collect(Collectors.groupingBy(employee -> employee.getDeptName()));
		//System.out.println(map);

		Map<String , Long> map1 = null;
		map1 = linkedList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.summingLong(Employee::getSalary)));
				//.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue))
				//.collect(Collectors.toMap(stringLongEntry -> stringLongEntry.getKey(), stringLongEntry -> stringLongEntry.getValue(), (o1, o2) -> o1, LinkedHashMap::new));

		//System.out.println(map1);

		Comparator<Employee> comparator = (o1, o2) -> {
			int nameCompareResult = o1.getName().compareTo(o2.getName());
			int deptCompareResult = o1.getDeptName().compareTo(o2.getDeptName());
			int empNOCompareResult = o1.getEmpNo() == o2.getEmpNo()? 0 : o1.getEmpNo() > o2.getEmpNo()? 1 : -1 ;

			return nameCompareResult !=0 ? nameCompareResult : deptCompareResult !=0 ? deptCompareResult : empNOCompareResult;
		};

		CustomFunctionalInterface c = a -> a*a;

		System.out.println(c.square(2));
*//*
		TreeSet<Employee> treeSet = new TreeSet<>();
		treeSet.add(employee1);
		treeSet.add(employee2);
		treeSet.add(employee3);
		treeSet.add(employee4);*//*
		//System.out.println(treeSet);

		TreeMap<String, Employee> treeMap = new TreeMap<>();
		treeMap.put("one", employee1);
		treeMap.put("two", employee2);
		treeMap.put("three", employee3);
		System.out.println(treeMap);

		String s = "test";
		Map<Character, Long> result = Arrays.stream("test".chars().toArray()).mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(result);

		List<String> list1 = new ArrayList<>();
		list1.add("test");

		List<String> list2 = new ArrayList<>();
		list2.add("test2");
		List<String> list3 = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		//System.out.println(list3);*/
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

/*	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(10);
		executor.setThreadNamePrefix("Payment-");
		executor.initialize();
		return executor;
	}*/

}
