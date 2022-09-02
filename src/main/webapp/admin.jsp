<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:3px solid #bbb;
}

li:last-child {
  border-right:3px solid #bbb;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 34px 36px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
</head>
<body>

<ul>
  <li><a href="loginuser.jsp">Login User</a></li>
  <li><a href="adduser">Add User</a></li>
  <li><a href="addproduct">Add Product</a></li>
  <li><a href="productslist">Product List</a></li>
  <li><a href="">User List</a></li>
</ul>

</body>
</html>