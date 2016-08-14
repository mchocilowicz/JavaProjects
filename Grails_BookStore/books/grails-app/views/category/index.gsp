<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
        <title>Kategorie</title>
    </head>
    <body>

        <div class="header-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><g:link class="list" action="index">Lista kategorii</g:link></li>
                                <li><g:link class="create" action="create">Utwórz kategorie</g:link></li>
                                </ul>
                            </div>
                        </div>

                </div>
            </div>
        </div>
    </header>



    <section>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 padding-right">
                    <div class="features_items">
                        <div class="nav" role="navigation">
                            <div id="list-category" class="content scaffold-list" role="main">
                                <h1>Lista kategorii</h1>
                                <g:if test="${flash.message}">
                                    <div class="message" role="status">${flash.message}</div>
                                </g:if>
                                <f:table collection="${categoryList}" />

                                <div class="pagination">
                                    <g:paginate total="${categoryCount ?: 0}" />
                                </div>
                            </div>                    </div>
                    </div>
                </div>
            </div>
    </section>



</body>
</html>