INSERT INTO roles (id, name)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'USER');

INSERT INTO users (id,username, email, firstname, lastname, password, registeredon, isadmin)
VALUES (1, 'admin' 'admin@admin.com', 'Admin',  'Adminov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b','1998-07-27 16:32:55.900903', true);

INSERT INTO users (id,username, email, firstname, lastname, password, registeredon, isadmin)
VALUES (2,'moderator', 'moderator@moderator.com', 'Moderator', 'Moderatorov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b','2018-06-27 16:32:55.900903', true);

INSERT INTO users (id,username, email, firstname, lastname, password, registeredon, isadmin)
VALUES (3, 'user', 'user@user.com', 'User', 'Userov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b','2024-03-17 12:32:55.900903', false);

INSERT INTO users (id,username, email, firstname, lastname, password, registeredon, isadmin)
VALUES (4, 'ivan', 'ivan@ivan.com', 'Ivan', 'Ivanov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b','2023-07-27 16:32:55.900903', false);