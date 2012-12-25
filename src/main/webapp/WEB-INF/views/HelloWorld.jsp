<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>YSpring MVC Example</title>

    <script src="<c:url value='/resources/js/jquery-1.8.3.min.js' /> "></script>
    <script src="<c:url value='/resources/js/handsontable-0.7.5/dist/jquery.handsontable.full.js' /> "></script>
    <link rel="stylesheet" media="screen" href="<c:url value='/resources/js/handsontable-0.7.5/dist/jquery.handsontable.full.css' /> "/>

</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:choose>
    <c:when test="${msg==null || msg==''}">
        <c:set var="greeting" value="World" scope="page" />
    </c:when>
    <c:otherwise>
        <c:set var="greeting" value="${msg}" scope="page" />
    </c:otherwise>
</c:choose>

<div style="text-align:center">Hello ${greeting}!</div>
<br>



<FORM ID="SHAUNFORM"  ACTION="${contextPath}/HelloWorld">
    <div id="dataTable"></div>
    <script>
        var data = [
            ["", "Kia", "Nissan", "Toyota", "Honda"],
            ["2008", 10, 11, 12, 13],
            ["2009", 20, 11, 14, 13],
            ["2010", 30, 15, 12, 13]
        ];
        $("#dataTable").handsontable({
            data: data,
            startRows: 6,
            startCols: 8
        });
    </script>

    Enter greeting recipient...:
    <INPUT ID="msg"  NAME="msg" TYPE="TEXT" value="${msg}">
    <p></p>
    <INPUT ID="Submit" TYPE="SUBMIT" VALUE="Submit">
</FORM>

<hr>

<div style="text-align:left">
    <label id="jsGreeting"></label>
</div>

</body>

<script>
    $(document).ready(function () { // DOM hierarchy constructed. Ready to attach event handlers and run jQuery code etc.
        $("#Submit").click(function (e) {
            console.log("Form submitted");
            e.preventDefault();

            var serForm = $("#SHAUNFORM").serialize();
            console.log("serForm=", serForm);

            var tableData = $("#dataTable").handsontable("getData");
            console.log("tableData=", tableData);
//            var tableDataSerialized = tableData.serialize();
//            console.log("tableDataSerialized=", tableDataSerialized);

//            var tableDataSerialized = tableData.serializeArray();
//            console.log("tableDataSerialized=", tableDataSerialized);

//            var tableDataSerialized = tableData.param();
//            console.log("tableDataSerialized=", tableDataSerialized);

//            var tableDataSerialized = $("#dataTable").serialize();
//            console.log("tableDataSerialized=", tableDataSerialized);

            var tableDataJson = JSON.stringify(tableData);
            console.log("tableDataJson=", tableDataJson);

            var msg = $("#msg").val();
            var formValues = jQuery.param(msg);
            console.log("formValues=" + formValues);
            var jsonStr = '  "user":{"name":"'+msg + '"}  '
//                    + "&"
//                    + "education=education" + "&"
//                    + "tableData=" + tableDataJson
;
            console.log("jsonStr=" + jsonStr);
            $.post("jsontest", jsonStr, function (e) {
                console.log('AJAX post returned ', e);
            });
            console.log("AJAX post done");

//document.getElementById('xls').value = tableDataJson;
//$(this).closest("form").submit();
        });
    });
</script>
</html>
