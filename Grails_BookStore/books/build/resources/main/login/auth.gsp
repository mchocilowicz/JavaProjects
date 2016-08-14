<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <title>Logowanie</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 padding-right">
                        <div class="features_items">


                            <form class="form-horizontal" action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">

                                <fieldset>

                                    <h1><g:message code='springSecurity.login.header'/></h1>
                                    <g:if test='${flash.message}'>
                                        <div class="login_message">${flash.message}</div>
                                    </g:if>
<!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="login"><g:message code='springSecurity.login.username.label'/></label>  
                                        <div class="col-md-4">
                                            <input  name="${usernameParameter ?: 'username'}" id="username" class="form-control input-md" required="" type="text">

                                        </div>
                                    </div>

<!-- Password input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="password"><g:message code='springSecurity.login.password.label'/></label>
                                        <div class="col-md-4">
                                            <input  name="${passwordParameter ?: 'password'}" id="password" placeholder="" class="form-control input-md" type="password">

                                        </div>
                                    </div>

<!-- Button -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="singlebutton"></label>
                                        <div class="col-md-4">
                                            <input class="btn btn-primary"type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
                        </div>
                    </div>   
                </div>
            </div>
        </section>


    </body>
</html>