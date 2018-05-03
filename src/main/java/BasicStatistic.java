/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    @Override
    public void addDoubleToData(Double valueToAdd){

    }

    @Override
    public void clearData(){

    };
	
    @Override
    public int numberOfDataItems(){
        int rv = 0;
        return rv;
    }

    @Override
    public Double sum(){
        double rv = 0.0;
        return rv;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }
}
