<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="GalleryWrite" method="post" enctype="multipart/form-data">
	<table border="">
		<tr>
			<td width="100px">제목</td>
			<td width="800px"><input type="text" name="title" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="30" rows="10" name="descriptions" style="resize: none; width: 99%;"></textarea></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><p>파일은 이미지만 가능합니다.</p><input type="file" name="upfile" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글쓰기" />
				<input type="reset" value="초기화" />
				<a href="GalleryList">목록으로</a>
			</td>
		</tr>
	</table>
</form>