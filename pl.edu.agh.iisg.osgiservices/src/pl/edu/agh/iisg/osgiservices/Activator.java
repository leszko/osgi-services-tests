package pl.edu.agh.iisg.osgiservices;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator implements BundleActivator {

    // The plug-in ID
    public static final String PLUGIN_ID = "pl.edu.agh.iisg.osgiservices"; //$NON-NLS-1$

    private static int SERVICE_NUMBER = 100;

    private static Logger logger = Logger.getLogger(Activator.class.getName());

    // The shared instance
    private static Activator plugin;

    private BundleContext context;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        plugin = this;
        this.context = context;

        testServices();
    }

    private void testServices() {
        long startCreate = System.currentTimeMillis();
        testCreateManyServices();
        long endCreate = System.currentTimeMillis();
        logger.info("Create time: " + (endCreate - startCreate));

        long startUse = System.currentTimeMillis();
        testUseService();
        long endUse = System.currentTimeMillis();
        logger.info("Use time: " + (endUse - startUse));
    }

    private void testCreateManyServices() {
        ServiceCreator creator = new ServiceCreator(context);
        creator.createAndRegisterServices(SERVICE_NUMBER);
    }

    private void testUseService() {
        ServiceUser user = new ServiceUser(context);
        user.useServices(SERVICE_NUMBER);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
