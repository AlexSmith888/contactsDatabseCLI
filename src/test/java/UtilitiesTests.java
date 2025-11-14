import org.junit.*;
import org.junit.jupiter.api.Assertions;
import own.nio.utilities.InputParser;
import own.nio.utilities.InputValidation;

import static org.junit.jupiter.api.Assertions.*;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.swing.text.html.parser.Parser;

public class UtilitiesTests {
    @Test
    public void InputParserTests(){
        InputParser pars = new InputParser();
        assertAll(
                ()-> assertArrayEquals(new String[]{"scsc"}, pars.parse("scsc")),
                ()-> assertArrayEquals(new String[]{}, pars.parse("sc sc")),
                ()-> assertArrayEquals(new String[]{}, pars.parse("sc sc sdsdc ada")),
                ()-> assertArrayEquals(new String[]{}, pars.parse("sc \" sc")),
                ()-> assertArrayEquals(
                        new String[]{"add", "alex", "777"}
                        , pars.parse("add \"alex\" 777")),
                ()-> assertArrayEquals(
                        new String[]{"add", "alex smith", "777"}
                        , pars.parse("add \"alex smith\" 777")),
                ()-> assertArrayEquals(new String[]{""}, pars.parse(""))
        );
    }

    @Test
    public void validationTests(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new InputValidation().processData(new String[]{}));
        assertEquals(e.getMessage(), "Input Data are incorrect");

        Exception e1 = assertThrows(IllegalArgumentException.class, () ->
                new InputValidation().processData(new String[]{"add", "sdcsd dasc"}));
        assertEquals(e1.getMessage()
                , "Both a name and a telephone num should be provided");

        Exception e2 = assertThrows(IllegalArgumentException.class, () ->
                new InputValidation().processData(new String[]{"upd", "sdcsd dasc"}));
        assertEquals(e2.getMessage()
                , "Both a name and a telephone num should be provided");

        Exception e3 = assertThrows(IllegalArgumentException.class, () ->
                new InputValidation().processData(new String[]{"del"}));
        assertEquals(e3.getMessage()
                , "A contact name should be provided");

        Exception e4 = assertThrows(IllegalArgumentException.class, () ->
                new InputValidation().processData(new String[]{"get"}));
        assertEquals(e4.getMessage()
                , "A contact name should be provided");
    }

}
