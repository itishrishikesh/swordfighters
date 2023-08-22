<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sword Fighters!</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet" />
  </head>

  <body>

    <div class="container">
      <div class="display-3 mt-3" style="width:400px;">Add an upcoming fight!</div>
      <form:form method="post" class="mt-5" modelAttribute="event">
        <form:input type="hidden" path="id"></form:input>
        <form:input type="hidden" path="done"></form:input>
        <div class="form-group">
          <label for="defender">Defender</label>
          <form:input type="text" id="defender" class="form-control" path="defender" placeholder="defender's name" />
        </div>
        <div class="form-group mt-2">
          <label for="challenger">Challenger</label>
          <form:input type="text" id="challenger" class="form-control" path="challenger" placeholder="challenger's name" />
        </div>
        <div class="form-group mt-2">
          <label for="description">Description</label>
          <form:input type="text" id="description" class="form-control" path="description" placeholder="description" />
          <form:errors path="description" />
        </div>
        <div class="form-group mt-2">
          <label for="date">Date</label>
          <form:input type="text" id="date" class="form-control" path="scheduledDate" placeholder="date" />
        </div>
        <input type="submit" class="btn btn-primary mt-2"></input>
      </form:form>
    </div>

    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\js\jquery.min.js"></script>
  </body>

</html>