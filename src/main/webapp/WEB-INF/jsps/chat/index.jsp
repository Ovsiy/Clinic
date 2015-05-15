<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <script src="assets/stomp.js"></script>
        <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
        <script>
//            var engine = {
////                socket: new SockJS("/hello"),
//                stompClient: Stomp.over(new SockJS("/hello")),
//
//                connectCallback: function() {
//                    var self = this;
//                    alert("connected!");
//                    self.stompClient.subscribe('/topic/greetings', function(greeting){
//                        alert(JSON.parse(greeting.body).content);
//                    });
//                },
//
//                errorCallback: function(error) {
//                    // display the error's message header:
//                    alert('EEEEERRRRROOOOOOOR' + error.headers.message);
//                },
//
//                sayHi: function() {
//                    this.stompClient.send("/app/hello", {}, JSON.stringify({ 'name': 'Joe' }));
//                },
//
//                connect: function() {
//                    this.stompClient.connect("guest", "guest", this.connectCallback(), this.errorCallback);
//                }
//            };
//
//            engine.connect();
//            engine.sayHi();

            var stompClient = null;
            var userEmail = "${email}";

            var setConnected = function(connected) {
                document.getElementById('connect').disabled = connected;
                document.getElementById('sendMessage').disabled = !connected;
                document.getElementById('disconnect').disabled = !connected;
            };

            var connectCallback = function() {
                pasteToChat('User ' + userEmail + ' connected');
                stompClient.subscribe('/topic/message', function(message){
//                    pasteToChat(JSON.parse(message.body).userEmail + ': ' + JSON.parse(message.body).content);
                    var row = beutifyRow(JSON.parse(message.body).userEmail, JSON.parse(message.body).content);
                    console.log(row);
                    pasteToChat(row);
                });
            };

            var disconnectCallback = function() {
                stompClient.unsubscribe();
            };

            var errorCallback = function(error) {
                alert(error.headers.message);
            };

            var connect = function() {

                var socket = new SockJS("/hello");
                stompClient = Stomp.over(socket);

                stompClient.connect("guest", "guest", connectCallback, errorCallback);
                setConnected(true);
            };

            var disconnect = function() {
                stompClient.unsubscribe();
                stompClient.disconnect();
                setConnected(false);
                pasteToChat('User ' + userEmail + ' disconnected');
            };

            var sendMessage = function() {
                var inputMessage = $('#inputMessage').val();
//                stompClient.send("/app/hello", {}, JSON.stringify({ 'name': 'Joe' }));
                stompClient.send("/app/hello", {}, JSON.stringify({ 'message': inputMessage, 'userEmail': userEmail }));
                $('#inputMessage').val('');
            };

            var pasteToChat = function(message) {
                $('#chatWindow').append(message + '\r\n');
            };

            var beutifyRow = function(name, message) {
                var row = "<strong>" + name + ":</strong>" + message;
                return row;
            }


        </script>

        <button id="connect" class="btn btn-primary" onclick="connect();">Connect</button>
        <button id="disconnect" class="btn btn-primary" disabled="disabled" onclick="disconnect();">Disconnect</button>

        <div class="form-group">
            <textarea disabled="true" id="chatWindow" class="form-control" rows="10"></textarea>
        </div>

        <div class="form-group">
            <input type = "text" id="inputMessage" class="form-control" placeholder="Type a message">
        </div>

        <button id="sendMessage" class="btn btn-primary" onclick="sendMessage();">Send</button>

    </tiles:putAttribute>
</tiles:insertDefinition>