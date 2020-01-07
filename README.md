# Email Counters

### Build

 ##### Using  IDE 
* Import project into you favorite IDE and build using maven.

[ OR ]

 ##### Using  Commandline 
* Navigate to folder where pom.xml is available
* run mvn clean install. Note: mvn needs to be installed ano on the Path

### Run
 ##### Using  IDE 
* Find com.email.emailcounter.EmailApplication class and run using IDE 

[ OR ]

 ##### Using  Commandline 
* After build is successful at command line 
* cd into target directory from the directory containing the pom.xml
* run
  * java -jar emailcounter-0.0.1-SNAPSHOT.jar 
  
### Test
* Open browser or post man and hit the following url with various email address as follows
  * localhost:8080/emailcount?email=a
 
