<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Lista użytkowników</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">

                                <div id="list-user" class="content scaffold-list" role="main">
                                    <h1>Lista użytkowników</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <f:table collection="${userList}" properties="['username','firstName', 'lastName', 'city', 'street']"/>

                                    <div class="pagination">
                                        <g:paginate total="${userCount ?: 0}" />
                                    </div>
                                </div>
                            </div>               
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </body>
</html>