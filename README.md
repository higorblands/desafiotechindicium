### Goal

Convert Northwind PostgreSQL database into local files for this I chose JSON format with local date or specific date.
Then convert a CSV File to Json local file.
All this will be converted to a new Database MongoDB and collections how can be made a select to Orders(Old PostgreSQL Table), Categories and others tables soon. :)

# Considering that you have pre-installed these packages into your local machine:
- Docker;
- Git;
- Java 11 open-jdk by RedHat; 
- A good IDE;
- Mongo Compass
- DBeaver ( Recommended )

---

# Proceed with these instructions:

- First, use git to clone the remote project into your local machine

### git clone https://github.com/higorblands/desafiotechindicium.git

- Now navigate to desafiotechindicium folder. that's our project-root directory;
- To build up our PostgreSQL and MongoDB with Docker database, run:

### docker-compose up -d [using detached mode to keep using same terminal tab]

To run the project database necessary : 

- Create PostgreSQL Database and tables, populate database with date use file in path \data\northwind. ( Because that recommend DBeaver)
- Create MongoDB Database " myMongoDB " and collections : categories, orders. ( Recommend Mongo Compass)

### If you need to change configure in your application to Dbs connect go to :

- into the project src/main/resources/application.properties file;

### Now just run:
- With your IDE run DesafiotechindiciumApplication

- Application based file in DesafioTechIndiciumService.java
---

# If some problem ocurred during docker usage, you may use this following cmds

- cleanup guide - use with caution, if you have other docker images running, you may have to use 'container image' to prevent stop/removing docker images from another project.

### docker stop `docker ps -qa`
### docker rm `docker ps -qa`
### docker rmi -f `docker images -qa `
### docker volume rm $(docker volume ls -qf dangling=true)
