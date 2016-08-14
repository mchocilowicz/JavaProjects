<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Księgarnia</title>
    </head>
    <body>
        <h2 class="title text-center">Książki</h2>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div><br/>
        </g:if>
        <g:if test="${bookCount == 0}">
            Brak książek do wyświetlenia
        </g:if>   

        <g:each in="${bookList}" var="book">

            <div class="col-sm-4">
                <div class="product-image-wrapper">
                    <div class="single-products">
                        <div class="productinfo text-center">
                            <g:if test="${book.image}">
                                <img class="sImg" src="${createLink(controller:'book', action:'displayImage', id:book.id)}" />
                            </g:if>   
                            <h2><g:link action="show" id="${book.id}">${book.title}</g:link></h2>
                            <p>${book.price} zł</p>

                            <sec:ifAllGranted roles="ROLE_USER">
                                <g:link action="addToCard" id="${book.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Dodaj do koszyka</g:link>
                                </sec:ifAllGranted>

                        </div>
                    </div>
                </div>
            </div>
        </g:each>

    </body>
</html>