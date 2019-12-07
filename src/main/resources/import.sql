insert into Coupon(id, name, description) values(1,'Diák','50% kedvezmény');
insert into Coupon(id, name, description) values(2,'Dolgozó','75% kedvezmény');

insert into Movie(id, name,genre,description) values(1,'Joker','Thriller', 'Nem volt még őrültebb, veszélyesebb és viccesebb antihős a képregényvilágban. De hogyan lett Jokerből Joker, a komor Batman örök ellensége és ellentéte? Ez a történet megmutatja, miképpen válhat egy ártatlan lúzerből világok felforgatója, hadseregek legyőzője és szuperhősök esélyes ellenfele');
insert into Movie(id, name,genre,description) values(2,'Volt egyszer egy Hollywood','Dráma', '1969, Los Angeles. Egy munka nélkül maradt, western tévésorozatából kikerült, munkanélküli színész (Leonardo DiCaprio) és jó barátja, kaszkadőre (Brad Pitt) együtt próbálnak boldogulni Hollywood kegyetlen világában.');

insert into Room(id, name,size) values(1,'1-es szoba', 120);
insert into Room(id, name,size) values(2,'2-es szoba', 150);
insert into Room(id, name,size) values(3,'3-as szoba', 100);

insert into User(id, name,password,email) values(1,'Bíró Zoltán','jelszo12','b.zoltan1999@gmail.com');
insert into User(id, name,password,email) values(2,'Béres Anita','password','b.anita@gmail.com');

insert into Projection(id,movie_id,room_id,projection_date) values(1,1,1,TO_DATE('2019.10.21','YYYY.MM.DD'));
insert into Projection(id,movie_id,room_id,projection_date) values(2,2,2,TO_DATE('2019.10.15','YYYY.MM.DD'));
