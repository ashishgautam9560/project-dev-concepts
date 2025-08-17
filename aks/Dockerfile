# This tells Docker which *base image*
# Its values is fetched by CI/CD pipeline from Azure Container Registry (ACR).
FROM #{ACR_IMAGE_PATH_JAVA17}#

# Mount Point - temporary files will be stored at /tmp
# our container can refer those files from there
VOLUME /tmp

#Copies all cert files from your local aks/cert/ directory → into the container’s /tmp/ folder.
COPY aks/cert/* /tmp/

# Takes the built Spring Boot jar (from target/ after Maven build) 
# and copies it into the container renaming it as app.jar.
COPY target/*.jar app.jar

# CMD ["sh", "-c", "java -jar -Dspring.profiles.active=$profile -Dspring.config.location=file:deployments/config/application-$profile.$filetype,file:deployments/config/application/$filetype,file:deployments/config/common-$group-$profile.$filetype /app.jar"]
# Run the Spring Boot application 'app.jar'
CMD ["sh", "-c", "java -jar \
					  -Dspring.profiles.active=$profile \
					  -Dspring.config.location=\
					    file:deployments/config/application-$profile.$filetype,\
					    file:deployments/config/application/$filetype,\
					    file:deployments/config/common-$group-$profile.$filetype \
					  /app.jar"]

