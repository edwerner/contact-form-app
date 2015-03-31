<nav class="navbar navbar-default top-navigation" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <!-- <a class="navbar-brand" href="#">Brand</a> -->
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath()%>/">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Contacts <b class="caret"></b></a>
        <ul class="dropdown-menu">
        	<li><a href="<%=request.getContextPath()%>/contacts/new/index">Add a Contact</a></li>
        	<li><a href="<%=request.getContextPath()%>/contacts/list/all">List Contacts</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Cars <b class="caret"></b></a>
        <ul class="dropdown-menu">
        <li><a href="<%=request.getContextPath()%>/cars/new/index">Add a Car</a></li>
        <li><a href="<%=request.getContextPath()%>/cars/list/all">List Cars</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">JSON Service <b class="caret"></b></a>
        <ul class="dropdown-menu">
        	<li><a href="<%=request.getContextPath()%>/contacts/contactsJson">View Contact Messages</a></li>
        	<li><a href="<%=request.getContextPath()%>/cars/carsJson">View Cars</a></li>
        </ul>
      </li>
    </ul>
<!--     <form class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form> -->
<!--     <ul class="nav navbar-nav navbar-right">
      <li><a href="#">Link</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="#">Separated link</a></li>
        </ul>
      </li>
    </ul> -->
  </div><!-- /.navbar-collapse -->
</nav>