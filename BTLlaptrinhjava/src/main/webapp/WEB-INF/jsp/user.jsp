<%-- 
    Document   : user
    Created on : Feb 15, 2022, 10:23:06 AM
    Author     : Hau Exoty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>


<!-- Content -->
<div class="container-xxl">
    <div class="row">
        <!-- Main Content -->
        <div class="col-12 col-lg-10">
            <session>
                <!-- User && Map -->
                <div class="row mt-3 mt-md-4">
                    <div class="col-12 col-sm-6 mb-3">
                        <div>
                            <div class="row mb-2 mb-md-3">
                                <div class="col-5">
                                    <img
                                        src="${user.avatar}"
                                        class="
                                        img-fluid
                                        rounded
                                        h-100
                                        w-100
                                        object-fit-cover
                                        "
                                        alt=""
                                        />
                                </div>
                                <div class="col-7">
                                    <div class="">
                                        <h3 class="fs-3 fw-bold">
                                            ${user.firstName} ${user.lastName}
                                        </h3>
                                        <p class="card-text"></p>
                                        <p class="mb-0">
                                            <i
                                                class="fas fa-star fs-5"
                                                style="color: #0aa2c0"
                                                ></i>
                                            <i
                                                class="fas fa-star fs-5"
                                                style="color: #0aa2c0"
                                                ></i>
                                            <i
                                                class="fas fa-star fs-5"
                                                style="color: #0aa2c0"
                                                ></i>
                                            <i
                                                class="fas fa-star fs-5"
                                                style="color: #0aa2c0"
                                                ></i>
                                            <i
                                                class="far fa-star fs-5"
                                                style="color: #0aa2c0"
                                                ></i>
                                            <a href="#user-detail" class="ms-2">
                                                <span>74 Reviews</span>
                                            </a>
                                        </p>
                                        <p class="fs-4 fw-normal mb-0">
                                            1,286 Followers
                                        </p>
                                    </div>
                                </div>
                            </div>  
                            <c:if test="${currentUser != null && currentUser.id != user.id}">
                                <div class="row">
                                    <div class="col-5">
                                        <button
                                            type="button"
                                            class="btn rounded-0 w-100"
                                            style="
                                            color: #0aa2c0;
                                            background-color: white;
                                            border: 1px solid #0aa2c0;
                                            "
                                            >
                                            ?????t c??u h???i
                                        </button>
                                    </div>
                                    <div class="col-7">
                                        <button
                                            type="button"
                                            class="btn rounded-0 w-100"
                                            style="
                                            background-color: #0aa2c0;
                                            color: white;
                                            "
                                            id="btn-report"
                                            role="button" data-bs-toggle="modal" data-bs-target="#reportModal" onclick="showReport(${user.id})"
                                            >
                                            <i
                                                class="fas fa-exclamation-circle"
                                                style="color: white"
                                                ></i>
                                            <span class="fs-6">B??o c??o</span>
                                        </button>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <c:if test="${user.address != null}">
                        <div class="col-12 col-sm-6 mb-3">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div style="height: 300px">
                                        <iframe
                                            width="100%"
                                            height="100%"
                                            style="border: 0"
                                            allowfullscreen=""
                                            loading="lazy"
                                            src="https://www.google.com/maps/embed/v1/search?q=${user.address}&key=API_KEY">
                                        </iframe>
                                    </div>
                                    <div class="">
                                        <div class="card-body">
                                            <h5 class="card-title">
                                                ${currentUser.address}
                                            </h5>
                                            <div
                                                class="
                                                d-flex
                                                justify-content-between
                                                "
                                                >
                                                <p class="card-text">
                                                    S??? ??i???n tho???i: ${user.phone}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
                <!-- End User && Map  -->

                <!-- Navigate -->
                <div class="flex-column" style="display: inherit">
                    <div
                        class="position-lg-sticky"
                        style="
                        top: 78px;
                        background-color: #ffffff;
                        z-index: 1039;
                        "
                        >
                        <div class="d-flex border-bottom border-1 border-gray">
                            <div class="">
                                <a
                                    href="#auction"
                                    class="
                                    text-dark
                                    fs-4
                                    text-decoration-none
                                    me-2 me-md-4
                                    "
                                    >?????u gi??</a
                                >
                                <a
                                    href="#review"
                                    class="
                                    text-dark
                                    fs-4
                                    text-decoration-none
                                    me-2 me-md-4
                                    "
                                    >????nh gi??</a
                                >
                                <a
                                    href="#auction-finish"
                                    class="
                                    text-dark
                                    fs-4
                                    text-decoration-none
                                    me-2 me-md-4
                                    "
                                    >?????u gi?? ???? ho??n th??nh</a
                                >
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Navitgate -->

                <!-- List Auction  -->
                <div
                    class="
                    d-flex
                    flex-row flex-wrap
                    d-md-block
                    mt-3
                    position-relative
                    "
                    >
                    <div
                        id="auction"
                        class="position-absolute"
                        style="top: -87px"
                        ></div>
                    <h2 class="fs-2 pt-md-4 mt-3">?????u gi??</h2>
                    <c:forEach items="${auctions}" var="auction" >
                        <c:if test="${auction.acceptPrice == null}">
                            <div
                                class="
                                item-auction
                                row
                                m-0
                                flex-column flex-md-row
                                pb-3
                                shadow-sm
                                "
                                >
                                <div
                                    class="
                                    col-md-5
                                    p-0
                                    mt-3
                                    position-relative
                                    z-index-1
                                    "
                                    >
                                    <div
                                        href="javascript:;"
                                        class="d-block wrap-item-image"
                                        >
                                        <img
                                            src="${auction.images.iterator().next().image}"
                                            class="
                                            object-fit-cover
                                            h-100
                                            w-100
                                            rounded rounded-3
                                            "
                                            width="100%"
                                            />
                                    </div>
                                </div>
                                <div class="col-md-5 pt-3">
                                    <a href="<c:url value='/auction/${auction.id}' />" class="text-dark h5 d-block">
                                        ${auction.title}
                                    </a>
                                    <p class="mb-2">
                                        ${auction.content}
                                    </p>
                                </div>
                                <div class="col-md-2 pt-md-3">
                                    <div
                                        class="
                                        mb-0
                                        d-flex d-md-block
                                        justify-content-between
                                        "
                                        >
                                        <small class="text-muted"
                                               >Started ${auction.createAt}</small
                                        >
                                        <p class="mb-0 my-md-3">
                                            <span style="color: #dc3545" class="time-left"
                                                  >${auction.deadline}</span
                                            >
                                        </p>
                                    </div>
                                    <a
                                        type="button"
                                        href="<c:url value='/auction/${auction.id}' />"
                                        class="btn rounded-0 w-100 d-none d-md-block"
                                        style="background-color: #0aa2c0; color: white"
                                        >
                                        <span class="fs-6">Chi ti???t</span>
                                    </a>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!-- End List Auction  -->

                <!-- Review  -->
                <div class="overview-review mt-3 position-relative">
                    <div
                        id="review"
                        class="position-absolute"
                        style="top: -87px"
                        ></div>
                    <h2 class="fs-2 mt-3 pt-md-4">????nh gi??</h2>
                    <!--                    <div
                                            class="
                                            d-flex
                                            align-items-center
                                            flex-column flex-sm-row
                                            "
                                            >
                                            <div
                                                class="
                                                left
                                                d-flex
                                                flex-column
                                                justify-content-center
                                                "
                                                >
                                                <div class="star">
                                                    <i
                                                        class="fas fa-star fs-5"
                                                        style="color: #0aa2c0"
                                                        ></i>
                                                    <i
                                                        class="fas fa-star fs-5"
                                                        style="color: #0aa2c0"
                                                        ></i>
                                                    <i
                                                        class="fas fa-star fs-5"
                                                        style="color: #0aa2c0"
                                                        ></i>
                                                    <i
                                                        class="fas fa-star fs-5"
                                                        style="color: #0aa2c0"
                                                        ></i>
                                                    <i
                                                        class="far fa-star fs-5"
                                                        style="color: #0aa2c0"
                                                        ></i>
                                                </div>
                                                <p class="text-gray mb-0">4.5 out of 5.0 Stars</p>
                                            </div>
                                            <div class="right ms-3 ms-md-5">
                                                <div class="d-flex align-items-center my-1 my-md-2">
                                                    <span class="me-2 me-md-4">5 Star</span>
                                                    <div
                                                        class="progress"
                                                        style="width: 200px; height: 10px"
                                                        >
                                                        <div
                                                            class="progress-bar"
                                                            role="progressbar"
                                                            style="width: 85%"
                                                            aria-valuenow="85"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                    <span class="ms-2 ms-md-4"> 85% (85) </span>
                                                </div>
                                                <div class="d-flex align-items-center my-1 my-md-2">
                                                    <span class="me-2 me-md-4">4 Star</span>
                                                    <div
                                                        class="progress"
                                                        style="width: 200px; height: 10px"
                                                        >
                                                        <div
                                                            class="progress-bar"
                                                            role="progressbar"
                                                            style="width: 10%"
                                                            aria-valuenow="10"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                    <span class="ms-2 ms-md-4"> 10% (10) </span>
                                                </div>
                                                <div class="d-flex align-items-center my-1 my-md-2">
                                                    <span class="me-2 me-md-4">3 Star</span>
                                                    <div
                                                        class="progress"
                                                        style="width: 200px; height: 10px"
                                                        >
                                                        <div
                                                            class="progress-bar"
                                                            role="progressbar"
                                                            style="width: 5%"
                                                            aria-valuenow="5"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                    <span class="ms-2 ms-md-4"> 5% (5) </span>
                                                </div>
                                                <div class="d-flex align-items-center my-1 my-md-2">
                                                    <span class="me-2 me-md-4">2 Star</span>
                                                    <div
                                                        class="progress"
                                                        style="width: 200px; height: 10px"
                                                        >
                                                        <div
                                                            class="progress-bar"
                                                            role="progressbar"
                                                            style="width: 0%"
                                                            aria-valuenow="0"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                    <span class="ms-2 ms-md-4"> 0% (0) </span>
                                                </div>
                                                <div class="d-flex align-items-center my-1 my-md-2">
                                                    <span class="me-2 me-md-4">1 Star</span>
                                                    <div
                                                        class="progress"
                                                        style="width: 200px; height: 10px"
                                                        >
                                                        <div
                                                            class="progress-bar"
                                                            role="progressbar"
                                                            style="width: 0%"
                                                            aria-valuenow="0"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                    <span class="ms-2 ms-md-4"> 0% (0) </span>
                                                </div>
                                            </div>
                                        </div>-->

                    <!-- List review -->
                    <div class="list-review mt-2 mt-md-3 mt-lg-4">
                        <c:if test="${ratings != null && ratings.size()!= 0}">
                            <c:forEach items="${ratings}" var="rating">
                                <div class="item-review row mb-2 mb-md-3">
                                    <div class="col-10 d-flex align-items-start">
                                        <div style="flex: 2">
                                            <h4 class="fs-4 mb-0">
                                                ${rating.user.firstName} ${rating.user.lastName}
                                                <i
                                                    class="fas fa-check-circle fs-6"
                                                    style="color: #0aa2c0"
                                                    ></i>
                                            </h4>
                                            <p class="m-0">Binh Phuoc, VN</p>
                                        </div>
                                        <div class="content mt-2" style="flex: 6">
                                            <div class="d-flex align-items-center">
                                                <div class="star star-review" data-star="${rating.star}">
                                                </div>
                                                <span class="date ms-2 ms-md-3 time-feed">${rating.createAt}</span>
                                            </div>
                                            <p class="fs-6">
                                                ${rating.content}
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-2 image-review">
                                        <img
                                            src="${rating.user.avatar}"
                                            alt=""
                                            class="object-fit-cover"
                                            />
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>

                        <script>
                            let starEles = document.getElementsByClassName("star-review");
                            for (let starEle of starEles) {
                                let star = parseInt(starEle.getAttribute("data-star"));
                                let unstar = 5 - star;
                                let content = "";

                                for (let i = 1; i <= star; i++) {
                                    content += `<i class="fas fa-star fs-6" style="color: #0aa2c0"></i>`;
                                }
                                for (let i = 1; i <= unstar; i++) {
                                    content += `<i class="far fa-star fs-6" style="color: #0aa2c0"></i>`;
                                }
                                starEle.innerHTML = content;
                            }
                        </script>
                    </div>
                    <!-- End List review -->
                </div>
                <!-- End Review -->

                <!-- Auction Finish -->
                <div class="auction-finish mt-3 position-relative">
                    <div
                        id="auction-finish"
                        class="position-absolute"
                        style="top: -87px"
                        ></div>
                    <h2 class="fs-2 mt-3 pt-md-4">?????u gi?? ???? ho??n th??nh</h2>
                    <div class="d-flex flex-wrap">
                        <c:forEach items="${auctions}" var="auction" >
                            <c:if test="${auction.acceptPrice != null}">
                                <div class="card position-relative border-0 m-2" style="width: 30%; box-sizing: border-box;">
                                    <c:if test="${auction.images != null && auction.images.size() > 0}">
                                        <img
                                            src="${auction.images.iterator().next().image}"
                                            class="card-img-top object-fit-cover w-100"
                                            height="300"
                                            />
                                    </c:if>
                                    <div class="card-body p-0">
                                        <div
                                            class="
                                            top-info-item
                                            d-flex
                                            justify-content-between
                                            "
                                            >
                                            <p class="mb-0">
                                                <span style="color: #dc3545"
                                                      >10 Hrs Left</span
                                                >
                                            </p>
                                            <a class="mb-0" href="<c:url value="/user/${auction.user.id}" />">
                                                ${auction.user.firstName} ${auction.user.lastName}
                                            </a>
                                        </div>
                                        <div class="my-0 my-sm-1 my-md-2">
                                            <h4
                                                class="
                                                m-0
                                                d-inline-block
                                                text-uppercase text-xs
                                                font-weight-bold
                                                "
                                                >
                                                ${auction.basePrice}
                                            </h4>
                                            <small class="text-capitalize">(${auction.countComment} bids)</small>
                                        </div>
                                        <a
                                            href="<c:url value="/auction/${auction.id}" />"
                                            class="text-dark fs-5 fs-md-4 d-block"
                                            >
                                            ${auction.title}
                                        </a>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <!-- End Auction Finish -->
            </session>
        </div>
        <!-- End Main Content  -->

        <!-- Notification -->
        <div class="col-lg-2 p-0 flex-column" style="display: inherit;">
            <div class="position-lg-sticky" style="top: 78px;">
                <div class="d-none d-lg-flex justify-content-between px-2 mt-lg-3">
                    <h4 class="text-center">Th??ng b??o</h4>
                </div>
                <c:if test="${currentUser != null && notifications != null && notifications.size() != 0}">
                    <ul id="notification-content" class="w-100 list-group cus-content-friends list-group-flush d-flex flex-row flex-lg-column overflow-auto pb-2" style="top: 101px;" >
                        <c:forEach items="${notifications}" var="message">
                            <li class="list-group-item-none shadow-sm border border-1 p-2">
                                <div class="d-flex justify-content-between">
                                    <a class="fs-6 mb-0" style="white-space: nowrap;overflow: hidden;" href="${message.url != null ? message.url : 'javascript::'}">
                                        ${message.title}
                                    </a>

                                </div>

                                <p class="mb-0 text-muted" style="white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">
                                    ${message.content}
                                </p>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
        <!-- End Notification -->
    </div>
</div>
<!-- End Content -->



<!--Modal report-->
<c:if test="${currentUser != null && typeReports != null}">
    <div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-body p-0 position-relative">
                    <button type="button" class="btn-close position-absolute top-0 end-0 z-index-2000 p-3" data-bs-dismiss="modal" aria-label="Close"></button>
                    <div class="card m-0 w-100 border-0">
                        <div class="card-body my-3">
                            <h3 class="mb-2 mb-md-3 m-auto">B??o c??o</h3>
                            <form id="form-report" name="form-report">
                                <div class="textInvalidForm" id="errorMessageReport">

                                </div>
                                <select class="form-select mb-md-3 mb-2" name="typeReportId" id="typeReportId" required>
                                    <option selected value="${typeReports[0].id}">${typeReports[0].name}</option>
                                    <c:forEach items="${typeReports}" var="typeReport" begin="1" >
                                        <option value="${typeReport.id}">${typeReport.name}</option>
                                    </c:forEach>
                                </select>
                                <div class="mb-2 mb-md-3">
                                    <textarea class="form-control w-100"
                                              name="content"
                                              id="content"
                                              placeholder="N???i dung b??o c??o"
                                              required
                                              rows="3"
                                              ></textarea>
                                </div>

                                <button type="submit" class="btn btn-primary text-uppercase w-100 mt-3">G???i</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        document.querySelector("#form-report button[type='submit']")
                .addEventListener("click", function (event) {
                    event.preventDefault();
                    let reportModal = document.getElementById("reportModal");
                    let myForm = document.getElementById('form-report');
                    let formData = new FormData(myForm);
                    if (!formData.get("content")) {
                        document.getElementById("errorMessageReport").textContent = "Vui l??ng ??i???n n???i dung"
                        return;
                    }
                    let url = "/laptrinhjava/api/add-report/" + myForm.getAttribute('data-user-report-id');
                    let body = JSON.stringify(Object.fromEntries(formData));
                    fetch(url, {
                        method: "post",
                        body,
                        headers: {
                            "Content-Type": "application/json"
                        }
                    }).then((response) => {
                        if (response.status !== 200) {
                            document.getElementById("errorMessageReport").textContent = "???? c?? l???i x???y ra vui l??ng th??? l???i"
                        }
                        bootstrap.Modal.getInstance(document.getElementById('reportModal')).hide();
                        document.getElementById("btn-report").textContent = "???? g???i b??o c??o"
                        document.getElementById("btn-report").setAttribute("disabled", "true")
                    })
                });
    </script>
</c:if>
<!--End Modal report-->
