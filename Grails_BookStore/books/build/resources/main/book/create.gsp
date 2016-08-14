<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Dodaj książkę</title>
    </head>
    <body>


        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">
                                <div id="list-category" class="content scaffold-list" role="main">
                                    <h1>Dodaj książkę</h1>
                                    <g:if test="${flash.message}">
                                        <div class="message" role="status">${flash.message}</div>
                                    </g:if>
                                    <g:hasErrors bean="${this.book}">
                                        <ul class="errors" role="alert">
                                            <g:eachError bean="${this.book}" var="error">
                                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                                </g:eachError>
                                        </ul>
                                    </g:hasErrors>
                                    <g:uploadForm action="save" class="form-horizontal">
                                        <fieldset class="form">

                                            <f:field bean="book" property = "title"/>
                                            <f:field bean="book" property = "author"/>
                                            <f:field bean="book" property = "price"/>
                                            <f:field bean="book" property = "category"/>
                                            <f:field bean="book" property = "description"/>
                                            <f:field bean="book" property = "year"/>
                                            <f:field bean="book" property = "image"/>
                                        </fieldset>
                                        <fieldset class="buttons">
                                            <g:submitButton name="create" class="btn btn-primary pull-right" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                        </fieldset>
                                    </g:uploadForm>
                                </div>          
                            </div>
                        </div>
                    </div>
                </div>
        </section>

    </body>
</html>
