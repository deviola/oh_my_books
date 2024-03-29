DROP TABLE IF EXISTS "BOOKS" CASCADE;

CREATE TABLE "BOOKS"
(
    "id"                BIGSERIAL NOT NULL,
    "title"             VARCHAR(250) NOT NULL,
    "authorId"          BIGINT NOT NULL,
    "isbn"              VARCHAR(13) NOT NULL,
    "publicationYear"   BIGINT NOT NULL,
    "status"            VARCHAR(50),
    "createdAt"         TIMESTAMP WITH TIME ZONE NOT NULL
);

ALTER TABLE "BOOKS" ADD CONSTRAINT "PK_BOOKS" PRIMARY KEY (id);

ALTER TABLE "BOOKS" ADD CONSTRAINT "FK_BOOKS_AUTHORS"
    FOREIGN KEY ("authorId") REFERENCES "AUTHORS" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
