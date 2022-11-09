import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

class longerThanFive implements StringChecker {
	public boolean checkString(String s){
		if(s.length() > 5){return true;}
		return false;
	}
}

public class TestListExamples {
    @Test
	public void testFilter() {
		List<String> input1 = new ArrayList<>();
		input1.add("a");
		input1.add("longone");
		input1.add("four");
		input1.add("verlongstring");
	    longerThanFive sc = new longerThanFive();
	    input1 = ListExamples.filter(input1, sc);
		
		List<String> input2 = new ArrayList<>();
		input2.add("longone");
		input2.add("verlongstring");
		assertEquals(input2, input1);		
	}

    @Test
	public void testMerge() {
		List<String> input1 = new ArrayList<>();
		List<String> input2 = new ArrayList<>();
		List<String> input3 = new ArrayList<>();
        List<String> input4 = new ArrayList<>();

		input1.add("a");
		input1.add("b");
		input1.add("c");
		input1.add("d");
    
		input2.add("a");
		input2.add("a");
		input2.add("a");
		input2.add("e");

        input3.add("a");
		input3.add("a");
		input3.add("a");
		input3.add("a");
		input3.add("b");
		input3.add("c");
		input3.add("d");
		input3.add("e");

	    input4 = ListExamples.merge(input1,input2);
	
		assertEquals(input3, input4);		
	}
}