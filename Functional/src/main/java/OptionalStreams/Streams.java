package OptionalStreams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import io.espinoleandroo.java.functional.NombresUtils;

public class Streams {

	public static void main(String[] args) {
		List<String> courseList = NombresUtils.getList("Java", "FrontEnd", "BackEnd", "FullStack");
		
		
		for (String course : courseList) {
			System.out.println("Platzi: " + course);
		}
		
		Stream<String> courseStream = Stream.of("Java", "FrontEnd", "BackEnd", "FullStack");
		
		// Stream<Integer> courseLengthStream  = courseStream.map(course -> course.length());
		// Optional<Integer> longest = courseLengthStream.max((x, y) -> y - x);
		
		Stream<String> emphasis = courseStream.map(course -> course + "!");
		Stream<String> justJava = emphasis.filter(course -> course.contains("Java"));
		
		justJava.forEach(System.out::println);
		
	}

}
