JavaCLI
=========

A starter Java CLI application project including examples of Maven, command line argument config with Jopt Simple, logging with Log4J, unit testing with JUnit, Mockito and code coverage testing with JaCoCo.

## Build

  cd into project folder and run 'mvn' (default goal is clean and package).

  The build process copies script/Java1.sh to the root folder using the Maven resources plugin.

  The Maven replacer plugin modifies the copied Java1.sh to set up the proper class path and -v option.

## Usage

  Run the Java1 script, command line arguments will be passed to the main application. Tail Java1.log to see the output from the application.

  ./Java1

  ./Java1 --config-file Java2.cfg

## Tests

  mvn test

## Release History

* 0.1.0 Initial release
