<%--
  Created by IntelliJ IDEA.
  User: yangkuan
  Date: 2017/8/24
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>time</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width,initial-scale=0.6,minimum-scale=0.6,maximum-scale=0.6,user-scalable=no" />
    <script type="text/javascript">
        function getDoubleValue(val) {
            if (val < 10) {
                return '0' + val;
            }

            return val;
        }

        $(function () {
            var now = new Date();

            $.post("time.json", function (result,flag,response) {
                var net_delay = (new Date().getTime() - now.getTime());
                var sys_delay = (result + net_delay) - new Date().getTime();

                $("#s_net_delay").html(net_delay);
                $("#s_sys_delay").html(sys_delay);

                setInterval(function () {
                    var local_now = new Date();
                    $("#s_now").html(getDoubleValue(local_now.getHours()) + ":" + getDoubleValue(local_now.getMinutes()) + ":" + getDoubleValue(local_now.getSeconds()) + ":" + local_now.getMilliseconds());

                    var server_now = new Date(local_now.getTime() + sys_delay);

                    $("#s_time").html(getDoubleValue(server_now.getHours()) + ":" + getDoubleValue(server_now.getMinutes()) + ":" + getDoubleValue(server_now.getSeconds()) + ":" + server_now.getMilliseconds());
                },5);
            })
        });
    </script>
</head>
<body>
<div>
    <span style="font-size:3rem;">&nbsp;&nbsp;&nbsp;net-delay:</span>
    <span id="s_net_delay" style="font-size:3rem;">000</span>
    <br>
    <span style="font-size:3rem;">&nbsp;&nbsp;&nbsp;sys-delay:</span>
    <span id="s_sys_delay" style="font-size:3rem;">000</span>
    <br/>
    <span style="font-size:3rem;">&nbsp;&nbsp;local-now:</span>
    <span id="s_now" style="font-size:3rem;">00:00:00:000</span>
    <br/>
    <span style="font-size:3rem;">server-now:</span>
    <span id="s_time" style="font-size:3rem;">00:00:00:000</span>
</div>
</body>
</html>
