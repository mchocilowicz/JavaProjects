<header id="header">
    <div class="header_top">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> chomar8@gmail.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header-middle">
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a class="home" href="${createLink(uri: '/')}"><g:img dir="images" file="logo.png" /></a>
                    </div>

                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <sec:ifAllGranted roles="ROLE_ADMIN">
                                <li><g:link controller="book" action="create"><i class="fa fa-user"></i>Dodaj książkę</g:link>
                                <li><g:link controller="user" action="index"><i class="fa fa-user"></i>Użytkownicy</g:link>
                                <li><g:link controller="category" action="index"><i class="fa fa-user"></i>Kategorie</g:link>
                                <li><g:link controller="order" action="index"><i class="glyphicon  glyphicon-shopping-cart"></i>Zamówienia</g:link>
                                </sec:ifAllGranted>

                            <sec:ifAllGranted roles="ROLE_USER">
                                <li><g:link controller="user" action="show" id="${sec.loggedInUserInfo(field:"id")}" ><i class="fa fa-user"></i>Moje konto</g:link>
                                <li><g:link controller="card" action="index"><i class="fa fa-shopping-cart"></i>Koszyk</g:link>
                                </sec:ifAllGranted>

                            <sec:ifLoggedIn>
                                <li><g:link controller="logout" ><i class="fa fa-lock"></i> Wyloguj <sec:username /> </a></g:link></li>
                                </sec:ifLoggedIn>

                            <sec:ifNotLoggedIn>
                                <li><g:link controller="login" action="auth"><i class="fa fa-lock"></i> Zaloguj się</a></g:link></li>
                                <li><g:link controller="user" action="create"><i class="fa fa-lock"></i> Rejestracja</a></g:link></li>
                            </sec:ifNotLoggedIn>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>