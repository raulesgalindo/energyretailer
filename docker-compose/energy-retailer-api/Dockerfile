# Use OpenJDK 11 as the base image
FROM adoptopenjdk/openjdk11:alpine-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY energyretailer/target/energy-retailer-0.0.1-SNAPSHOT.jar /app/energy-retailer.jar

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "energy-retailer.jar"]