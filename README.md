# egraphql-kotlin

The project uses [Expedia Group's GraphQL](https://opensource.expediagroup.com/graphql-kotlin/docs/)
 wrapper along with Kotlin to demonstrate how the library works.

Technologies used:
- Kotlin
- Spring Boot
- Exepdia GraphQL Library
- Java 11
- Docker

The project supports Docker using Dockerfile where a container is built with the Spring Boot jar, and the container can be started locally.
Also this project right now also deployed to [Heroku](https://egraphql-test.herokuapp.com/playground) for futher testing.

The repo also supports GitHub action that builds the project, and checks if the code commited to main branch is working or not.

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

The Heroku deployement is auto deployable, whenever there is a commit on main branch happens the GitHub actions checks the build and after successful build the app is deployed to Heroku free dynamos.

## Future improvements

- More tests
- [Branch](https://github.com/cricketsamya/egraphql-kotlin/pull/14) is already prepared with JWT authentication
- Docker deployment on Heroku

# Some sample queries:

```
query {
findUserById(id:"f80cdce0-7b3e-4674-9673-ab9f30b148f9"){name}
}
```

```
query {
getAllUsers{id,name}
}
```

```
mutation addUser {
addUser(user: { name: "sameer", password: "asss", username: "aaa" }) {
id
}
}
```

```
mutation deleteUser {
  deleteUser(id:"f9e49473-4d2d-4ec1-919f-10671c0299ae") {
    id
  }
}
```

```
mutation updateUser {
  updateUser(user: { id:"4d830a13-25b6-4b5c-9fbf-5677acf55ad2",name: "samdeer1", password: "asss", username: "aaa" }) {
    id
  }
}
```



