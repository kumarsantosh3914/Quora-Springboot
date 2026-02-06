# API Endpoints

---

## User APIs

### Get All Users
- **GET** `/api/v1/users`
```bash
curl -X GET http://localhost:8080/api/v1/users -H "Content-Type: application/json"
```

### Get User by ID
- **GET** `/api/v1/users/{id}`
```bash
curl -X GET http://localhost:8080/api/v1/users/1 -H "Content-Type: application/json"
```

### Create User
- **POST** `/api/v1/users`
- **Body:** `{ "username": "string", "password": "string" }`
```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{"username": "jane", "password": "pass"}'
```

### Follow Tag
- **POST** `/api/v1/users/{userId}/follow/{tagId}`
```bash
curl -X POST http://localhost:8080/api/v1/users/1/follow/2 -H "Content-Type: application/json"
```

### Delete User
- **DELETE** `/api/v1/users/{id}`
```bash
curl -X DELETE http://localhost:8080/api/v1/users/1 -H "Content-Type: application/json"
```

---

## Question APIs

### Get All Questions
- **GET** `/api/v1/questions?page=0&size=10`
```bash
curl -X GET "http://localhost:8080/api/v1/questions?page=0&size=10" -H "Content-Type: application/json"
```

### Get Question by ID
- **GET** `/api/v1/questions/{id}`
```bash
curl -X GET http://localhost:8080/api/v1/questions/1 -H "Content-Type: application/json"
```

### Create Question
- **POST** `/api/v1/questions`
- **Body:** `{ "title": "string", "content": "string", "tagIds": [1,2] }`
```bash
curl -X POST http://localhost:8080/api/v1/questions \
  -H "Content-Type: application/json" \
  -d '{"title": "test", "content": "desc", "tagIds": [1,2]}'
```

### Delete Question
- **DELETE** `/api/v1/questions/{id}`
```bash
curl -X DELETE http://localhost:8080/api/v1/questions/1 -H "Content-Type: application/json"
```

---

## Answer APIs

### Get All Answers by Question
- **GET** `/api/v1/answers?questionId=1&page=0&size=10`
```bash
curl -X GET "http://localhost:8080/api/v1/answers?questionId=1&page=0&size=10" -H "Content-Type: application/json"
```

### Get Answer by ID
- **GET** `/api/v1/answers/{id}`
```bash
curl -X GET http://localhost:8080/api/v1/answers/1 -H "Content-Type: application/json"
```

### Create Answer
- **POST** `/api/v1/answers`
- **Body:** `{ "content": "string", "questionId": 1, "userId": 1 }`
```bash
curl -X POST http://localhost:8080/api/v1/answers \
  -H "Content-Type: application/json" \
  -d '{"content": "answer", "questionId": 1, "userId": 1}'
```

### Delete Answer
- **DELETE** `/api/v1/answers/{id}`
```bash
curl -X DELETE http://localhost:8080/api/v1/answers/1 -H "Content-Type: application/json"
```

---

## Comment APIs

### Get Comments by Answer
- **GET** `/api/v1/comments/answer/{answerId}?page=0&size=10`
```bash
curl -X GET "http://localhost:8080/api/v1/comments/answer/1?page=0&size=10" -H "Content-Type: application/json"
```

### Get Replies by Comment
- **GET** `/api/v1/comments/comment/{commentId}?page=0&size=10`
```bash
curl -X GET "http://localhost:8080/api/v1/comments/comment/1?page=0&size=10" -H "Content-Type: application/json"
```

### Get Comment by ID
- **GET** `/api/v1/comments/{id}`
```bash
curl -X GET http://localhost:8080/api/v1/comments/1 -H "Content-Type: application/json"
```

### Create Comment
- **POST** `/api/v1/comments`
- **Body:** `{ "content": "string", "answerId": 1, "parentCommentId": 2 }`
```bash
curl -X POST http://localhost:8080/api/v1/comments \
  -H "Content-Type: application/json" \
  -d '{"content": "comment", "answerId": 1, "parentCommentId": 2}'
```

### Delete Comment
- **DELETE** `/api/v1/comments/{id}`
```bash
curl -X DELETE http://localhost:8080/api/v1/comments/1 -H "Content-Type: application/json"
```

---

## Tag APIs

### Get All Tags
- **GET** `/api/v1/tags`
```bash
curl -X GET http://localhost:8080/api/v1/tags -H "Content-Type: application/json"
```

### Get Tag by ID
- **GET** `/api/v1/tags/{id}`
```bash
curl -X GET http://localhost:8080/api/v1/tags/1 -H "Content-Type: application/json"
```

### Create Tag
- **POST** `/api/v1/tags`
- **Body:** `{ "name": "string" }`
```bash
curl -X POST http://localhost:8080/api/v1/tags \
  -H "Content-Type: application/json" \
  -d '{"name": "tagname"}'
```

### Delete Tag
- **DELETE** `/api/v1/tags/{id}`
```bash
curl -X DELETE http://localhost:8080/api/v1/tags/1 -H "Content-Type: application/json"
```

---

## Schema Structure

### User
- id: Long
- username: String
- password: String
- followedTags: Set<Tag> (ManyToMany)

### Question
- id: Long
- title: String
- content: String
- tags: Set<Tag> (ManyToMany)
- user: User (ManyToOne)

### Answer
- id: Long
- content: String
- question: Question (ManyToOne)
- user: User (ManyToOne)
- comments: Set<Comment> (OneToMany)
- likedBy: Set<User> (ManyToMany)

### Comment
- id: Long
- content: String
- answer: Answer (ManyToOne)
- parentComment: Comment (ManyToOne)
- replies: Set<Comment> (OneToMany)
- likedBy: Set<User> (ManyToMany)

### Tag
- id: Long
- name: String
- questions: Set<Question> (ManyToMany, inverse)
- followers: Set<User> (ManyToMany, inverse)
