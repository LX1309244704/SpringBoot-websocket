<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Home</title>
<script src="http://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script> 
<spring:url value="/" var="context" />

<script type="text/javascript">
var stompClient = null;
//$(function(){
//	connect();
//});

var ws,uid,groupName;
function login(){
	uid = $("#uid").val();
	groupName = $("#group").val();
	ws = $("#address").val();
	connect();
}

function connect(){
	var socket = new SockJS(ws);
	stompClient = Stomp.over(socket);
	var authHeaders = {'group': groupName, 'uid': uid};
	stompClient.connect(authHeaders, function(frame) {
	    stompClient.subscribe("/topic/broadcast", function(msg) {
	    	showGreeting(JSON.parse(msg.body).content);  
	    });
		stompClient.subscribe("/topic/group."+groupName, function(msg) {
			showGreeting(JSON.parse(msg.body).content); 
		});
		stompClient.subscribe("/user/topic/p2p."+groupName + uid, function(msg) {
			showGreeting(JSON.parse(msg.body).content); 
		});
	});
}
function broadcast(){
	stompClient.send("/app/message/broadcast",{},JSON.stringify({'type':1,'title': '通知消息','content': $("#msg").val()}));
}
function group(){
	stompClient.send("/app/message/group",{},JSON.stringify({'group': groupName,'message':{'type':1,'title': '通知消息','content': $("#msg").val()}}));
}
function p2p(){
	stompClient.send("/app/message/p2p",{},JSON.stringify({'group': groupName,'uid':1,'message':{'type':1,'title': '通知消息','content': $("#msg").val()}}));
}

function showGreeting(message) {  
 var response = document.getElementById('ret');  
 var p = document.createElement('p');  
 p.style.wordWrap = 'break-word';  
 p.appendChild(document.createTextNode(message));  
 response.appendChild(p);  
}  
</script>
</head>
<body>
	<h1>Hello WebSocket Client !!</h1>
	地址：<input id = "address" type="text" value="http://localhost:7071/jmyps"/>
	uid：<input id = "uid" type="text" value="1"/>
	group：<input id = "group" type="text" value="gc"/>
	消息：<input id = "msg" type="text" value="消息内容"/>
	<button id = "ws0" onclick="login();">连接</button>
	<button id = "ws1" onclick="broadcast();">广播推送</button>
	<button id = "ws2" onclick="group();">分组推送</button>
	<button id = "ws3" onclick="p2p();">精准推送</button>
	<p id="ret"></p>
</body>
</html>
