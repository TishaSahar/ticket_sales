create TABLE IF NOT EXISTS users
(
    id   UUID        PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL
);

CREATE UNIQUE INDEX idx_users_email_unique ON users(email);