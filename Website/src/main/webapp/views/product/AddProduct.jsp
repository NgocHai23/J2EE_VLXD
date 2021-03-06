<%@page import="vlxd.dto.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Add Product</title>
<%@include file="../layouts/importstyle.jsp"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-latest.pack.js"></script>
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
							<h1>Add New Product</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="">Home</a></li>
								<li class="breadcrumb-item active">Add</li>
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
									<h3 class="card-title  p-3">Add New Product</h3>
								</div>

								<div class="card-body">
									<form class="form" id="" action="./CreateNewProductServlet"
										method="POST">

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Name</label>
													<div>
														<input id="name" name="name" type="text"
															class="form-control" value="" placeholder="Product Name">
													</div>
												</div>
												<!-- /input-group -->
											</div>
											<!-- /.col-md-5 -->

											<div class="col-md-2"></div>

											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Unit</label>
													<div>
														<input id="unit" name="unit" type="text"
															class="form-control" maxlength="255" value=""
															placeholder="Product Unit">

													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5">
												<div class="form-group required">
													<label class="control-label">Price</label>
													<div>
														<input id="price" name="price" type="text"
															class="form-control" maxlength="255" value=""
															placeholder="Product Price">

													</div>
												</div>
											</div>
											<div class="col-md-2"></div>
											<div class="col-md-5">
												<label class="control-label">Category</label>
												<div>
													<select id="category_id" name="category_id"
														class="form-control">
														<c:forEach items="${listCategory}" var="category">
															<option value="${category.getId()}">${category.getName()}</option>
														</c:forEach>
													</select>
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
												<button type="submit" class="btn  btn-primary">Create</button>
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
		$(document).ready(function() {
			$("#price").on({
				input : function() {
					formatCurrency($(this));
				}
			});
		});

		function formatNumber(n) {
			//return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ".");
			return Number(n.replace(/\./g, '')).toLocaleString('vi');
		}

		function formatCurrency(input) {
			var input_val = input.val();

			if (input_val === "") {
				return;
			}
			
			var original_len = input_val.length;

			var caret_pos = input.prop("selectionStart");

			input_val = formatNumber(input_val);

			input.val(input_val);

			var updated_len = input_val.length;
			caret_pos = updated_len - original_len + caret_pos;
			input[0].setSelectionRange(caret_pos, caret_pos);
		}
	</script>


</body>

</html>