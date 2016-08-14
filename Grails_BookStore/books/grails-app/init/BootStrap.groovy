class BootStrap {
    def assetResourceLocator 
    def init = { servletContext ->
        def cat = new books.Category();
        cat.name ='Kryminał';
        cat.save()
        
        cat = new books.Category();
        cat.name ='Fantastyka';
        cat.save()
        
        cat = new books.Category();
        cat.name ='Thriler';
        cat.save()
        
        cat = new books.Category();
        cat.name ='Fantastyka';
        cat.save()
        
        
        //        roles
        def springSecurityService
        def userRole = books.Role.findByAuthority('ROLE_USER') ?: new books.Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = books.Role.findByAuthority('ROLE_ADMIN') ?: new books.Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        
        def adminUser = books.User.findByUsername('admin') ?: new  books.User(
            username: 'admin@admin.pl',
            password: 'admin',
            firstName: 'Jan',
            lastName: 'Kowalski',
            city: 'Lublin',
            street: 'Niewiadoma',
            zipCode: '21-111',
            enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            books.UserRole.create adminUser, adminRole
        }
        
        def user = books.User.findByUsername('user') ?: new  books.User(
            username: 'user@user.pl',
            password: 'user',
            firstName: 'Marian',
            lastName: 'Nowa',
            city: 'Warszawa',
            street: 'Inna',
            zipCode: '25-222',
            enabled: true).save(failOnError: true)

        if (!user.authorities.contains(adminRole)) {
            books.UserRole.create user, userRole
        }
        
        
        def book = new books.Book(
            title:'Pomnik cesarzowej Achai. Tom 5',
            author: 'Ziemiański Andrzej',
            description: 'Wybuchowe i nieprzewidywalne zakończenie cyklu. Tego się nie spodziewacie. "Jak zwykle doskonały język i błyskotliwe pomysły. Ziemiański to prawdziwy fachowiec fantastyki. Dobrze, że wrócił." Jarosław Grzędowicz "Choć od mojego pierwszego kontaktu ze światem Achai minęła dekada (a w samym cesarstwie tysiąc lat) do książek Ziemiańskiego wróciłam jak do domu. Jest dobrze, jest bardzo dobrze! Ziemiański wciąż potrafi stworzyć powieść, która wciąga jak ruchome piaski, gra na emocjach, wgniata w fotel rozmachem i zachwyca świetnie wykreowanymi postaciami." ',
            year: 2016,
            price: 47,
        )  
        book.image = assetResourceLocator.findAssetForURI( 'covers/pomnik.jpg').getByteArray()
        book.save(flush:true,failOnError:true)
        
        book = new books.Book(
            title:'Królowa Cieni',
            author: 'Maas Sarah J.',
            description: 'Nadszedł czas walki o wszystko, co ważne. Aelin wraca do Adarlanu, by pomścić bliskich, odzyskać tron i stanąć twarzą w twarz z cieniami przeszłości. A przede wszystkim po to, by chronić tych, którzy jej pozostali. Mroczne bestie, magiczne moce,  namiętność i pragnienie zemsty… Sarah J. Maas porywa i zaskakuje jeszcze bardziej niż do tej pory.',
            year: 2016,
            price: 43,
        )        
        book.image = assetResourceLocator.findAssetForURI( 'covers/krolowa.jpg').getByteArray()
        book.save(flush:true,failOnError:true)
        
        book = new books.Book(
            title:'Igrając z ogniem',
            author: 'Gerritsen Tess',
            description: 'Julia Ansdell, skrzypaczka, matka trzyletniej Lilly, podczas pobytu w Wenecji wchodzi w posiadanie partytury z zapisem nutowym utworu „Incendio” skomponowanego przez nieznanego muzyka Lorenzo Todesco. Gdy Julia próbuje zagrać utwór, jej córka wpada w szał, zabija kota i próbuje skrzywdzić matkę. Jaki jest związek pomiędzy dziwnym zachowaniem dziewczynki a nieznanym utworem muzycznym? Tropy wiodą do Wenecji lat 40. XX wieku i związku dwojga młodych muzyków, który nie miał szans na powodzenie we Włoszech Benito Mussoliniego.',
            year: 2016,
            price: 28,
        )
        book.image = assetResourceLocator.findAssetForURI( 'covers/igrajac.jpg').getByteArray()
        book.save(flush:true,failOnError:true)
        
        book = new books.Book(
            title:'Śladem zbrodni',
            author: 'Gerritsen Tess',
            description: 'Nikt nigdy nie miał poznać tej tajemnicy…. Przez dwadzieścia lat śmierć jej rodziców, agentów brytyjskiego wywiadu, otaczała zmowa milczenia. Gdy Beryl Tavistock przypadkowo poznaje przebieg dramatycznych wydarzeń, przeżywa szok. Ojciec brutalnie zamordował matkę, a następnie popełnił samobójstwo? Oboje byli komunistycznymi szpiegami? Beryl nie może w to uwierzyć. Postanawia odkryć, co stało się naprawdę. Śledztwo rozpoczyna w Paryżu, gdzie przed laty wydarzyła się tragedia. Z bratem i zaprzyjaźnionym agentem CIA wpada w sam środek szpiegowskiej afery i bezwzględnej gry służb. Nie zdaje sobie sprawy, że szukając prawdy, wydaje na siebie wyrok śmierci.',
            year: 2016,
            price: 31,
        )

        book.image = assetResourceLocator.findAssetForURI( 'covers/sladem.jpg').getByteArray()
        book.save(flush:true,failOnError:true)
    }
    def destroy = {
    }
}
