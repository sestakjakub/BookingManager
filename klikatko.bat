call mvn tomcat7:undeploy
call mvn clean install -Dmaven.test.skip=true
start mvn tomcat7:run