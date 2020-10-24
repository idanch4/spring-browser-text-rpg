# A Simple Browser-Text RPG 
**IMPORTANT: Project is not finished - only contains some inital backend code & setup**

## How to Run:
1. Execute: git clone https://github.com/idanch4/spring-browser-text-rpg.git
2. cd to the repository
3. Execute: mvn clean install war:war 
    * downloads dependencies & compiles the project
    * creates a WAR file in target/ directory
4. Deploy the .war file to the server.
    * If you are using Tomcat:
       * Copy .war file in target/ to $CATALINA_HOME/webapps directory
       * Execute: catalina.sh run (if the server is not running)
       * Go to localhost:8080/<project name here>/ or go to localhost:8080/ and execute the web-app from the UI
## Endpoints:
Right now, the front-end is pretty much empty, so 2 only 2 basic displays exist:
1. / - home page
2. /classes - displays the available hero classes in the database 
