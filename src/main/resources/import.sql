insert into Coupon(id, name, description) values(1,'Student','50% off');
insert into Coupon(id, name, description) values(2,'Child','75% off');

insert into Movie(id, name,genre,description) values(1,'Joker','Thriller', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.');
insert into Movie(id, name,genre,description) values(2,'Ford v Ferrari','Drama', 'American car designer Carroll Shelby and driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary race car for Ford and challenge Ferrari at the 24 Hours of Le Mans in 1966.');

insert into Room(id, name,size) values(1,'Bolyai room', 120);
insert into Room(id, name,size) values(2,'Kitaibel room', 150);
insert into Room(id, name,size) values(3,'Lovarda room', 100);

insert into User(id, name,password,email) values(1,'bzoltan','jelszo12','b.zoltan1999@gmail.com');
insert into User(id, name,password,email) values(2,'banita','password','b.anita@gmail.com');

insert into Projection(id,movie_id,room_id,projection_date) values(1,1,1,TO_DATE('2019.12.15','YYYY.MM.DD'));
insert into Projection(id,movie_id,room_id,projection_date) values(2,2,2,TO_DATE('2019.12.16','YYYY.MM.DD'));
