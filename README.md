# Quarkus-Example Project with DOCKER & KUBERNETES 

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/Quarkus-Example-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

## Some important quarkus commands to remember
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true

./mvnw package -Pnative -Dquarkus.native.container-build=true

./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker

docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-example .

docker build -f src/main/docker/Dockerfile.native --platform linux/amd64 -t quarkus/quarkus-example .

docker buildx build --platform linux/amd64 -f src/main/docker/Dockerfile.native -t quarkus/quarkus-example .

docker run --platform=linux/amd64 -i -p 8080:8080  quarkus/quarkus-example
docker run -i --rm -p 8080:8080 quarkus/quarkus-example

brew install minikube
minikube start
Kubectl cluster-info
minikube docker-env

eval $(minikube -p minikube docker-env)
minikube dashboard
minikube status
minikube service --url quarkus-service

echo -n 'my-string' | base64

Kubectl describe pod
kubectl delete service postgres-service
kubectl delete -f quarkus.yaml
kubectl exec -it pod-name  — /bin/bash.
kubectl get po -A
kubectl get nodes
kubectl get endpoints
kubectl exec -it containerId   /bin/bash.

psql -U postgres

docker login -u "myusername" -p "mypassword" docker.io
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname
docker build -f src/main/docker/Dockerfile.new -t ajayk297/quarkus-example .
docker port minikube
```

