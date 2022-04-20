CREATE TABLE IF NOT EXISTS readings (
    client_id   CHAR(36)     NOT NULL,
    fecha       CHAR(7) NOT NULL,
    importe INT NOT NULL,
    PRIMARY KEY (id,fecha)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS suspicious_readings (
    client_id       CHAR(36) NOT NULL,
    month           CHAR(7)  NOT NULL,
    reading         INT      NOT NULL,
    median          INT      NOT NULL    
    PRIMARY KEY (id,month)
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
