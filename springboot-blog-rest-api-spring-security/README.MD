Requests
===========
1)GET REQUEST
http://localhost:9091/api/posts/getAllPosts
2)POST REQUEST
http://localhost:9091/api/posts/
{
"title":"august post",
"description":"it has content",
"content":"Test"
}
3)http://localhost:9091/api/posts/1  (GET REQUEST)
4)http://localhost:9091/api/posts/1 (PUT MAPPING)
{
"title":"august post",
"description":"it has content",
"content":"Test"
}
5)http://localhost:9091/api/posts/1 (DELETE REQUEST)

Comment Controller
==================
POST REQUEST
1)http://localhost:9091/api/posts/1/comments
{
"body":"very interesting boy",
"name":"jasvin",
"email":"jasvin@gmail.com"
}
2)GET REQUEST
http://localhost:9091/api/posts/1/comments
3)GET REQUEST
http://localhost:9091/api/posts/1/comments/2
4)PUT Mapping
http://localhost:9091/api/posts/1/comments/2
{
"body":"very interesting boy",
"name":"jasvin",
"email":"jasvin@gmail.com"
}
5)DELETE Mapping
http://localhost:9091/api/posts/1/comments/2
