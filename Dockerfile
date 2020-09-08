FROM openjdk:8
ENV PORT 8080

WORKDIR /usr/app/
COPY /build/libs/* ./app.jar
#Copy example file, remove later
COPY example.xlsx ./example.xlsx

EXPOSE $PORT
ENTRYPOINT ["java"]
CMD  ["-jar", "app.jar"]