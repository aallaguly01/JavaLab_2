<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
</head>
<body>
<h1><@spring.message 'sign_in_page.signIn.title'/></h1>
<form action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label>
        <input name="email" type="email" placeholder="<@spring.message 'sign_in_page.email.title'/>">
        <input name="password" type="password" placeholder="<@spring.message 'sign_in_page.password.title'/>">
        <input type="checkbox" name="remember-me"><@spring.message 'sign_in_page.rememberMe.title'/>
    </label>
    <input type="submit" value="<@spring.message 'sign_in_page.signIn.title'/>">
</form>
</body>
</html>