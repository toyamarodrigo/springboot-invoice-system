/* Populate tables */
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (1, 'Jose', 'Pepe', 'josepepe@gmail.com', '2019-10-09', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (2, 'Maria', 'Pepa', 'mariapepa@gmail.com', '2019-09-25', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (3,'Biron','Chastaing','bchastaing0@ocn.ne.jp','2018-12-24', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (4,'Doug','Quig','dquig1@webnode.com','2019-05-21', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (5,'Francyne','Terbrug','fterbrug2@angelfire.com','2019-10-10', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (6,'Egan','Newlands','enewlands3@ftc.gov','2019-08-29', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (7,'Willi','Squibe','wsquibe4@nsw.gov.au','2019-04-12', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (8,'Anatola','Roddam','aroddam5@home.pl','2019-03-07', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (9,'Ramonda','Haylett','rhaylett6@unc.edu','2019-01-19', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (10,'Timothy','McMurty','tmcmurty7@opensource.org','2019-01-11', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (11,'Micky','Gammie','mgammie8@mapy.cz','2018-12-18', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (12,'Dun','Gregersen','dgregersenb@tuttocitta.it','2019-06-05', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (13,'Forester','Jerwood','fjerwoodc@mayoclinic.com','2019-07-03', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (14,'Gertruda','Vernalls','gvernallsd@psu.edu','2018-12-25', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (15,'Lita','Jansen','ljansene@yellowbook.com','2019-04-30', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (16,'Saw','Erley','serleyf@photobucket.com','2019-06-02', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (17,'Dagny','Copelli','dcopellig@goodreads.com','2019-04-17', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (18,'Izak','Gerssam','igerssamh@163.com','2018-10-28', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (19,'Gawen','Stot','gstoti@jimdo.com','2019-01-07', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (20,'Jessee','Strowlger','jstrowlgerj@redcross.org','2019-01-05', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (21,'Bay','Pashler','bpashlerk@istockphoto.com','2019-01-29', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (22,'Verine','Keightley','vkeightleyl@tripadvisor.com','2019-06-24', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (23,'Gratia','Loble','globlem@joomla.org','2019-07-25', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (24,'Drake','Kingston','dkingstonn@altervista.org','2019-02-21', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (25,'Grayce','Cruddas','gcruddaso@marriott.com','2019-05-06', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (26,'Karry','Botten','kbottenp@sitemeter.com','2019-02-02', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (27,'Mead','Jellings','mjellingsq@accuweather.com','2019-07-08', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (28,'Elden','Wiltsher','ewiltsherr@theglobeandmail.com','2019-03-25', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (29,'Caprice','Strase','cstrases@goo.gl','2019-04-28', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (30,'Dolly','Ringrose','dringroset@drupal.org','2019-01-22', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (31,'Stanley','Hovert','shovert9@rediff.com','2019-05-04', '');
INSERT INTO clients (id, first_name, last_name, email, create_at, photo) VALUES (32,'Janelle','Quilleash','jquilleasha@slashdot.org','2019-06-12', '');

/* Populate table products */
INSERT INTO products (name, price, create_at) VALUES('Panasonic LCD', 259990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony Camera DSC-W320B', 1234590, NOW());
INSERT INTO products (name, price, create_at) VALUES('Apple iPod', 1499990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO products (name, price, create_at) VALUES('HP F2280 MultiF', 69990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Bike 26 BMW', 69990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Keyboard Razer CLGv', 299990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Mouse Razer Deathadder', 299650, NOW());

/* Invoices */
INSERT INTO invoices(description, observation, client_id, create_at) VALUES('Invoice office team', null, 1, NOW());
INSERT INTO items_invoices(amount, invoice_id, product_id) VALUES(1, 1, 1); 
INSERT INTO items_invoices(amount, invoice_id, product_id) VALUES(2, 1, 4); 
INSERT INTO items_invoices(amount, invoice_id, product_id) VALUES(1, 1, 5); 
INSERT INTO items_invoices(amount, invoice_id, product_id) VALUES(1, 1, 7); 

INSERT INTO invoices(description, observation, client_id, create_at) VALUES('Bike Invoice', 'IMPORTANT STUFF', 1, NOW());
INSERT INTO items_invoices(amount, invoice_id, product_id) VALUES(3, 2, 6); 

/* */
INSERT INTO users (username, password, enabled) VALUES ('rodri', '$2a$10$bwhu5TxyJPuxwn6.g2bUC.8dUCV5vh9eq40RoFX4pEIDqrHlEUx3.', 1);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$R244P6hZ4MUa9EBeAUEcne5B8Lb6mTzw5.2vzKH6S7q9u3pqrGfoW', 1);

INSERT INTO authorities (user_id, authority) VALUES ('1', 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES ('2', 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES ('2', 'ROLE_USER');
