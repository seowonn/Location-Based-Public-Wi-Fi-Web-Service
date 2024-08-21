## 📡 Public Wi-Fi Information Service Based on User Location
### : 나의 위치를 기반으로 주변 와이파이 정보 보여주기

#

## ⭐ 프로젝트 소개 
* 진행 동기 : 학습한 Java, JSP, DB 활용 역량을 복습하고 프로젝트로 진행해보고자 진행하였습니다.
* 소개 : 사용자의 위치를 기반으로, 주변의 와이파이 정보를 제공하는 웹서비스를 개발하였습니다.
* 개발 기간 : 2024.01.02 ~ 2024.01.15 (2주)
* 프로젝트 주요 목표
    * 외부 데이터 연동을 위한 OpenAPI 활용
    * JDBC 이해 및 DB 연동을 하여 CRUD(INSERT, SELECT, UPDATE, DELETE) 기능 구현
    * Dynamic 웹 프로젝트를 생성하고 JSP를 활용하여 웹페이지 개발

#
## ⚙️ 활용 기술 스택
<img src="https://img.shields.io/badge/sqlite-003B57?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=springsecurity&logoColor=white">
#

## 구성 ERD
![손서원_ERD파일](https://github.com/seowonn/mini_web_project/assets/144876148/2bb5a49c-d045-4082-959a-3af62ef58c84)
# 
* seoul_wifi 테이블 : 서울시 공공 와이파이 open api에 저장된 와이파이 정보를 저장
* search_history 테이블 : 근처 와이파이 보기 버튼을 눌렀을 때, 사용된 LAT, LNT 정보 기록을 저장<br>
* bookmark_group 테이블 : 북마크들을 하나의 그룹을 묶어서 보기 위해, 그룹 정보를 저장하는 테이블<br>
* bookmarked_wifi 테이블 : 원하는 와이파이 정보를 북마크로 저장할 때 사용되는 테이블로, 북마크 그룹과 함께 저장. <br>
이때, 북마크 정보들은 북마크 그룹과 연계되어 있기 때문에 북마크 그룹의 기본키를 외래키로 갖도록 설정해서, 북마크 그룹이 삭제되면, 해당 그룹 내에 포함
된 북마크들도 삭제되게 설정.

<br>

## 📍 주요 기능 및 화면 설계
[기능사항]
- [x] 서울시 공공와이파이 오픈 API를 활용하여 공공 와이파이 정보를 가져온다. 
- [x] 내 위치 정보를 입력하면 가까운 위치에 있는 와이파이 정보 20개를 보여준다.
- [x] 와이파이 클릭 시 상세 정보를 조회할 수 있다. 
- [x] 위치 기반 정보 조회 시 해당 데이터를 DB에 저장한다.
- [x] 조회 기록 열람을 통해 검색 기록을 DB에서 가져와 히스토리를 보여준다.
- [x] 와이파이 정보에 대한 북마크를 추가하여 따로 볼 수 있다.
- [x] 와이파이 북마크 내역은 그룹 단위로 관리되고 북마크 그룹은 추가, 조회, 수정, 삭제 가능하다.
- [x] 와이파이를 북마크에 추가 및 삭제할 수 있다.


## 구현 과정 정리
* https://boardmix.com/app/share/CAE.CJWgDCABKhBg16KiP-aI4mSlpNbj3SyXMAZAAQ/m8S0Sa，

<h4>활용 데이터 리소스 출처</h4>
- 서울시 공공와이파이 서비스 위치 정보 API 활용 

<h3>데모 영상</h3>
[손서원_내주변와이파이검색.zip](https://github.com/seowonn/mini_web_project/files/13936608/_mission1_.zip)
