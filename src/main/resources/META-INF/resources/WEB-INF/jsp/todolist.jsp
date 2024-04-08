<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
    <div class="container">
	    <h1>Your Todo List is:</h1>
		    <table class="table">
		         <thead>
		              <tr>
		                
		                <th>Description</th>
		                <th>Target Date</th>
		                <th>Status</th>
		                <th>Delete</th>
		                <th>Update</th>
		              </tr>
		         </thead>
		         <tbody>
		         <c:forEach items="${list}" var="todo"> 
		              <tr>
		                
		                <td>${todo.description}</td>
		                <td>${todo.date}</td>
		                <td>${todo.done}</td>
		                <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
		                <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
		              </tr>
		         </c:forEach>
		         </tbody>
		    </table>
		    <a href="add-todo" class="btn btn-success">Add Todo</a>
    </div>
<%@ include file="common/footer.jspf"%>