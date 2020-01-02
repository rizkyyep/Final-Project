<%-- 
    Document   : starttest
    Created on : Dec 30, 2019, 9:00:49 AM
    Author     : Rizky
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/>coba itung ulang</h1>
            <h3>
                <c:forEach var = "i" begin = "1" end = "5">
                    <c:set var="income" value="${random.nextInt(10)}"/>
                    <fmt:parseNumber var="a" integerOnly="true" 
                       type="number" value="${income}" />
                    Item <c:out value = "${i}"/><c:out value="${income}" /> <br>
                </c:forEach>
            </h3>

            <h4 id="countdown"></h4>
        </body>


        <script>
// Set the date we're counting down 
            var neww = new Date().getTime();
            var timeInMinutes = 1;
            var countDownDate = new Date(neww + timeInMinutes * 60 * 1000).getTime();


// Update the count down every 1 second
            var x = setInterval(function () {
                var now = new Date().getTime();
                // Get today's date and time

                // Find the distance between now and the count down date
                var distance = countDownDate - now;

                // Time calculations for days, hours, minutes and seconds
                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                // Output the result in an element with id="demo"
                document.getElementById("countdown").innerHTML = days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ";

                // If the count down is over, write some text 
                if (distance < 0) {
                    clearInterval(x);
                    window.location.href = "/psychotest";
//                    document.getElementById("countdown").innerHTML = "EXPIRED";
                }
            }, 1000);
        </script>
    </html>
</f:view>
