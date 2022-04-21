CREATE TABLE IF NOT EXISTS readings (
    client_id   CHAR(36)     NOT NULL,
    period       CHAR(7) NOT NULL,
    amount INT NOT NULL,
    PRIMARY KEY (client_id,period)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS readings_counter (
    client_id   CHAR(36)     NOT NULL,
    total       INT NOT NULL,
    existing_readings JSON NOT NULL,
    PRIMARY KEY (client_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS suspicious_readings (
    client_id       CHAR(36) NOT NULL,
    month           CHAR(7)  NOT NULL,
    amount         INT      NOT NULL,
    median          INT      NOT NULL,    
    PRIMARY KEY (client_id,month)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS domain_events (
    id           CHAR(36)     NOT NULL,
    aggregate_id CHAR(36)     NOT NULL,
    name         VARCHAR(255) NOT NULL,
    body         JSON         NOT NULL,
    occurred_on  TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
