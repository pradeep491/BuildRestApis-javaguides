1)POST Request
http://localhost:8088/api/auth/signin
http://localhost:8088/api/auth/login
Request Body:
{
"usernameOrEmail": "admin",
"password": "admin"
}
(or)
{
"usernameOrEmail": "admin@gmail.com",
"password": "admin"
}
(or)
{
"usernameOrEmail": "pradeep@gmail.com",
"password": "pradeep@491"
}
(or)
{
"usernameOrEmail": "pradeep",
"password": "pradeep@491"
}
2)POST Request
http://localhost:8088/api/auth/signup 
Request Body:
{
"name":"jyo",
"username":"jyo",
"email":"jyo@gmail.com",
"password":"jyo"
}

Category Rest API endpoint
============================
1)POST Request
http://localhost:8088/api/categories
Request Body:
{
"name":"Electronics",
"description":"This category contains all the electronic items"
}
2)GET Request
http://localhost:8088/api/categories/1
3)Get All Categories
http://localhost:8088/api/categories