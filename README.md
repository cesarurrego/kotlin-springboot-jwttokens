# Getting Started

Kotlin JWT tokens it's a simple backend server that implement JWT for user sign up and login with access token and refresh token using a PostgreSQL database.

## Installation

- Clone repository
- Open project using IntelliJ IDEA
- Add environment variables 
  - JWT_KEY= Random jwt key. Ensure this is long enough
  - POSTGRES_USER=postgresUser
  - POSTGRES_PASSWORD=postgresPassword,
  - POSTGRES_URL=postgresHost

## DB Configuration

Articles Table

```roomsql
CREATE TABLE article(
    id      SERIAL PRIMARY KEY ,
    title   varchar(40) NOT NULL,
    content varchar(255) NOT NULL
);
```

## Testing

### Global APIs

Create User
```shell
curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "jhondoe@email.com",
    "password": "password123"
}'
```

Log in 
```shell
curl --location 'http://localhost:8080/api/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "admin@bimbly.com",
    "password": "123456"
}'
```

### Logged user APIs

Refresh Access Token
```shell
curl --location 'http://localhost:8080/api/auth/refresh' \
--header 'Content-Type: application/json' \
--data '{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBiaW1ibHkuY29tIiwiaWF0IjoxNzEwNzUwNjI2LCJleHAiOjE3MTA4MzcwMjZ9.mWq-WWBUPMpEKgvU1EHhCnx2xm0XJUQwnlUhVViwgbcTP9fpORsWTWpB3f9BSPNcM8mau3ZcfGBNoX521Uj4-g"
}'
```

Get Articles
```shell
curl --location 'http://localhost:8080/api/article' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBiaW1ibHkuY29tIiwiaWF0IjoxNzExMDExMjI3LCJleHAiOjE3MTEwMTQ4Mjd9.RvS39ec0kBXddQX9YKHkUAMDNMgGECH10kmwehvBGQM24CJCyV_UxehEXAIaCxrUsMmvl_jDRuiAV3s3PPpdfg'
```

Create Article
```shell
curl --location 'http://localhost:8080/api/article' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBiaW1ibHkuY29tIiwiaWF0IjoxNzExMDExMjI3LCJleHAiOjE3MTEwMTQ4Mjd9.RvS39ec0kBXddQX9YKHkUAMDNMgGECH10kmwehvBGQM24CJCyV_UxehEXAIaCxrUsMmvl_jDRuiAV3s3PPpdfg' \
--data '{
    "title": "New articl 1123 e",
    "content": "This is a new article bitches"
}'

```
### Admin User APIs

Delete User
```shell
curl --location --request DELETE 'http://localhost:8080/api/user/83a744cc-4761-4efa-b128-338ed0ded78e'
```

Get user by ID
```shell
curl --location 'http://localhost:8080/api/user/a4e882e5-a478-47ff-b2cf-c18f6ae8b297'
```

Get user by Email
```shell
curl --location 'http://localhost:8080/api/user/email/admin@bimbly.com'
```

Get all User
```shell
curl --location 'http://localhost:8080/api/user' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBiaW1ibHkuY29tIiwiaWF0IjoxNzExMDExMjI3LCJleHAiOjE3MTEwMTQ4Mjd9.RvS39ec0kBXddQX9YKHkUAMDNMgGECH10kmwehvBGQM24CJCyV_UxehEXAIaCxrUsMmvl_jDRuiAV3s3PPpdfg'
```

### Disclaimer:

The base code of this app was extracted from: <img src="https://codersee.com/wp-content/uploads/2022/02/logo_square_500_500-300x300.png" height="12" alt="Codersee Image"/>[ Codersee](https://codersee.com)