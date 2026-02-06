# Quora Spring Boot - API Curl Commands

**Base URL:** `http://localhost:8080`

---

## User APIs (`/api/v1/users`)

### 1. Get All Users
**Endpoint:** `GET /api/v1/users`

```bash
curl -X GET http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json"
```

**Response:** List of all users
```json
[
  {
    "id": 1,
    "username": "john_doe",
    "password": "hashedPassword",
    "followedTags": []
  }
]
```

---

### 2. Get User by ID
**Endpoint:** `GET /api/v1/users/{id}`

```bash
curl -X GET http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json"
```

**Response:**
```json
{
  "id": 1,
  "username": "john_doe",
  "password": "hashedPassword",
  "followedTags": []
}
```

---

### 3. Create User
**Endpoint:** `POST /api/v1/users`

```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "jane_doe",
    "password": "securePassword123"
  }'
```

**Response:**
```json
{
  "id": 2,
  "username": "jane_doe",
  "password": "securePassword123",
  "followedTags": []
}
```

---

### 4. Follow a Tag
**Endpoint:** `POST /api/v1/users/{userId}/follow/{tagId}`

```bash
curl -X POST http://localhost:8080/api/v1/users/1/follow/5 \
  -H "Content-Type: application/json"
```

**Response:** HTTP 200 OK (empty body)

---

### 5. Delete User
**Endpoint:** `DELETE /api/v1/users/{id}`

```bash
curl -X DELETE http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json"
```

**Response:** HTTP 200 OK (empty body)

---

## Notes

- Replace `1`, `5`, etc. with actual IDs
- The application runs on `localhost:8080` by default
- All requests should have `Content-Type: application/json` header
- UserDTO expected fields for creation: `username`, `password`

---

## Testing Workflow Example

```bash
# 1. Create a new user
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{"username": "testuser", "password": "password123"}'

# 2. Get all users
curl -X GET http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json"

# 3. Get specific user (replace 1 with actual user ID)
curl -X GET http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json"

# 4. Follow a tag (replace 1 with user ID, 5 with tag ID)
curl -X POST http://localhost:8080/api/v1/users/1/follow/5 \
  -H "Content-Type: application/json"

# 5. Delete user (replace 1 with actual user ID)
curl -X DELETE http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json"
```

