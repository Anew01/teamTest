<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="/mokupCss/rating.css">
<body>
	<form action="/ratingResult.do" method="get">
    <table>
        <tr>
            <th>
                <label for="rating1">★</label>
            </th>
            <td>
                <input type="radio" name="rating" value="1" id="rating1">
            </td>
            <th>
                <label for="rating2">★★</label>
            </th>
            <td>
                <input type="radio" name="rating" value="2" id="rating2">
            </td>
            <th>
                <label for="rating3">★★★</label>
            </th>
            <td>
                <input type="radio" name="rating" value="3" id="rating3">
            </td>
            <th>
                <label for="rating4">★★★★</label>
            </th>
            <td>
                <input type="radio" name="rating" value="4" id="rating4">
            </td>
            <th>
                <label for="rating5">★★★★★</label>
            </th>
            <td>
                <input type="radio" name="rating" value="5" id="rating5">
            </td>
            <th colspan="2"><button type="submit">별점입력</button></th>
        </tr>
    </table>
    </form>     
</body>
</html>