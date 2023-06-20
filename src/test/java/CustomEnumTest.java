import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.komarov.CustomEnum;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CustomEnumTest {
    static CustomEnum ONE;
    static CustomEnum TWO;
    static CustomEnum THREE;
    static CustomEnum FOUR;

    @BeforeAll
    public static void initCustomEnum() {
        ONE = new CustomEnum("ONE");
        TWO = new CustomEnum("TWO");
        THREE = new CustomEnum("THREE");
        FOUR = new CustomEnum("FOUR");
    }

    @Test
    public void CustomEnum_shouldSetOrdinalAccordingToOrderAndNamePassedInParameter_test() {
        assertEquals("ONE", ONE.name());
        assertEquals(0, ONE.ordinal());
        assertEquals("FOUR", FOUR.name());
        assertEquals(3, FOUR.ordinal());
    }

    @Test
    public void values_shouldReturnArrayOfCorrectLengthAndWithValuesInOrderOfAddition_test() {
        CustomEnum[] values = CustomEnum.values();
        assertEquals(4, values.length);
        assertEquals(ONE, values[0]);
        assertEquals(FOUR, values[3]);
    }

    @Test
    public void valueOf_shouldThrowRuntimeExceptionIfValueOrOrdinalIsPassedIsNotAvailable_test() {
        int ordinal = 4;
        String name = "FIVE";
        Throwable exceptionWithOrdinal = assertThrows(RuntimeException.class, () -> CustomEnum.valueOf(ordinal));
        Throwable exceptionWithName = assertThrows(RuntimeException.class, () -> CustomEnum.valueOf(name));
        assertEquals(CustomEnum.NO_ENUM_FOR_ORDINAL + ordinal, exceptionWithOrdinal.getMessage());
        assertEquals(CustomEnum.NO_ENUM_FOR_NAME + name, exceptionWithName.getMessage());
    }

    @Test
    public void valueOf_shouldReturnCustomEnumWithPassedNameIfExistingNameIsPassed_test() {
        assertEquals(ONE, CustomEnum.valueOf("ONE"));
        assertEquals(FOUR, CustomEnum.valueOf("FOUR"));
    }

    @Test
    public void valueOf_shouldReturnCustomEnumWithValidNameIfExistingOrdinalIsPassed_test() {
        assertEquals(ONE, CustomEnum.valueOf(0));
        assertEquals(FOUR, CustomEnum.valueOf(3));
    }
}
