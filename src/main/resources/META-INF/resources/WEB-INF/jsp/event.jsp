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
      <div class="display-3" style="width:400px;">Add an upcoming fight!</div>
      <form method="post" class="mt-5">
        <div class="form-group mt-2">
          <label for="defender">Defender</label>
          <input type="text" id="defender" class="form-control" name="defender" placeholder="defender's name" />
        </div>
        <div class="form-group mt-2">
          <label for="challenger">Challenger</label>
          <input type="text" id="challenger" class="form-control" name="challenger" placeholder="challenger's name" />
        </div>
        <div class="form-group mt-2">
          <label for="description">Description</label>
          <input type="text" id="description" class="form-control" name="description" placeholder="description" />
        </div>
        <div class="form-group mt-2">
          <label for="date">Date</label>
          <input type="text" id="date" class="form-control" name="date" placeholder="date" />
        </div>
        <input type="submit" class="btn btn-primary mt-2"></input>
      </form>
    </div>

    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\js\jquery.min.js"></script>
  </body>

</html>