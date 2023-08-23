<%@ include file="commons/header.jspf" %>
<%@ include file="commons/navbar.jspf" %>

<div class="container">
    <h1 class="text-center">Welcome to Sword Fighters club!</h1>
    <div class="row justify-content-center d-flex mt-5">
        <div class="col-6">
            <form method='post'>
                <div class="mb-3">
                    <label for="name" class="form-label">Email address</label>
                    <input type="email" class="form-control" name="username" aria-describedby="emailHelp"/>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password"/>
                </div>
                <input type="submit" class="btn btn-primary"></input>
                <div class="text-danger mb-5" role="alert">${error}</div>
            </form>
        </div>
    </div>
</div>


<%@ include file="commons/footer.jspf" %>