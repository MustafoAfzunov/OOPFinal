https://oopfinal-1.onrender.com - Deployment link
How to test APIs--->
APIs:
###
GET /user/
###
POST http://localhost:8080/user/register
Content-Type: application/json
{
  "username": "",
  "email": "",
  "password": ""
}
{
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWZhbXVtICIsImlhdCI6MTczNDY4MjcyMiwiZXhwIjoxNzM0NzE4NzIyfQ.J28f1Bvy1QOPRPxS5IW89IMpCDOolmge1hHr3l0ZI_g",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWZhbXVtICIsImlhdCI6MTczNDY4MjcyMiwiZXhwIjoxNzM3Mjc0NzIyfQ.hfR2xH-q4z6U8H4KAhIDbeFS2k0cDlGxhVdWpaO9eOM",
    "tokenType": "Bearer"
}
Will give you tokens needed to login in postman
###
POST http://localhost:8080/user/login
Content-Type: application/json
{
  "username": "",
  "password": ""
}
Expected output:
{
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWNrbmFtZSIsImlhdCI6MTczNDY4MjU0NiwiZXhwIjoxNzM0NzE4NTQ2fQ.cJUF2KV_wdXL5S4y1oUrGN-tqyUx3KqJzjaMt9ymvX4",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWNrbmFtZSIsImlhdCI6MTczNDY4MjU0NiwiZXhwIjoxNzM3Mjc0NTQ2fQ.YLvKhEocLvxGZsDge6smp6G5ebavg95EoGDCMMqVoHY",
    "tokenType": "Bearer"    
}
Will generate you an access token to test other API like /app-expense. NOTE: without access token will throw 403 Error
###
POST http://localhost:8080/expenses/add-expense
Content-Type: application/json
Bearer: AccessToken provided when logging in!
{
    "category": "www",
    "amount": 0.0,
    "date": "2022-08-08"
}
Expected output:
{
    "category": "www",
    "amount": 0.0,
    "date": "2022-08-08"
}
Adds the transaction
###
GET http://localhost:8080/expenses/list-expenses
Will list all the transactions
