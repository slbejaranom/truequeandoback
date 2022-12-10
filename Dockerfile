FROM gradle:jdk17-focal
WORKDIR /app
COPY . /app

EXPOSE 8080
CMD ["sh", "start.sh"]