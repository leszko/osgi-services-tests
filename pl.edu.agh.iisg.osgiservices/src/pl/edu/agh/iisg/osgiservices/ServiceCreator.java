package pl.edu.agh.iisg.osgiservices;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;

public class ServiceCreator {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private BundleContext context;

    public ServiceCreator(BundleContext context) {
        this.context = context;
    }

    public void createAndRegisterServices(int n) {
        for (int i = 0; i < n; i++) {
            Hashtable<String, String> prop = new Hashtable<>();
            prop.put("name", "sampleservice-" + i);
            context.registerService(ISampleService.class.getName(), new SampleService(i), prop);
            logger.log(Level.FINE, "Registering service number: " + i);
        }
    }
}
