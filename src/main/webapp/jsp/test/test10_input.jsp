<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

 <%@ page import="java.util.*" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Melong</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<style>

*{

	color:#333333;

	list-style:none;

	text-decoration-line:none;
}
.copy{
	margin-top:20px;
}





</style>

</head>





<body>

<%

// 아티스트 정보 



    Map<String, Object> artistInfo = new HashMap<>();

    artistInfo.put("name", "아이유");

    artistInfo.put("debute", 2008);

    artistInfo.put("agency", "EDAM엔터테인먼트");

    artistInfo.put("photo", "https://musicmeta-phinf.pstatic.net/artist/000/112/112579.jpg?type=ff300_300");





// 아이유 노래 리스트 

    List<Map<String, Object>> musicList = new ArrayList<>();



    Map<String, Object> musicInfo = new HashMap<>();

    musicInfo.put("id", 1);

    musicInfo.put("title", "팔레트");

    musicInfo.put("album", "Palette");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/002/000/2000240.jpg?type=r360Fll");

    musicInfo.put("time", 217);

    musicInfo.put("composer", "아이유");

    musicInfo.put("lyricist", "아이유");

    musicList.add(musicInfo);



    musicInfo = new HashMap<>();

    musicInfo.put("id", 2);

    musicInfo.put("title", "좋은날");

    musicInfo.put("album", "Real");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/000/184/184117.jpg?type=r360Fll");

    musicInfo.put("time", 233);

    musicInfo.put("composer", "이민수");

    musicInfo.put("lyricist", "김이나");

    musicList.add(musicInfo);



    musicInfo = new HashMap<>();

    musicInfo.put("id", 3);

    musicInfo.put("title", "밤편지");

    musicInfo.put("album", "palette");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/002/000/2000240.jpg?type=r360Fll");

    musicInfo.put("time", 253);

    musicInfo.put("composer", "제휘,김희원");

    musicInfo.put("lyricist", "아이유");

    musicList.add(musicInfo);



    musicInfo = new HashMap<>();

    musicInfo.put("id", 4);

    musicInfo.put("title", "삐삐");

    musicInfo.put("album", "삐삐");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/002/559/2559408.jpg?type=r360Fll");

    musicInfo.put("time", 194);

    musicInfo.put("composer", "이종훈");

    musicInfo.put("lyricist", "아이유");

    musicList.add(musicInfo);



    musicInfo = new HashMap<>();

    musicInfo.put("id", 5);

    musicInfo.put("title", "스물셋");

    musicInfo.put("album", "CHAT-SHIRE");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/000/592/592471.jpg?type=r360Fll");

    musicInfo.put("time", 194);

    musicInfo.put("composer", "아이유,이종훈,이채규");

    musicInfo.put("lyricist", "아이유");

    musicList.add(musicInfo);



    musicInfo = new HashMap<>();

    musicInfo.put("id", 6);

    musicInfo.put("title", "Blueming");

    musicInfo.put("album", "Love poem");

    musicInfo.put("singer", "아이유");

    musicInfo.put("thumbnail", "https://musicmeta-phinf.pstatic.net/album/003/399/3399860.jpg?type=r360Fll");

    musicInfo.put("time", 217);

    musicInfo.put("composer", "아이유,이종훈,이채규");

    musicInfo.put("lyricist", "아이유");

    musicList.add(musicInfo);

%>



	<div class="container">
		<header class="header d-flex">
			<h2 class="logo text-success"><a class="text-success" href="/jsp/test/test10_input.jsp">Melong</a></h2>
			<form action="/jsp/test/test10_result.jsp" method="get" class="ml-5 input-group">
				<input name="title" type="text" placeholder="제목을 입력하세요." class="form-control h-100">
				<button type="submit" class="btn bg-info text-white">검색</button>
			</form>

		</header>
		<div class="menu">
			<ul class="nav font-weight-bold">
					<li class="nav-item"><a class="nav-link text-dark" href="#">멜롱차트</a></li>
					<li class="nav-item"><a class="nav-link text-dark" href="#">최신음악</a></li>
					<li class="nav-item"><a class="nav-link text-dark" href="#">장르음악</a></li>
					<li class="nav-item"><a class="nav-link text-dark" href="#">멜롱DJ</a></li>
					<li class="nav-item"><a class="nav-link text-dark" href="#">뮤직어워드</a></li>
			</ul>
		</div>

		<article class="border d-flex border-success p-3">
			<a href="#"><img style="width:150px" src=<%= artistInfo.get("photo") %> alt="이이유사진"></a>
			<div style="margin-left:20px">
				<h1><%= artistInfo.get("name") %></h1>
				<h5 class="text-secondary" style="margin-top:20px"><%= artistInfo.get("agency") %></h5>
				<h5 class="text-secondary"><%= artistInfo.get("debute") %>년 데뷔</h5>
			</div>
		</article>

		<main class="main mt-2">
			<h3>곡 목록</h3>

			<table class="table text-center">
				<thead>
					<tr>
						<th>no</th>
						<th>제목</th>
						<th>앨범</th>
					</tr>
				</thead>
				
				<tbody>
				<% for(Map<String, Object> info : musicList) { %>
					<tr>
						<td><%= info.get("id") %></td>
						<td class="text-primary"><a href="/jsp/test/test10_result.jsp?id=<%= info.get("id") %>"><%= info.get("title") %></a></td>
						<td><%= info.get("album") %></td>
					</tr>
				<% } %>
				</tbody>
			</table>

			

		</main>

		
		<span class="copy text-secondary">Copyright © marondal 2021</span>
		

		

	</div>











<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

	

</body>

</html>





