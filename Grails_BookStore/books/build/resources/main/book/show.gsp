<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
        <title>Książka ${this.book.title}</title>
    </head>
    <body>

        <div class="product-details"><!--product-details-->
            <div class="col-sm-5">
                <div class="view-product">
                    <g:if test="${this.book.image}">
                        <img src="${createLink(controller:'book', action:'displayImage', id:this.book.id)}" />
                    </g:if>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="product-information"><!--/product-information-->
                    <img src="images/product-details/new.jpg" class="newarrival" alt="" />
                    <h2>${this.book.title}</h2>
                    <p><strong>Kod:</strong> ${this.book.id}</p>
                    <p><strong>Autor:</strong> ${this.book.author}</p>
                    <g:if test="${this.book.category}">
                        <p><strong>Kategoria:</strong> 
                            <g:link controler="book" action="index" params="[categoryId: this.book.category.id]" >${this.book.category.name}</g:link></p>
                        </g:if>

                    <span>
                        <span>${this.book.price} zł</span>


                        <sec:ifAllGranted roles="ROLE_USER">
                            <g:link action="addToCard" id="${book.id}" class="btn btn-fefault cart"><i class="fa fa-shopping-cart"></i>Dodaj do koszyka</g:link>
                            </sec:ifAllGranted>
                        </span>

                    <p><b>Stan:</b> 
                        <g:if test="${this.book.isDeleted}">
                            Niedostępny
                        </g:if>
                        <g:else>
                            Dostępny
                        </g:else>
                    </p>

                    <sec:ifAllGranted roles="ROLE_ADMIN">
                        <g:form resource="${this.book}" method="DELETE">
                            <g:link class="btn btn-primary" action="edit" resource="${this.book}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <g:link class="btn btn-primary" action="editPhoto" resource="${this.book}">Edytuj zdjęcie</g:link>
                            <input class="btn btn-primary" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </sec:ifAllGranted>

                </div><!--/product-information-->
            </div>
        </div>

        <div class="category-tab shop-details-tab"><!--category-tab-->
            <div class="col-sm-12">
                <ul class="nav nav-tabs">
                    <li><a href="#details" data-toggle="tab">Opis</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane fade active in" id="details" >
                    <p>${this.book.description}</p>
                </div>
            </div>
        </div><!--/category-tab-->
    </body>
</html>
