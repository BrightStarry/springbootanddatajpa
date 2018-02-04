package com.zx;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		ICsvBeanReader beanReader = null;
		try {
			beanReader = new CsvBeanReader(new FileReader("C:\\Users\\97038\\Desktop\\a.csv"), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the values to the bean (names must match)
			final String[] header = new String[]{"id", "name", "pId", "pName"};

			List<Emp> list1 = new LinkedList<>();
			Emp emp;
			while( (emp = beanReader.read(Emp.class,header)) != null ) {
				System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
						beanReader.getRowNumber(), emp));
				list1.add(emp);
			}

			List<Emp> roots = list1.stream().filter(item -> StringUtils.isEmpty(item.getPId())).collect(Collectors.toList());


			List<A> result = new LinkedList<>();
			roots.forEach(item -> {
				LinkedList<A> root = new LinkedList<>();
				root.add(new A(item, new LinkedList<>()));
				test1(list1, root);
				result.add(new A(null,root));
			});

			result.forEach(System.out::println);

			String s = new Gson().toJson(result);
			System.out.println("--------------------------------------------------------");
			System.out.println(s);


		}
		finally {
			if( beanReader != null ) {
				beanReader.close();
			}
		}

	}

	private void test1(List<Emp> list, List<A> root) {
		for (A item : root) {
			if(CollectionUtils.isEmpty(item.getChild())){
				List<A> child = list.stream()
						.filter(item2 -> item2.getPId() != null && item2.getPId().equals(item.getEmp().getId()))
						.map(item3 -> new A(item3, new LinkedList<>()))
						.collect(Collectors.toList());
				if (!CollectionUtils.isEmpty(root)) {
					item.setChild(child);
					test1(list, child);
				}
			}
		}
	}
}
