<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sword Fighters!</title>
      <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>

  <body>

<div class='container'>
    <h3 class='display-3 mt-3'> List of upcoming events! </h3>
    <table class='table mt-5'>
        <thead>
            <tr>
                <th>id</th>
                <th>defender</th>
                <th>challenger</th>
                <th>description</th>
                <th>date</th>
                <th>done</th>
                <th></th>
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
                    <td>
                        <a href="/update-event/${event.id}" class="btn btn-primary"><i class="fa-solid fa-pen"></i></a>
                        <a href="/delete-event/${event.id}" class="btn btn-danger"><i class="fa-solid fa-xmark"></i></a>
                    </td>
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