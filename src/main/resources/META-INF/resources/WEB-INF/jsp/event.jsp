<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navbar.jspf" %>

<div class="container">
    <div class="display-3 mt-3">Add an upcoming fight!</div>
    <form:form method="post" class="mt-5" modelAttribute="event" style="width:400px;">
        <form:input type="hidden" path="id"></form:input>
        <form:input type="hidden" path="done"></form:input>
        <div class="form-group">
            <label for="defender">Defender</label>
            <form:input type="text" id="defender" class="form-control" path="defender" placeholder="defender's name"/>
        </div>
        <div class="form-group mt-2">
            <label for="challenger">Challenger</label>
            <form:input type="text" id="challenger" class="form-control" path="challenger"
                        placeholder="challenger's name"/>
        </div>
        <div class="form-group mt-2">
            <label for="description">Description</label>
            <form:input type="text" id="description" class="form-control" path="description" placeholder="description"/>
            <form:errors path="description"/>
        </div>
        <div class="form-group mt-2">
            <label for="date">Date</label>
            <form:input type="text" id="scheduledDate" class="form-control" path="scheduledDate" placeholder="date"/>
        </div>
        <input type="submit" class="btn btn-primary mt-5"></input>
    </form:form>
</div>

<%@ include file="commons/footer.jspf" %>