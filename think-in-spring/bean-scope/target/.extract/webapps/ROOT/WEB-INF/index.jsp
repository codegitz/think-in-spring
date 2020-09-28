<html>
    <head>
        <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
    </head>
    <body>
    <!-- page -> request -> session -> application(servletContext)-->
    Dispatcher...\${userObject.name}:${userObject.name}
    <br/>
    Dispatcher...\${applicationScope['scopedTarget.user'].name}:${applicationScope['scopedTarget.user'].name}
    </body>
</html>