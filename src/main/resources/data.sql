INSERT INTO HardwareType(name) VALUES('CPU');
INSERT INTO HardwareType(name) VALUES('GPU');
INSERT INTO HardwareType(name) VALUES('MBO');
INSERT INTO HardwareType(name) VALUES('RAM');
INSERT INTO HardwareType(name) VALUES('STORAGE');
INSERT INTO HardwareType(name) VALUES('OTHER');


INSERT INTO Hardware(name, code, price, hardwareTypeId, quantity)
VALUES('CPU1', 'c_001', 100.00, 1, 10);

INSERT INTO Hardware(name, code, price, hardwareTypeId, quantity)
VALUES('CPU2', 'c_002', 120.00, 1, 8);
