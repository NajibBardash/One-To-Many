Run this after connecting to Derby:

connect 'jdbc:derby://localhost:50000/OneToMany; create=true' ;

Contains an Employer-class and an Employee-class.
Employer has a unidirectional One-To-Many relationship to Employee.

In the Main-class:

On the first run, leave "create" in the hibernate.cfg.xml and create the:
	- Employer
	- Emplyees
	- And add the employees to the employer

On the second run, change to "update" in the file and comment out the previous code.
And un-comment the code for retrieving the employees by referecing the employer.
