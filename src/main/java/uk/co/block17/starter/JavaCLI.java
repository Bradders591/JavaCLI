package uk.co.block17.starter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class JavaCLI {

    public static Logger log = Logger.getLogger("uk.co.block17.starter.JavaCLI");
    private final String version = "v0.1.0-hardcoded";
    private String manifestVersion = "";
    private String manifestBuildNumber = "";
    //
    private String configFilePath;
    private final Properties config = new Properties();
    private boolean debugMode = false;

    public static void main(String[] args) {
        //System.out.println("-= " + Constants.APPNAME + " =-");

        JavaCLI j = new JavaCLI(args);
        j.End();
    }

    public JavaCLI(String[] args) {
        JavaCLI(args);
    }

    private void JavaCLI(String[] args) {
        parseCommandLineArguments(args);
        String versionAndBuild = getVersionAndBuildFromManifest();

        log.info("--------------------------------------------------------------------");
        log.info(versionAndBuild);
        log.info("Configuration File: " + configFilePath);
        log.info("--------------------------------------------------------------------");

        configureLogging();

        log.info("Config some.var: " + (config.containsKey("some.var") ? config.getProperty("some.var") : ""));
    }

    private void parseCommandLineArguments(String[] args) {

        OptionParser parser = new OptionParser();
        boolean canContinue = true;

        parser.accepts(Constants.CLI_DEBUGGING);
        parser.accepts(Constants.CLI_CONFIG_FILE).withRequiredArg();

        OptionSet options = parser.parse(args);

        // config-file is mandatory, allow command line override of default $PPHOME/cfg/mcname.cfg
        if (options.has(Constants.CLI_CONFIG_FILE)) {
            configFilePath = options.valueOf(Constants.CLI_CONFIG_FILE).toString();

            // don't print usage, the command line arg has been passed it's just blank
            if (configFilePath.equals("")) {
                System.out.println("--" + Constants.CLI_CONFIG_FILE + " parameter can not be blank.");
                canContinue &= false;
            }

            canContinue &= loadConfigFile(configFilePath);
        } else {
            configFilePath = "./" + Constants.DEFAULT_CONFIG_FILE;
            canContinue &= loadConfigFile(configFilePath);
        }

        if (options.has(Constants.CLI_DEBUGGING)) {
            debugMode = true;
        }

        if (!canContinue) {
            log.error("Cannot continue.");
            System.exit(Constants.EXIT_FAILURE);
        }
    }

    private boolean loadConfigFile(String path) {
        File configFile = new File(path);

        // don't print usage, the command line value has been set it just doesn't exist
        if (!configFile.exists()) {
            log.error("Could not find config file: '" + path + "'");
            return false;
        }

        // send the config file through the log4j configurator, non log4j elements will be ignored
        PropertyConfigurator.configure(path);

        // load the config file into the config object
        try {
            config.load(new FileInputStream(path));
        } catch (IOException ex) {
            log.error("Could not load config file: '" + path + "'");
            return false;
        }

        return true;
    }

    private void configureLogging() {
        if (!config.containsKey(Constants.CFG_LOG_LEVEL)) {
            log.info("Log level not set by config.");
            return;
        }

        String logLevel = config.getProperty(Constants.CFG_LOG_LEVEL);
        boolean logLevelRecognised = true;
        if ("DEBUG".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.DEBUG);
        } else if ("INFO".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.INFO);
        } else if ("WARN".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.WARN);
        } else if ("TRACE".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.TRACE);
        } else if ("ERROR".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.ERROR);
        } else if ("FATAL".equalsIgnoreCase(logLevel)) {
            log.setLevel(Level.FATAL);
        } else {
            logLevelRecognised = false;
            log.setLevel(Level.INFO);
        }

        if (logLevelRecognised) {
            log.info("Log level has been set to: " + logLevel);
        } else {
            log.error("Configured value for " + Constants.CFG_LOG_LEVEL + " '" + logLevel + "' not recognised");
        }
    }

    private String getVersionAndBuildFromManifest() {
        return getVersionAndBuildFromManifest(false);
    }

    private String getVersionAndBuildFromManifest(boolean shortVersion) {
        Class myClass = JavaCLI.class;
        String myClassName = myClass.getSimpleName() + ".class";
        String myClassPath = myClass.getResource(myClassName).toString();

        if (!myClassPath.startsWith("jar")) {
            log.info("Class not in JAR. Defaulting to version string in code.");
            return version;
        }

        String myManifestPath = myClassPath.substring(0, myClassPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";

        Manifest myManifest;

        try {
            myManifest = new Manifest(new URL(myManifestPath).openStream());
            Attributes myAttributes = myManifest.getMainAttributes();

            manifestVersion = myAttributes.getValue("Implementation-Version");
            manifestBuildNumber = myAttributes.getValue("Implementation-Build");

            String justBuildNumber = manifestBuildNumber.replace("#", "");
            justBuildNumber = justBuildNumber.substring(0, justBuildNumber.indexOf(" "));

            return (shortVersion) ? Constants.APPNAME + " v" + manifestVersion + "." + justBuildNumber : "JavaCLI version " + manifestVersion + " build " + manifestBuildNumber;
        } catch (IOException ex) {
            log.error("Failed to extract version and build details from manifest.");
            return version;
        }
    }

    public void End() {
        log.info("-= END =-");
    }
}
