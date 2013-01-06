<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Handsontable-SpringMVC Example</title>

    <script src="<c:url value='/resources/js/jquery-1.8.3.min.js' /> "></script>
    <script src="<c:url value='/resources/js/handsontable-0.7.5/dist/jquery.handsontable.full.js' /> "></script>
    <link rel="stylesheet" media="screen" href="<c:url value='/resources/js/handsontable-0.7.5/dist/jquery.handsontable.full.css' /> "/>

</head>
<body>
<h2>Handsontable/SpringMVC Example</h2>

<FORM ID="handsontableForm">
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

    Description:
    <INPUT ID="description" TYPE="TEXT" >
    <p></p>
    <INPUT ID="Submit" TYPE="SUBMIT" VALUE="Submit">
</FORM>

<hr>

<div style="text-align:left">
    <label id="serverResults"></label>
</div>
<img src="<c:url value='/resources/img/Button-Built-on-CB-1.png'/>" alt='Built on CloudBees' >
</body>

<script>
    $(document).ready(function () { // DOM hierarchy constructed. Ready to attach event handlers and run jQuery code etc.
        $("#Submit").click(function (e) {
            e.preventDefault();

            var tableData = $("#dataTable").handsontable("getData");
            var description = $('#description').val();
            var formDataJson = JSON.stringify({"description": description,  "data":tableData});
            jQuery.ajax({
                type: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'url': "processRequest",
                'data':  formDataJson,
                'dataType': 'json',
                'success': function (e) {
                    var resultString = 'The following data was returned from server:';
                    resultString += '<p>Description: ' + e.description+'</p>';
                    resultString += '<p>Data: </p>';
                    $.each(e.data, function(index, value) {
                        resultString += '<p>' + value+'</p>';
                    });
                    $('#serverResults').html(resultString);
                }
            });
        });
    });
</script>
</html>
