<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>
        Simple Last Card
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <style>
        p{
            overflow-wrap:break-word;
            margin-right:10px;
        }
        div.row{
            width:598px;
        }
    </style>
</head>
<body>
<div class="container">
<form action="/CardGame" method = "post">
    <button id="start-game-button">Start Game</button>
</form>
    <button class="btn btn-default" id="helpbtn">?</button>

</div>
<!-- Modal code goes here-->
<div class ="modal fade" tabindex="-1" role ="dialog" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Rules</h4>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class = row>
                        <p id="helpmsg">Last Card is a game in which each player takes turns placing cards that match the suit or value. You can place multiple cards at the same time, so long as they match value. If you're unable to place any cards, you must pick up 1. Whoever empties their hand first wins the game.</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<!-- /.modal -->

<script type="text/javascript">
    $(document).ready(function(){
        $('button[id="helpbtn"]').click(function (e) {
            $('#myModal').modal('show');
            return true
        });
    });
</script>
</body>


</html>