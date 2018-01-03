-----------------------
-- TABLE: GRAPH_LIBRARY
-----------------------
CREATE TABLE IF NOT EXISTS employee (
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    position      	VARCHAR(255) NOT NULL,
    created_date     VARCHAR(255),
    modified_date    VARCHAR(255),
    created_by       VARCHAR(50),
    last_modified_by VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS user_conf (
    id               BIGSERIAL PRIMARY KEY,
    username             VARCHAR(100) NOT NULL,
    password      	VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS role (
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    user_id				BIGSERIAL REFERENCES user_conf(id)
);

INSERT INTO user_conf (id, username, password)
SELECT 1, 'user', 'user'
WHERE NOT EXISTS (SELECT 1 FROM user_conf WHERE username = 'user');
