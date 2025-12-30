FROM gitpod/workspace-full

# Install Java 11 (or higher)
RUN sudo apt-get update && \
    sudo apt-get install -y openjdk-11-jdk && \
    java -version && mvn -v

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH