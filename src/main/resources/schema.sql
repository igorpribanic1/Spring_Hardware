CREATE TABLE HardwareType
(
    id IDENTITY PRIMARY KEY,
    name        VARCHAR(50)    NOT NULL
);



CREATE TABLE Hardware
(
    id IDENTITY PRIMARY KEY,
    name        VARCHAR(50)    NOT NULL,
    code        VARCHAR(16)    NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    hardwareTypeId  INT,
    quantity INT,
    FOREIGN KEY (hardwareTypeId) REFERENCES HardwareType(id)
);