# Library Management System (CLI)

A simple command-line based Library Management System for managing books and student members. The system allows an admin to add books, manage members, handle borrowing and returning of books, and view library records.

## Features

### Book Management
- Add new books
  - Book name
  - Number of total copies
  - Number of available copies

- List all books with:
  - Book name
  - Available copies

### Member Management
- Members are students only

### Borrow Book
- Borrow a book by providing:
  - Book name
  - Student name
- Decreases available copies when a book is borrowed

### Borrowed Book List
- View all borrowed books with:
  - Book name
  - Student name

### Return Book
- Return a book by providing:
  - Book name
  - Student name
- Increases available copies when a book is returned

## Class Overview

### Book
- Represents a book title, id
- Tracks total and available copies

### Member
- Base class for library members
- Contains common attributes like `memberId` and `name`

### Student
- Extends `Member`
- Represents a student library member

### Library
- Handles all business logic
- Manages books and borrowing/returning operations

