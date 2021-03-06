<%@page import="vlxd.dto.VendorDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>List Vendor</title>
<%@include file="../layouts/importstyle.jsp"%>
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
		<%@include file="../layouts/navbar.jsp"%>
		<%@include file="../layouts/sidebar.jsp"%>

		<!-- content Add, List, Edit -->

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">List Vendor</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Vendor List</li>
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
									<h3 class="card-title">Vendor</h3>
								</div>


								<div class="card-body">
									<!-- <form role="form"> -->
									<div class="row">
										<div class="col-md-6 col-6" style="display: inline-flex; align-items: center">
											<a href="./CreateNewVendorServlet">
												<Button type="button" class="btn  btn-primary float-right">Add
													New Vendor</Button>
											</a>
										</div>
										
										<div class="col-md-6 col-6">
											<nav class="navbar navbar-light">
												<form class="form-inline" action="./ListVendorServlet">
													<input id="searchy" name="search"
														class="form-control mr-sm-2" type="search"
														placeholder="id or name" aria-label="Search">
													<button class="btn btn-outline-success my-2 my-sm-0"
														type="submit">Search</button>
												</form>
											</nav>
										</div>
									</div>
									<!-- </form> -->
								</div>

								<div class="card-body">
									<div class="table-responsive">
										<table id="projectTable"
											class="table table-bordered table-hover">
											<thead>
												<tr>
													<th>Id</th>
                                                    <th>Name</th>
                                                    <th>Address</th>
                                                    <th>Phone</th>
                                                    <th>Email</th>
                                                    <th>Debt (VND)</th>
                                                    <th>Created At</th>
                                                    <th>Updated At</th>
                                                    <th>Edit</th>
                                                    <th>Delete</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${vendors}" var="vendor">
                                                    <tr>
                                                        <td>${vendor.getId()}</td>
                                                        <td>${vendor.getName()}</td>
                                                        <td>${vendor.getAddress()}</td>
                                                        <td>${vendor.getPhone()}</td>
                                                        <td>${vendor.getEmail()}</td>
                                                        <td class="currency">${vendor.getDebt()}</td>                                                        
                                                        <td>${vendor.getCreatedAt()}</td>
                                                        <td>${vendor.getUpdatedAt()}</td>
                                                        <td>
                                                            <a href="./GoPageEditVendorServlet?id=${vendor.getId()}" type="button" class="btn btn-outline-info">Edit</a>
                                                        </td>
                                                        <td>
                                                            <a href="#" type="button" class="btn btn-outline-danger" onClick="deleteVendor(${vendor.getId()})">Delete</a>
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
			<div class="modal fade" id="confirmDeleteVendor" tabindex="-1"
				role="dialog" aria-labelledby="modelLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<form class="form" id=""
							action="./DeleteVendorServlet"
							method="POST">
							<div class="modal-header">Confirm delete</div>
							<div id="confirmMessage" class="modal-body">Do you want to
								delete this vendor ?</div>
							<input type="hidden" id="vendorId" name="vendorId" value="">
							<div class="modal-footer">
								<button type="submit" id="btnDelete"
									class="btn  btn-primary btn-outline-danger">Delete</button>
								<button type="button" id="btnCancel" class="btn btn-cancel"
									data-dismiss="modal">Cancel</button>
							</div>
						</form>

					</div>
				</div>
			</div>

		</div>
		<!-- end content Add, List, Edit -->

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block-down">Anything you
				want</div>
			<strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.
			</strong> All rights reserved. <br>
		</footer>
	</div>

	<%@include file="../layouts/importscript.jsp"%>

	<script type="text/javascript">
		$(function () {
			$('.currency').each(function() {
				var currency = Number($(this).text());
				$(this).text(currency.toLocaleString('vi'));
			})
		});
		
        function deleteVendor(id) {
            $('#vendorId').val(id);
            $("#confirmDeleteVendor").modal('show');
        }
    </script>


</body>

</html>