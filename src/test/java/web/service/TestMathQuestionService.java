package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {
	
	

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test
	public void testAddNumber1Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
	}
	
	@Test
	public void testAddNumber2Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("2", ""));
	}
	
	@Test
    public void testQ1AdditionEmptyInput() {
		Assert.assertNull(MathQuestionService.q1Addition("", "")); // Test addition with empty input
    }
	
	@Test
    public void testQ1AdditionBasic() {
        assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.0001); // Test basic addition
    }

    @Test
    public void testQ1AdditionNegativeNumbers() {
        assertEquals(-1.0, MathQuestionService.q1Addition("-2", "1"), 0.0001); // Test addition with negative numbers
    }

    @Test
    public void testQ1AdditionWithZero() {
        assertEquals(0.0, MathQuestionService.q1Addition("0", "0"), 0.0001); // Test addition with zero
    }

    @Test
    public void testQ1AdditionDecimalNumbers() {
        assertEquals(6.25, MathQuestionService.q1Addition("2.5", "3.75"), 0.0001); // Test addition with decimal numbers
    }

    @Test
    public void testQ2SubtractionEmptyInput() {
    	Assert.assertNull(MathQuestionService.q2Subtraction("", "")); // Test subtraction with empty input
    }
    
    @Test
	public void testSubtractNumber1Empty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
	}
	
	@Test
	public void testAddSubtract2Empty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("2", ""));
	}
	
    @Test
    public void testQ2SubtractionBasic() {
        assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0.0001); // Test basic subtraction
    }

    @Test
    public void testQ2SubtractionNegativeNumbers() {
        assertEquals(-3.0, MathQuestionService.q2Subtraction("-1", "2"), 0.0001); // Test subtraction with negative numbers
    }

    @Test
    public void testQ2SubtractionWithZero() {
        assertEquals(0.0, MathQuestionService.q2Subtraction("0", "0"), 0.0001); // Test subtraction with zero
    }

    @Test
    public void testQ2SubtractionDecimalNumbers() {
        assertEquals(-2.5, MathQuestionService.q2Subtraction("1.25", "3.75"), 0.0001); // Test subtraction with decimal numbers
    }
}
