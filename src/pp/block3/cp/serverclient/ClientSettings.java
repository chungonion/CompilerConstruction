package pp.block3.cp.serverclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/*
 * The outside file can be modified whilst `reloadSettings` is reading -> exception
 * Lazy initialization, the lock causes a non-visible deadlock, preventing updates of the settings
 * Both the timed `reloadSettings` and the manual call want to read the client.properties at the same time.
 */

public class ClientSettings {

    private Settings settings = null;
    private String filename;
    private ReentrantLock initializationLock = new ReentrantLock();
    
    ClientSettings(String filename_) {
        filename = filename_;
    }   
    
    public Settings getSettings() {

        initializationLock.lock();

        if(settings == null) {
            settings = new Settings();
            initializationLock.unlock();
        }
        return settings;
    }
    
    
    public class Settings extends TimerTask{
        
        private Settings() {
            Timer timer = new Timer(true);
            timer.schedule(this, 0, 1000);
            reloadSettings();
        }
        
        private Properties prop = new Properties();
        
        private int requestsPerSecond;
        public int getRequestsPerSecond() {
            return requestsPerSecond;
        }
        
        private int numConnections;
        public int getNumConnections() {
            return numConnections;
        }

        private int cacheExpirationTime;
        public int getCacheExpirationTime() {
            return cacheExpirationTime;
        }
        
        private void reloadSettings() {
            try {
                InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
                prop.load(input);
                input.close();

                requestsPerSecond = Integer.valueOf(prop.getProperty("RequestsPerSecond"));
                numConnections = Integer.valueOf(prop.getProperty("NumConnections"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        @Override
        public void run() {
            reloadSettings();
        }
    }
    
    

    

}
