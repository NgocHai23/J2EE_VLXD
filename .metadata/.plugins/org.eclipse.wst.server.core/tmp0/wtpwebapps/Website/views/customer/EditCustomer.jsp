<%@page import="vlxd.dto.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Edit Customer</title>
<%@include file="../layouts/importstyle.jsp"%>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<%@include file="../layouts/navbar.jsp"%>
		<%@include file="../layouts/sidebar.jsp"%>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Edit Customer</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="">Home</a></li>
								<li class="breadcrumb-item active">Edit</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card card-primary card-outline">
								<div class="card-header  d-flex p-0">
									<h3 class="card-title  p-3">Edit Customer</h3>
								</div>

								<div class="card-body">
									<form class="form" id="" action="./EditCustomerServlet" method="POST">
										<%
											CustomerDTO customer = (CustomerDTO) request.getAttribute("infoEditCustomer");
										%>

										<div class="row">
											<div class="col col-lg-2">
												<div class="input-group mb-3">
													<input id="id" name="id" type="hidden"
														value="<%=customer.getId()%>">
													<button type="button" class="btn btn-success">
														Customer Id <span class="badge badge-light"><%=customer.getId()%></span>
													</button>
												</div>
											</div>

											<div class="col-md-auto"></div>
											<div class="col"></div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Name</label>
													<div>
														<input id="name" name="name" type="text"
															class="form-control" value=" <%=customer.getName()%> "
															placeholder="   ">
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Address</label>
													<div>
														<input id="address" name="address" type="text"
															class="form-control" maxlength="255"
															value=" <%=customer.getAddress()%> " placeholder="  ">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Phone</label>
													<div>
														<input id="phone" name="phone" type="text"
															class="form-control" maxlength="255"
															value=" <%=customer.getPhone()%> " placeholder="  ">
													</div>
												</div>
											</div>
											<div class="col-md-2"></div>
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Email</label>
													<div>
														<input id="email" name="email" type="text"
															class="form-control" maxlength="255"
															value=" <%=customer.getEmail()%> " placeholder="  ">
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-5">
												<div class="form-group">
													<a href="">
														<button type="button" class="btn btn-outline-danger">Cancel</button>
													</a>
												</div>
											</div>
											<div class="col-md-2"></div>
											<div class="col-md-5 col-5">
												<button type="submit" class="btn  btn-primary">Update</button>
											</div>
										</div>
									</form>
									<!-- /.form -->
								</div>
								<!-- /.card-body -->

							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>


				</div>
			</section>





		</div>


		<footer class="main-footer">
			<!-- To the right -->
			<div class="float-right d-none d-sm-block-down">Anything you
				want</div>
			<!-- Default to the left -->
			<strong> &nbsp; Copyright &copy; 2020 <a href="#">QL-VLXD</a>.
			</strong> All rights reserved. <br>
		</footer>
	</div>

	<%@include file="../layouts/importscript.jsp"%>

	<script type="text/javascript">
		
	</script>


</body>

</html>