<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navbar.jspf" %>

<div class='container'>
    <h3 class='display-4'> This is homepage! </h3>
    <p>User: <span class="text-success">${username}</span></p>
    <div class="alert alert-info"><a href='events'>list of sword fight events</a> in the upcoming days</div>
</div>

<%@ include file="commons/footer.jspf" %>