<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><g:layoutTitle default="Księgarnia"/> </title>
    <asset:stylesheet src="style.css"/>   
    <asset:stylesheet src="font-awesome.min.css"/>  
    <asset:stylesheet src="bootstrap.min.css"/>
    <g:layoutHead/>
</head>

<body>
    <g:render template="/layouts/header"/>



    <section>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="left-sidebar">
                        <h2>Kategorie</h2>
                        <div class="panel-group category-products" id="accordian">
                            <g:each in="${categoryList}" var="category">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">             
                                            <g:link controller="book"  params="[categoryId: category.id]">${category.name}</g:link> 
                                            </h4>
                                        </div>
                                    </div>
                            </g:each>


                        </div>


                    </div>
                </div>

                <div class="col-sm-9 padding-right">
                    <div class="features_items">
                        <g:layoutBody/>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <g:render template="/layouts/footer"/>
</body>
</html>
