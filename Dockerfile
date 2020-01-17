FROM openjdk:latest
COPY ./target/org.cerner.multiplex.packageinfo-0.0.1-SNAPSHOT.jar /usr/local/webapps/org.cerner.multiplex.packageinfo-0.0.1-SNAPSHOT.jar
#COPY ./target/classes/images /usr/local/webapps/images
#COPY ./target/classes/images /usr/local/webapps/images
WORKDIR /usr/local/webapps
ENTRYPOINT java -jar org.cerner.multiplex.packageinfo-0.0.1-SNAPSHOT.jar
# docker build -t org.cerner.multiplex.packageinfo .
# docker run -p8080:8080 org.cerner.multiplex.packageinfo