FROM openjdk:12

LABEL maintainer="Kirill.Vasilev"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/ExchangeRates-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} ExchangeRates-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/ExchangeRates-0.0.1-SNAPSHOT.jar"]