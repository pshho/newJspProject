<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3, 6, 9</title>
</head>
<body>
	<h2>3, 6, 9</h2>
	<%
		int n = 50000;
		for(int i=1; i<=n; i++){
			// int a = i/10;
			int c = i;
			
			String text = "";
			
			while(true){
				int b = c%10;
				c /= 10;
				
				if(b%3==0 && b!=0){
					text += "짝";
				}
				
				if(c==0){
					break;
				}
			}
			
			if(text.equals("")){
				text += i;
			}
			
			out.println(text + "<br/>");
		}
	%>
</body>
</html>