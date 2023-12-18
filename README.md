1. Test API
Endpoint: GET /task/test
Description: Test API for checking the success of the service.
Request:
No request body required.
Response:
''''''json

"success"
2. Create Task
Endpoint: POST /task/createTask
Description: Creates a new task in the system.
Request:
'''json

{
  "title": "string",
  "description": "string",
  "dueDate": "string",
  "status": "PENDING",
  "assignedUsersAndStatus": []
}
Response:
'''json

"Task created successfully."
3. Assign Task
Endpoint: POST /task/assignTask/{taskId}
Description: Assigns a task to a list of users.
Request:
'''json

{
  "userIds": [1, 2, 3]
}
Response:
'''json

"Tasks assigned successfully."
4. Update Task
Endpoint: PUT /task/updateTask/{taskId}
Description: Updates the details of a specific task.
Request:
'''json

{
  "title": "string",
  "description": "string",
  "dueDate": "string",
  "status": "PENDING",
  "assignedUsersAndStatus": []
}
Response:
'''json

"Task updated successfully."
5. Get Task by ID
Endpoint: GET /task/getTaskById/{taskId}
Description: Retrieves task details by task ID.
Response:
'''json

{
  "taskId": 1,
  "title": "string",
  "description": "string",
  "created": "string",
  "dueDate": "string",
  "status": "string",
  "assignedUsersAndStatus": []
}
6. Delete Task by ID
Endpoint: DELETE /task/deleteTaskById/{taskId}
Description: Deletes a task from the system.
Response:
'''json

"Task deleted successfully."
7. Get All Tasks Paginated
Endpoint: GET /task/getAllTasksPaginated
Description: Retrieves a paginated list of all tasks in the system.
Response:
'''json

{
  "totalElements": 1,
  "totalPages": 1,
  "size": 10,
  "content": [
    {
      "taskId": 1,
      "title": "string",
      "description": "string",
      "created": "string",
      "dueDate": "string",
      "status": "string",
      "assignedUsersAndStatus": []
    }
  ],
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "first": true,
  "last": true,
  "numberOfElements": 1,
  "pageable": {
    "offset": 0,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "pageSize": 10,
    "pageNumber": 0,
    "paged": true,
    "unpaged": true
  },
  "empty": false
}
8. Get Task Status of User
Endpoint: GET /task/getTaskStatusOfUser/{taskId}
Description: Retrieves the status of a specific task for a given user.
Request:
Query Parameter: userId
Response:
'''json

{
  "userId": 1,
  "status": "string",
  "dueDate": "string"
}
9. Get All Tasks Status of User
Endpoint: GET /task/getAllTasksStatusOfUser/{userId}
Description: Retrieves the status of all tasks for a given user.
Response:
'''json

[
  {
    "userId": 1,
    "status": "string",
    "dueDate": "string"
  }
]
10. Get Users Status By Task ID
Endpoint: GET /task/getUsersStatusByTaskId/{taskId}
Description: Retrieves the status of all users for a given task.
Response:
'''json

[
  {
    "userId": 1,
    "status": "string",
    "dueDate": "string"
  }
]
11. Get Tasks Due Before
Endpoint: GET /task/tasksDueBefore
Description: Retrieves tasks due before a specified date.
Request:
Query Parameter: date (format: "YYYY-MM-DD")
Response:
'''json

[
  {
    "taskId": 1,
    "title": "string",
    "description": "string",
    "created": "string",
    "dueDate": "string",
    "status": "string",
    "assignedUsersAndStatus": []
  }
]
12. Get Tasks By Status
Endpoint: GET /task/tasksByStatus
Description: Retrieves tasks based on the specified status.
Request:
Query Parameter: status (enum: ["PENDING", "IN_PROGRESS", "COMPLETED", "OVERDUE"])
Response:
'''json

[
  {
    "taskId": 1,
    "title": "string",
    "description": "string",
    "created": "string",
    "dueDate": "string",
    "status": "string",
    "assignedUsersAndStatus": []
  }
]
