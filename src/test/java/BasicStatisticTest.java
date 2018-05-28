import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test(expected = NoDataItemsException.class)
    public void getHighestValueThrowsExceptionBecauseOfEmptyList() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.highestValue();
    }

    @Test
    public void checkIfCorrectHighestIsReturned() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(2.55);
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(2.3);

        assertEquals(10, bs.highestValue(), 0);
    }

    @Test(expected = NoDataItemsException.class)
    public void checkIfExceptionIsThrownAfterListIsCleared() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(2.55);
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(2.3);
        bs.clearData();

        bs.highestValue();
    }

    @Test(expected = NoDataItemsException.class)
    public void getMeanValueThrowsExceptionBecauseOfEmptyList() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.getMean();
    }

    @Test
    public void checkIfCorrectMeanIsReturned() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(2.0);
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(6.0);

        assertEquals(6, bs.getMean(), 0);
    }

    @Test(expected = NoDataItemsException.class)
    public void checkIfExceptionIsThrownAfterListIsClearedAndGetMean() throws NoDataItemsException {
        BasicStatistic bs = new BasicStatistic();
        bs.addDoubleToData(2.55);
        bs.addDoubleToData(10.0);
        bs.addDoubleToData(2.3);
        bs.clearData();

        bs.getMean();
    }

    @Test
    public void NrOfDataItemsIsZeroWhenNonArePresent() {
        BasicStatistic bs = new BasicStatistic();
        assertEquals(0, bs.numberOfDataItems());
    }

    @Test
    public void numberOfDataItemsIsZeroAfterClear() {
        BasicStatistic bs = new BasicStatistic();

        bs.addDoubleToData(2.55);
        bs.addDoubleToData(5.2);

        bs.clearData();

        assertEquals(0, bs.numberOfDataItems());
    }

    @Test
    public void nrOfItemsDifferentThanZeroAfterAdd(){
        BasicStatistic bs = new BasicStatistic();
        assertEquals(0, bs.numberOfDataItems());

        bs.addDoubleToData(2.55);
        bs.addDoubleToData(5.2);

        assertNotEquals(0, bs.numberOfDataItems());
    }

    @Test
    public void nrOfItemsEqualsItemsAdded(){
        BasicStatistic bs = new BasicStatistic();
        assertEquals(0, bs.numberOfDataItems());

        bs.addDoubleToData(2.55);
        bs.addDoubleToData(5.2);
        assertEquals(2, bs.numberOfDataItems());

        bs.addDoubleToData(2.55);
        assertEquals(3, bs.numberOfDataItems());
    }

    @Test
    public void checkIfInitilSumIsZero() {
        BasicStatistic bs = new BasicStatistic();
        assertEquals(0, bs.sum(), 0);
    }

    @Test
    public void sumEqualsToAddedItemsSum() {
        BasicStatistic bs = new BasicStatistic();

        bs.addDoubleToData(2.55);
        bs.addDoubleToData(5.2);

        assertEquals(7.75, bs.sum(), 0);
    }

    @Test
    public void sumEqualsToZeroAfterClear() {
        BasicStatistic bs = new BasicStatistic();

        bs.addDoubleToData(2.55);
        bs.addDoubleToData(5.2);

        assertEquals(7.75, bs.sum(), 0);
        bs.clearData();

        assertEquals(0, bs.sum(), 0);
    }
}