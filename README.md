"# BreizhCarBack" 
A l'aide de Spring initializr, un projet maven a été créé, avec les dépendances spring boot devtools/spring web/spring data jpa et h2 database.
J'ai donc créé des entités; actor, category, film, preference, show, village.
A la suite de cela les controller associés ont été créé, ainsi que interface repository, les interfaces service et les classes serviceImpl.
Dans chaque entité les getters et setters ont été créés.
Créations également des relations OneToMany , ManyToOne et ManyToMany représenté sur le diagramme de class. 

Petit soucis en copiant le tuto de manu jukebox, sur la compréhension des repository, en copiant bêtement la méthode findByNameContaining, qui n'a aucune utilisé pour plusieurs entités.

9h15 le 22/12/2020 soucis d'importation du VillageRepository, why??? I don't know ! Mais le serveur h2 fonctionne..

**Pour accéder à la base de donnée, malgré que les username et password d'application.properties soient vide il faut mettre l'username: sa  et l'url est jdbc:h2:mem:breizhvideo**
