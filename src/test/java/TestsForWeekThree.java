import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestsForWeekThree {

    private BasicStatistic bs;

    public static final Object[] getHighestValueParams(){
        return $(
                $(1, 2, 3, 4, 4),
                $(10, 20 ,30 , 40, 40),
                $(-20, 110, 30, -200, 110),
                $(-10.0, -20.0, 1, -5.2, 1)
                );
    }

    public static final Object[] getMeanParams(){
        return $(
                $(1, 1, 1, 1, 1),
                $(10, 10 ,30 , 70, 30),
                $(-40, 110, 30, 100, 50)
        );
    }

    public static final Object[] getHighestValueParamsThrowException(){
        return $(
                $( 4),
                $( 1)
        );
    }

    @Before
    public void setUp(){
        bs = new BasicStatistic();
    }


    @Test
    @Parameters(method = "getHighestValueParams")
    public void checkIfCorrectHighestIsReturned(double first, double second, double third, double fourth, double result) throws NoDataItemsException {

        bs.addDoubleToData(first);
        bs.addDoubleToData(second);
        bs.addDoubleToData(third);
        bs.addDoubleToData(fourth);

        assertEquals(result, bs.highestValue(), 0);
    }

    @Test
    @Parameters(method = "getMeanParams")
    public void checkIfMeanIsCorrect(double first, double second, double third, double fourth, double result) throws NoDataItemsException {

        bs.addDoubleToData(first);
        bs.addDoubleToData(second);
        bs.addDoubleToData(third);
        bs.addDoubleToData(fourth);

        assertEquals(result, bs.getMean(), 0);
    }

    @Test (expected = NoDataItemsException.class)
    @Parameters(method = "getHighestValueParamsThrowException")
    public void checkIfHighestThrowsException(double expectedResult) throws NoDataItemsException {
        bs.highestValue();
    }

    @Test (expected = NoDataItemsException.class)
    @Parameters(method = "getHighestValueParamsThrowException")
    public void checkIfMeanThrowsException(double expectedResult) throws NoDataItemsException {
        bs.getMean();
    }


}
