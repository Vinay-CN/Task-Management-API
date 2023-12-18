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
-**Response:**

```json
{
  "userId": 1,
  "username": "string",
  "password": "string",
  "role": "string",
  "tasks": []
}

**Change user password**
Endpoint: PUT /user/changePassword/{userId}
Description: Changes the password for a specific user.
Parameters:
userId (path): User ID.
Request:
'''json
 
{
  "oldPassword": "string",
  "newPassword": "string"
}
**Response**:
'''json
 
"Password changed successfully"
Change username
Endpoint: PUT /user/changeUsername/{userId}
Description: Changes the username for a specific user.
Parameters:
userId (path): User ID.
**Request:**
'''json
 
{
  "newUsername": "string"
}
**Response:**
'''json
 
"Username changed successfully"

**Delete user**
Endpoint: DELETE /user/deleteUser/{userId}
Description: Deletes a user.
Parameters:
userId (path): User ID.
**Response:**
'''json
 
"User deleted successfully"


**Get user by ID**
Endpoint: GET /user/getUserTasksById/{userId}
Description: Retrieves user details by ID.
Parameters:
userId (path): User ID.
**Response:**
'''json
 
{
  "userId": 1,
  "username": "string",
  "password": "string",
  "role": "string",
  "tasks": []
}

Get all users
Endpoint: GET /user/getAllUsers
Description: Retrieves a list of all users.
**Response:**
'''json
 
[
  {
    "userId": 1,
    "username": "string",
    "password": "string",
    "role": "string",
    "tasks": []
  },
  ...
]

**Task Controller**
Create a new task
Endpoint: POST /task/createTask
Description: Creates a new task.
**Request:**
'''json
 
{
  "title": "string",
  "description": "string",
  "dueDate": "yyyy-MM-dd",
  "status": "string"
}
**Response:**
'''json
 
"Task created successfully."


**Assign task to users**
Endpoint: POST /task/assignTask/{taskId}
Description: Assigns a task to one or more users.
Parameters:
taskId (path): Task ID.
**Request:**
'''json
 
{
  "userIds": [1, 2, 3]
}

**Response:**
'''json
 
"Tasks assigned successfully."
