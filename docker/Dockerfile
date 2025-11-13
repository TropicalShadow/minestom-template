ARG BASE_IMAGE=eclipse-temurin:25-jre
FROM ${BASE_IMAGE}

ARG GITHUB_BASEURL=https://github.com

ENV SERVER_HOST=localhost
ENV SERVER_PORT=25565

ARG MC_MONITOR_VERSION=0.16.0
ARG MC_MONITOR_BASE_URL=${GITHUB_BASEURL}/itzg/mc-monitor/releases/latest/download

# Install curl and tar
RUN apt-get update && apt-get install -y curl tar && rm -rf /var/lib/apt/lists/*

# Download and extract mc-monitor binary
RUN curl -fsSL ${MC_MONITOR_BASE_URL}/mc-monitor_${MC_MONITOR_VERSION}_linux_amd64.tar.gz | tar -xz -C /usr/local/bin

# Make sure binary is executable
RUN chmod +x /usr/local/bin/mc-monitor

HEALTHCHECK --start-period=10s --retries=2 --interval=30s \
  CMD mc-monitor status --host "${SERVER_HOST}" --port "${SERVER_PORT}"

WORKDIR /app

# Copy the built jar from the builder stage
COPY *.jar /app/server.jar

CMD ["java", "-jar", "/app/server.jar"]