DROP TABLE IF EXISTS HardwareType;

CREATE TABLE HardwareType
(
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS Hardware;

CREATE TABLE Hardware
(
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    code VARCHAR(16) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    hardwareTypeId INT,
    quantity INT,
    FOREIGN KEY (hardwareTypeId) REFERENCES HardwareType(id)
);


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