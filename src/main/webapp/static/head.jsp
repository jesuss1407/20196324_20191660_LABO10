<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/zombie-16.ico" type="image/x-icon">
    <title><%=request.getParameter("title")%>
    </title>
    <style>
        body {
            background-image: url("fondo.jpg");
        }

        .container {
            padding-right: 0 !important;
            padding-left: 0 !important;
        }

        .titlecolor {
            background: linear-gradient(0deg, #1d1d1d 0%, #525252 130%);
        }

        .navbar {
            padding-left: 20px !important;
            padding-right: 20px !important;
            background-color: rgba(6, 21, 122, 0.94) !important;
        }

        .table-transparent {
            background-color: #343a4000 !important
        }

        .tabla {
            background-color: #1d1d1d;
            padding-left: 30px;
            padding-right: 30px;
            padding-bottom: 50px;
            padding-top: 40px;
        }

        thead {
            border-top: hidden;
            font-size: 14px;
        }

        .table td {
            padding: 0.5rem;
            font-weight: 500;
        }

        .table th {
            padding: 0.5rem;
            font-weight: 100;
        }

        .fila-red {
            background-color: #ba49498c;
        }

        .fila-blue {
            background-color: #2441ac8c;
        }

        .fila-purple {
            background-color: #a4219a8c;
        }

        .fila-yellow {
            background-color: #f0e01f91;
        }


    </style>

</head>