package pl.edu.agh.iisg.osgiservices;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ServiceUser {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private BundleContext context;

    public ServiceUser(BundleContext context) {
        this.context = context;
    }

    public void useServices(int n) {
        try {
            for (int i = n - 1; i >= 0; i--) {
                String filter = "(name=" + i + ")";
                Collection<ServiceReference<ISampleService>> references = context.getServiceReferences(ISampleService.class, filter);
                for (ServiceReference<ISampleService> ref : references) {
                    ISampleService service = context.getService(ref);
                    logger.log(Level.FINE, "Using service: " + String.valueOf(service.getValue()));
                }
            }
        } catch (InvalidSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
