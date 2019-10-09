FROM adoptopenjdk/openjdk8
MAINTAINER lizhe 364756388@qq.com
ADD boot-web-0.0.1.jar boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/boot.jar"," --spring.profiles.active=dev"]