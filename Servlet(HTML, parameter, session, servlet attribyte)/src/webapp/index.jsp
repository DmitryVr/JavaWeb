<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hi</title>
  </head>
  <body>
    <h1>Test form get</h1>
    <form action="ShowParameter">
      Parameter 1: <input type="text" value="1" name="parameter1"><br/>
      Parameter 2: <input type="text" value="2" name="parameter2"><br/>

      <textarea rows="10" cols="10" name="text"></textarea><br/>

      <select name="select">
        <option>one</option>
        <option>two</option>
        <option>three</option>
      </select><br/>

      <input type="checkbox" name="check">

      <input type="submit" value="Goooooo">
    </form><br/>


    <h1>Test form post</h1>
    <form action="ShowParameter" method="post">
      Login: <input type="text" name="parameter1"><br/>
      Password: <input type="password" name="parameter2"><br/>

      <input type="submit" value="Goooooo">
    </form>
  </body>
</html>
