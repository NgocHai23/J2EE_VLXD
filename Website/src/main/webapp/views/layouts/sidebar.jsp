<%@page import="vlxd.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar elevation-4 sidebar-light-primary">
	<!-- Brand Logo -->
	<a href="./Home" class="brand-link bg-primary ">
		<img src="${pageContext.request.contextPath}/views/public/img/avery-logo.png" alt="AVERY Logo"
			class="brand-image img-circle elevation-3" style="opacity: 1">
		<span class="brand-text font-weight-light effect-shine"><b>QL - VLXD</b></span>
	</a>

	<div class="sidebar">
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="${pageContext.request.contextPath}/views/public/img/avatar/avatar8.png"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">${loginedUser.getName()}</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
				<li class="nav-item">
					<a href="" class="nav-link effect-underline">
						<i class="nav-icon fa fa-dashboard"></i>
						<p>
							Dashboard
						</p>
					</a>
				</li>

				<li class="nav-item has-treeview ">
					<a href="#" class="nav-link ">
						<i class="nav-icon fa fa-building"></i>
						<p>
							Vendor
							<i class="right fa fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./ListVendorServlet" class="nav-link  effect-underline ">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>List Vendor</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./GoPageCreateNewVendorServlet" class="nav-link  effect-underline">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>Create Vendor</p>
							</a>
						</li>
					</ul>
				</li>

				<li class="nav-item has-treeview ">
					<a href="#" class="nav-link ">
						<i class="nav-icon fa fa-list"></i>
						<p>
							Category
							<i class="right fa fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./ListCategoryServlet" class="nav-link  effect-underline ">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>List Category</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./GoPageCreateNewCategoryServlet" class="nav-link  effect-underline">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>Create Category</p>
							</a>
						</li>
					</ul>
				</li>

				<li class="nav-item has-treeview ">
					<a href="#" class="nav-link ">
						<i class="nav-icon fa fa-car"></i>
						<p>
							Product
							<i class="right fa fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./ListProductServlet" class="nav-link  effect-underline ">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>List Product</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./GoPageCreateNewProductServlet" class="nav-link  effect-underline">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>Create Product</p>
							</a>
						</li>
					</ul>
				</li>

				<li class="nav-item has-treeview ">
					<a href="#" class="nav-link ">
						<i class="nav-icon fa fa-users"></i>
						<p>
							Customer
							<i class="right fa fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./ListCustomerServlet" class="nav-link  effect-underline ">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>List Customer</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./GoPageCreateNewCustomerServlet" class="nav-link  effect-underline">
								<i class="fa fa-circle-o nav-icon"></i>
								<p>Create Customer</p>
							</a>
						</li>
					</ul>
				</li>
				
				<li class="nav-item">
					<a href="./ListProductInWarehouse" class="nav-link effect-underline">
						<i class="nav-icon fa fa-home"></i>
						<p>
							Inventory Report
						</p>
					</a>
				</li>

				<%
					UserDTO loginedUser = (UserDTO) session.getAttribute("loginedUser");
				%>

				<c:set var="loginedInfo" scope="session" value="<%=loginedUser%>" />
				<c:choose>
					<c:when test="${loginedInfo.getRole() == 'manager'}">
						<li class="nav-item has-treeview">
							<a href="#" class="nav-link">
								<i class="nav-icon fa fa-user"></i>
								<p>
									User
									<i class="right fa fa-angle-left"></i>
								</p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="./ListUserServlet" class="nav-link effect-underline ">
										<i class="fa fa-circle-o nav-icon"></i>
										<p>List User</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="./GoPageCreateNewUserServlet" class="nav-link active effect-underline">
										<i class="fa fa-circle-o nav-icon"></i>
										<p>Create User</p>
									</a>
								</li>
							</ul>
						</li>

					</c:when>
					<c:when test="${loginedInfo.getRole() == 'employee'}">

						<li class="nav-item has-treeview ">
							<a href="#" class="nav-link ">
								<i class="nav-icon fa fa-line-chart"></i>
								<p>
									Goods Receipt
									<i class="right fa fa-angle-left"></i>
								</p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="./GoPageGoodsReceiptServlet" class="nav-link  effect-underline ">
										<i class="fa fa-circle-o nav-icon"></i>
										<p>Goods Received Note</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="./ListGoodsReceiptServlet" class="nav-link  effect-underline">
										<i class="fa fa-circle-o nav-icon"></i>
										<p>Stock Take</p>
									</a>
								</li>
							</ul>
						</li>

					</c:when>

					<c:otherwise>
						<c:redirect url="./GoPageLoginServlet" />
					</c:otherwise>
				</c:choose>

				<li class="header">&nbsp;</li>
				<li><a href="#">&nbsp;</a></li>
				<li><a href="#">&nbsp;</a></li>
				<li><a href="#">&nbsp;</a></li>
			</ul>
		</nav>
	</div>
</aside>