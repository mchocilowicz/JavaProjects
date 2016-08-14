<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Lista zamówień</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">
                                <div id="list-order" class="content scaffold-list" role="main">
                                    <h1>Lista zamówień</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <f:table displayStyle="link" collection="${orderList}" />

                                    <div class="pagination">
                                        <g:paginate total="${orderCount ?: 0}" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </body>
</html>