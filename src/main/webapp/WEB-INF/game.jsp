<%--
  Created by IntelliJ IDEA.
  User: jluso
  Date: 29/04/2021
  Time: 01:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Unity WebGL Player | The chamber</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/ChamberWEB/TemplateData/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ChamberWEB/TemplateData/style.css">
    <script src="${pageContext.request.contextPath}/ChamberWEB/TemplateData/UnityProgress.js"></script>
    <script src="${pageContext.request.contextPath}/ChamberWEB/Build/UnityLoader.js"></script>

    <script>
        var unityInstance = UnityLoader.instantiate("unityContainer", "Build/ChamberWEB.json", {onProgress: UnityProgress});
    </script>
</head>
<body>
<center>
    <div>
        <form action="logout" method="get">
            <button type="submit">Cerrar sesion</button>
        </form>
    </div>
</center>

<div class="webgl-content">
    <div id="unityContainer" style="width: 960px; height: 600px"></div>
    <div class="footer">
        <div class="webgl-logo"></div>
        <div class="fullscreen" onclick="unityInstance.SetFullscreen(1)"></div>
        <div class="title">The chamber</div>
    </div>
</div>
</body>
</html>
