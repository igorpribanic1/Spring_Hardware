DROP TABLE IF EXISTS Hardware;
DROP TABLE IF EXISTS HardwareType;


CREATE TABLE IF NOT EXISTS HardwareType
(
    id IDENTITY PRIMARY KEY,
    name        VARCHAR(50)    NOT NULL
);


CREATE TABLE IF NOT EXISTS Hardware
(
    id IDENTITY PRIMARY KEY,
    name        VARCHAR(50)    NOT NULL,
    code        VARCHAR(16)    NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    hardware_type_id  INT,
    quantity INT,
    FOREIGN KEY (hardware_type_id) REFERENCES HardwareType(id)
);