<h1>[Web Service] Providing Public Wi-Fi Information Based on My Location<h1></h1>

<h3>db 구성 ERD</h3>
![손서원_ERD파일](https://github.com/seowonn/mini_web_project/assets/144876148/2bb5a49c-d045-4082-959a-3af62ef58c84)
<p></p>
seoul_wifi 테이블 : 서울시 공공 와이파이 open api에 저장된 와이파이 정보를 저장<br>
search_history 테이블 : 근처 와이파이 보기 버튼을 눌렀을 때, 사용된 LAT, LNT 정보 기록을 저장<br>
bookmark_group 테이블 : 북마크들을 하나의 그룹을 묶어서 보기 위해, 그룹 정보를 저장하는 테이블<br>
bookmarked_wifi 테이블 : 원하는 와이파이 정보를 북마크로 저장할 때 사용되는 테이블로, 북마크 그룹과 함께 저장. <br>
이때, 북마크 정보들은 북마크 그룹과 연계되어 있기 때문에 북마크 그룹의 기본키를 외래키로 갖도록 설정해서, 북마크 그룹이 삭제되면, 해당 그룹 내에 포함
된 북마크들도 삭제되게 설정.
