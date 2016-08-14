<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Koszyk</title>
    </head>
    <body>
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a></li>
                        <li class="active">Koszyk</li>
                    </ol>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Produkt</td>
                                <td class="price">Cena</td>
                                <td class="price">Ilość</td>
                                <td class="price">Wartość</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${session['order']}" var="orderItem">
                                <tr>

                                    <td class="cart_description">
                                        <h4>${orderItem.book.title}</h4>
                                        <p>ID: ${orderItem.book.id}</p>
                                    </td>


                                    <td class="cart_price">
                                        <p>${orderItem.book.price} zł</p>
                                    </td>

                                    <td class="cart_price">
                                        <p>${orderItem.amount}</p>
                                    </td>

                                    <td class="cart_price">
                                        <p>${orderItem.book.price * orderItem.amount} zł</p>
                                    </td>

                                    <td class="cart_delete">
                                        <g:link class="cart_quantity_delete"  action="deleteItem" id="${orderItem.book.id}"><i class="fa fa-times"></i></g:link>
                                        </td>
                                    </tr>
                            </g:each>



                        </tbody>
                    </table>
                </div>
                <div> 
                    <h3 class=" pull-right " >Łączny koszt: ${sum}zł &nbsp;&nbsp;&nbsp;&nbsp;</h3><br/><br/><br/>
                    <g:if test="${session['order']}">
                        <g:link class="btn btn-primary pull-right"  action="order">Zamów&nbsp;&nbsp;&nbsp;&nbsp;</g:link><br/><br/><br/><br/>
                    </g:if>

                </div>
            </div>
        </section> <!--/#cart_items-->
    </body>
</html>