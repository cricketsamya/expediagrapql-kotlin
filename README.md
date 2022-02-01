# egraphql-kotlin

The project uses [Expedia Group's GraphQL](https://opensource.expediagroup.com/graphql-kotlin/docs/)
wrapper along with Kotlin to demonstrate how the library works.

Technologies used:

- Kotlin
- Spring Boot
- Exepdia GraphQL Library
- Java 11
- Docker

The project supports Docker using Dockerfile where a container is built with the Spring Boot jar, and the container can
be started locally. Also this project right now also deployed
to [Heroku](https://egraphql-test.herokuapp.com/playground) for futher testing.

The repo also supports GitHub action that builds the project, and checks if the code commited to main branch is working
or not.

## Build Docker image locally and run the app in container

### Build

```
docker build . -t egraphql
```

### Run

```
docker run -p 3080:8080 egraphql
```

## Test

```
localhost:3080/playground
```

## Heroku deployment

The Heroku deployement is auto deployable, whenever there is a commit on main branch happens the GitHub actions checks
the build and after successful build the app is deployed to Heroku free dynamos.

## Future improvements

- H2 is used for build and test, should be switch to PostgreSQL and H2 for tests
- More tests
- [Branch](https://github.com/cricketsamya/egraphql-kotlin/pull/14) is already prepared with JWT authentication
- Docker deployment on Heroku

# Some sample queries:

There is a sample data in the project added to HSQLDB, using plain SQLS. Below are some sample queries that helps to
understand how GraphQL library works.

- Get all users from DB with all the attributes

```
query {
getAllUsers{id,name}
}
```

- Find a user by Id

```
query {
findUserById(id:"1"){name}
}
```

- Find a user by Name

```
query {
findUserByName(name:"Sameer"){name}
}
```

- Add user to the DB

```
mutation addUser {
addUser(user: { name: "sameer", password: "asss", username: "aaa" }) {
id
}
}
```

- Delete the user from DB

```
mutation deleteUser {
  deleteUser(id:"1") {
    id
  }
}
```

- Update a user in the DB

```
mutation updateUser {
  updateUser(user: { id:"1",name: "samdeer1", password: "asss", username: "aaa" }) {
    id
  }
}
```

## Kubernetes deployment
This part is optional but could be helpful to understand how K8S works. Here assumption is Docker image is already built.

- To setup Kubernetes install minikube, kubectl.
  * 		[Install kubectl] (https://kubernetes.io/docs/tasks/tools/install-kubectl/)
  * 		[Install minikube] (https://minikube.sigs.k8s.io/docs/start/)

- After setting up, execute below commands
### Create a deployment and service
```
kubectl apply -f egraphql.yml
```
### To check if the pod started
```
kubectl get pods
```
### To check if the service is started
```
kubectl get services
```

### To open a tunnel
```
minikube tunnel
```

### To test the Kubernetes deployment via browser
```
http://localhost:5050/playground
```




