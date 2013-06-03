package pl.edu.agh.iisg.osgiservices;

public class SampleService implements ISampleService {

    private int value;

    public SampleService(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}
