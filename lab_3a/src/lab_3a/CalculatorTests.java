package lab_3a;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class CalculatorTests {

    @Test
    public void invalidDate(){
        Assert.assertThrows(IllegalArgumentException.class, () -> new MovieTicketPriceCalculator(LocalTime.of(5, 0, 0), LocalTime.of(3, 0,0 ), 12, 60));
    }

    @Nested
    public class DiscountPrices{
        private final MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(LocalTime.of(12, 0, 0), LocalTime.of(23, 0, 0), 12, 60);
        @Test
        @DisplayName("Senior Discount within Matinee and without")
        public void seniorDiscount(){
            Assert.assertEquals(2000, calculator.computePrice(LocalTime.of(13, 0,0), 60));
            Assert.assertEquals(2300, calculator.computePrice(LocalTime.of(2, 0,0), 60));
        }
        @Test
        @DisplayName("Child Discount within Matinee and without")
        public void childDiscount(){
            Assert.assertEquals(2100, calculator.computePrice(LocalTime.of(13, 0,0), 12));
            Assert.assertEquals(2400, calculator.computePrice(LocalTime.of(2, 0,0), 12));
        }
        @Test
        @DisplayName("No Discount within Matinee and without")
        public void noDiscount(){
            Assert.assertEquals(2400, calculator.computePrice(LocalTime.of(13, 0,0), 13));
            Assert.assertEquals(2700, calculator.computePrice(LocalTime.of(2, 0,0), 13));
        }
    }



}
