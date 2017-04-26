package com.xxx.opensys.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

import lombok.Builder;
import lombok.Data;

public class StreamTest {

	public static void main(String[] args) {
		
		List<Integer> list = Lists.newArrayList(1,2,3,4,5);
		
		List<Integer> result = list.stream().filter( num -> num > 3).collect(Collectors.toList());
		
		System.out.println(result);
		
		Student s1 = Student.builder().name("xxx").id(1).salary(100).department("first").grade(50).build();
		Student s2 = Student.builder().name("yyy").id(2).salary(200).department("second").grade(70).build();
		Student s3 = Student.builder().name("zzz").id(3).salary(300).department("third").grade(80).build();
		Student s4 = Student.builder().name("vvv").id(4).salary(400).department("third").grade(100).build();
		
		List<Student> studentList = Lists.newArrayList(s1, s2, s3, s4);
		
		List<String> l1 = studentList.stream().map(Student::getName).collect(Collectors.toList());
		
		Set<String> set1 = studentList.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new));
		
		String str = studentList.stream().map(Object::toString).collect(Collectors.joining(","));
		
		int total =  studentList.stream().collect(Collectors.summingInt(Student::getSalary));
		
		Map<String, Long> map1 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
		Map<String, List<Student>> map2 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
		Map<Boolean,List<Student>> map3 = studentList.stream().collect(Collectors.partitioningBy(s -> s.getGrade() > 75));
		
//		Stream.iterate(1, item ->item + 1).limit(20).forEach(System.out::println);
		
		List<Integer> duplicate = Lists.newArrayList(1,1,2,3,2,3,4,5,4,5,6);
		
//		System.out.println(duplicate.stream().map(x -> x + 2).collect(Collectors.toList()));
		
		
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		int[] result1 = IntStream.range(0, a.length).map(i -> a[i] * b[i]).toArray();
		
		
		List<Student> st1 = Lists.newArrayList(s1,s2);
		
		List<Student> st2 = Lists.newArrayList(s3,s4);
		
		Map<Integer, String> m = st1.stream().collect(Collectors.toMap(Student::getId,Student::getName));
		
//		System.out.println(m);
		

		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		
//		Arrays.stream(data).flatMap(x->Arrays.stream(x)).filter(x->"a".equals(x.toString())).forEach(System.out::println);
		
		
//		System.out.println(l1);
//		System.out.println(set1);
//		System.out.println(str);
//		System.out.println(total);
//		System.out.println(map1);
//		System.out.println(map2);
//		System.out.println(map3);
//		System.out.println(result1);
		//1. filter line 3
		//2. convert all content to upper case
		//3. convert it into a List
		List<String> list1 = new ArrayList<>();
		String fileName = "c://lines.txt";
		try(Stream<String> s = Files.lines(Paths.get(fileName))){
			list1 = s.filter(line -> !line.startsWith("line3")).map(String::toUpperCase).collect(Collectors.toList());
		} catch (IOException e) {
		}
		
		User u1 = User.builder().name(Lists.newArrayList("u1","u2","u3")).build();
		
		User u4 = User.builder().name(Lists.newArrayList("u4","u5","u6")).build();
		
		Stream.of(u1,u4).map(x->x.getName().stream()).flatMap(e->e).forEach(System.out::println);
		
		
//		System.out.println(list1);
	}
	
	@Data
	@Builder
	static class Student{
		private String name;
		private int id;
		private int salary;
		private String department;
		private int grade;
	}
	@Data
	@Builder
	static class User{
		private List<String> name;
	}

}
