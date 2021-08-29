# ExpReimburseSystem
Expense Reimbursement System The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

Features:

An Employee can: • Login. • View the employee home page. • Logout. • Submit a reimbursement request. • View their pending reimbursement requests. • View their resolved reimbursement requests. • View their information. • Update their information.

A Manager can: • Login. • View the manager home page. • Logout. • Approve/Deny pending reimbursement requests. • View all pending requests of all employees. • View all resolved requests of all employees. • View reimbursement requests of a specific employee. • View all employees.

Technologies Used: • Java 1.8 • REST API • Hibernate • PL/SQL • HTML/CSS • Bootstrap • JavaScript • Fetch API 

Deployment:

To run from source code:

• git clone https://github.com/safwanunited/ExpReimburseSystem.git • mvn package • java -jar target/.jar

To run with docker: • docker build . • docker run -it -p 8081:8080
