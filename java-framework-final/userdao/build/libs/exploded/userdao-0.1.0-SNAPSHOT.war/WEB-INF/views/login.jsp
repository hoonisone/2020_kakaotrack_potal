<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <h1>로그인</h1>

    <a>${message}</a>
    <form action="/login_request" method="post" enctype="multipart/form-data">
        <div>
            <div>
                <div><a>ID: </a><input type="text" name="id"/></div>
                <div><a>PW: </a><input type="password" name="password"/></div>
                </div>
            <div><input type="submit" value="확인"/></div>
        </div>
    </form>
    <div><button type="button" onclick="location.href='/join'">회원가입</button></div>
</html>