CREATE TABLE TEST.PUBLIC.article
(
    id          UUID            PRIMARY KEY,
    businessId  INTEGER         NOT NULL,
    href        VARCHAR(200)    NOT NULL,
    title       VARCHAR(200)    NOT NULL,
    content     VARCHAR(10000)
);
