mvn tomcat7:undeploy
mvn clean install -Dmaven.test.skip=true
mvn tomcat7:run
