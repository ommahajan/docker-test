FROM adoptopenjdk/openjdk11
#EXPOSE 8085
ADD /target/docker-test-1.1.jar docker-test-1.1.jar
ENTRYPOINT ["java","-jar","docker-test-1.1.jar"]
