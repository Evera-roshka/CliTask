# CLI Task Manager

A simple command-line interface (CLI) application for managing tasks, built in Java. This application allows you to create, update, delete, and track the status of your tasks through a JSON file-based storage system.

## Features

- **Add Tasks**: Create new tasks with descriptions
- **Update Tasks**: Modify existing task descriptions
- **Delete Tasks**: Remove tasks from your list
- **Status Management**: Mark tasks as done or in progress
- **List Tasks**: View all tasks or filter by status
- **Persistent Storage**: Tasks are stored in a `tasks.json` file

## Prerequisites

- Java 8 or higher
- A Java IDE or command-line Java compiler

## Installation

1. Clone or download the project files
2. Compile the Java files:
   ```bash
   javac -d . org/CliTask/*.java
   ```
3. The application will automatically create a `tasks.json` file in the project directory when first run

## Usage

Run the application from the command line using:

```bash
java org.CliTask.Main [command] [arguments]
```

### Available Commands

#### Add a Task
```bash
java org.CliTask.Main --add "Task description"
```
Creates a new task with the specified description.

#### Update a Task
```bash
java org.CliTask.Main --update [task_id] "New description"
```
Updates the description of the task with the specified ID.

#### Delete a Task
```bash
java org.CliTask.Main --delete [task_id]
```
Removes the task with the specified ID from your task list.

#### Mark Task as Done
```bash
java org.CliTask.Main --mark-done [task_id]
```
Marks the specified task as completed.

#### Mark Task as In Progress
```bash
java org.CliTask.Main --mark-in-progress [task_id]
```
Marks the specified task as currently in progress.

#### List Tasks
```bash
# List all tasks
java org.CliTask.Main --list

# List tasks by status
java org.CliTask.Main --list done
java org.CliTask.Main --list "in progress"
java org.CliTask.Main --list "not done"
```
Displays tasks based on the specified filter or shows all tasks if no filter is provided.

#### Help
```bash
java org.CliTask.Main --help
```
Displays all available commands and their usage.

## Task Status Options

- **done**: Task has been completed
- **in progress**: Task is currently being worked on
- **not done**: Task has not been started (default status)

## File Structure

```
org/
└── CliTask/
    ├── Main.java                    # Main application entry point
    ├── Utils.java                   # Utility functions and helpers
    ├── AddCommandController.java    # Handles task addition
    ├── UpdateCommandController.java # Handles task updates
    ├── DeleteCommandController.java # Handles task deletion
    ├── MarkStatusController.java    # Handles status changes
    └── ListCommandController.java   # Handles task listing
```

## Data Storage

Tasks are stored in a `tasks.json` file in the application's root directory. This file is automatically created when you first run the application and persists your tasks between sessions.

## Error Handling

The application includes comprehensive error handling for:
- Invalid command syntax
- Missing required arguments
- File operation errors
- Invalid task IDs
- Unrecognized commands

## Examples

```bash
# Add a new task
java org.CliTask.Main --add "Complete project documentation"

# Update task with ID 1
java org.CliTask.Main --update 1 "Complete and review project documentation"

# Mark task 1 as done
java org.CliTask.Main --mark-done 1

# List all completed tasks
java org.CliTask.Main --list done

# Delete task with ID 2
java org.CliTask.Main --delete 2
```

## Project Url
https://github.com/Evera-roshka/CliTask

## Contributing

Feel free to fork this project and submit pull requests for any improvements or additional features you'd like to add.

## License

This project is open source and available under standard open source licensing terms.
