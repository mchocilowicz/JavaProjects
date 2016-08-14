<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Szczegóły zamówienia</title>
    </head>
    <body>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">
                                <div id="show-order" class="content scaffold-show" role="main">
                                    <h1>Szczegóły zamówienia</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <f:display bean="order" />
                                    <g:form resource="${this.order}" method="DELETE">
                                        <fieldset class="buttons">
                                            <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                        </fieldset>
                                    </g:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </body>
</html>
