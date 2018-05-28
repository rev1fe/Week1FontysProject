import java.util.ArrayList;
import java.util.Arrays;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    ArrayList<Double> data = new ArrayList<>();


    public BasicStatistic() {
    }

    public BasicStatistic(ArrayList<Double> data) {
        this.data = data;
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        data.add(valueToAdd);
    }

    @Override
    public void clearData(){
        data.clear();
    }
	
    @Override
    public int numberOfDataItems(){
        int rv = data.size();
        return rv;
    }

    @Override
    public Double sum(){
        double rv = 0.0;
        for (Double d : data) {
            rv += d;
        }
        return rv;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        double rv = 0.0;
        if(data.size() == 0) throw new NoDataItemsException();
        for (Double d : data) {
            if(rv<d)
                rv = d;
        }
        return rv;
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        double rv = 0.0;
        if(data.size() == 0) throw new NoDataItemsException();
        rv = sum();
        rv = rv/ data.size();
        return rv;
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        double rv = 0.0;
        if(data.size() == 0) throw new NoDataItemsException();
        //data.sort();
        Arrays.sort(data.toArray());//??? not sure if it will work
        if((data.size()%2) == 0){
            int element = data.size()/2;
            rv = (data.get(element-1) + data.get(element))/2;
        }
        else {
            int element = (data.size()+1)/2;
            rv = data.get(element-1);
        }

        return rv;
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        if(data.size() == 0) throw new NoDataItemsException();

        double mean = getMean();
        double deviationsSum = 0;
        for (Double d : data) {
            double x = Math.pow(Math.abs(d-mean), 2);
            deviationsSum+=x;
        }
        deviationsSum = deviationsSum/data.size();
        rv = Math.sqrt(deviationsSum);
        return rv;
    }
}
