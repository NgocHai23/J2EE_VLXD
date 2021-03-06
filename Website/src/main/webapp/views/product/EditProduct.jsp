<%@page import="vlxd.dto.CategoryDTO"%>
<%@page import="vlxd.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Edit Agency</title>
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
							<h1>Edit Agency</h1>
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
									<h3 class="card-title  p-3">Edit Agency</h3>
								</div>

								<div class="card-body">
									<form class="form" id=""
										action="./EditProductServlet"
										method="POST">
										<%
											ProductDTO product = (ProductDTO) request.getAttribute("infoEditProduct");
										%>
										<c:set var="product" value="<%=product %>" />
										<div class="row">
											<div class="col col-lg-2">
												<div class="input-group mb-3">
													<input id="id" name="id" type="hidden"
														value="<%=product.getId()%>">
													<button type="button" class="btn btn-success">
														Product Name <span class="badge badge-light"><%=product.getName()%></span>
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
															class="form-control" value=" <%=product.getName()%> "
															placeholder="">
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Price</label>
													<div>
														<input id="price" name="price" type="text"
															class="form-control" maxlength="255"
															value=" <%=product.getPrice()%> " placeholder="">

													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Unit</label>
													<div>
														<input id="unit" name="unit" type="text"
															class="form-control" maxlength="255"
															value=" <%=product.getUnit()%> " placeholder="">
													</div>
												</div>
											</div>
											<div class="col-md-2"></div>
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Category</label>
													<div>
														<select id="category_id" name="category_id"
															class="form-control">
															<c:forEach items="${listCategory}" var="category">
																<c:choose>
																	<c:when
																		test="${category.getId() == product.getCategory().getId()}">
																		<option selected value="${category.getId()}">${category.getName()}</option>
																	</c:when>
																	<c:otherwise>
																		<option value="${category.getId()}">${category.getName()}</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</select>
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