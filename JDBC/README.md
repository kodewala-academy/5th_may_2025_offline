JDBC (Java Database Connectivity) is a standard API in Java that allows applications to connect to databases, execute SQL queries, and process results.

Load Driver – Register JDBC driver class.

Establish Connection – Use DriverManager.getConnection() to connect to DB.

Create Statement – Use Statement or PreparedStatement to write SQL.

Execute Query/Update – Perform CRUD operations.

Process ResultSet – Read DB results.

Close Resources – Always close ResultSet, Statement, Connection.

Classes in Your Project

1. SimpleJDBC

Goal: Demonstrates the basic JDBC flow (Insert + Select).

Functional Flow:

Connect to batch5thmay database.

Insert one record into payment table.

Select all rows from payment and display them.


2. JDBCTransaction

Goal: Demonstrates transaction management with commit and rollback.

Functional Flow:

Disable auto-commit on connection.

Insert a record into payment.

Insert a record into orders.

If both succeed → commit().

If any fails → rollback().


3. JDBCBatch

Goal: Demonstrates batch processing for performance.

Functional Flow:

Disable auto-commit.

Use PreparedStatement.

Add multiple INSERT queries into batch using addBatch().

Execute all at once using executeBatch().

Commit results.

4. StatementVsPrepared

Goal: Show the difference between Statement and PreparedStatement.

Functional Flow:

Using Statement:

Execute a static SQL (placed_by = 'Suresh').

Risk of SQL Injection.

Using PreparedStatement:

Parameterized SQL with ?.

Example: placed_by = 'Suresh'.

Safe and reusable.