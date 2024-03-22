# spring-docker-demo
A simple Spring boot app backend linked to a psql database that can be hosted on Docker.

This project can be launched locally with spring via maven.

It is also possible to package the project and put the jar in the docker/app folder.
Running the dockercompose in the docker file after this manipulation allow to run both the backend
and the psql database on Docker.

If you want to execute the backend locally and run the database on Docker you can run the docker compose
at the root of this project.

It is important to modify every database connection information in the config file that is in the ressource folder.
