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
