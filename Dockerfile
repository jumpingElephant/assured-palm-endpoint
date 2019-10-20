FROM payara/micro:5.193

COPY target/integration-test.war $DEPLOY_DIR
ENTRYPOINT [ "java", "-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n", "-jar", "/opt/payara/payara-micro.jar", "--deploymentDir", "/opt/payara/deployments"]