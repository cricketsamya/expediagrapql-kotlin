# graphql-kotlin

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


## Build Docker image and run in container

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
