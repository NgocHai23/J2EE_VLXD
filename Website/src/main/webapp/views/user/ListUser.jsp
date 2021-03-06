<%@page import="vlxd.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>List Agency</title>
    <%@include file="../layouts/importstyle.jsp" %>
    <style>
        .hovermouse {
            cursor: -webkit-grab;
            cursor: grab;
            color: #007bff;
            text-decoration: underline;
        }

        .hovermouse:hover {
            color: #0056b3;
        }
    </style>
</head>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <%@include file="../layouts/navbar.jsp" %>
        <%@include file="../layouts/sidebar.jsp" %>

        <!-- content Add, List, Edit -->

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1 class="m-0 text-dark">List User</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">List User</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>

            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 connectedSortable ui-sortable">
                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="card-title">Project</h3>
                                </div>


                                <div class="card-body">
                                    <!-- <form role="form"> -->
                                    <div class="row">
                                        <div class="col-md-6 col-6" style="display: inline-flex; align-items: center">
                                            <a href="./GoPageCreateNewUserServlet">
                                                <Button type="button" class="btn  btn-primary float-right">Add New User</Button>
                                            </a>
                                        </div>
                                        <div class="col-md-6 col-6">
                                            <nav class="navbar navbar-light">
                                                <form class="form-inline" action="./ListUserServlet">
                                                    <input id="search" name="search"
                                                        class="form-control mr-sm-2" type="search" placeholder="id or name"
                                                        aria-label="Search">
                                                    <button class="btn btn-outline-success my-2 my-sm-0"
                                                        type="submit">Search</button>
                                                </form>
                                            </nav>
                                        </div>
                                    </div>
                                </div>

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="projectTable" class="table table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Username</th>
                                                    <th>Phone</th>
                                                    <th>Role</th>
                                                    <th>Created At</th>
                                                    <th>Updated At</th>
                                                    <th>Edit</th>
                                                    <th>Delete</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${users}" var="user">
                                                    <tr>
                                                        <td>${user.getId()}</td>
                                                        <td>${user.getName()}</td>
                                                        <td>${user.getEmail()}</td>
                                                        <td>${user.getUsername()}</td>
                                                        <td>${user.getPhone()}</td>
                                                        <td>${user.getRole()}</td>
                                                        <td>${user.getCreatedAt()}</td>
                                                        <td>${user.getUpdatedAt()}</td>
                                                        <td>
                                                            <a href="./GoPageEditUserServlet?id=${user.getId()}" type="button" class="btn btn-outline-info">Edit</a>
                                                        </td>
                                                        <td>
                                                            <a href="#" type="button" class="btn btn-outline-danger" onClick="deleteUser(${user.getId()})">Delete</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>

                                <div class="card-footer"></div>
                            </div>
                            <!-- /.card -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </div>
            </section>
            <!-- /.content -->

            <!-- confirm dialog-->
            <div class="modal fade" id="confirmDeleteAgency" tabindex="-1" role="dialog" aria-labelledby="modelLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form class="form" id="" action="./DeleteUserServlet" method="POST">
                            <div class="modal-header">
                                Confirm delete
                            </div>
                            <div id="confirmMessage" class="modal-body">
                                Do you want to delete this user ?
                            </div>
                            <input type="hidden" id="userId" name="userId" value="">
                            <div class="modal-footer">
                                <button type="submit" id="btnDelete" class="btn  btn-primary btn-outline-danger">
                                    Delete
                                </button>
                                <button type="button" id="btnCancel" class="btn btn-cancel" data-dismiss="modal">
                                    Cancel
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!-- end content Add, List, Edit -->

        <footer class="main-footer">
            <div class="float-right d-none d-sm-block-down">
                Anything you want
            </div>
            <strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.</strong> All rights reserved.
            <br>
        </footer>
    </div>

    <%@include file="../layouts/importscript.jsp" %>

    <script type="text/javascript">
        function deleteUser(id) {
            $('#userId').val(id);
            $("#confirmDeleteAgency").modal('show');
        }
    </script>


</body>

</html>