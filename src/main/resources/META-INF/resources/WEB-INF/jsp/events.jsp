<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navbar.jspf" %>

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

<%@ include file="commons/footer.jspf" %>