# Library Management System (CLI)

A simple command-line based Library Management System for managing books and student members. The system allows an admin to add books, manage members, handle borrowing and returning of books, and view library records.

## Features

### Book Management
- Add new books
  - Book name

- List all books with:
  - Book name
  - Auther name
  - Available copies

### Member Management
- Members are students only
  - Members have : Name, ID, Mobile Number

### Borrow Book
- Borrow a book by providing:
  - Student Mobile Number
  - Student name
  - Book name
- Decreases available copies when a book is borrowed

### Borrowed Book List
- View all borrowed books with:
  - Book 
  - Student name
 ### Completed till Borrowed Book List
 
### Return Book
- Return a book by providing:
  - Book name
  - Student name
- Increases available copies when a book is returned

## How to Run the CLI Application

1. Make sure Java (JDK) is installed.

2. Clone the project and go to the folder:
   git clone https://github.com/Priyansh7999/library-management-system.git
   cd library-management-system

3. Compile the program:
   javac *.java

4. Run the program:
   java Main

Note: Data is not saved after the program ends.