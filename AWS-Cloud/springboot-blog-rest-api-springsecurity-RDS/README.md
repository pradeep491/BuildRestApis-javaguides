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

VERSIONONG DOCUMENTATION:
===========================
API versioning is the practice of transparently managing changes to your API.
In this article, we will explore four ways of versioning a REST API:

1. Versioning through URI Path
2. Versioning through Query Parameters
3. Versioning through Custom Headers
4. Versioning through Content Negotiation

When to Version a REST API
One of the major challenges in exposing services is handling updates to the API contract. Clients may not want to update their applications when the API changes, so a versioning strategy becomes crucial. A versioning strategy allows clients to continue using the existing REST API and migrate their applications to the newer API when they are ready.

APIs need to be versioned only when a breaking change is made. Breaking changes include:

Changing the request/response format (e.g., from XML to JSON)
Changing a property name (e.g., from name to productName) or data type on a property (e.g., from an integer to a float)
Adding a required field on the request (e.g., a new required header or property in a request body)
Removing a property on the response (e.g., removing description from a product)
4 REST API Versioning Strategies
1. Versioning through URI Path

   One way to version a REST API is to include the version number in the URI path.

Examples:

http://www.example.com/api/1/products
http://www.example.com/api/v1/products
http://www.example.com/api/v2/products
http://www.example.com/api/v1/posts
http://www.example.com/api/v1/employees
In this approach, we create a completely different URI for the new service.

Real-world examples:

Twitter API Versioning
PayPal API Versioning
Google Translate API Versioning

2. Versioning through Query Parameters

   Another option for versioning a REST API is to include the version number as a query parameter.

Examples:

http://www.example.com/api/products?version=1
http://www.example.com/api/products?version=2
http://www.example.com/api/posts?version=1
http://www.example.com/api/employees?version=1
Real-world examples:

Google Translation APIs
3. Versioning through Custom Headers
   REST APIs can also be versioned by providing custom headers with the version number included as an attribute. The main difference between this approach and the two previous ones is that it doesn’t clutter the URI with versioning information.

Examples:

http://localhost:8080/api/products
Headers: [X-API-VERSION=1]

http://localhost:8080/api/products
Headers: [X-API-VERSION=2]

Pros: It doesn’t clutter the URI with versioning information.

Cons: It requires custom headers.

4. Versioning through Content Negotiation
   The last strategy we are addressing is versioning through content negotiation.

In this approach, we use the Accept header in the request.

Examples:

http://localhost:8080/api/products
Headers: [Accept=application/vnd.javaguides-v1+json]

http://localhost:8080/api/products
Headers: [Accept=application/vnd.javaguides-v2+json]

Real-world examples:

GitHub API Versioning