FROM centos:latest
RUN sed -i -e "s|mirrorlist=|#mirrorlist=|g" /etc/yum.repos.d/CentOS-*
RUN sed -i -e "s|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g" /etc/yum.repos.d/CentOS-*
COPY /site/ /var/www/html
RUN yum -y install httpd; yum clean all;
EXPOSE 80
ENTRYPOINT /usr/sbin/httpd -D FOREGROUND
