<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="">ADF Cultural Exhibit Gallery</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <center>
        <div class="container">
            <h1>Welcome to the gallery</h1>
            <img src="" height="500">
            <h2>Please choose one of the following options</h2>
        </div>
    </center>
</div>


<center>

    <div class="container">

        <div class="row">
            <div class="col-md-4">
                <h2>Gallery</h2>
                <p>View a selection of images</p>
                <p>
                    <a class="btn btn-default" href="" role="button">View details</a>
                </p>
            </div>
            <div class="col-md-4">
                <h2>Profile</h2>
                <p>View your profile details</p>
                <p>
                    <a class="btn btn-default" href="" role="button">View details</a>
                </p>
            </div>
            <div class="col-md-4">
                <h2>Leaderboard</h2>
                <p>View user submission leaderboard</p>
                <p>
                    <a class="btn btn-default" href="" role="button">View details</a>
                </p>
            </div>
        </div>


        <hr>
        <footer>
            <p>&copy; Group 5 2015</p>
        </footer>
    </div>
</center>

</body>
</html>