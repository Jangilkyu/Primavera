# **mypage**

- 마이페이지 기능
    - 내 정보 변경
    - 내가 작성한 글 확인
        - 작성글 리스트 확인
        - 디테일 페이지
        - 글 수정 및 삭제
    - 상품 올리기
    - 리뷰 올리기

<hr>

## **Web(mypage)**
<img src ="https://user-images.githubusercontent.com/69107255/111992240-87672980-8b58-11eb-8ab3-1d05706ee6eb.png">

# **회원정보 변경**

## **web**

- 회원 정보 화면
- css프레임워크는 materializecss을 적용해보았다.

## **MemberInfoAction**

- 일단 마이페이지에 경우 로그인이 안되어 있을 경우 이용 할 수 없다. 따라서 id session이 null아닌 회원만 들어올 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/111992463-cd23f200-8b58-11eb-8d0a-83bf1506fb6a.png">

<img src ="https://user-images.githubusercontent.com/69107255/111995096-e4181380-8b5b-11eb-9ac1-05c02fb9b883.png">

## **Service(MemberService.java)**

<img src ="https://user-images.githubusercontent.com/69107255/111993290-c8ac0900-8b59-11eb-9a91-798b44540547.png">

## **DAO**

- DAO를 통해 회원 아이디에 대한 모든 값을 리스트에 담았다.

<img src="https://user-images.githubusercontent.com/69107255/111993459-001ab580-8b5a-11eb-858d-b62d4036dbb0.png">

- 상태 유지 후 memberInfoUpdate.jsp로 이동한다.

<img src="https://user-images.githubusercontent.com/69107255/111995096-e4181380-8b5b-11eb-9ac1-05c02fb9b883.png">


- 상태 유지 한 값을 jsp에 뿌려서 값이 보이는 것을 확인 할 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/111992135-6acaf180-8b58-11eb-9ce9-3c8f6f9500b8.png">


# **내가 작성한 글 확인**

## Action(MemberWriteAction.java)

<img src ="https://user-images.githubusercontent.com/69107255/112021950-2863dd80-8b75-11eb-9659-7b826f7f8a9e.png">

## **Service**
* mywrite.jsp에 내가 등록 상품에 정보들을 가져오는 메소드

<img src ="https://user-images.githubusercontent.com/69107255/112023252-6ca3ad80-8b76-11eb-91bb-f7e6eeca634c.png">


## **DAO**

- member테이블에 회원번호와 상품에 회원번호를 참조하고 있는 products.m_no에 값이 같은 것에 상품 정보를 조회하고 그 값을 list를 통해 리턴 하고 있다.


<img src="https://user-images.githubusercontent.com/69107255/112023501-aaa0d180-8b76-11eb-87b7-34fbfe3d5f6e.png">

## **상태유지**

* 조회해온 회원이 작성한 글에 대한 list를 상태 유지 후 myWrite로 이동한다.

```java
    request.setAttribute("list", list);
	forward.setPath("myWrite.jsp");
```

**myWrite**

- 로그인한 아이디에 회원이 작성한 글에 대한 내용이 아래 이미지와 같은 내용을 myWrite.jsp에서 확인이 가능하다.

<img src ="https://user-images.githubusercontent.com/69107255/111996930-db284180-8b5d-11eb-8acf-8ca3f179958c.png">

**myDetailWrite**

쿼리스트링을 이용해 상품 제목을 클릭 시 상품번호에 대한 정보를 조회할 수 있다.

```sql
	pstmt = conn.prepareStatement("SELECT * FROM products WHERE no = ?");
```
<img src ="https://user-images.githubusercontent.com/69107255/111998468-5d653580-8b5f-11eb-9675-eab78483071e.png">

## 상품 수정

## **Action(ProductUpdateAction.java)**

- 사용자가 `글 수정`을 클릭 시 ProductUpdateAction로 가서 특정 한 상품에 대한 상품번호를 가지고 상품 정보를 DB에서 가져온다.

<img src ="https://user-images.githubusercontent.com/69107255/112098858-d60ed500-8be5-11eb-8f5f-fd1fee006125.png">

- 상태 유지 후 productUpdate.jsp로 이동한다.

<img src ="https://user-images.githubusercontent.com/69107255/112098722-9c3dce80-8be5-11eb-9239-89ed546ffe4e.png">

- 클릭 시 상품번호에 대한 값들이 상태유지한 list에 값으로 세팅되고 `SUBMIT`버튼 클릭 시 ProductUpdateProAction.java

<img src ="https://user-images.githubusercontent.com/69107255/112097542-8d561c80-8be3-11eb-98f2-6783263e5646.png">


## 상품 삭제



# **상품 올리기**

## **Action(ProductProAction.java)**

- ProductAction.java에서 productWrite.jsp페이지로 이동 시킨 후 아래 이미지 코드는 제출 시 상품을 등록하기 위한 코드이다.

<img src ="https://user-images.githubusercontent.com/69107255/112086169-14e56080-8bcf-11eb-9987-c40ba5c5e7e8.png">

## **Service**

- 상품을 추가해주는 메소드

<img src ="https://user-images.githubusercontent.com/69107255/112087391-36dfe280-8bd1-11eb-9780-dcfa41ee2b08.png">

## **DAO**

<img src="https://user-images.githubusercontent.com/69107255/112087460-56770b00-8bd1-11eb-8ed1-2abf1489ebe2.png">

<img src= "https://user-images.githubusercontent.com/69107255/112024893-fb64fa00-8b77-11eb-82ee-c1aa2c48954a.png">

# **리뷰 올리기**

리뷰 올리기 위해서 사용자가 GET방식으로 `ReviewUploadAction.java` setpath(/views/reviewupload.jsp)로 이동 후 아래 와 같은 `리뷰 올리기`페이지로 이동하게 된다.

<img src ="https://user-images.githubusercontent.com/69107255/112089584-49f4b180-8bd5-11eb-8d95-193b490b59f2.png">


## Action(ReviewUploadProAction.java)

사용자가 글을 작성 후 **SUBMIT**버튼을 클릭 Controller에서 `reviewUploadPro.do`매핑을 해서 ReviewUploadProAction.java로 이동해 아래 코드를 실행한다.

    VO 저장 시 
	reviewVo.setM_no(service.getMemberNo(id));에는 고객에 회원번호를 저장한다.

<img src ="https://user-images.githubusercontent.com/69107255/112090950-cd170700-8bd7-11eb-91d2-d2b940cff7f3.png">

## **Service**

<img src ="https://user-images.githubusercontent.com/69107255/112091418-a86f5f00-8bd8-11eb-8ce9-dbc06720b942.png">


## **DAO**

클라이언트가 등록하려는 정보를 저장한다.

<img src ="https://user-images.githubusercontent.com/69107255/112093570-0140f680-8bdd-11eb-819d-34ea90c7c60a.png">


글이 정상적으로 작성이 되었다면, 메인화면으로 이동한다.

<img src ="https://user-images.githubusercontent.com/69107255/112093716-4ebd6380-8bdd-11eb-89e4-8ea0d7ed98a3.png">