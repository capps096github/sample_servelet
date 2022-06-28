<%--
  Created by IntelliJ IDEA.
  User: momak
  Date: 6/28/2022
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Java Servelet Form</title>
</head>
<body>
<h1>Java Servelet Sample</h1>

<p>Choose an option From the dropdown below</p>

<!-- form -->
<form
        action="form-servlet"
        method="post"
>
    <!-- drop down -->
    <select
            id="option"
            name="options"
            title="options"
            onchange="this.form.submit()"
    >
        <option value="create_session">Create Session</option>
        <option value="create_cookie">Create Cookie</option>
        <option value="check_if_cookie_exists">Check if Cookie Exists</option>
        <option value="remove_session_variables">
            Remove Session Variables
        </option>
        <option value="show_cookies_session_attributes">
            Show Cookies and Session Attributes
        </option>
    </select>
</form>
</body>
</html>
