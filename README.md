{
  "endpoints": [
    {
      "**name**": "Test API",
      "**method**": "GET",
      "**path**": "/task/test",
      "**description**": "Test API for checking the success of the service.",
      "request": null,
      "response": "success"
    },
    {
      "**name**": "Create Task",
      "**method**": "POST",
      "**path**": "/task/createTask",
      "**description**": "Creates a new task in the system.",
      "request": {
        "title": "string",
        "description": "string",
        "dueDate": "string",
        "status": "PENDING",
        "assignedUsersAndStatus": []
      },
      "response": "Task created successfully."
    },
    {
      "**name**": "Assign Task",
      "**method**": "POST",
      "**path**": "/task/assignTask/{taskId}",
      "**description**": "Assigns a task to a list of users.",
      "request": {
        "userIds": [1, 2, 3]
      },
      "response": "Tasks assigned successfully."
    },
    {
      "**name**": "Update Task",
      "**method**": "PUT",
      "**path**": "/task/updateTask/{taskId}",
      "**description**": "Updates the details of a specific task.",
      "request": {
        "title": "string",
        "description": "string",
        "dueDate": "string",
        "status": "PENDING",
        "assignedUsersAndStatus": []
      },
      "response": "Task updated successfully."
    },
    {
      "**name**": "Get Task by ID",
      "**method**": "GET",
      "**path**": "/task/getTaskById/{taskId}",
      "**description**": "Retrieves task details by task ID.",
      "request": null,
      "response": {
        "taskId": 1,
        "title": "string",
        "description": "string",
        "created": "string",
        "dueDate": "string",
        "status": "string",
        "assignedUsersAndStatus": []
      }
    },
    {
      "**name**": "Delete Task by ID",
      "**method**": "DELETE",
      "**path**": "/task/deleteTaskById/{taskId}",
      "**description**": "Deletes a task from the system.",
      "request": null,
      "response": "Task deleted successfully."
    },
    {
      "**name**": "Get All Tasks Paginated",
      "**method**": "GET",
      "**path**": "/task/getAllTasksPaginated",
      "**description**": "Retrieves a paginated list of all tasks in the system.",
      "request": {
        "page": 0,
        "size": 10
      },
      "response": {
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
    },
    {
      "**name**": "Get Task Status of User",
      "**method**": "GET",
      "**path**": "/task/getTaskStatusOfUser/{taskId}",
      "**description**": "Retrieves the status of a specific task for a given user.",
      "request": {
        "userId": 1
      },
      "response": {
        "userId": 1,
        "status": "string",
        "dueDate": "string"
      }
    },
    {
      "**name**": "Get All Tasks Status of User",
      "**method**": "GET",
      "**path**": "/task/getAllTasksStatusOfUser/{userId}",
      "**description**": "Retrieves the status of all tasks for a given user.",
      "request": null,
      "response": [
        {
          "userId": 1,
          "status": "string",
          "dueDate": "string"
        }
      ]
    },
    {
      "**name**": "Get Users Status By Task ID",
      "**method**": "GET",
      "**path**": "/task/getUsersStatusByTaskId/{taskId}",
      "**description**": "Retrieves the status of all users for a given task.",
      "request": null,
      "response": [
        {
          "userId": 1,
          "status": "string",
          "dueDate": "string"
        }
      ]
    },
    {
      "**name**": "Get Tasks Due Before",
      "**method**": "GET",
      "**path**": "/task/tasksDueBefore",
      "**description**": "Retrieves tasks due before a specified date.",
      "request": {
        "date": "string"
      },
      "response": [
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
    },
    {
      "**name**": "Get Tasks By Status",
      "**method**": "GET",
      "**path**": "/task/tasksByStatus",
      "**description**": "Retrieves tasks based on the specified status.",
      "request": {
        "status": "string"
      },
      "response": [
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
    }
  ]
}
