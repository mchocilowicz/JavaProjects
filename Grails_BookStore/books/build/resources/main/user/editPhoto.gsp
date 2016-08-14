<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Edycja użytkownika ${this.user.username}</title>
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
                                <div id="edit-user" class="content scaffold-edit" role="main">
                                    <h1>Edycja użytkownika ${this.user.username}</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <g:hasErrors bean="${this.user}">
                                        <ul class="errors" role="alert">
                                            <g:eachError bean="${this.user}" var="error">
                                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                                </g:eachError>
                                        </ul>
                                    </g:hasErrors>
                                    <g:uploadForm resource="${this.user}" class="form-horizontal" action="update2" >
                                        <g:hiddenField name="version" value="${this.user?.version}" />
                                        <fieldset class="form">
                                            <f:field required="true" bean="user" property = "image"/>
                                        </fieldset>
                                        <fieldset class="buttons">
                                            <input class="btn btn-primary pull-right" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                                        </fieldset>
                                    </g:uploadForm>
                                </div>          
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </section>



</body>
</html>
