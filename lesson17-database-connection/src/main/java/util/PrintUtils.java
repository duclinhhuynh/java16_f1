package util;

import java.util.List;

public class PrintUtils {
	public PrintUtils() {
	}
	public static <E> void generate(String prefix,E element) {
		System.out.println(prefix + "--> {" + element + "}");
	}
	public static <E> void generate(String prefix,List<E> elements) {
		System.out.println(prefix + "--> {");
		elements.forEach(System.out::println);
		System.out.println("}");
	}
}
