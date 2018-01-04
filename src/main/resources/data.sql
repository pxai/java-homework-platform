insert into message values (1,'This is great','Nice guestbook, best I have ever seen');
insert into message values (2,'Awesome','A wonderful experience, a must-see');
insert into message values (3,'Ultra cool','Very good guestbook, bootstrap is a nice touch');
insert into user (id, username, password, email, enabled) values (1,'falken','1111','falk@mit.edu', true);
insert into user (id, username, password, email, enabled) values (2,'john_doe','1234','jdoe@ge.us', true);
insert into user (id, username, password, email, enabled) values (3,'nobody','nothing','no@no.org', true);
insert into role (id, role) values (1,'ANONYMOUS');
insert into role (id, role) values (2, 'USER');
insert into role (id, role) values (3, 'ADMIN');

insert into user_role (user_id , role_id ) values (1,2);
insert into user_role (user_id , role_id ) values (1,3);
insert into user_role (user_id , role_id ) values (2,2);
insert into user_role (user_id , role_id ) values (3,2)

insert into assignment (id, name, description,  start, due, user_id) values (1,'1st assignment','The first','2017-10-23','2018-01-02', 1);
insert into assignment (id, name, description,  start, due, user_id) values (2,'2nd assignment','The second','2017-10-23','2018-01-02', 1);
insert into assignment (id, name, description,  start, due, user_id) values (3,'1st assignment','The first','2017-10-23','2018-01-02', 2);
insert into assignment (id, name, description,  start, due, user_id) values (4,'2nd assignment','The second','2017-10-23','2018-01-02', 2);


