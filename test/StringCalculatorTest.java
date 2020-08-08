import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalc = new StringCalculator();

    @Test
    public void BasicTest() throws Exception {
        String input = "1,2,3";
        assertEquals(stringCalc.add(input), 6);
    }

    @Test
    public void EmptyTest() throws Exception {
        String input = "";
        assertEquals(stringCalc.add(input), 0);
    }

    @Test
    public void BasicWithSingleTest() throws Exception {
        String input = "1,";
        assertEquals(stringCalc.add(input), 1);
    }

    @Test
    public void BasicWithNewLineTest() throws Exception {
        String input = "\n1,\n2,4\n";
        assertEquals(stringCalc.add(input), 7);
    }

    @Test
    public void CustomDelimiterBasicTest() throws Exception {
        String input = "//@\n1@2@4";
        assertEquals(stringCalc.add(input), 7);
    }

    @Test
    public void CustomDelimiterWithNewlineTest() throws Exception {
        String input = "//;\n4;2\n;\n\n9";
        assertEquals(stringCalc.add(input), 15);
    }

    @Test
    public void CustomDelimiterLongTest() throws Exception {
        String input = "//;[]72#k^^*!&\n4;[]72#k^^*!&2\n;[]72#k^^*!&\n\n9";
        assertEquals(stringCalc.add(input), 15);
    }

    @Test(expected = Exception.class)
    public void NegativeNumberExceptionTest() throws Exception {
        String input = "-1,2,3";
        stringCalc.add(input);
    }

    @Test
    public void BonusOneBasicTest() throws Exception {
        String input = "//%\n1001%100";
        assertEquals(stringCalc.add(input), 100);
    }

    @Test
    public void BonusOneLowerBoundaryTest() throws Exception {
        String input = "//%\n10%0%3";
        assertEquals(stringCalc.add(input), 13);
    }

    @Test
    public void BonusOneUpperBoundaryTest() throws Exception {
        String input = "//%\n1000%1001%3";
        assertEquals(stringCalc.add(input), 1003);
    }

    @Test
    public void BonusOneBothBoundaryTest() throws Exception {
        String input = "//%\n1000%0%3";
        assertEquals(stringCalc.add(input), 1003);
    }

    @Test
    public void BonusTwoArbitaryLengthTest() throws Exception {
        String input = "//***\n1***2\n***3\n";
        assertEquals(stringCalc.add(input), 6);
    }

    @Test
    public void BonusThreeMultipleDelimiterTest() throws Exception {
        String input = "//*,&\n10*21\n&13\n";
        assertEquals(stringCalc.add(input), 44);
    }

    @Test
    public void BonusThreeMultipleSimilarDelimiterTest() throws Exception {
        String input = "//*,**\n10*21\n**13\n";
        assertEquals(stringCalc.add(input), 44);
    }

    @Test
    public void BonusThreeMultipleSimilarDelimiterReversedTest() throws Exception {
        String input = "//**,*\n10*21\n**13\n";
        assertEquals(stringCalc.add(input), 44);
    }

    @Test
    public void BonusFourMultipleLengthDelimiterTest() throws Exception {
        String input = "//*&&,*!**!*\n10*!**!*21\n*&&13*!**!*1\n";
        assertEquals(stringCalc.add(input), 45);
    }
}