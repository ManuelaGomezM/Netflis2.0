
CREATE TABLE Serie (
  Id INT AUTO_INCREMENT  PRIMARY KEY,
  Title VARCHAR(250) NOT NULL,
  Genre VARCHAR(250) NOT NULL,
  Seasons VARCHAR(250) DEFAULT NULL
  ActoresFijos VARCHAR (300)

  PRIMARY KEY  ('Id'),
  //    constraint fk_ foreign key (bossId) references Employee (id)
  ) engine=innodb DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
)//;


CREATE TABLE Pelicula (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  Title VARCHAR(250) NOT NULL,
  Genre VARCHAR(250) NOT NULL,
  Seasons VARCHAR(250) DEFAULT NULL
  ActoresFijos VARCHAR (300)
);


