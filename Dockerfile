FROM ubuntu:latest
LABEL authors="salo"

ENTRYPOINT ["top", "-b"]