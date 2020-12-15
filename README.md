# Music simple API project to start working with spring and hibernate

## Building and executing

- Build war file with the command `mvn clean install`. The war file will be created in the target directory (
  target/music-db.war)
- Follow the guide [here](https://www.jetbrains.com/help/idea/deploying-a-web-app-into-an-app-server-container.html)
  (see "Deploy your application inside a Tomcat server" tab). The configuration should look like the following:
  ![Docker config](images/docker-intellij-tomcat-config.png?raw=true "Docker config")
- Start the newly created container by right-clicking it and selecting "Start container"
- Test the application "hello" endpoint.
  ![Test endpoint](images/test-endpoint.png?raw=true "Test endpoint")
