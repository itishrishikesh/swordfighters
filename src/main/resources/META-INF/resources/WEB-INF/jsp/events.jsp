<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sword Fighters!</title>
      <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet" />
  </head>

  <body>

<div class='container'>
    <h3 class='display-3'> List of upcoming events! </h3>
    <table class='table mt-5'>
        <thead>
            <tr>
                <th>id</th>
                <th>defender</th>
                <th>challenger</th>
                <th>description</th>
                <th>date</th>
                <th>done</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${events}" var='event'>
                <tr>
                    <td>${event.id}</td>
                    <td>${event.defender}</td>
                    <td>${event.challenger}</td>
                    <td>${event.description}</td>
                    <td>${event.scheduledDate}</td>
                    <td>${event.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-event" class="btn btn-primary">Add new event!</a>
</div>
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.0\js\jquery.min.js"></script>
  </body>

</html>