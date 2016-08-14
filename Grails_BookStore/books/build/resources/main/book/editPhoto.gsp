<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Edycja książki ${this.book.title}</title>
    </head>
    <body>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">
                            <div class="nav" role="navigation">
                                <div id="list-category" class="content scaffold-list" role="main">
                                    <div id="edit-book" class="content scaffold-edit" role="main">
                                        <h1>Edytuj okładkę ${this.book.title}</h1>
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
                                        <g:uploadForm resource="${this.book}" action="update2" class="form-horizontal" >
                                            <g:hiddenField name="version" value="${this.book?.version}" />

                                            <fieldset class="form" >

                                                <f:field required="true" bean="book" property = "image"/>
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
