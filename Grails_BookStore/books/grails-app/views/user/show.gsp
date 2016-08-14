<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Użytkownik ${this.user.username}</title>
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
                                <li><g:link class="user" action="editPhoto" id="${this.user.id}">Edytuj zdjęcie</g:link></li>
                                <li><g:link action="edit" resource="${this.user}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">
                                <div id="show-user" class="content scaffold-show" role="main">
                                    <h1>${this.user.username}</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <g:if test="${this.user.image}">
                                                <img src="${createLink(controller:'user', action:'displayImage', id:this.user.id)}" />
                                            </g:if>
                                        </div>
                                        <div class="col-md-3">

                                            <f:with bean="${user}">
                                                <table class="table" style="width:500px;">
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">Imię</th>
                                                            <td>
                                                    <f:display  property="firstName"/>
                                                    </td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">Nazwisko</th>
                                                        <td>
                                                    <f:display  property="lastName"/>
                                                    </td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">Ulica</th>
                                                        <td>
                                                    <f:display  property="street"/>
                                                    </td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">Miasto</th>
                                                        <td>
                                                    <f:display  property="city"/>
                                                    </td>
                                                    </tr>

                                                    <tr>
                                                        <th scope="row">Kod pocztowy</th>
                                                        <td>
                                                    <f:display  property="zipCode"/>
                                                    </td>
                                                    </tr>

                                                    </tbody>
                                                </table>
                                                <br/>

                                            </f:with>

                                            <g:form resource="${this.user}" method="DELETE">
                                                <fieldset class="buttons">
                                                    <sec:ifAllGranted roles="ROLE_ADMIN">
                                                        <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

                                                    </sec:ifAllGranted>

                                                </fieldset>
                                            </g:form>
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
