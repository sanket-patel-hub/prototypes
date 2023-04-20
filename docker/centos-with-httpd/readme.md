# Dockerize webserver on centos

## Prerequisite

- install docker

## Steps to start apache webserver in minutes

I. pull current directory files to local machine

II. run below docker command to build webserver image called centos/httpd
  - <code>docker build -t centos/httpd:v1 .</code>

III. create network `webservernet` where webserver resides with below command
  - <code>docker network create webservernet --subnet=172.20.0.0/16</code>

IV. start container with created image and network using following command
  - <code>docker run -it --net webservernet --ip 172.20.0.10 -p 80:80 --name webserver centos/httpd:v1</code>

V. as we have configured default http host port 80 with container 80. go to browser and hit url http://localhost/index.html

### Notice:- 
- Here, step III is optional. I have created private custom network with this step. but, default bridge network can be used if skip this step and avoid `--net webservernet` command option from step IV.
