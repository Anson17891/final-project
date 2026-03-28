# sh = shell script

docker compose stop data-provider-app stock-data-app

cd project-data-provider

#Generate Jar file
mvn clean install -DskipTests

#Generate Docker image by dockerfile (Dockerfile : dockerfile's name)
docker build -t project-data-provider-0.0.1 -f Dockerfile .   
cd ..

# same for project-stock-data
cd project-stock-data
mvn clean install -DskipTests
docker build -t project-stock-data-0.0.1 -f Dockerfile .
cd ..

# Look up docker-compose.yml, generate containers
docker compose up -d




