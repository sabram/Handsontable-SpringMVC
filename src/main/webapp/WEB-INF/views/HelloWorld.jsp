<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spring MVC Example.</title>

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

<div style="text-align:center">-Hello ${greeting}!</div>
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

//            $.post("jsontest1", "msg=msg", function (e) {
//                console.log('AJAX post returned ', e);
//            });

//            $.post("jsontest2", "msg1=msg1&msg2=msg2", function (e) {
//                console.log('AJAX post returned ', e);
//            });


//            $.post("jsontest3",
//                    {  msg1:  'msg1' },
//                    function (e) {
//                console.log('AJAX post returned ', e);
//            });


            //none of the following work:
            //  data: {"name": "name"},
            //  data: {"user":{"name": "name"}},
            //  data: {user:{name: "name"}},
            //work against
            //  public String jsontest4(@RequestBody Object user) {
            //or
            //  public String jsontest4(@RequestParam("user") User user) {
//            $.ajax({
//                type: "POST",
////                contentType: "application/json; charset=utf-8",
//                url:  "jsontest4.json",
//                data: {a:"a" },
////                dataType: "json",
//                error: function(data){
//                    alert("fail", data);
//                },
//                success: function(data){
//                    alert("success", data);
//                }
//            });

            //This jsontest5 doesn't work to:
//            @RequestMapping(value = "/jsontest5", method = RequestMethod.POST)
//            public String jsontest5(@RequestParam(value="a", required=false) String a,
//                            @RequestParam(value="b", required=false) Object[] b) {
//            $.post("jsontest5",
//                    {  a:  'a' ,
//                    b : [["","Kia"],["2008","10"]] },
//                    function (e) {
//                console.log('AJAX post returned ', e);
//            });

//            $.post("jsontest6",
//                    'a=[["","Kia"],["2008","10"]]',
//                    function (e) {
//                        console.log('AJAX post returned ', e);
//                    });

            var shaundata = JSON.stringify({ "left": 13 , "right" : 7, "a": [["a"],["b"]] });
//            var ddd = JSON.stringify({"left":13,"right":7,"a":tableData});
            var ddd = JSON.stringify({"left":13,"right":7,"a":["a", "b"], "b":tableData});
            console.log("shaundata", shaundata);
            console.log("ddd", ddd);
            jQuery.ajax({
                type: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'url': "jsontest7",
                'data':  ddd,
                'dataType': 'json',
                'success': function (e) {
                    console.log('AJAX post returned ', e);
                }
            });

            console.log("AJAX post done");

//document.getElementById('xls').value = tableDataJson;
//$(this).closest("form").submit();
        });
    });
</script>
</html>
