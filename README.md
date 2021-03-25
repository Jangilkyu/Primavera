# Primavera(청춘)

### JSP로 프로젝트를 하게 된 계기는?

국비지원 수료가 두달 앞으로 다가왔을 시점 강사님이 바뀌게 되는 상황이 발생하게 되었습니다. JSP는 다른 강사님께 배우게 됨으로써 MVC1으로 팀프로젝트가 진행이 되어야하지만 무산이 되었습니다.
새로오신 강사님께 MVC1과 MVC2에 차이점을 배우면서 자신감이 생겼고, MVC2방식을 조금 더 공부해보고 싶어서 개인적으로 프로젝트를 시작하게 되었습니다.
간단하게 `사진형 게시판`과 `리뷰 게시판` 그리고 마이페이지를 만들어서 `회원 정보 수정` 및 `글 수정 및 삭제`기능 정도만 생각하고 구현을 하였는데 백지에서 front단 부터 back단까지 혼자서 고민하고 구글링하면서 구현하였습니다.


## **프로젝트의 구조**
<img src ="https://user-images.githubusercontent.com/69107255/111952980-4c013680-8b29-11eb-8c4f-f9635482ea2f.png">


1. session을 이용한 로그인 및 회원가입

## 🗃️ 디렉토리 구조

```shell
📁 src
├── 📁com.primavera.www.action
│   ├── 📄HomeAction.java
├── 📁com.primavera.www.board
│   ├── 📄ProductAction.java
│   ├── 📄ProductDeleteAction.java
│   ├── 📄ProductListAction.java
│   ├── 📄ProductListProAction.java
│   ├── 📄ProductProAction.java
│   ├── 📄ProductUpdateAction.java
│   ├── 📄ProductUpdateProAction.java
├── 📁com.primavera.www.common
│   ├── 📄Action.java
│   ├── 📄ActionForward.java
│   ├── 📄JdbcUtil.java
│   ├── 📄LoginSessionListener.java
├── 📁com.primavera.www.dao
│   ├── 📄AjaxCheckIdAction.java
│   ├── 📄JoinAction.java
│   ├── 📄LoginProAction.java
│   ├── 📄LogoutAction.java
│   ├── 📄MemberInfoAction.java
│   ├── 📄MemberInfoProcAction.java
│   ├── 📄MemberJoinProcAction.java
│   ├── 📄MemberWriteAction.java
│   ├── 📄MyDetailWriteAction.java
│   ├── 📄myPagePro.java
├── 📁com.primavera.www.review
│   ├── 📄ReviewDetailAction.java
│   ├── 📄ReviewListAction.java
│   ├── 📄ReviewUploadAction.java
│   ├── 📄ReviewUploadProAction.java
├── 📁com.primavera.www.service
│   ├── 📄MemberService.java
│   ├── 📄ProductService.java
│   ├── 📄ReviewService.java
├── 📁com.primavera.www.MemberVo
│   ├── 📄MemberVo.java
│   ├── 📄ProductVo.java
│   ├── 📄ReviewVo.java
│
📁web
├── 📁ajax
│   ├── 📄AjaxCheckJoin.jsp
│   ├── 📁board
├── 📁css
│   ├── 📄AjaxCheckJoin.jsp
│   ├── 📄reivew.css
│   ├── 📄reviewupload.css
│   ├── 📄style.css
│   ├── 📄write.css
├── 📁img
│   ├── 📄img1.jpg
│   ├── 📄img2.jpg
│   ├── 📄img3.jpg
├── 📁META-INF
└── 📁views
│   ├── 📁goods
│   ├── 📁upload
│   ├── 📄index.jsp
│   ├── 📄join.jsp
│   ├── 📄memberInfoUpdate.jsp
│   ├── 📄myDetailWrite.jsp
│   ├── 📄myPage.jsp
│   ├── 📄productDetailList.jsp
│   ├── 📄productList.jsp
│   ├── 📄productUpdate.jsp
│   ├── 📄productWrite.jsp
│   ├── 📄reviewDetail.jsp
│   ├── 📄reviewList.jsp
│   ├── 📄reviewDetail.jsp
│   ├── 📄reviewupload.jsp
│   ├── 📄start.jsp
│
📁WEB-INF
├── 📁lib
│   ├── 💊activation.jar
│   ├── 💊cos.jar
│   ├── 💊jstl.jar
│   ├── 💊ojdbc8.jar
├── 📄web.xml
```