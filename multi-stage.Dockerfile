FROM maven:3.6.0-jdk-13-alpine as BUILT
WORKDIR /opt/app

COPY empty-pom.xml .
RUN mvn verify -f empty-pom.xml && mvn clean -f empty-pom.xml

COPY pom.xml .
RUN mvn verify && mvn clean

COPY src src
RUN mvn package -Dmaven.test.skip


FROM payara/micro:5.193

COPY --from=BUILT /opt/app/target/integration-test.war $DEPLOY_DIR
ENTRYPOINT [ "java", "-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n", "-jar", "/opt/payara/payara-micro.jar", "--deploymentDir", "/opt/payara/deployments"]