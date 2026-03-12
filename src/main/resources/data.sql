INSERT INTO HardwareType(id, name) VALUES(1, 'CPU');
INSERT INTO HardwareType(id, name) VALUES(2, 'GPU');
INSERT INTO HardwareType(id, name) VALUES(3, 'MBO');
INSERT INTO HardwareType(id, name) VALUES(4, 'RAM');
INSERT INTO HardwareType(id, name) VALUES(5, 'STORAGE');
INSERT INTO HardwareType(id, name) VALUES(6, 'OTHER');


INSERT INTO Hardware(name, code, price, hardware_type_id, quantity) VALUES('CPU1', 'c_001', 100.00, 1, 10);
INSERT INTO Hardware(name, code, price, hardware_type_id, quantity) VALUES('CPU2', 'c_002', 120.00, 1, 8);


INSERT INTO Users(id, username, password) VALUES(1, 'admin', '$2a$12$.AEEsmqIrGxgAAyeMJJ/ru2bW1cKAaBBHyQSeRmT2wf0CA5EucntO'); --pass=admin
INSERT INTO Users(id, username, password) VALUES(2, 'user', '$2a$12$FgLR3he.h/NmyL9uAJir3uLd6PH3/uSMFBoD9LhDI046Igyi4/9R2');--pass=user


INSERT INTO Roles(id, name) VALUES(1, 'Administrator');
INSERT INTO Roles(id, name) VALUES(2, 'User');


INSERT INTO User_Role(user_id, role_id) VALUES(1, 1);
INSERT INTO User_Role(user_id, role_id) VALUES(2, 2);
