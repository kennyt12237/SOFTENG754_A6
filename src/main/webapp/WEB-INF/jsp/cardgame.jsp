<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>
        Simple Last Card
    </title>
</head>
<body>
<button id="help-icon">?</button>
<form action="/CardGame" method = "post">
    <button id="start-game-button">Start Game</button>

</form>

<div class ="modal fade" tabindex="-1" role ="dialog" id="myModal">
    <div class="modal-dialog">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Rules</h4>
        </div>
        <div class="modal-body">
            <div class="container">
                <div class = row>
                    <p>Last Card is a game in which each player takes turns placing cards that match the suit or value. You can place multiple cards at the same time, so long as they match value. If you're unable to place any cards, you must pick up 1. Whoever empties their hand first wins the game.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('input[type="help-icon"]').click(function (e) {
            $('#myModal').modal('show');
            return true
        });
    });
</script>
</body>


</html>