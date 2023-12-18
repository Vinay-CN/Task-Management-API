# Task Management Application API

This document outlines the RESTful APIs provided by the Task Management Application.

## API Endpoints

### User Controller

#### Add a new user

- **Endpoint:** `POST /user/addUser`
- **Description:** Adds a new user to the system.
- **Request:**
  ```json
  {
    "username": "string",
    "password": "string",
    "role": "string"
  }

  ![image](https://github.com/Vinay-CN/Task-Management-API/assets/70995499/acca3491-babd-4f0e-a861-10af52a395e3)
  
