# API Documentation

## Authentication

### POST /auth/login
Login endpoint (returns JWT token)

**Request body:**
```json
{
    "email": "usuario@ejemplo.com",
    "password": "contraseña123"
}
```

**Response (200 OK):**
```json
{
    "token": "eyJ...",
    "tokenType": "Bearer"
}
```

### POST /auth/register/patient
Register new patient

**Request body:**
```json
{
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "password": "contraseña123",
    "dateOfBirth": "1990-01-01",
    "gender": "MAN"
}
```

**Response (201 Created):**
```json
{
    "id": 123,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "dateOfBirth": "1990-01-01",
    "gender": "MAN"
}
```

### POST /auth/register/doctor
Register new doctor

**Request body:**
```json
{
    "firstName": "Ana",
    "lastName": "García",
    "email": "ana.garcia@ejemplo.com",
    "password": "contraseña123",
    "dateOfBirth": "1985-05-15",
    "gender": "WOMAN",
    "specialization": "Cardiología",
    "licenseNumber": "1234567",
    "priceHour": 100.0
}
```

**Response (201 Created):**
```json
{
    "id": 456,
    "firstName": "Ana",
    "lastName": "García",
    "email": "ana.garcia@ejemplo.com",
    "dateOfBirth": "1985-05-15",
    "gender": "WOMAN",
    "specialization": "Cardiología",
    "licenseNumber": "1234567",
    "priceHour": 100.0
}
```

## Users

### GET /users/me
Get authenticated user information

**Response (200 OK):**
```json
{
    "id": 123,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "dateOfBirth": "1990-01-01",
    "gender": "MAN",
    "userRole": "PATIENT"
}
```

### GET /users/{id}
Get user information by ID

**Response (200 OK):**
```json
{
    "id": 123,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "dateOfBirth": "1990-01-01",
    "gender": "MAN",
    "userRole": "PATIENT"
}
```

## Patients

### GET /patients
Get list of patients

**Response (200 OK):**
```json
[
    {
        "id": 123,
        "firstName": "Juan",
        "lastName": "Pérez",
        "email": "juan.perez@ejemplo.com",
        "dateOfBirth": "1990-01-01",
        "gender": "MAN"
    },
    {
        "id": 789,
        "firstName": "María",
        "lastName": "González",
        "email": "maria.gonzalez@ejemplo.com",
        "dateOfBirth": "1988-11-20",
        "gender": "WOMAN"
    }
]
```

### GET /patients/{id}
Get patient information by ID

**Response (200 OK):**
```json
{
    "id": 123,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "dateOfBirth": "1990-01-01",
    "gender": "MAN"
}
```

### PUT /patients/{id}
Update patient information

**Request body:**
```json
{
    "firstName": "Juan",
    "lastName": "Pérez",
    "dateOfBirth": "1991-02-02",
    "gender": "MAN"
}
```

**Response (200 OK):**
```json
{
    "id": 123,
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan.perez@ejemplo.com",
    "dateOfBirth": "1991-02-02",
    "gender": "MAN"
}
```

## Doctors

### GET /doctors
Get list of doctors

**Response (200 OK):**
```json
[
    {
        "id": 456,
        "firstName": "Ana",
        "lastName": "García",
        "email": "ana.garcia@ejemplo.com",
        "dateOfBirth": "1985-05-15",
        "gender": "WOMAN",
        "specialization": "Cardiología",
        "licenseNumber": "1234567",
        "priceHour": 100.0
    },
    {
        "id": 987,
        "firstName": "Carlos",
        "lastName": "López",
        "email": "carlos.lopez@ejemplo.com",
        "dateOfBirth": "1978-12-10",
        "gender": "MAN",
        "specialization": "Traumatología",
        "licenseNumber": "7654321",
        "priceHour": 80.0
    }
]
```

### GET /doctors/{id}
Get doctor information by ID

**Response (200 OK):**
```json
{
    "id": 456,
    "firstName": "Ana",
    "lastName": "García",
    "email": "ana.garcia@ejemplo.com",
    "dateOfBirth": "1985-05-15",
    "gender": "WOMAN",
    "specialization": "Cardiología",
    "licenseNumber": "1234567",
    "priceHour": 100.0
}
```

### PUT /doctors/{id}
Update doctor information

**Request body:**
```json
{
    "firstName": "Ana",
    "lastName": "García",
    "specialization": "Cardiología Infantil",
    "priceHour": 120.0
}
```

**Response (200 OK):**
```json
{
    "id": 456,
    "firstName": "Ana",
    "lastName": "García",
    "email": "ana.garcia@ejemplo.com",
    "dateOfBirth": "1985-05-15",
    "gender": "WOMAN",
    "specialization": "Cardiología Infantil",
    "licenseNumber": "1234567",
    "priceHour": 120.0
}
```
